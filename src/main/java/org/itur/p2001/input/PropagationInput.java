// src/main/java/org/itur/p2001/input/PropagationInput.java
package org.itur.p2001.input;

/**
 * Immutable container for all inputs defined in §2 of ITU-R P.2001-6. Java 11
 * compatible – no record syntax.
 */
public final class PropagationInput {

  // Terrain profile (§2.1)
  private final double[] distancesKm;
  private final double[] heightsM;
  private final int[] zoneCodes;

  // Primary parameters
  private final double frequencyMHz;
  private final double pathDistanceKm;
  private final double txHeightM;
  private final double rxHeightM;
  private final double timePercentage;

  // Additional climatic/environmental parameters
  private final String climateZone;
  private final double surfaceWaterVapourDensityGM3;
  private final double rainRateMmPerHour;

  public PropagationInput(
    double[] distancesKm,
    double[] heightsM,
    int[] zoneCodes,
    double frequencyMHz,
    double pathDistanceKm,
    double txHeightM,
    double rxHeightM,
    double timePercentage,
    String climateZone,
    double surfaceWaterVapourDensityGM3,
    double rainRateMmPerHour) {

    // Defensive copies of arrays
    this.distancesKm = distancesKm != null ? distancesKm.clone() : null;
    this.heightsM = heightsM != null ? heightsM.clone() : null;
    this.zoneCodes = zoneCodes != null ? zoneCodes.clone() : null;

    this.frequencyMHz = frequencyMHz;
    this.pathDistanceKm = pathDistanceKm;
    this.txHeightM = txHeightM;
    this.rxHeightM = rxHeightM;
    this.timePercentage = timePercentage;
    this.climateZone = climateZone;
    this.surfaceWaterVapourDensityGM3 = surfaceWaterVapourDensityGM3;
    this.rainRateMmPerHour = rainRateMmPerHour;
  }

  // --- Getters ---
  public double[] getDistancesKm() {
    return distancesKm != null ? distancesKm.clone() : null;
  }

  public double[] getHeightsM() {
    return heightsM != null ? heightsM.clone() : null;
  }

  public int[] getZoneCodes() {
    return zoneCodes != null ? zoneCodes.clone() : null;
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

  public double getTimePercentage() {
    return timePercentage;
  }

  public String getClimateZone() {
    return climateZone;
  }

  public double getSurfaceWaterVapourDensityGM3() {
    return surfaceWaterVapourDensityGM3;
  }

  public double getRainRateMmPerHour() {
    return rainRateMmPerHour;
  }

  @Override
  public String toString() {
    return "PropagationInput{"
      + "frequencyMHz=" + frequencyMHz
      + ", pathDistanceKm=" + pathDistanceKm
      + ", timePercentage=" + timePercentage
      + ", climateZone='" + climateZone + '\''
      + '}';
  }
}
