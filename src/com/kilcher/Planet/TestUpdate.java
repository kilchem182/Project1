package com.kilcher.Planet;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *  Tests update in Planets
 */
public class TestUpdate {

    @Test
    public void checkUpdate() {
	System.out.println("Checking update()...");

      Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");

      p1.update(2.0, 1.0, -0.5);

      assertEquals("xPos from update()", 7.8, p1.getxPos(), 0.01);
      assertEquals("yPos from update()", 8.6, p1.getyPos(), 0.01);
      assertEquals("xVel from update()", 3.4, p1.getxVel(), 0.01);
      assertEquals("yVel from update()", 3.8, p1.getyVel(), 0.01);
  }

}