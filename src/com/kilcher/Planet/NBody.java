package com.kilcher.Planet;

/*The purpose of this program is to create a
 * simulation of planets, given a text file
 * with the number of planets in the system,
 * the radius of the simulated universe, and
 * information regarding each planet (x position,
 * y position, x velocity, y velocity, mass, and 
 * associated jpg. Command line arguments should
 * consist of 157788000.0(T), 25000.0(dt), and the
 * name of the text file the data is being drawn from.
 */

public class NBody {
	
	//Reads radius of the universe
	public static double readRadius(String fileName) {
		In in = new In(fileName);
		
		in.readInt();
		return in.readDouble();
	}
	
	//Reads all information about the planets in the text file
	public static Planet[] readPlanets(String fileName) {
		In in = new In(fileName);
		int numPlanets = in.readInt();
		Planet[] planets = new Planet[numPlanets];
		in.readDouble();
		
		for(int i = 0; i < numPlanets; i++) {
			planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		}
		
		
		
		return planets;
		
	}
	
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		String background = "starfield.jpg";
		In in = new In(filename);
		
		readRadius(filename);
		
		//Draws background
		StdDraw.setScale(-readRadius(filename), readRadius(filename));
		StdDraw.clear();
		StdDraw.picture(0, 0, background);
		
		//Draws planets
		int numPlanets = in.readInt();
		Planet[] planets = readPlanets(filename);
		for(int i = 0; i < numPlanets; i++) {
			planets[i].draw();
		}
		
		//Creates animation
		for(double t = 0.0; t < T; t += dt) {
			double[] xForces = new double[numPlanets];
			double[] yForces = new double[numPlanets];
			
			for(int i = 0; i < numPlanets; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			
			for(int i = 0; i < numPlanets; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			
			StdDraw.picture(0, 0, background);
			
			for(int i = 0; i < numPlanets; i++) {
				planets[i].draw();
			}
			
			StdDraw.show(10);
		}
		
		//Outputs various information about planets at end of animation
		System.out.printf("%d\n", planets.length);
		System.out.printf("%.2e\n", readRadius(filename));
		for(int i = 0; i < planets.length; i++) {
			System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", planets[i].getxPos(), planets[i].getyPos(), planets[i].getxVel(), planets[i].getyVel(), planets[i].getMass(), planets[i].getImgFileName());
		}
	}
	
}
