# ITU-R P.2001-6 — Wide-Range Terrestrial Propagation Model
**30 MHz – 50 GHz | 3 km – ≥1 000 km | 0.00001 % – 99.99999 % time**

![ITU-R P.2001-6](https://www.itu.int/dms_pubrec/itu-r/rec/p/R-REC-P.2001-6-202509-I!!PDF-E.pdf)

This repository contains a **high-fidelity, fully traceable Java software architecture** for Recommendation ITU-R P.2001-6 (September 2025) — the current state-of-the-art general-purpose wide-range terrestrial propagation model.

### Purpose
- Deliver a clean, modular, human-readable architecture that mirrors the Recommendation section-by-section
- Every future package, interface, and method will be explicitly mapped back to the original ITU-R document
- Serve as the foundation for a future open-source reference implementation

### Key features of P.2001-6 (2025)
- Covers **both fading and enhancement** over the full 0–100 % time range
- Designed specifically for **Monte-Carlo interference and sharing studies**
- Four parallel propagation mechanisms (diffraction, ducting, troposcatter, sporadic-E)
- Three additive attenuation terms (gaseous absorption, precipitation, multipath/focusing)
- Statistically rigorous combination via inverse CDFs (Attachment J)
- Frequency range: **30 MHz to 50 GHz**
- Distance range: **≥3 km** (no upper limit specified)

### Source document
Official normative reference (ITU-R P.2001-6, 09/2025):  
→ [docs/source/R-REC-P.2001-6-202509-I!!PDF-E.pdf](docs/source/R-REC-P.2001-6-202509-I!!PDF-E.pdf)

### Key Resources
- **Source document**: [docs/source/R-REC-P.2001-6-202509-I!!PDF-E.pdf](docs/source/R-REC-P.2001-6-202509-I!!PDF-E.pdf)
- **Full model documentation**: [docs/README.md](docs/README.md)
- **Canonical architecture diagram**: [docs/diagrams/P2001-6-Model.mmd](docs/diagrams/P2001-6-Model.mmd)
- **Critical gaps requiring external references**: [docs/GAPS.md](docs/GAPS.md)
- **Open technical doubts**: [docs/DOUBTS.md](docs/DOUBTS.md)
- **All 14 normative ITU-R references**: [docs/references/](docs/references/)
- **Supporting datasets (including IDWM)**: [docs/data/](docs/data/)

### License
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)


— Maintained in collaboration with Grok (xAI) — November 2025



---

### Official ITU-R P.2001-6 Specification (September 2025)

**Recommendation ITU-R P.2001-6**  
**P Series: Radio-wave propagation**  
**A general purpose wide-range terrestrial propagation model in the frequency range 30 MHz to 50 GHz**  
*(Question ITU-R 205/3)*  
*(2012-2013-2015-2019-2021-2023-2025)*

**Scope**  
This Recommendation contains a general purpose wide-range model for terrestrial propagation which predicts basic transmission loss due to both signal enhancements and fading over effectively the range from 0 % to 100 % of an average year. This makes the model particularly suitable for Monte-Carlo methods, and studies in which it is desirable to use the same propagation model, with no discontinuities in its output, for signals which may be either wanted or potentially interfering.

**Keywords**  
Monte Carlo, diffraction, ducting, precipitation, layer reflection, troposcatter, gaseous absorption, sporadic-E

**Abbreviations**  
- ICDF – Inverse cumulative distribution function  
- IDWM – ITU Digitized World Map  
- LoS / NLoS – Line-of-sight / Non-line-of-sight  
- UHF / VHF – Ultra-high / Very high frequency  
- WRPM – Wide-range propagation model

**Normative External References** (all present in `/docs/references/`):  
P.452 P.528 P.530 P.617 P.676 P.836 P.837 P.838 P.839 P.844 P.1144 P.1411 P.1546 P.1812

**Official document**: [docs/source/R-REC-P.2001-6-202509-I!!PDF-E.pdf](docs/source/R-REC-P.2001-6-202509-I!!PDF-E.pdf)

This implementation is built **exclusively** from the official ITU-R P.2001-6 (09/2025) specification and its normative dependencies — no approximations, no legacy models, no external assumptions.

