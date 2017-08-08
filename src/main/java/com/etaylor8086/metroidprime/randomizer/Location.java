package com.etaylor8086.metroidprime.randomizer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
	
	public String getName() {
		return this.name;
	}
	
	public boolean hasItem() {
		return this.item != null;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public boolean canFill(Item item, List<Item> items) {
		boolean canFill = true;
		for(int i = 0; i < this.required.length; i++) {
			if (Collections.disjoint(items, Arrays.asList(this.required[i]))) {
				canFill = false;
				break;
			}
		}
		return canFill;
	}
	
	public boolean canLeave(Item item, List<Item> items) {
		return true;
	}
}
