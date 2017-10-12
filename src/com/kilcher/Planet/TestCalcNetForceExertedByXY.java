package com.kilcher.Planet;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.math.*; // for BigDecimal

/**
 *  Tests calcNetForceExertedByX and calcNetForceExertedByY methods in Planets.
 */
public class TestCalcNetForceExertedByXY {

    /**
     *  Rounds a double value to a number of decimal places.
     *
     *  @param  value   Double to be rounded.
     *  @param  places  Integer number of places to round VALUE to.
     */
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Test
    public void checkCalcNetForceExertedByXY() {
      System.out.println("Checking calcNetForceExertedByX() and calcNetForceExertedByY()...");

      Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
      Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");
        
      Planet p3 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");
      Planet p4 = new Planet(3.0, 2.0, 3.0, 4.0, 5.0, "jupiter.gif");

      Planet[] planets = {p2, p3, p4};

      double xNetForce = p1.calcNetForceExertedByX(planets);
      double yNetForce = p1.calcNetForceExertedByY(planets);

      assertEquals("calcNetForceExertedByX()", 133.4, round(xNetForce,2), 0.01);
      assertEquals("calcNetForceExertedByY()", 0.0, round(yNetForce,2), 0.01);
    
      System.out.println("Running test again, but with array that contains the target planet.");

      planets = new Planet[]{p1, p2, p3, p4};

      xNetForce = p1.calcNetForceExertedByX(planets);
      yNetForce = p1.calcNetForceExertedByY(planets);

      assertEquals("calcNetForceExertedByX()", 133.4, round(xNetForce,2), 0.01);
      assertEquals("calcNetForceExertedByY()", 0.0, round(yNetForce,2), 0.01);
  }

}