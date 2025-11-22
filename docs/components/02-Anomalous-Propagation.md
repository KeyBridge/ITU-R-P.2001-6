# Sub-model 2 – Anomalous Propagation (§4.2)

**Traceability**: §4.2, Attachment D (Anomalous/layer-reflection model)

### Role in the Model
This sub-model captures strong, long-distance propagation enhancements caused by atmospheric refraction, primarily:
- Surface ducts (especially over sea or flat land)
- Elevated ducts / layer reflection

These phenomena can produce extremely low-loss paths for small percentages of time (typically &lt; 1 %), dramatically increasing interference range — critical for spectrum-sharing studies.

### Key calculations performed (Attachment D)
- Characterization of radio-climatic zones along the path (§D.1)
- Point incidence of ducting (probability and type) (§D.2)
- Site-shielding losses with respect to the duct (§D.3)
- Over-sea surface duct coupling corrections (§D.4)
- Total coupling loss into the anomalous mechanism (§D.5)
- Angular-distance dependent loss (§D.6)
- Distance- and time-dependent loss (§D.7)
- Final basic transmission loss for ducting/layer reflection (§D.8)

### Architectural implication (future Java)
A `AnomalousPropagationCalculator` (or `DuctingCalculator`) will:
- Use global radio-climatic maps (e.g., derived from ITU data)
- Compute coupling efficiency at both terminals
- Apply distance/time decay specific to duct geometry
- Produce a steep inverse CDF (very low loss for p &lt;&lt; 1 %, rapidly rising thereafter)

This sub-model typically dominates interference tails in coastal and subtropical environments. When active, it often becomes the lowest-loss path in the final combination (Attachment J), making it a high-priority component for regulatory Monte-Carlo simulations.
