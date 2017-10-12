package com.kilcher.Planet;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *  Tests the calcForceExertedBy  method in Planets.
 */
public class TestCalcForceExertedBy {

    @Test
    public void checkCalcForceExertedBy() {
      System.out.println("Checking calcForceExertedBy()...");

      Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
      Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");
      Planet p3 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

      assertEquals("Force exerted by p2 on p1 = 133.4 N", 133.4, p1.calcForceExertedBy(p2), 0.01);
      assertEquals("Force exerted by p3 on p1 = 6.67e-11 N", 6.67e-11, p1.calcForceExertedBy(p3), 1e-14);
  }

}