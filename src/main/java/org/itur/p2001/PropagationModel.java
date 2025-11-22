// src/main/java/org/itur/p2001/PropagationModel.java
package org.itur.p2001;

import org.itur.p2001.input.PropagationInput;
import org.itur.p2001.result.PropagationResult;

/**
 * Main façade for ITU-R P.2001-6 (09/2025). Orchestrates §3 preliminary
 * calculations, the four parallel paths (§4), the three additive attenuations,
 * and final combination per Attachment J.
 */
public interface PropagationModel {

  PropagationResult calculate(PropagationInput input);
}
