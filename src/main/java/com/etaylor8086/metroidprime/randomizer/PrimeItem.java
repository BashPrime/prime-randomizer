package com.etaylor8086.metroidprime.randomizer;

public class PrimeItem {
	public String name;
	public Integer count;
	public String item;
	public String capacity;
	public String amount;
	public String model;
	public String animSet;
	public String animCharacter;
	public Rotation rotation;
	public String xrayModel;
	public String xraySkin;
	
	public String toString() {
		return "PrimeItem [name=" + this.name + ", "
			+ "count=" + this.count + ", "
			+ "item=" + this.item + ", "
			+ "capacity=" + this.capacity + ", "
			+ "amount=" + this.amount + ", "
			+ "model=" + this.model + ", "
			+ "animSet=" + this.animSet + ", "
			+ "animCharacter=" + this.animCharacter + ", "
			+ "rotation=" + this.rotation.toString() + ", "
			+ "xrayModel=" + this.xrayModel + ", "
			+ "xraySkin=" + this.xraySkin + "]";
	}
}
