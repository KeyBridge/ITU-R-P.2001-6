// src/main/java/org/itur/p2001/util/PropagationInputBuilder.java
package org.itur.p2001.util;

import org.itur.p2001.input.PropagationInput;

import static java.lang.Math.*;

/**
 * Creates PropagationInput from minimal user input. Now with robust
 * height-profile method that guarantees matching arrays.
 */
public final class PropagationInputBuilder {

  private PropagationInputBuilder() {
  }

  /**
   * Accepts user-defined height profile (m) along path. Automatically generates
   * correctly sized and spaced distance array.
   */
  public static PropagationInput createWithHeightProfile(
    double txLatDeg, double txLonDeg, double txHeightM,
    double rxLatDeg, double rxLonDeg, double rxHeightM,
    double frequencyMHz,
    double[] heightsM) {

    if (heightsM == null || heightsM.length < 2) {
      throw new IllegalArgumentException("heightsM must contain at least 2 points");
    }

    if (Math.abs(heightsM[0] - txHeightM) > 0.1) {
      throw new IllegalArgumentException("First height must match txHeightM");
    }
    if (Math.abs(heightsM[heightsM.length - 1] - rxHeightM) > 0.1) {
      throw new IllegalArgumentException("Last height must match rxHeightM");
    }

    double pathDistanceKm = haversineDistance(txLatDeg, txLonDeg, rxLatDeg, rxLonDeg);

    int n = heightsM.length;
    double[] distancesKm = new double[n];
    for (int i = 0; i < n; i++) {
      distancesKm[i] = pathDistanceKm * i / (n - 1.0);
    }

    return new PropagationInput(
      distancesKm,
      heightsM.clone(),
      null,
      frequencyMHz,
      pathDistanceKm,
      txHeightM,
      rxHeightM,
      0.01,
      "Unknown",
      0.0,
      0.0
    );
  }

  public static PropagationInput create(
    double txLatDeg, double txLonDeg, double txHeightM,
    double rxLatDeg, double rxLonDeg, double rxHeightM,
    double frequencyMHz) {
    return create(txLatDeg, txLonDeg, txHeightM,
                  rxLatDeg, rxLonDeg, rxHeightM,
                  frequencyMHz, null, null);
  }

  public static PropagationInput create(
    double txLatDeg, double txLonDeg, double txHeightM,
    double rxLatDeg, double rxLonDeg, double rxHeightM,
    double frequencyMHz,
    double[] distancesKm, double[] heightsM) {

    double pathDistanceKm = haversineDistance(txLatDeg, txLonDeg, rxLatDeg, rxLonDeg);

    if (distancesKm == null || heightsM == null) {
      distancesKm = new double[]{0.0, pathDistanceKm * 0.5, pathDistanceKm};
      heightsM = new double[]{txHeightM, (txHeightM + rxHeightM) * 0.5, rxHeightM};
    } else if (distancesKm.length != heightsM.length) {
      throw new IllegalArgumentException("distancesKm and heightsM must have equal length");
    }

    return new PropagationInput(
      distancesKm.clone(),
      heightsM.clone(),
      null,
      frequencyMHz,
      pathDistanceKm,
      txHeightM,
      rxHeightM,
      0.01,
      "Unknown",
      0.0,
      0.0
    );
  }

  private static double haversineDistance(double lat1, double lon1, double lat2, double lon2) {
    double R = 6371.0088;
    double dLat = toRadians(lat2 - lat1);
    double dLon = toRadians(lon2 - lon1);
    double a = sin(dLat * 0.5) * sin(dLat * 0.5)
      + cos(toRadians(lat1)) * cos(toRadians(lat2))
      * sin(dLon * 0.5) * sin(dLon * 0.5);
    double c = 2 * atan2(sqrt(a), sqrt(1 - a));
    return R * c;
  }
}
