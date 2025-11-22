// src/main/java/org/itur/p2001/input/PropagationInput.java
package org.itur.p2001.input;

/**
 * Immutable container for all inputs defined in §2 of ITU-R P.2001-6.
 */
public record PropagationInput(
  // Terrain profile (§2.1)
  double[] distancesKm,
  double[] heightsM,
  int[] zoneCodes,
  // Primary parameters
  double frequencyMHz,
  double pathDistanceKm,
  double txHeightM,
  double rxHeightM,
  double timePercentage,
  // Additional climatic/environmental parameters
  String climateZone,
  double surfaceWaterVapourDensityGM3,
  double rainRateMmPerHour
  ) {

}
