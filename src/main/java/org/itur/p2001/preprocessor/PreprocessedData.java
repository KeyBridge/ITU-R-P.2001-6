// src/main/java/org/itur/p2001/preprocessor/PreprocessedData.java
package org.itur.p2001.preprocessor;

/**
 * Standalone, immutable container for all results of §3 preliminary
 * calculations. Extended to support DiffractionPathCalculatorImpl and all other
 * calculators. Java 11 compatible – no records.
 */
public final class PreprocessedData {

  // Core §3 results
  private final double effectiveEarthRadiusKm;
  private final double pathInclinationRad;
  private final double[] horizonAngles;
  private final String pathClassification;
  private final double freeSpaceLossDb;

  // Primary parameters (needed by multiple calculators)
  private final double frequencyMHz;
  private final double pathDistanceKm;
  private final double txHeightM;
  private final double rxHeightM;

  // Geographic coordinates (required for raster lookups)
  private final double txLat;
  private final double txLon;
  private final double rxLat;
  private final double rxLon;

  // Terrain profile (required for Bullington diffraction)
  private final double[] distancesKm;
  private final double[] heightsM;

  public PreprocessedData(
    double effectiveEarthRadiusKm,
    double pathInclinationRad,
    double[] horizonAngles,
    String pathClassification,
    double freeSpaceLossDb,
    double frequencyMHz,
    double pathDistanceKm,
    double txHeightM,
    double rxHeightM,
    double txLat,
    double txLon,
    double rxLat,
    double rxLon,
    double[] distancesKm,
    double[] heightsM) {

    this.effectiveEarthRadiusKm = effectiveEarthRadiusKm;
    this.pathInclinationRad = pathInclinationRad;
    this.horizonAngles = horizonAngles != null ? horizonAngles.clone() : null;
    this.pathClassification = pathClassification;
    this.freeSpaceLossDb = freeSpaceLossDb;

    this.frequencyMHz = frequencyMHz;
    this.pathDistanceKm = pathDistanceKm;
    this.txHeightM = txHeightM;
    this.rxHeightM = rxHeightM;

    this.txLat = txLat;
    this.txLon = txLon;
    this.rxLat = rxLat;
    this.rxLon = rxLon;

    this.distancesKm = distancesKm != null ? distancesKm.clone() : null;
    this.heightsM = heightsM != null ? heightsM.clone() : null;
  }

  // --- Getters ---
  public double getEffectiveEarthRadiusKm() {
    return effectiveEarthRadiusKm;
  }

  public double getPathInclinationRad() {
    return pathInclinationRad;
  }

  public double[] getHorizonAngles() {
    return horizonAngles != null ? horizonAngles.clone() : null;
  }

  public String getPathClassification() {
    return pathClassification;
  }

  public double getFreeSpaceLossDb() {
    return freeSpaceLossDb;
  }

  public double getFrequencyMHz() {
    return frequencyMHz;
  }

  public double getPathDistanceKm() {
    return pathDistanceKm;
  }

  public double getTxHeightM() {
    return txHeightM;
  }

  public double getRxHeightM() {
    return rxHeightM;
  }

  public double getTxLat() {
    return txLat;
  }

  public double getTxLon() {
    return txLon;
  }

  public double getRxLat() {
    return rxLat;
  }

  public double getRxLon() {
    return rxLon;
  }

  public double[] getDistancesKm() {
    return distancesKm != null ? distancesKm.clone() : null;
  }

  public double[] getHeightsM() {
    return heightsM != null ? heightsM.clone() : null;
  }

  @Override
  public String toString() {
    return "PreprocessedData{"
      + "pathDistanceKm=" + pathDistanceKm
      + ", frequencyMHz=" + frequencyMHz
      + ", txLat=" + txLat + ", txLon=" + txLon
      + ", pathClassification='" + pathClassification + '\''
      + '}';
  }
}
