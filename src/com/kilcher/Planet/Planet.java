package com.kilcher.Planet;

public class Planet {

	private double xPos = 0.0;
	private double yPos = 0.0;
	private double xVel = 0.0;
	private double yVel = 0.0;
	private double mass = 0.0;
	private String imgFileName = "";
	
	public double getxPos() {
		return xPos;
	}
	
	public void setxPos(double x) {
		xPos = x;
	}
	
	public double getyPos() {
		return yPos;
	}
	
	public void setyPos(double y) {
		yPos = y;
	}
	
	public double getxVel() {
		return xVel;
	}
	
	public void setxVel(double x) {
		xVel = x;
	}
	
	public double getyVel() {
		return yVel;
	}
	
	public void setyVel(double x) {
		yVel = x;
	}
	
	public double getMass() {
		return mass;
	}
	
	public void setMass(double x) {
		mass = x;
	}
	
	public String getImgFileName() {
		return imgFileName;
	}
	
	public void setImgFileName(String x) {
		imgFileName = x;
	}
	
	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xPos = xP;
		yPos = yP;
		xVel = xV;
		yVel = yV;
		mass = m;
		imgFileName = img;
		
	}
	
	public Planet(Planet p) {
		this.setxPos(p.getxPos());
		this.setyPos(p.getyPos());
		this.setxVel(p.getxVel());
		this.setyVel(p.getyVel());
		this.setMass(p.getMass());
		this.setImgFileName(p.getImgFileName());
	}
	
	//Calculates distance between planets
	public double calcDistance(Planet planet2) {
		double plan1xPos = xPos;
		double plan1yPos = yPos;
		double plan2xPos = planet2.getxPos();
		double plan2yPos = planet2.getyPos();
		double temp1, temp2 = 0.0;
		
		temp1 = plan2xPos - plan1xPos;
		temp1 *= temp1;
		temp2 = plan2yPos - plan1yPos;
		temp2 *= temp2;
		
		return Math.sqrt(temp1 + temp2);
	}
	
	//Calculates force exerted by a given planet
	public double calcForceExertedBy(Planet planet2) {
		double plan1Mass = mass;
		double plan2Mass = planet2.getMass();
		double distance = calcDistance(planet2);
		double temp = 0.0;
		final double G = 6.67e-11;
		
		temp = G * plan1Mass * plan2Mass;
		return (temp / (distance * distance));
	}
	
	//Calculates x component of force
	public double calcForceExertedByX(Planet planet2) {
		double force = calcForceExertedBy(planet2);
		double distance = calcDistance(planet2);
		double xDist = planet2.getxPos() - this.getxPos();
		
		return (force * xDist) / distance;
	}
	//Calculates y component of force
	public double calcForceExertedByY(Planet planet2) {
		double force = calcForceExertedBy(planet2);
		double distance = calcDistance(planet2);
		double yDist = planet2.getyPos() - this.getyPos();
		
		return (force * yDist) / distance;
	}
	
	//Calculates net x force exerted by a given planet
	public double calcNetForceExertedByX(Planet[] planetArray) {
		double netForce = 0.0;
		double currentForce = 0.0;
		
		for(int i = 0; i < planetArray.length; i++) {
			if(!(planetArray[i].equals(this))) {
				currentForce = 0.0;
				currentForce = calcForceExertedByX(planetArray[i]);
				netForce += currentForce;
			}
		}
		
		return netForce;
	}
	
	//Calculates net y force exerted by a given planet
	public double calcNetForceExertedByY(Planet[] planetArray) {
		double netForce = 0.0;
		double currentForce = 0.0;
		
		for(int i = 0; i < planetArray.length; i++) {
			if(!(planetArray[i].equals(this))) {
				currentForce = 0.0;
				currentForce = calcForceExertedByY(planetArray[i]);
				netForce += currentForce;
			}
		}
		
		return netForce;
	}
	
	//updates various components associated with a given planet
	public void update(double time, double xForce, double yForce) {
		double xAccel = xForce / this.getMass();
		double yAccel = yForce / this.getMass();
		
		double xnew_vel = this.getxVel() + (xAccel * time);
		double ynew_vel = this.getyVel() + (yAccel * time);
		double xnew_pos = this.getxPos() + (xnew_vel * time);
		double ynew_pos = this.getyPos() + (ynew_vel * time);
		
		this.setxVel(xnew_vel);
		this.setyVel(ynew_vel);
		
		this.setxPos(xnew_pos);
		this.setyPos(ynew_pos);
	}
	
	public void draw() {
		StdDraw.picture(this.getxPos(), this.getyPos(), this.getImgFileName());
	}
	
	}