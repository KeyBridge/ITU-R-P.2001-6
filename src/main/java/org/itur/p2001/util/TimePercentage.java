// src/main/java/org/itur/p2001/util/TimePercentage.java
package org.itur.p2001.util;

/**
 * Represents time percentage p as defined in P.2001-6.
 * Valid range: 0.00001 % ≤ p ≤ 99.99999 %
 */
public record TimePercentage(double value) {
    public TimePercentage {
        if (value < 0.00001 || value > 99.99999) {
            throw new IllegalArgumentException("Time percentage must be in range 0.00001–99.99999 %");
        }
    }
}
