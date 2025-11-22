# /docs/data – Supporting Datasets

This directory contains large-scale digital datasets required for a numerically faithful implementation of ITU-R P.2001-6.

**Important**: The largest datasets (P.836 annual/monthly water-vapour maps, ~455 MB) are **explicitly excluded** via `.gitignore` to keep the repository lightweight.

| Dataset | Source | Status | Notes |
|-------|--------|--------|-------|
| ITU Digitized World Map (IDWM) | ITU-R | Committed | Includes DN50.txt and supporting files – used for ΔN and radio-climatic zoning |
| P.836 processed lookup tables (optional) | Derived from P.836-6 | Not committed | Can be generated at runtime or added as small CSV if needed |
| Other ancillary data (terrain, clutter, etc.) | Future | — | Will be added only if required for validation |

**Policy**: Only small, processed, or essential binary data is committed. Large raw map files are loaded at runtime from official ITU sources or local installation.
