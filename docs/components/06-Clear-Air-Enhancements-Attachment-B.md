# Attachment B – Clear-Air Enhancements and Fading

**Traceability**: Attachment B (§B.1–B.5)

### Role in the Model
Attachment B defines the statistical behaviour of signal level variations under clear-air (non-precipitating) conditions. These variations arise primarily from multipath propagation and atmospheric focusing/defocusing effects. The model produces both fading (increased loss) and enhancement (reduced loss) relative to the median.

### Key calculations performed
- **Characterization of multi-path activity** (§B.2)  
  Determines the strength and type of multipath present on the path using path geometry, frequency, and climatic factors.
- **Calculation of the notional zero-fade annual percentage time** (§B.3)  
  Establishes a reference time percentage at which the signal level equals the free-space value (no fading or enhancement).
- **Percentage time a given clear-air fade level is exceeded on a surface path** (§B.4)  
  Core calculation for normal (non-troposcatter) paths.
- **Percentage time a given clear-air fade level is exceeded on a troposcatter path** (§B.5)  
  Modified version used when the dominant mechanism is troposcatter.

### Behaviour in the overall model
- Clear-air fading/enhancement statistics are applied within Sub-model 1 (Normal propagation) and also influence Sub-model 3 (Troposcatter).
- The resulting inverse cumulative distribution function (ICDF) is generally shallow for small fade depths and steepens at large depths.
- Enhancements (negative fades) are permitted and are crucial for interference studies, especially at low percentage times.

This attachment provides one of the three additive attenuation components that are combined with the parallel propagation mechanisms in the final stage (Attachment J).
