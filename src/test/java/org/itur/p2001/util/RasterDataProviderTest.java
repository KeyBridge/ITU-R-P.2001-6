// src/test/java/org/itur/p2001/util/RasterDataProviderTest.java
package org.itur.p2001.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RasterDataProviderTest {

  @Test
  public void testDNMedian_Equator() {
    RasterDataProvider provider = new RasterDataProvider("DN_Median.txt");
    double value = provider.getValue(0.0, 0.0);
    assertEquals(53.048, value, 0.001, "ΔN at equator (0°N, 0°E) should be 53.048");
  }

  @Test
  public void testDNMedian_Polar() {
    RasterDataProvider provider = new RasterDataProvider("DN_Median.txt");
    double value = provider.getValue(90.0, 0.0);
    assertEquals(40.726, value, 0.001, "ΔN at North Pole should be 40.726");
  }

  @Test
  public void testSurfwv50_Equator() {
    RasterDataProvider provider = new RasterDataProvider("Surfwv_50_fixed.txt");
    double value = provider.getValue(0.0, 0.0);
    assertEquals(18.040034, value, 1e-6, "Water vapour at equator should be 18.040034 g/m³");
  }
}
