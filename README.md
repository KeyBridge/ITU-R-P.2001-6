# ITU-R P.2001-6 — Wide-Range Terrestrial Propagation Model
**30 MHz – 50 GHz | 3 km – ≥1 000 km | 0.00001 % – 99.99999 % time**

![ITU-R P.2001-6](https://www.itu.int/dms_pubrec/itu-r/rec/p/R-REC-P.2001-6-202509-I!!PDF-E.pdf)

This repository is dedicated to producing a **high-fidelity, fully traceable Java software architecture** for the ITU-R Recommendation P.2001-6 (September 2025) — the current state-of-the-art general-purpose wide-range terrestrial propagation model.

### Purpose of this repository
- Deliver a clean, modular, human-readable architecture that mirrors the Recommendation section-by-section.
- Every package, interface, and method will be explicitly mapped back to the original ITU-R document.
- The final output will serve as the foundation for a future open-source reference implementation.

### Key features of P.2001-6 (2025)
- Covers **both fading and enhancement** over the full 0–100 % time range
- Designed for **Monte-Carlo interference and sharing studies**
- Four parallel propagation mechanisms (diffraction, ducting, troposcatter, sporadic-E)
- Three additive attenuation terms (gaseous, precipitation, multipath/focusing)
- Statistically rigorous combination via inverse CDFs (Attachment J)
- Frequency range: **30 MHz to 50 GHz**
- Distance range: **≥3 km** (no upper limit specified)

### Repository status
- **Stage 0** – Project definition – COMPLETE
- **Stage 1** – Source review & canonical ASCII diagram – COMPLETE
- **Stage 2** – Abstract mental model & Mermaid diagrams – ACTIVE

See the canonical high-level model in ASCII form here:  
[docs/components/00-OVERVIEW.md](docs/components/00-OVERVIEW.md)

### Source document
The normative reference is the official ITU-R P.2001-6 (09/2025):  
[docs/source/R-REC-P.2001-6-202509-I!!PDF-E.pdf](docs/source/R-REC-P.2001-6-202509-I!!PDF-E.pdf)

### License
To be determined (will respect ITU redistribution rules).

— Maintained in collaboration with Grok (xAI) — November 2025
