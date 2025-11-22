# Critical Gaps in ITU-R P.2001-6 (09/2025)

**Status: Identified and documented – 22 November 2025**

P.2001-6 is a *hybrid* model. While it defines the overall structure and combination method (Attachment J), it **deliberately omits detailed physics** for several mechanisms and instead normatively references other ITU-R Recommendations.

The following components **cannot be faithfully implemented** from P.2001-6 alone:

| Gap | Location in P.2001-6 | Required External Reference | Status in Repository |
|-----|------------------------|-------------------------------|-----------------------|
| Gaseous attenuation (oxygen + water vapour) | §3.10, Attachment F | **P.676** | Missing – must import |
| Rain specific attenuation γ_R(f, R) | Attachment C §C.3 | **P.838** | Missing – must import |
| Rain height & 0°C isotherm | Attachment C §C.2, §C.4 | **P.837**, **P.839** | Missing – must import |
| Surface water-vapour density maps | Attachment F §F.2, §3.4 | **P.836** | Missing – must import |
| Radio-climatic zones (ΔN, β₀, ducting incidence) | Attachment D §D.1 | **P.836** + **IDWM** | IDWM added (uncommitted) |
| Melting-layer (bright-band) enhancement | Attachment C §C.4 | **P.839** + literature | Missing – must import |
| Troposcatter scattering efficiency | Attachment E §E.3 | **P.617** | Missing – strongly advised |
| Sporadic-E foEs maps & occurrence | Attachment G §G.1 | **P.844**, ionospheric data | Missing – optional above 150 MHz |
| Bullington knife-edge reduction details | Attachment A §A.4–A.5 | **P.526** | Minor – should import for precision |

**Conclusion**: A numerically accurate implementation of P.2001-6 **requires at minimum** P.676, P.838, P.836, P.837, and P.839. These are not optional enhancements — they are **normative dependencies**.

These gaps will be closed in Stage 3 via dedicated adapter classes.
