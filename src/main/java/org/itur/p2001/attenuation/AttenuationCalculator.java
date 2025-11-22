// src/main/java/org/itur/p2001/attenuation/AttenuationCalculator.java
package org.itur.p2001.attenuation;

import org.itur.p2001.preprocessor.Section3Preprocessor.PreprocessedData;
import org.itur.p2001.util.LossDistribution;

/**
 * Common contract for the three additive attenuation mechanisms.
 */
public interface AttenuationCalculator {

  LossDistribution calculate(PreprocessedData data);
}
