# Attachment F – Attenuation Due to Gaseous Absorption

**Traceability**: Attachment F (§F.1–F.6)

### Role in the Model
Attachment F calculates the additional transmission loss caused by absorption of radio waves by atmospheric oxygen and water vapour. This is one of the three additive attenuation mechanisms applied after the four parallel propagation paths (diffraction, ducting, troposcatter, sporadic-E) have been determined.

### Key calculations performed
- **Gaseous absorption for surface paths** (§F.2)  
  Computes dry air (oxygen) and water-vapour attenuation along near-ground paths using local pressure, temperature, and humidity.
- **Gaseous absorption for a troposcatter path** (§F.3)  
  Applies slant-path geometry through the common scattering volume.
- **Gaseous absorption for terminal/common-volume troposcatter path** (§F.4)  
  Separates terminal losses from the scattering volume contribution.
- **Water-vapour density in rain** (§F.5)  
  Adjusts water-vapour content during precipitation events.
- **Specific sea-level attenuations** (§F.6)  
  Provides reference values for oxygen and water vapour as a function of frequency.

### Behaviour in the overall model
- Gaseous absorption increases rapidly with frequency: negligible below approximately 10 GHz, noticeable above 15 GHz, and significant above 22 GHz (oxygen resonance) and 60 GHz (strong oxygen band – though P.2001-6 stops at 50 GHz).
- The loss is added in decibels after the dominant propagation mechanism has been selected.
- It is nearly constant over time (except during rain, when humidity rises), so it shifts the entire loss distribution upward rather than changing its shape significantly.

This attenuation mechanism becomes increasingly important in the upper portion of the P.2001-6 frequency range (approximately 20–50 GHz) and must be accurately modelled for systems operating near oxygen absorption peaks.
