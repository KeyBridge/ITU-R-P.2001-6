// src/main/java/org/itur/p2001/impl/PropagationModelImpl.java
package org.itur.p2001.impl;

import java.util.List;
import org.itur.p2001.PropagationModel;
import org.itur.p2001.attenuation.AttenuationCalculator;
import org.itur.p2001.combiner.AttachmentJCombiner;
import org.itur.p2001.input.PropagationInput;
import org.itur.p2001.path.PathCalculator;
import org.itur.p2001.preprocessor.Section3Preprocessor;
import org.itur.p2001.result.PropagationResult;

/**
 * Reference implementation façade for ITU-R P.2001-6 (09/2025).
 * Architecture-only – no physics implemented.
 */
public class PropagationModelImpl implements PropagationModel {

  private final Section3Preprocessor preprocessor;
  private final List<PathCalculator> pathCalculators;
  private final List<AttenuationCalculator> attenuationCalculators;
  private final AttachmentJCombiner combiner;

  public PropagationModelImpl(
    Section3Preprocessor preprocessor,
    List<PathCalculator> pathCalculators,
    List<AttenuationCalculator> attenuationCalculators,
    AttachmentJCombiner combiner
  ) {
    this.preprocessor = preprocessor;
    this.pathCalculators = List.copyOf(pathCalculators);
    this.attenuationCalculators = List.copyOf(attenuationCalculators);
    this.combiner = combiner;
  }

  @Override
  public PropagationResult calculate(PropagationInput input) {
    var preprocessed = preprocessor.process(input);

    var pathDistributions = pathCalculators.stream()
      .map(calc -> calc.calculate(preprocessed))
      .toList();

    var attenuationDistributions = attenuationCalculators.stream()
      .map(calc -> calc.calculate(preprocessed))
      .toList();

    var finalDistribution = combiner.combine(pathDistributions, attenuationDistributions);

    return new PropagationResult(finalDistribution);
  }
}
