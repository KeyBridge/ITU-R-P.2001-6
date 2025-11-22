# Abstract Mental Model – ITU-R P.2001-6 Java Architecture
**Locked as canonical – 22 November 2025**

## Core Design Philosophy
The P.2001-6 model is fundamentally built on **seven physical mechanisms** that compete and combine in a statistically rigorous way. The Java architecture must preserve this physics-first structure with **zero abstraction leakage**.

### The Seven Mechanisms (never to be merged or hidden)
1. Diffraction-dominated normal propagation
2. Ducting / layer-reflection (anomalous)
3. Troposcatter
4. Sporadic-E
5. Gaseous absorption
6. Precipitation fading (including melting layer)
7. Clear-air multipath / focusing enhancement & fading

### Fundamental Rule (non-negotiable)
At any given percentage time p:
- Exactly **one** of the four end-to-end paths (1–4) is active — the one with the lowest loss.
- All **three** additive attenuations (5–7) are always applied on top of the selected path.

This is **not** a layered cake.  
This is **four parallel highways** with **three toll booths** you always pass after choosing your highway.

### Abstract Computational Flow
```ascii
Inputs → Section 3 Pre-processor → Four independent Sub-model Calculators
          └──────────────────────→ Minimum selector (strongest path)
                                         ↓
                                 Three Attenuation Calculators
                                         ↓
                             Correlation-aware summer (Attachment J)
                                         ↓
                             Final ICDF of L_b(p) for 0.00001% ≤ p ≤ 99.99999%
```



### Key Architectural Consequences
- Every sub-model **must** produce a complete inverse CDF (ICDF) over the full time range.
- The final combiner **must not** average or weight — it selects the minimum path first, then adds.
- No mechanism may be approximated away or merged into another.
- All intermediate results must be traceable to a specific section/attachment.

### Java Mapping Strategy (preview)

```ascii
org.itur.p2001
├── model
│   ├── PropagationModel            → orchestrates the entire flow
│   ├── input                       → immutable input DTOs
│   ├── preprocessor               → Section 3 calculations
│   ├── path
│   │   ├── DiffractionPathCalculator
│   │   ├── DuctingPathCalculator
│   │   ├── TroposcatterPathCalculator
│   │   └── SporadicEPathCalculator
│   ├── attenuation
│   │   ├── GaseousAbsorption
│   │   ├── PrecipitationAttenuation
│   │   └── ClearAirFading
│   └── combiner                    → Attachment J (minimum + correlated sum)
└── result                          → ICDF, L_b(p), statistics
```
