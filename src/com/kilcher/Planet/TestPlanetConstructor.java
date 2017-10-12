package com.kilcher.Planet;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetConstructor {

	@Test
	public void test() {
		System.out.println("Checking Planet constructor...");
		double xxPos = 1.0, yyPos = 2.0, xxVel = 3.0, yyVel = 4.0, mass = 5.0;
		String imgFileName = "jupiter.gif";
		Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		assertEquals("p.getxPos() = xxPos", xxPos, p.getxPos(), 0.001);
		assertEquals("p.getyPos() = yyPos", yyPos, p.getyPos(), 0.001);
		assertEquals("p.getxVel() = xxVel", xxVel, p.getxVel(), 0.001);
		assertEquals("p.getyVel() = yyVel", yyVel, p.getyVel(), 0.001);
		assertEquals("p.getMass() = mass", mass, p.getMass(), 0.001);
		assertEquals(imgFileName, imgFileName, p.getImgFileName());
		System.out.println("Checking Planet copy constructor...");
		Planet pCopy = new Planet(p);
		assertEquals("pCopy.xPos == p.xPos", p.getxPos(), pCopy.getxPos(), 0.001);
		assertEquals("pCopy.yPos == p.yPos", p.getyPos(), pCopy.getyPos(), 0.001);
		assertEquals("pCopy.xVel == p.xVel", p.getxVel(), pCopy.getxVel(), 0.001);
		assertEquals("pCopy.yVel == p.yVel", p.getyVel(), pCopy.getyVel(), 0.001);
		assertEquals("pCopy.mass == p.mass", p.getMass(), pCopy.getMass(), 0.001);
		assertEquals("pCopy.ImgFileName == p.getImgFileName", p.getImgFileName(), pCopy.getImgFileName());
		System.out.println("Checking Planet set methods...");
		double xPos = -1.0;p.setxPos(xPos);
		assertEquals("p.getxPos() = xPos", xPos, p.getxPos(), 0.001);
		double yPos = -2.0;p.setyPos(yPos);
		assertEquals("p.getyPos() = yPos", yPos, p.getyPos(), 0.001);
		double xVel = -3.0;p.setxVel(xVel);
		assertEquals("p.getxVel() = xVel", xVel, p.getxVel(), 0.001);
		double yVel = -4.0;p.setyVel(yVel);
		assertEquals("p.getyVel() = yVel", yVel, p.getyVel(), 0.001);
		mass = 5.0;p.setMass(mass);
		assertEquals("p.getMass() = mass", mass, p.getMass(), 0.001);
		imgFileName = "saturn.gif";
		p.setImgFileName(imgFileName);
		assertEquals("p.getImgFileName() = imgFileName", imgFileName, p.getImgFileName());
		}
	
	}


