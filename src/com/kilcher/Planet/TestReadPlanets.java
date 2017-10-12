package com.kilcher.Planet;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *  Tests NBody.readPlanets.  
 *  Reads in ./data/planets.txt and checks 
 *  output of readPlanets().
 */
public class TestReadPlanets {

    @Test
    public void checkReadPlanets() {
	System.out.println("Checking readPlanets()...");

	String planetsTxtPath = "./data/planets.txt";
        /* If the following line fails to compile, you probably need to make
         * a certain method static! */
	Planet[] actualOutput = NBody.readPlanets(planetsTxtPath);

        /* Check the simple things: */
        if (actualOutput == null) {
            fail("readPlanets(); null output");
	    return;
        }
        if (actualOutput.length != 5) {
            fail("FAIL: readPlanets().length: Expected 5 and you gave " + actualOutput.length);
	    return;
        }

        /* Check to make sure every planet exists, plus random spot checks */
        boolean foundEarth = false;
        boolean foundMars = false;
        boolean foundMercury = false;
        boolean foundSun = false;
        boolean foundVenus = false;
        boolean randomChecksOkay = true;
        for (Planet p : actualOutput) {
            if ("earth.gif".equals(p.getImgFileName())) {
                foundEarth = true;
                try {
		    assertEquals(1.4960e+11, p.getxPos(), 0.01);
		}
		catch (Exception e) {
                    System.out.println("Advice: Your Earth doesn't have the right xxPos!");
                    randomChecksOkay = false;
                }
            } else if ("mars.gif".equals(p.getImgFileName())) {
                foundMars = true;
            } else if ("mercury.gif".equals(p.getImgFileName())) {
                foundMercury = true;
                try {
		    assertEquals(0, p.getyPos(), 0.01);
		}
		catch (Exception e) {
                    System.out.println("Advice: Your Mercury doesn't have the right yyPos!");
                    randomChecksOkay = false;
                }
            } else if ("sun.gif".equals(p.getImgFileName())) {
                foundSun = true;
            } else if ("venus.gif".equals(p.getImgFileName())) {
                foundVenus = true;
                try {
		    assertEquals(4.8690e+24, p.getMass(), 0.01);
		}
		catch (Exception e) {
                    System.out.println("Advice: Your Venus doesn't have the right mass!");
                    randomChecksOkay = false;
                }
            }
        }

	/* Build up a nice list of missing planets */
        String missingPlanets = "";
        if (!foundEarth) {
            missingPlanets += "Earth, ";
        }
        if (!foundMars) {
            missingPlanets += "Mars, ";
        }
        if (!foundMercury) {
            missingPlanets += "Mercury, ";
        }
        if (!foundSun) {
            missingPlanets += "Sun, ";
        }
        if (!foundVenus) {
            missingPlanets += "Venus, ";
        }
        if (missingPlanets.length() > 0) {
            String answer = "readPlanets(); Missing these planets: ";
            answer += missingPlanets.substring(0, missingPlanets.length() - 2);
	    fail(answer);
	}

	if (!randomChecksOkay) {
            fail("readPlanets(); Not all planets have correct info!");
        } else {
	    System.out.println("readPlanets(); Congrats! This was the hardest test!");
	}
  }

}
