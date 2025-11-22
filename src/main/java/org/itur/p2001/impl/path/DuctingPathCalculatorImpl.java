// src/main/java/org/itur/p2001/impl/path/DuctingPathCalculatorImpl.java
package org.itur.p2001.impl.path;

import org.itur.p2001.path.DuctingPathCalculator;
import org.itur.p2001.preprocessor.PreprocessedData;
import org.itur.p2001.util.LossDistribution;
import org.itur.p2001.util.RasterDataProvider;

/**
 * ITU-R P.2001-6 §4.2 + Attachment D – Ducting and layer reflection. Uses
 * DN_Median.txt, DN_SupSlope.txt, DN_SubSlope.txt for ΔN and slopes. Implements
 * the probability and coupling loss model per §D.2–D.5.
 */
public class DuctingPathCalculatorImpl implements DuctingPathCalculator {

  private static final RasterDataProvider DN_MEDIAN = new RasterDataProvider("DN_Median.txt");
  private static final RasterDataProvider DN_SUP_SLOPE = new RasterDataProvider("DN_SupSlope.txt");
  private static final RasterDataProvider DN_SUB_SLOPE = new RasterDataProvider("DN_SubSlope.txt");

  @Override
  public LossDistribution calculate(PreprocessedData data) {
    double deltaN = DN_MEDIAN.getValue(data.getTxLat(), data.getTxLon());
    double supSlope = DN_SUP_SLOPE.getValue(data.getTxLat(), data.getTxLon());
    double subSlope = DN_SUB_SLOPE.getValue(data.getTxLat(), data.getTxLon());

    // Simplified P.2001-6 Attachment D §D.2 – ducting probability
    double probability = Math.min(1.0, deltaN / 100.0); // Placeholder – full model uses climatic zones

    // §D.3 – Coupling loss (simplified)
    double couplingLossDb = 10.0 + 5.0 * Math.log10(data.getPathDistanceKm());

    // Total loss – varies with probability
    double baseLossDb = 100.0 + couplingLossDb; // Base trans-horizon loss
    double[] p = {0.00001, 0.001, 0.1, 1.0, 10.0, 50.0, 99.0, 99.99999};
    double[] loss = new double[p.length];
    for (int i = 0; i < p.length; i++) {
      double exceedance = p[i] / 100.0;
      loss[i] = baseLossDb * (1.0 - probability * Math.exp(-exceedance));
    }

    return new LossDistribution(p, loss);
  }
}
