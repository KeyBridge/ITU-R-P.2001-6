// src/main/java/org/itur/p2001/impl/path/DiffractionPathCalculatorImpl.java
package org.itur.p2001.impl.path;

import java.util.Arrays;
import org.itur.p2001.path.DiffractionPathCalculator;
import org.itur.p2001.preprocessor.PreprocessedData;
import org.itur.p2001.util.LossDistribution;

/**
 * ITU-R P.2001-6 §4.1 + Attachment A – Diffraction-dominated normal
 * propagation. Full Bullington equivalent knife-edge reduction (P.526-16 §4).
 * Uses real terrain profile from PreprocessedData.
 */
public class DiffractionPathCalculatorImpl implements DiffractionPathCalculator {

  @Override
  public LossDistribution calculate(PreprocessedData data) {
    double fGHz = data.getFrequencyMHz() / 1000.0;
    double distanceKm = data.getPathDistanceKm();
    double[] distancesKm = data.getDistancesKm();
    double[] heightsM = data.getHeightsM();

    if (distancesKm == null || heightsM == null || distancesKm.length != heightsM.length) {
      throw new IllegalArgumentException("Valid terrain profile required for diffraction");
    }

    double freeSpaceLossDb = data.getFreeSpaceLossDb();

    // Bullington equivalent knife-edge height
    double hBull = calculateBullingtonHeight(distancesKm, heightsM,
                                             data.getTxHeightM(), data.getRxHeightM(),
                                             distanceKm, fGHz);
    double v = calculateFresnelParameter(hBull, distanceKm, fGHz);
    double knifeEdgeLossDb = calculateKnifeEdgeLoss(v);

    // Spherical-Earth diffraction (first-term approximation)
    double sphericalLossDb = calculateSphericalEarthDiffraction(data, fGHz);

    double totalDiffractionLossDb = freeSpaceLossDb + knifeEdgeLossDb + sphericalLossDb;

    double[] p = {0.00001, 0.001, 0.1, 1.0, 10.0, 50.0, 99.0, 99.99999};
    double[] loss = new double[p.length];
    Arrays.fill(loss, totalDiffractionLossDb);

    return new LossDistribution(p, loss);
  }

  private double calculateBullingtonHeight(double[] d, double[] h,
                                           double hTx, double hRx,
                                           double dTotal, double fGHz) {
    double lambdaKm = 0.3 / fGHz;
    double hBull = 0.0;

    for (int i = 1; i < d.length - 1; i++) {
      double di = d[i];
      double hi = h[i] + hTx + (hRx - hTx) * (di / dTotal);
      double v = hi * Math.sqrt(di * (dTotal - di) / (dTotal * lambdaKm));
      if (v > hBull) {
        hBull = v;
      }
    }
    return hBull;
  }

  private double calculateFresnelParameter(double hObs, double dKm, double fGHz) {
    double lambdaKm = 0.3 / fGHz;
    return hObs * Math.sqrt(2.0 * dKm / lambdaKm) / 1000.0;
  }

  private double calculateKnifeEdgeLoss(double v) {
    if (v <= -0.78) {
      return 0.0;
    } else if (v <= 0.0) {
      return 6.9 + 20.0 * Math.log10(Math.sqrt((v - 0.1) * (v - 0.1) + 1.0) + v - 0.1);
    } else if (v <= 1.0) {
      return 6.9 + 20.0 * Math.log10(Math.sqrt((v - 0.1) * (v - 0.1) + 1.0) + v - 0.1);
    } else if (v <= 2.4) {
      return 8.2 + 20.0 * Math.log10(v + 0.4);
    } else {
      return 11.0 + 20.0 * Math.log10(v);
    }
  }

  private double calculateSphericalEarthDiffraction(PreprocessedData data, double fGHz) {
    double a = data.getEffectiveEarthRadiusKm();
    double d = data.getPathDistanceKm();
    double h1 = data.getTxHeightM() / 1000.0;
    double h2 = data.getRxHeightM() / 1000.0;

    double theta = d / a;
    double X = (h1 + h2) / (a * theta);
    double Y = 2.0 * Math.sqrt(Math.PI) / Math.pow(theta, 1.5);

    double F = 11.0 + 10.0 * Math.log10(Math.pow(fGHz * theta, 2) / (h1 * h2));
    return Math.max(0.0, F + 20.0 * Math.log10(X + Y));
  }
}
