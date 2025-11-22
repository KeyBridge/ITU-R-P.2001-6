# Attachment C – Precipitation Fading

**Traceability**: Attachment C (§C.1–C.5)

### Role in the Model
Attachment C describes the additional transmission loss caused by precipitation (rain, snow, melting layer) along the path. This is one of the three additive attenuation mechanisms applied after the four parallel propagation paths have been computed.

### Key calculations performed
- **Preliminary calculations** (§C.2)  
  Determines rain intensity exceedance, rain height, and path segment classification (rain vs. melting layer).
- **Percentage time a given precipitation fade level is exceeded** (§C.3)  
  Core model that produces the time-varying attenuation due to rain.
- **Melting-layer (bright-band) model** (§C.4)  
  Accounts for enhanced attenuation in the 0 °C isotherm layer where snow melts into rain.
- **Path-averaged multiplier** (§C.5)  
  Adjusts the specific attenuation (dB/km) to account for spatial non-uniformity of rainfall along real paths.

### Behaviour in the overall model
- Precipitation attenuation is treated as an additive loss applied on top of whichever parallel propagation mechanism (diffraction, ducting, troposcatter, or sporadic-E) is active at a given percentage time.
- The effect is strongly frequency-dependent: negligible below approximately 5 GHz, moderate up to 20 GHz, and dominant above 30 GHz on long paths.
- Rain fading affects both fading (increased loss) and, indirectly, enhancement tails by raising the overall loss floor during rainy periods.

This attachment is essential for accurate predictions in the upper part of the P.2001-6 frequency range (approximately 20–50 GHz) and for systems requiring high availability (p > 99 %).
