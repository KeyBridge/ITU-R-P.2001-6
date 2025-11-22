// src/main/java/org/itur/p2001/util/TimePercentage.java
package org.itur.p2001.util;

/**
 * Represents time percentage p as defined in P.2001-6. Valid range: 0.00001 % ≤
 * p ≤ 99.99999 % Java 11 compatible – no record syntax.
 */
public final class TimePercentage {

  private final double value;

  public TimePercentage(double value) {
    if (value < 0.00001 || value > 99.99999) {
      throw new IllegalArgumentException(
        "Time percentage must be in range 0.00001–99.99999 %. Given: " + value
      );
    }
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.format("%.8f%%", value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TimePercentage)) {
      return false;
    }
    TimePercentage that = (TimePercentage) o;
    return Double.compare(that.value, value) == 0;
  }

  @Override
  public int hashCode() {
    return Double.hashCode(value);
  }
}
