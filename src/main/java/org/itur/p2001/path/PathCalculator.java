// src/main/java/org/itur/p2001/path/PathCalculator.java
package org.itur.p2001.path;

import org.itur.p2001.preprocessor.PreprocessedData;
import org.itur.p2001.util.LossDistribution;

/**
 * Common contract for the four parallel end-to-end propagation paths (§4). Each
 * returns a complete inverse CDF of basic transmission loss.
 */
public interface PathCalculator {

  LossDistribution calculate(PreprocessedData data);
}
