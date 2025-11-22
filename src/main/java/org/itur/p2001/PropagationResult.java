// src/main/java/org/itur/p2001/PropagationResult.java
package org.itur.p2001;

import org.itur.p2001.util.LossDistribution;

/**
 * Final output of P.2001-6. Contains the basic transmission loss L_b(p) not
 * exceeded for percentage p of an average year (0.00001 % ≤ p ≤ 99.99999 %).
 */
public record PropagationResult(LossDistribution lossDistribution) {

}
