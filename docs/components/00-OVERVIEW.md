# P.2001-6 Model Overview (Canonical ASCII Diagram)

**Locked as canonical on 22 November 2025**

ITU-R P.2001-6 Wide-Range Propagation Model
(30 MHz – 50 GHz)

```
                     ITU-R P.2001-6 Wide-Range Propagation Model
                                   (30 MHz – 50 GHz)

                         +-------------------------------------+
                         |             INPUTS                  |
                         |  • Terrain profile (d_i, h_i, z_i) |
                         |  • Frequency, distance, heights    |
                         |  • Time percentage p (0–100%)      |
                         +-------------------------------------+
                                           │
                                           ▼
                         +-------------------------------------+
                         |      §3 PRELIMINARY CALCULATIONS    |
                         |  Path geometry, effective Earth    |
                         |  radius, horizon angles, roughness |
                         |  free-space loss, knife-edge diff. |
                         +-------------------------------------+
                                           │
             ┌─────────────────────────────────────────────────────────────┐
             │                     SUB-MODELS (§4)                         │
             │            (each produces L_b(p) over 0–100%)               │
             │                                                             │
   +---------▼----------+        +-------------+        +-------------+  +------------+
   | Sub-model 1        |        | Sub-model 2 |        | Sub-model 3 |  | Sub-model 4|
   | Normal propagation |        | Anomalous   |        | Troposcatter|  | Sporadic-E |
   | (diffraction +     |        | (ducting /  |        | propagation |  | (ionospheric|
   | surface effects)   |        | layer refl.)|        +-------------+  | reflection) |
   +--------------------+        +-------------+                            +------------+
             │                           │
             ▼                           ▼
   +-------------------------------------+   +----------------------------------+
   | Attachment A – Diffraction          |   | Attachment D – Ducting / Layer   |
   | Attachment B – Clear-air (multipath)|   | Attachment E – Troposcatter      |
   | Attachment C – Precipitation fading|   | Attachment G – Sporadic-E        |
   +-------------------------------------+
                                           │
             ┌─────────────────────────────────────────────────────────────┐
             │               ADDITIVE ATTENUATIONS                         │
             │   (applied on top of the parallel paths)                    │
             │   • Gaseous absorption          (Attachment F)             │
             │   • Precipitation attenuation   (Attachment C)             │
             │   • Multipath / focusing         (Attachment B)             │
             └─────────────────────────────────────────────────────────────┘
                                           │
                                           ▼
                         +-------------------------------------+
                         |      §5 & Attachment J              |
                         |       FINAL COMBINATION             |
                         |  • 4 parallel end-to-end paths      |
                         |  • 3 additive loss terms            |
                         |  • Statistical combining using      |
                         |    inverse CDFs (ICDF) and          |
                         |    meteorological correlations      |
                         +-------------------------------------+
                                           │
                                           ▼
                         +-------------------------------------+
                         |            OUTPUT                   |
                         |  Basic transmission loss L_b(p)    |
                         |  not exceeded for percentage p     |
                         |  of an average year (0–100%)       |
                         +-------------------------------------+
```

This diagram is the authoritative high-level reference for the entire architecture.
