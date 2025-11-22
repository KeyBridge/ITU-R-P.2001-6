// src/main/java/org/itur/p2001/combiner/AttachmentJCombinerImpl.java
package org.itur.p2001.combiner;

import java.util.List;
import org.itur.p2001.util.LossDistribution;

/**
 * ITU-R P.2001-6 Attachment J – Final statistical combination Four parallel
 * paths → minimum loss Three additive attenuations → correlated sum
 */
public class AttachmentJCombinerImpl implements AttachmentJCombiner {

  @Override
  public LossDistribution combine(
    List<LossDistribution> pathDistributions,
    List<LossDistribution> attenuationDistributions) {

    if (pathDistributions.size() != 4) {
      throw new IllegalArgumentException("Exactly 4 path distributions required");
    }

    double[] p = pathDistributions.get(0).getTimePercentages();
    double[] finalLoss = new double[p.length];

    for (int i = 0; i < p.length; i++) {
      double timePct = p[i];

      // Step 1: Minimum of the four paths
      double minPathLoss = Double.MAX_VALUE;
      for (LossDistribution path : pathDistributions) {
        double pathLoss = interpolate(path, timePct);
        if (pathLoss < minPathLoss) {
          minPathLoss = pathLoss;
        }
      }

      // Step 2: Sum of three attenuations (correlated)
      double totalAttenuation = 0.0;
      for (LossDistribution att : attenuationDistributions) {
        totalAttenuation += interpolate(att, timePct);
      }

      finalLoss[i] = minPathLoss + totalAttenuation;
    }

    return new LossDistribution(p.clone(), finalLoss);
  }

  private double interpolate(LossDistribution dist, double targetP) {
    double[] p = dist.getTimePercentages();
    double[] loss = dist.getLossDb();

    for (int i = 0; i < p.length - 1; i++) {
      if (targetP >= p[i] && targetP <= p[i + 1]) {
        double t = (targetP - p[i]) / (p[i + 1] - p[i]);
        return loss[i] + t * (loss[i + 1] - loss[i]);
      }
    }
    return loss[loss.length - 1];
  }
}
