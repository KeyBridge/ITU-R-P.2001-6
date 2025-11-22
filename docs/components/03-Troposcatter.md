# Sub-model 3 – Troposcatter Propagation (§4.3)

**Traceability**: §4.3, Attachment E (Troposcatter)

### Role in the Model
This sub-model accounts for long-distance propagation via scattering from turbulent inhomogeneities in the troposphere. It becomes relevant on trans-horizon paths (typically > 100 km) when other mechanisms (diffraction, ducting) fade.

### Key calculations performed (Attachment E)
- Climatic classification of the path (§E.2)
- Determination of common scattering volume geometry
- Calculation of troposcatter basic transmission loss (§E.3), which includes:
  - Frequency-dependent scattering efficiency
  - Path geometry losses
  - Aperture-to-medium coupling losses
  - Time variability (seasonal and annual)

### Architectural implication (future Java)
A `TroposcatterCalculator` will:
- Compute the scattering volume intersection
- Apply the empirical scattering cross-section model
- Produce a relatively flat inverse CDF (moderate loss, low time variability compared to ducting)

Troposcatter is usually the “floor” mechanism on very long paths when ducting is not present. It dominates in continental interiors and high-latitude regions where surface ducts are rare.

Note: Gaseous absorption for troposcatter paths is handled separately in Attachment F (§F.3, §F.4) and added later as an additive attenuation.
