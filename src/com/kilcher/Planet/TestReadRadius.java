package com.kilcher.Planet;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *  Tests NBody.readRadius.  
 *  Reads in ./data/planets.txt and checks to see
 *  that result matches hard coded value.
 */
public class TestReadRadius {

    @Test
    public void checkReadRadius() {
	System.out.println("Checking readRadius()...");

	String planetsTxtPath = "./data/planets.txt";
        /* If the following line fails to compile, you probably need to make
         * a certain method static! */
        double actualOutput = NBody.readRadius(planetsTxtPath);
	assertEquals("readRadius()", 2.50E11, actualOutput, 0.01);
  }

}
