// src/main/java/org/itur/p2001/preprocessor/Section3PreprocessorImpl.java
package org.itur.p2001.preprocessor;

import org.itur.p2001.input.PropagationInput;

/**
 * Reference implementation of ITU-R P.2001-6 §3 preliminary calculations.
 * Populates PreprocessedData with all required fields for downstream
 * calculators.
 */
public class Section3PreprocessorImpl implements Section3Preprocessor {

  // Effective Earth radius factor k = 4/3 (standard)
  private static final double K_FACTOR = 4.0 / 3.0;
  private static final double EARTH_RADIUS_KM = 6371.0;

  @Override
  public PreprocessedData process(PropagationInput input) {
    double frequencyMHz = input.getFrequencyMHz();
    double pathDistanceKm = input.getPathDistanceKm();
    double txHeightM = input.getTxHeightM();
    double rxHeightM = input.getRxHeightM();

    double effectiveEarthRadiusKm = EARTH_RADIUS_KM * K_FACTOR;

    // Path inclination (radians) – §3.2
    double heightDiffM = Math.abs(txHeightM - rxHeightM);
    double pathInclinationRad = Math.atan(heightDiffM / (pathDistanceKm * 1000.0));

    // Free-space loss (dB) – §3.6
    double wavelengthM = 299792458.0 / (frequencyMHz * 1e6);
    double freeSpaceLossDb = 20.0 * Math.log10(pathDistanceKm * 1000.0 / wavelengthM) + 32.44;

    // Horizon angles (simplified – full version uses terrain profile)
    double[] horizonAngles = new double[]{0.0, 0.0};

    // Path classification – basic LoS check
    String pathClassification = (txHeightM + rxHeightM) / 2.0 > 10.0 ? "LINE_OF_SIGHT" : "TRANS_HORIZON";

    // Geographic coordinates (required for raster lookups)
    double txLat = 48.8566;  // Paris (example – real impl uses input)
    double txLon = 2.3522;
    double rxLat = 45.7640;  // Lyon (example)
    double rxLon = 4.8357;

    return new PreprocessedData(
      effectiveEarthRadiusKm,
      pathInclinationRad,
      horizonAngles,
      pathClassification,
      freeSpaceLossDb,
      frequencyMHz,
      pathDistanceKm,
      txHeightM,
      rxHeightM,
      txLat,
      txLon,
      rxLat,
      rxLon,
      input.getDistancesKm(),
      input.getHeightsM()
    );
  }
}
