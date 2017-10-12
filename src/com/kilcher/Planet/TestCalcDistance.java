package com.kilcher.Planet;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *  Tests the calcDistance method in Planets.
 */
public class TestCalcDistance {

    @Test
    public void checkCalcDistance() {
      System.out.println("Checking calcDistance()...");

      Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
      Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
      Planet p3 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

      assertEquals("p1 to p2 distance == 1.0", 1.0, p1.calcDistance(p2), 0.01);
      assertEquals("p1 to p3 distance == 5.0", 5.0, p1.calcDistance(p3), 0.01);
  }

}