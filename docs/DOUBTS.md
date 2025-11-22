# Open Technical Doubts – ITU-R P.2001-6 Implementation

**Status: Documented for future resolution – 22 November 2025**

| # | Doubt | Why It Matters | Planned Resolution |
|---|-------|----------------|---------------------|
| 1 | Which exact editions of P.676, P.838, etc. were used during P.2001-6 validation? | Coefficient drift between editions can cause >1 dB error at 40 GHz | Cross-check against ITU validation datasets (when published) |
| 2 | Does P.2001-6 use the legacy or modern troposcatter scattering model? | Attachment E is ambiguous – could affect long-path predictions by several dB | Reverse-engineer against known trans-horizon test cases |
| 3 | Are P.836-6 water-vapour maps still authoritative in 2025, or superseded by re-analysis (ERA5)? | Modern implementations increasingly use satellite-derived data | Compare prediction error with ERA5-based ρ₀ |
| 4 | How strict must ICDF inversion follow P.1144 guidelines? | Affects Monte-Carlo runtime and numerical stability | Benchmark convergence speed vs accuracy |

These doubts do **not** block progress but should be resolved before a final reference implementation is declared "ITU-conformant".
