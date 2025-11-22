# /docs – Project Documentation for ITU-R P.2001-6

This directory contains all supporting documentation for the high-fidelity Java architecture of Recommendation ITU-R P.2001-6 (September 2025).

## Structure

### Source material
- `/source/` – Official ITU-R P.2001-6 document (PDF)  
  → [R-REC-P.2001-6-202509-I!!PDF-E.pdf](source/R-REC-P.2001-6-202509-I!!PDF-E.pdf)

### Model components (traceable explanations)
- `/components/` – One Markdown file per major section and attachment of the Recommendation

| File | Content | Traceability |
|------|--------|--------------|
| [00-OVERVIEW.md](components/00-OVERVIEW.md) | Canonical high-level model diagram (ASCII) | §3–5 + Attachment J |
| [01-Normal-Propagation.md](components/01-Normal-Propagation.md) | Sub-model 1 – Normal propagation close to Earth | §4.1 |
| [02-Anomalous-Propagation.md](components/02-Anomalous-Propagation.md) | Sub-model 2 – Ducting & layer reflection | §4.2 + Attachment D |
| [03-Troposcatter.md](components/03-Troposcatter.md) | Sub-model 3 – Troposcatter propagation | §4.3 + Attachment E |
| [04-Sporadic-E.md](components/04-Sporadic-E.md) | Sub-model 4 – Sporadic-E ionospheric reflection | §4.4 + Attachment G |
| [05-Diffraction-Attachment-A.md](components/05-Diffraction-Attachment-A.md) | Diffraction mechanisms (knife-edge & spherical) | Attachment A |
| [06-Clear-Air-Enhancements-Attachment-B.md](components/06-Clear-Air-Enhancements-Attachment-B.md) | Multipath fading and enhancement | Attachment B |
| [07-Precipitation-Fading-Attachment-C.md](components/07-Precipitation-Fading-Attachment-C.md) | Rain and melting-layer attenuation | Attachment C |
| [08-Gaseous-Absorption-Attachment-F.md](components/08-Gaseous-Absorption-Attachment-F.md) | Oxygen and water-vapour absorption | Attachment F |
| [09-Model-Combination-Attachment-J.md](components/09-Model-Combination-Attachment-J.md) | Final statistical combination of all mechanisms | Attachment J |

All component documents are written purely from the official Recommendation text and are locked as part of Stage 1.

Future stages (abstract model, Mermaid diagrams, Java interface contracts, traceability matrix) will also be placed here as they are produced.

— Updated 22 November 2025
