package com.kilcher.Planet;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *  Tests calcForceExertedByX and calcForceExertedByY methods in Planets.
 */
public class TestCalcForceExertedByXY {

    @Test
    public void checkCalcForceExertedByXY() {
      System.out.println("Checking calcForceExertedByX() and calcForceExertedByY()...");

      Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
      Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");
        
      Planet p3 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");


      assertEquals("checking F_x exerted by p2 on p1", 133.4, p1.calcForceExertedByX(p2), 0.01);
      assertEquals("checking F_y exerted by p2 on p1", 0.0,   p1.calcForceExertedByY(p2), 0.01);

      assertEquals("checking F_x exerted by p3 on p1", 4.002e-11, p1.calcForceExertedByX(p3), 0.01);
      assertEquals("checking F_y exerted by p3 on p1", 5.336e-11, p1.calcForceExertedByY(p3), 0.01);    
  }

}