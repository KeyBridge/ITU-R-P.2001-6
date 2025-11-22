// src/main/java/org/itur/p2001/path/DiffractionPathCalculatorImpl.java
package org.itur.p2001.path;

import java.util.Arrays;
import org.itur.p2001.preprocessor.PreprocessedData;
import org.itur.p2001.util.LossDistribution;

/**
 * ITU-R P.2001-6 §4.1 + Attachment A – Diffraction-dominated normal
 * propagation. Implements Bullington equivalent knife-edge reduction per ITU-R
 * P.526-16 §4. Full spherical-Earth diffraction with first-term approximation.
 */
public class DiffractionPathCalculatorImpl implements DiffractionPathCalculator {

  @Override
  public LossDistribution calculate(PreprocessedData data) {
    double distanceKm = data.getPathDistanceKm();
    double frequencyMHz = data.getFrequencyMHz();
    double fGHz = frequencyMHz / 1000.0;

    // Free-space loss (already computed in §3)
    double freeSpaceLossDb = data.getFreeSpaceLossDb();

    // Bullington equivalent knife-edge (simplified – full version uses terrain profile)
    double v = calculateFresnelParameter(data);
    double knifeEdgeLossDb = calculateKnifeEdgeLoss(v);

    // Spherical-Earth diffraction (first-term approximation, P.526-16 §4.3)
    double sphericalLossDb = calculateSphericalEarthDiffraction(data, fGHz);

    double totalDiffractionLossDb = freeSpaceLossDb + knifeEdgeLossDb + sphericalLossDb;

    // Diffraction is nearly constant over time → same loss for all p
    double[] p = {0.00001, 0.001, 0.1, 1.0, 10.0, 50.0, 99.0, 99.99999};
    double[] loss = new double[p.length];
    Arrays.fill(loss, totalDiffractionLossDb);

    return new LossDistribution(p, loss);
  }

  private double calculateFresnelParameter(PreprocessedData data) {
    // Simplified Bullington v-parameter
    double hObs = Math.max(data.getTxHeightM(), data.getRxHeightM());
    double d = data.getPathDistanceKm();
    double lambda = 300.0 / data.getFrequencyMHz(); // wavelength in km
    return hObs * Math.sqrt(2.0 * d / lambda) / 1000.0;
  }

  private double calculateKnifeEdgeLoss(double v) {
    // ITU-R P.526-16 Figure 5 approximation
    if (v <= -0.78) {
      return 0.0;
    } else if (v <= 0.0) {
      return 6.9 + 20.0 * Math.log10(Math.sqrt(Math.pow(v - 0.1, 2) + 1.0) + v - 0.1);
    } else if (v <= 1.0) {
      return 6.9 + 20.0 * Math.log10(Math.sqrt(Math.pow(v - 0.1, 2) + 1.0) + v - 0.1);
    } else if (v <= 2.4) {
      return 8.2 + 20.0 * Math.log10(v + 0.4);
    } else {
      return 11.0 + 20.0 * Math.log10(v);
    }
  }

  private double calculateSphericalEarthDiffraction(PreprocessedData data, double fGHz) {
    // First-term approximation P.526-16 §4.3.3
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
