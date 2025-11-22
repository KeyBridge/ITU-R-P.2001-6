// src/main/java/org/itur/p2001/preprocessor/PreprocessedData.java
package org.itur.p2001.preprocessor;

/**
 * Standalone, immutable container for all results of §3 preliminary
 * calculations. Extended with fields required by
 * GaseousAbsorptionCalculatorImpl and other calculators. Java 11 compatible –
 * no records.
 */
public final class PreprocessedData {

  // Core §3 results
  private final double effectiveEarthRadiusKm;
  private final double pathInclinationRad;
  private final double[] horizonAngles;
  private final String pathClassification;  // LoS / trans-horizon / etc.
  private final double freeSpaceLossDb;

  // Extended fields required by calculators
  private final double frequencyMHz;
  private final double pathDistanceKm;
  private final double txLat;
  private final double txLon;
  private final double rxLat;
  private final double rxLon;

  public PreprocessedData(
    double effectiveEarthRadiusKm,
    double pathInclinationRad,
    double[] horizonAngles,
    String pathClassification,
    double freeSpaceLossDb,
    double frequencyMHz,
    double pathDistanceKm,
    double txLat,
    double txLon,
    double rxLat,
    double rxLon) {

    this.effectiveEarthRadiusKm = effectiveEarthRadiusKm;
    this.pathInclinationRad = pathInclinationRad;
    this.horizonAngles = horizonAngles != null ? horizonAngles.clone() : null;
    this.pathClassification = pathClassification;
    this.freeSpaceLossDb = freeSpaceLossDb;

    this.frequencyMHz = frequencyMHz;
    this.pathDistanceKm = pathDistanceKm;
    this.txLat = txLat;
    this.txLon = txLon;
    this.rxLat = rxLat;
    this.rxLon = rxLon;
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

  @Override
  public String toString() {
    return "PreprocessedData{"
      + "effectiveEarthRadiusKm=" + effectiveEarthRadiusKm
      + ", pathDistanceKm=" + pathDistanceKm
      + ", frequencyMHz=" + frequencyMHz
      + ", pathClassification='" + pathClassification + '\''
      + '}';
  }
}
