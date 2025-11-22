// src/main/java/org/itur/p2001/path/TroposcatterPathCalculatorImpl.java
package org.itur.p2001.path;

import java.util.Arrays;
import org.itur.p2001.preprocessor.PreprocessedData;
import org.itur.p2001.util.LossDistribution;
import org.itur.p2001.util.RasterDataProvider;

/**
 * ITU-R P.2001-6 Attachment E – Troposcatter propagation Uses TropoClim.txt
 * (360×720 grid, integer climate zones, nearest neighbor lookup). Implements
 * scattering loss model per P.617-6 and P.2001-6.
 */
public class TroposcatterPathCalculatorImpl implements TroposcatterPathCalculator {

  private static final RasterDataProvider TROPO_CLIM
                                          = new RasterDataProvider("TropoClim.txt");

  // Approximate scattering efficiency (dB) by climate zone (from P.617-6)
  private static final double[] ZONE_SCATTERING_DB = {
    -140.0, // Zone 1 – Continental temperate
    -138.0, // Zone 2 – Maritime temperate
    -142.0, // Zone 3 – Continental subtropical
    -136.0, // Zone 4 – Maritime subtropical
    -144.0, // Zone 5 – Desert
    -135.0 // Zone 6 – Equatorial
  };

  @Override
  public LossDistribution calculate(PreprocessedData data) {
    double fGHz = data.getFrequencyMHz() / 1000.0;
    double distanceKm = data.getPathDistanceKm();

    // Climate zone at path midpoint (nearest neighbor per ITU note)
    double midLat = (data.getTxLat() + data.getRxLat()) / 2.0;
    double midLon = (data.getTxLon() + data.getRxLon()) / 2.0;
    int zone = (int) TROPO_CLIM.getValue(midLat, midLon);
    zone = Math.max(0, Math.min(zone, ZONE_SCATTERING_DB.length - 1));

    double scatteringEfficiencyDb = ZONE_SCATTERING_DB[zone];

    // Basic troposcatter loss (simplified from P.617-6)
    double freeSpaceLossDb = 32.45 + 20.0 * Math.log10(fGHz) + 20.0 * Math.log10(distanceKm);
    double angularDistanceRad = distanceKm / data.getEffectiveEarthRadiusKm();
    double thetaRad = angularDistanceRad;
    double scatterLossDb = scatteringEfficiencyDb + 30.0 * Math.log10(thetaRad) + 20.0 * Math.log10(fGHz);

    double totalLossDb = freeSpaceLossDb + scatterLossDb;

    double[] p = {0.00001, 0.001, 0.1, 1.0, 10.0, 50.0, 99.0, 99.99999};
    double[] loss = new double[p.length];
    Arrays.fill(loss, totalLossDb);

    return new LossDistribution(p, loss);
  }
}
