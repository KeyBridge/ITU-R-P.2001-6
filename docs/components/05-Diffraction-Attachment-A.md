# Attachment A – Diffraction Loss

**Traceability**: Attachment A (§A.1–A.5)

### Role in the Model
Diffraction is the dominant propagation mechanism within Sub-model 1 (Normal propagation close to the surface of the Earth) whenever the direct line-of-sight path is obstructed by terrain. It governs the baseline transmission loss on trans-horizon paths and in obstructed near-line-of-sight conditions.

### Methods defined in the Recommendation
- **Spherical-Earth diffraction loss**  
  Calculates the loss when radio waves graze a smooth curved Earth surface. Two approaches are provided:
  - A first-term approximation (fast, sufficient for many cases)
  - A more accurate full residue-series method for long-distance paths

- **Knife-edge diffraction**
  - **Bull Bullington equivalent knife-edge for the actual terrain profile** (§A.4)  
    Reduces an irregular terrain profile to a single equivalent obstructing knife-edge.
  - **Bullington equivalent knife-edge for a notional smooth profile** (§A.5)  
    Provides a reference smooth-Earth diffraction loss for comparison and path classification.

These diffraction calculations are used at two distinct points in the overall procedure:
1. Early in §3.12 – to obtain a preliminary knife-edge loss used for path classification (LoS / trans-horizon) and horizon parameter determination.
2. Later within Sub-model 1 – as the core loss mechanism when no stronger anomalous propagation is present.

Diffraction is active on nearly all terrestrial paths longer than a few tens of kilometres when ducting or troposcatter mechanisms are not dominant. It typically establishes the “floor” level of basic transmission loss in non-ducted conditions.
