# Sub-model 4 – Sporadic-E Propagation (§4.4)

**Traceability**: §4.4, Attachment G (Sporadic-E propagation)

### Role in the Model
This sub-model handles occasional strong ionospheric reflection caused by Sporadic-E (Es) layers, primarily relevant below approximately 150 MHz (VHF band). At higher frequencies (UHF and above), Es propagation becomes negligible and is effectively ignored.

### Key calculations performed (Attachment G)
- Derivation of foEs (critical frequency of the Es layer) from global maps and solar activity (§G.1)
- 1-hop Sporadic-E propagation geometry and field strength (§G.2)
- 2-hop propagation when path length permits (§G.3)
- Basic transmission loss for Es paths, including MUF (maximum usable frequency) checks (§G.4)

### Architectural implication (future Java)
A `SporadicECalculator` will:
- Accept solar activity index and geographic coordinates
- Look up or interpolate monthly/seasonal foEs maps
- Determine whether the operating frequency is below the MUF
- Compute 1-hop and (if applicable) 2-hop loss
- Return a very low loss for small percentages of time (typically summer daytime at VHF)

### Important notes from the Recommendation
- Sporadic-E is highly seasonal and diurnal
- Primarily affects frequencies up to ~150 MHz; contribution drops rapidly above 100 MHz
- Can create extremely long interference ranges (thousands of km) for very small time percentages

In Monte-Carlo sharing studies involving VHF services (e.g., FM broadcasting, aeronautical), this sub-model is critical despite its rarity, because when active it often becomes the dominant (lowest-loss) mechanism.
