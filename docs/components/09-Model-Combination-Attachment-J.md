# Attachment J – Structure of the Wide-Range Propagation Model

**Traceability**: Attachment J (§J.1–J.2)

### Role in the Model
Attachment J is the heart of ITU-R P.2001-6. It defines exactly how the seven individual propagation and attenuation mechanisms are combined to produce the final basic transmission loss not exceeded for any given percentage of time (0 % to 100 %).

### Overall structure (as described in §J.2)
The model consists of:
- **Four parallel end-to-end propagation paths**  
  These represent different physical ways the signal can travel from transmitter to receiver:
  1. Diffraction-dominated (Sub-model 1 + Attachment A)
  2. Ducting / layer-reflection (Sub-model 2 + Attachment D)
  3. Troposcatter (Sub-model 3 + Attachment E)
  4. Sporadic-E (Sub-model 4 + Attachment G)

  At any given percentage time, the dominant (lowest-loss) path among these four is selected.

- **Three additive attenuation mechanisms**  
  These are applied on top of whichever parallel path is active:
  1. Gaseous absorption (Attachment F)
  2. Precipitation fading (Attachment C)
  3. Clear-air multipath/focusing enhancement and fading (Attachment B)

### Statistical combination method
- Each of the four parallel paths produces a full inverse cumulative distribution function (ICDF) of basic transmission loss over 0–100 % time.
- The three additive attenuations also produce time-dependent loss distributions.
- The final ICDF is obtained by:
  1. Taking the minimum loss among the four parallel paths at each percentage time (reflecting the strongest mechanism that occurs).
  2. Adding the three attenuation contributions (in decibels) using a correlation-aware method derived from long-term meteorological statistics.
  3. The result is a single, smooth, physically realistic ICDF that correctly captures both deep fades and strong enhancements across all time percentages.

### Why this structure matters
- It ensures continuity: no artificial jumps when moving from LoS to trans-horizon to anomalous conditions.
- It naturally supports Monte-Carlo simulations: one model, one output distribution, full 0–100 % coverage.
- It reflects real-world physics: multiple mechanisms can coexist, but only the strongest path plus common attenuations determine the received signal at any instant.

Attachment J is what makes P.2001-6 uniquely suitable for modern spectrum-sharing and interference studies requiring seamless treatment of both wanted-signal availability and worst-case interference tails.
