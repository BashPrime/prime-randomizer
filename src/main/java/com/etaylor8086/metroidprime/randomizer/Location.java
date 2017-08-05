package com.etaylor8086.metroidprime.randomizer;

public class Location {
	protected String name;
	protected String fileName;
	protected int id;
	protected Item item;
	
	public Location(String name, String fileName, int id, Item item) {
		this.name = name;
		this.fileName = fileName;
		this.id = id;
		this.item = item;
	}
}
