// src/main/java/org/itur/p2001/util/LossDistribution.java
package org.itur.p2001.util;

/**
 * Container for an inverse cumulative distribution function of loss. Represents
 * L_b(p) over the full 0.00001 % – 99.99999 % range.
 */
public record LossDistribution(
  double[] timePercentages,
  double[] lossDb
  ) {

}
