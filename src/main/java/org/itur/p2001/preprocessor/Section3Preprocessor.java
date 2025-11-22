// src/main/java/org/itur/p2001/preprocessor/Section3Preprocessor.java
package org.itur.p2001.preprocessor;

import org.itur.p2001.input.PropagationInput;

/**
 * Performs all preliminary calculations defined in §3 of P.2001-6. Output is
 * shared by all path and attenuation calculators.
 */
public interface Section3Preprocessor {

  PreprocessedData process(PropagationInput input);

  record PreprocessedData(
    double effectiveEarthRadiusKm,
    double pathInclinationRad,
    double[] horizonAngles,
    String pathClassification, // LoS / trans-horizon / etc.
    double freeSpaceLossDb
    ) {

  }
}
