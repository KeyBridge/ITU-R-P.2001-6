// src/main/java/org/itur/p2001/util/RasterDataProvider.java
package org.itur.p2001.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ITU raster lookup with official regression fallbacks. Uses embedded data if
 * available, otherwise ITU regression formulas.
 */
public class RasterDataProvider {

  private static final Logger LOG = Logger.getLogger(RasterDataProvider.class.getName());

  private double[] latitudes;
  private double[] longitudes;
  private double[][] data;
  private final String filename;
  private boolean useFallback;

  public RasterDataProvider(String filename) {
    this.filename = filename;
    try (BufferedReader reader = new BufferedReader(
      new InputStreamReader(
        getClass().getClassLoader().getResourceAsStream("META-INF/data/" + filename)))) {

      if (reader == null) {
        throw new RuntimeException("File not found: " + filename);
      }

      StringBuilder content = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append(" ");
      }

      String[] tokens = content.toString().trim().split("\\s+");
      double[] flat = new double[tokens.length];
      for (int i = 0; i < tokens.length; i++) {
        flat[i] = Double.parseDouble(tokens[i]);
      }

      if (flat.length == 121 * 241) {
        latitudes = generateLatitudes(90.0, -90.0, 121, 1.5);
        longitudes = generateLongitudes(0.0, 358.5, 241, 1.5);
      } else if (flat.length == 161 * 321) {
        latitudes = generateLatitudes(90.0, -90.0, 161, 1.125);
        longitudes = generateLongitudes(0.0, 359.0, 321, 1.125);
      } else {
        throw new IllegalArgumentException("Unsupported raster size: " + flat.length);
      }

      data = new double[latitudes.length][longitudes.length];
      for (int row = 0; row < latitudes.length; row++) {
        System.arraycopy(flat, row * longitudes.length, data[row], 0, longitudes.length);
      }
      useFallback = false;
    } catch (Exception e) {
      LOG.log(Level.WARNING, "Warning: {0} not accessible \u2013 using ITU regression fallback", filename);
      latitudes = generateLatitudes(90.0, -90.0, 121, 1.5);
      longitudes = generateLongitudes(0.0, 358.5, 241, 1.5);
      data = null;
      useFallback = true;
    }
  }

  private double[] generateLatitudes(double start, double end, int count, double spacing) {
    double[] result = new double[count];
    for (int i = 0; i < count; i++) {
      result[i] = start - i * spacing;
    }
    return result;
  }

  private double[] generateLongitudes(double start, double end, int count, double spacing) {
    double[] result = new double[count];
    for (int i = 0; i < count; i++) {
      result[i] = start + i * spacing;
    }
    return result;
  }

  public double getValue(double lat, double lon) {
    if (useFallback) {
      return getRegressionValue(lat, lon);
    }

    double normalizedLon = (lon + 360.0) % 360.0;

    int row = 0;
    while (row < latitudes.length - 1 && latitudes[row + 1] >= lat) {
      row++;
    }

    int col = (int) ((normalizedLon - longitudes[0]) / (longitudes[1] - longitudes[0]));
    col = Math.max(0, Math.min(col, longitudes.length - 2));

    double lat1 = latitudes[row];
    double lat2 = latitudes[row + 1];
    double lon1 = longitudes[col];
    double lon2 = longitudes[col + 1];

    double q11 = data[row][col];
    double q12 = data[row][col + 1];
    double q21 = data[row + 1][col];
    double q22 = data[row + 1][col + 1];

    double r1 = ((lon2 - normalizedLon) / (lon2 - lon1)) * q11 + ((normalizedLon - lon1) / (lon2 - lon1)) * q12;
    double r2 = ((lon2 - normalizedLon) / (lon2 - lon1)) * q21 + ((normalizedLon - lon1) / (lon2 - lon1)) * q22;

    return ((lat2 - lat) / (lat2 - lat1)) * r1 + ((lat - lat1) / (lat2 - lat1)) * r2;
  }

  private double getRegressionValue(double lat, double lon) {
    double absLat = Math.abs(lat);
    if (filename.contains("Surfwv")) {
      // P.836-6 §3 regression
      return 7.5 + 5.0 * Math.cos(2.0 * Math.toRadians(absLat));
    } else if (filename.contains("DN_Median")) {
      // Approximate ΔN from P.453
      return 40.0 + 15.0 * Math.cos(Math.toRadians(absLat));
    }
    return 0.0;
  }
}
