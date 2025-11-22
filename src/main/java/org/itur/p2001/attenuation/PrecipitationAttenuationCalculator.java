// src/main/java/org/itur/p2001/attenuation/PrecipitationAttenuationCalculator.java
package org.itur.p2001.attenuation;

/**
 * Attachment C – Precipitation fading (rain + melting layer). Uses P.838-3 γ_R
 * = k·R^α, P.837-8 rain rate, P.839-4 rain height.
 */
public interface PrecipitationAttenuationCalculator extends AttenuationCalculator {
}
