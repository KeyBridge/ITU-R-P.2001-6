// src/main/java/org/itur/p2001/combiner/AttachmentJCombiner.java
package org.itur.p2001.combiner;

import java.util.List;
import org.itur.p2001.util.LossDistribution;

/**
 * Attachment J – Final statistical combination. Takes four path
 * LossDistributions + three attenuation LossDistributions and produces the
 * final ICDF per the correlation-aware method.
 */
public interface AttachmentJCombiner {

  LossDistribution combine(
    List<LossDistribution> pathDistributions,
    List<LossDistribution> attenuationDistributions
  );
}
