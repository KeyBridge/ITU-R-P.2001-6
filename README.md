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

### Repository status
- **Stage 0** – Project definition – COMPLETE
- **Stage 1** – Source review, canonical ASCII diagram & full documentation – COMPLETE
- **Stage 2** – Abstract mental model & Mermaid diagrams – ACTIVE

**Complete model documentation and component breakdown** → [docs/README.md](docs/README.md)

### Source document
Official normative reference (ITU-R P.2001-6, 09/2025):  
→ [docs/source/R-REC-P.2001-6-202509-I!!PDF-E.pdf](docs/source/R-REC-P.2001-6-202509-I!!PDF-E.pdf)

### License
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

— Maintained in collaboration with Grok (xAI) — November 2025
