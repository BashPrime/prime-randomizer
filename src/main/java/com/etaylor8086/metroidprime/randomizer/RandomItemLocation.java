package com.etaylor8086.metroidprime.randomizer;

public class RandomItemLocation {
	private PrimeItem item;
	private PrimeItemLocation location;
	
	public RandomItemLocation(PrimeItem item, PrimeItemLocation location) {
		this.item = item;
		this.location = location;
	}
	
	public PrimeItem getItem() {
		return this.item;
	}
	
	public PrimeItemLocation getLocation() {
		return this.location;
	}
}
