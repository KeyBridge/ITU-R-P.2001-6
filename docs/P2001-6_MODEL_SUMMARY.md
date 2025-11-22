# ITU-R P.2001-6 (09/2025) – Model Summary
**Authoritative high-level description – locked 22 November 2025**

### Purpose
P.2001-6 is the ITU’s definitive general-purpose terrestrial propagation model for frequencies 30 MHz to 50 GHz and distances from 3 km to over 1 000 km.  
It predicts **basic transmission loss** (including both fading and enhancement) over the full time percentage range 0.00001 % – 99.99999 %, making it the only ITU model designed from the ground up for **Monte-Carlo interference studies** with no discontinuities.

### Core Concept – “Four highways, three toll booths”
The model treats propagation as **seven physical mechanisms** that are combined in a rigorously defined way (Attachment J):

**Four parallel end-to-end propagation paths** (exactly one is active at any given time percentage p):
1. **Diffraction-dominated normal propagation** (§4.1 + Attachment A)  
   – Knife-edge and spherical-Earth diffraction over terrain (P.526-16 Bullington method)  
   – Dominant for most obstructed paths
2. **Anomalous propagation (ducting / layer reflection)** (§4.2 + Attachment D)  
   – Surface and elevated ducts, especially over sea or flat land  
   – Uses ΔN from IDWM and P.836 climatic zones
3. **Troposcatter** (§4.3 + Attachment E, using P.617-6 scattering model)  
   – Long-distance scattering from atmospheric turbulence  
   – Important on trans-horizon continental paths
4. **Sporadic-E** (§4.4 + Attachment G, using P.844-1 ionospheric data)  
   – Rare ionospheric reflection, mainly below ~150 MHz

**Three additive attenuation mechanisms** (always applied on top of the selected path):
1. **Gaseous absorption** (Attachment F → P.676-13) – oxygen + water-vapour
2. **Precipitation fading** (Attachment C → P.838-3 rain attenuation + P.837/P.839 rain height)
3. **Clear-air multipath / focusing** (Attachment B)

### Final Combination (Attachment J)
At every time percentage p:
- Select the **minimum** loss from the four parallel paths
- Add the **three attenuations** using correlation-aware statistics derived from global meteorology
- Output a single, smooth inverse cumulative distribution function (ICDF) of basic transmission loss L_b(p)

This structure guarantees physical realism and seamless transition between mechanisms.

### Frequency-Dependent Behaviour (intuitive)
| Frequency range      | Dominant mechanisms                              |
|----------------------|---------------------------------------------------|
| 30 MHz – ~1 GHz      | Diffraction + Sporadic-E (when active)            |
| 1 – ~10 GHz          | Diffraction + occasional ducting + troposcatter   |
| 10 – 30 GHz          | Diffraction + ducting + increasing gaseous loss   |
| 30 – 50 GHz          | Heavy gaseous + rain attenuation; ducting still critical for interference tails |

### Key External Dependencies (all now closed)
- P.676-13 – Gaseous absorption (O₂ + H₂O)
- P.838-3 – Rain specific attenuation γ_R = kR^α
- P.836-6 – Surface water-vapour density ρ₀
- P.837-8 / P.839-4 – Rain height and precipitation characteristics
- P.617-6 – Troposcatter scattering model
- P.526-16 – Precise Bullington diffraction
- IDWM – ΔN and climatic zone data
- P.844-1 – Sporadic-E (optional above 150 MHz)

### Architectural Implications
The Java architecture **must** preserve this exact physics-first structure:
- Four independent `PathCalculator` implementations
- Three independent `AttenuationCalculator` implementations
- One `AttachmentJCombiner` that performs minimum-selection then correlated addition
- No merging or averaging of mechanisms allowed

This summary reflects the complete, gap-free understanding achieved after ingestion of P.2001-6 and all normative references.

**Locked as canonical – 22 November 2025**
