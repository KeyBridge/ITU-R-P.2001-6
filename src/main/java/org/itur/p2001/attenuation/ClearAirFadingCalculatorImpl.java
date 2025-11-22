// src/main/java/org/itur/p2001/attenuation/ClearAirFadingCalculatorImpl.java
package org.itur.p2001.attenuation;

import org.itur.p2001.preprocessor.PreprocessedData;
import org.itur.p2001.util.LossDistribution;

/**
 * ITU-R P.2001-6 Attachment B – Clear-air multipath/focusing enhancement and
 * fading Implements the two-ray model with geoclimatic factor.
 */
public class ClearAirFadingCalculatorImpl implements ClearAirFadingCalculator {

  @Override
  public LossDistribution calculate(PreprocessedData data) {
    double fGHz = data.getFrequencyMHz() / 1000.0;
    double distanceKm = data.getPathDistanceKm();

    // Geoclimatic factor K (simplified – real version uses DN_Median + path profile)
    double K = 1.0e-5;  // Typical continental value

    // Multipath fade depth (dB) exceeded for p% of time
    double A0 = 23.5 + 25.0 * Math.log10(fGHz) + 20.0 * Math.log10(distanceKm);
    double fadeDepth = A0 * Math.pow(K * Math.pow(10.0, -data.getPathInclinationRad()), 0.5);

    double[] p = {0.00001, 0.001, 0.01, 0.1, 1.0, 10.0, 50.0, 99.99999};
    double[] loss = new double[p.length];
    for (int i = 0; i < p.length; i++) {
      double exceedance = p[i];
      if (exceedance < 1.0) {
        loss[i] = fadeDepth * Math.pow(10.0, 0.2 * Math.log10(exceedance));
      } else {
        loss[i] = 0.0;  // Enhancement
      }
    }

    return new LossDistribution(p, loss);
  }
}
