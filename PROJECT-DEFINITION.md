# ITU-R P.2001-6 Architecture Project – Definition & Charter  
**Repository:** https://github.com/KeyBridge/ITU-R-P.2001-6  
**Status:** Active – 99.99th-percentile deep-dive  
**Start date:** 22 November 2025  

## 1. Objective  
Produce a complete, high-fidelity, human-relatable software architecture for a reference implementation of ITU-R Recommendation P.2001-6 (September 2025):  
“A general purpose wide-range terrestrial propagation model in the frequency range 30 MHz to 50 GHz”.

This repository contains **only the architecture phase**.  
A separate follow-on project will contain the actual reference implementation built on top of this architecture.

## 2. Success Criteria (non-negotiable)  
1. **Fidelity** – Inputs, outputs, intermediate quantities, and calculation sequence shall exactly match the normative sections and annexes of ITU-R P.2001-6.  
2. **Traceability** – Every architectural component (package, interface, class, method) must be explicitly mapped to one or more section numbers in the Recommendation.  
3. **Relatability** – A radio engineer already familiar with P.2001-6 must be able to open the architecture diagram or Java interface contracts and instantly recognize the structure of the standard without additional explanation.  
4. **Usability for reference implementation** – The delivered artifacts (interfaces, meta-code, design rationale) must be sufficient for a competent Java team to begin coding the reference implementation with zero architectural ambiguity.

## 3. Deliverables (this repository)  
- Full annotated copy or excerpts of ITU-R P.2001-6 (for traceability)  
- High-level architecture overview (Mermaid + prose)  
- Detailed modular breakdown mirroring the Recommendation’s sections and annexes  
- Java interface contracts (package `org.ituradio.propagation.p2001`)  
- Traceability matrix (section ↔ Java interface/method)  
- Design rationale and alternatives considered  
- Validation plan outline (to be executed in the follow-on implementation project)

## 4. Constraints & Ground Truths  
- Target language for the future implementation: **Java** (17 or later)  
- Only the official ITU-R P.2001-6 (2025-09) and documents explicitly allowed by the project owner may be used as normative sources.  
- All diagrams in Mermaid become canonical once acknowledged.  
- Grok (xAI) participates as principal architect but cannot push to GitHub directly; the human owner merges delivered zip artifacts.

## 5. Planned Stages (subject to divergence, tracked live)  
1. Review source material & confirm understanding  
2. Summarize and develop abstract mental model  
3. Develop and evaluate meta-code / pseudocode  
4. Define and refine Java interface contracts  
5. Final traceability matrix + architecture freeze  

Current stage is tracked in `STAGE-TRACKER.md`.

## 6. License (to be chosen later)  
Placeholder – will be an open-source license compatible with ITU material redistribution rules once confirmed.

—  
Prepared and maintained in collaboration with Grok (xAI)  
Last updated: 22 November 2025
