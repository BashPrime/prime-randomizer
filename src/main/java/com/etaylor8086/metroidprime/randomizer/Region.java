package com.etaylor8086.metroidprime.randomizer;

import java.util.Map;

public abstract class Region {
	protected String name;
	protected Map<String, Location> locations;
	
	public Map<String, Location> getLocations() {
		return this.locations;
	}
	
	public void init() {
		this.init("normal");
	}
	
	public void init(String difficulty) {
		switch (difficulty) {
			case "normal":
			default: {
				this.initNormal();
			}
		}
	}
	
	public Location getLocation(String key) {
		return this.locations.get(key);
	}
	
	public abstract void initNormal();
}
