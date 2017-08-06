package com.etaylor8086.metroidprime.randomizer;

public class Location {
	protected String name;
	protected String fileName;
	protected int id;
	protected Item item;
	protected Item[][] required;
	protected Item[][] escape;
	
	public Location(String name, String fileName, int id, Item item) {
		this.name = name;
		this.fileName = fileName;
		this.id = id;
		this.item = item;
	}
	
	public void setRequired(Item[][] required) {
		this.required = required;
	}
	
	public void setEscape(Item[][] escape) {
		this.escape = escape;
	}
}
