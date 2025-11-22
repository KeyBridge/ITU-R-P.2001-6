// src/main/java/org/itur/p2001/util/LossDistribution.java
package org.itur.p2001.util;

import java.util.Arrays;

/**
 * Immutable container for an inverse cumulative distribution function of loss.
 * Represents L_b(p) over the full 0.00001 % – 99.99999 % range. Java 11
 * compatible – no record syntax.
 */
public final class LossDistribution {

  private final double[] timePercentages;
  private final double[] lossDb;

  public LossDistribution(double[] timePercentages, double[] lossDb) {
    if (timePercentages == null || lossDb == null) {
      throw new IllegalArgumentException("Time percentages and loss values cannot be null");
    }
    if (timePercentages.length != lossDb.length) {
      throw new IllegalArgumentException("Arrays must have equal length");
    }
    this.timePercentages = timePercentages.clone();
    this.lossDb = lossDb.clone();
  }

  public double[] getTimePercentages() {
    return timePercentages.clone();
  }

  public double[] getLossDb() {
    return lossDb.clone();
  }

  public int size() {
    return timePercentages.length;
  }

  @Override
  public String toString() {
    return "LossDistribution[size=" + timePercentages.length + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LossDistribution)) {
      return false;
    }
    LossDistribution that = (LossDistribution) o;
    return Arrays.equals(timePercentages, that.timePercentages)
      && Arrays.equals(lossDb, that.lossDb);
  }

  @Override
  public int hashCode() {
    int result = Arrays.hashCode(timePercentages);
    result = 31 * result + Arrays.hashCode(lossDb);
    return result;
  }
}
