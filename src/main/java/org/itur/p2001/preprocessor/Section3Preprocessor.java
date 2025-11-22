// src/main/java/org/itur/p2001/preprocessor/Section3Preprocessor.java
package org.itur.p2001.preprocessor;

import org.itur.p2001.input.PropagationInput;

/**
 * Performs all preliminary calculations defined in §3 of ITU-R P.2001-6.
 * Returns standalone PreprocessedData object.
 */
public interface Section3Preprocessor {

  /**
   * Execute §3 calculations.
   *
   * @param input validated PropagationInput
   * @return fully populated PreprocessedData
   */
  PreprocessedData process(PropagationInput input);
}
