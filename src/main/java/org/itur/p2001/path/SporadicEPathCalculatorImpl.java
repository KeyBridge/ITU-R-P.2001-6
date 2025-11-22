// src/main/java/org/itur/p2001/path/SporadicEPathCalculatorImpl.java
package org.itur.p2001.path;

import org.itur.p2001.preprocessor.PreprocessedData;
import org.itur.p2001.util.LossDistribution;
import org.itur.p2001.util.RasterDataProvider;

/**
 * ITU-R P.2001-6 Attachment G – Sporadic-E propagation Uses FoEs50.txt,
 * FoEs10.txt, FoEs01.txt, FoEs0.1.txt (critical frequency exceedance)
 * Implements simple single-hop model with MUF comparison.
 */
public class SporadicEPathCalculatorImpl implements SporadicEPathCalculator {

  private static final RasterDataProvider FOES_50 = new RasterDataProvider("FoEs50.txt");
  private static final RasterDataProvider FOES_10 = new RasterDataProvider("FoEs10.txt");
  private static final RasterDataProvider FOES_01 = new RasterDataProvider("FoEs01.txt");
  private static final RasterDataProvider FOES_01T = new RasterDataProvider("FoEs0.1.txt");

  @Override
  public LossDistribution calculate(PreprocessedData data) {
    double fMHz = data.getFrequencyMHz();
    double distanceKm = data.getPathDistanceKm();

    // Midpoint of path for ionospheric sampling
    double midLat = (data.getTxLat() + data.getRxLat()) / 2.0;
    double midLon = (data.getTxLon() + data.getRxLon()) / 2.0;

    // foEs exceeded for 50%, 10%, 1%, 0.1% of time
    double foEs50 = FOES_50.getValue(midLat, midLon);
    double foEs10 = FOES_10.getValue(midLat, midLon);
    double foEs01 = FOES_01.getValue(midLat, midLon);
    double foEs01t = FOES_01T.getValue(midLat, midLon);

    // Simple MUF approximation for single-hop Sporadic-E
    double muf50 = foEs50 * 1.7;  // Typical M(3000)F2 factor
    double muf10 = foEs10 * 1.7;
    double muf01 = foEs01 * 1.7;
    double muf01t = foEs01t * 1.7;

    // Only active when operating frequency is below MUF
    double[] p = {0.00001, 0.001, 0.1, 1.0, 10.0, 50.0, 99.0, 99.99999};
    double[] loss = new double[p.length];

    for (int i = 0; i < p.length; i++) {
      double exceedance = p[i];
      double muf = exceedance <= 50 ? muf50
                   : exceedance <= 10 ? muf10
                     : exceedance <= 1 ? muf01 : muf01t;

      if (fMHz < muf && distanceKm < 2300) {  // Single-hop limit ~2300 km
        // Very low loss when active
        loss[i] = 80.0 + 20.0 * Math.log10(distanceKm / 1000.0);
      } else {
        loss[i] = 200.0;  // Effectively blocked
      }
    }

    return new LossDistribution(p, loss);
  }
}
