package com.etaylor8086.metroidprime.randomizer;

public class Rotation {
	protected double x;
	protected double y;
	protected double z;
	
	public Rotation(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String toString() {
		return "Rotation [x=" + this.x + ", y=" + this.y + ", z= " + this.z + "]";
	}
}
