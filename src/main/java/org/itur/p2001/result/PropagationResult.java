// src/main/java/org/itur/p2001/result/PropagationResult.java
package org.itur.p2001.result;

import org.itur.p2001.util.LossDistribution;

/**
 * Final output of P.2001-6. Contains the basic transmission loss L_b(p) not
 * exceeded for percentage p of an average year (0.00001 % ≤ p ≤ 99.99999 %).
 * <p>
 * Java 11 compatible – no record syntax.
 */
public final class PropagationResult {

  private final LossDistribution lossDistribution;

  public PropagationResult(LossDistribution lossDistribution) {
    if (lossDistribution == null) {
      throw new IllegalArgumentException("LossDistribution cannot be null");
    }
    this.lossDistribution = lossDistribution;
  }

  public LossDistribution getLossDistribution() {
    return lossDistribution;
  }

  @Override
  public String toString() {
    return "PropagationResult[size=" + lossDistribution.size() + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PropagationResult)) {
      return false;
    }
    PropagationResult that = (PropagationResult) o;
    return lossDistribution.equals(that.lossDistribution);
  }

  @Override
  public int hashCode() {
    return lossDistribution.hashCode();
  }
}
