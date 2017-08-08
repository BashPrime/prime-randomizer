package com.etaylor8086.metroidprime.randomizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etaylor8086.metroidprime.randomizer.regions.MagmoorCaverns;
import com.etaylor8086.metroidprime.randomizer.regions.TallonOverworld;

public class World {
	protected String difficulty;
	protected List<Region> regions;
	protected List<Location> locations;
	
	public World(String difficulty) {
		this.difficulty = difficulty;
		
		this.regions = new ArrayList<Region>();
		this.regions.add(new TallonOverworld());
		this.regions.add(new MagmoorCaverns());
		
		this.locations = new ArrayList<Location>();
		
		for(Region region : this.regions) {
			region.init(difficulty);
			
			for(Map.Entry<String, Location> entry : region.getLocations().entrySet()) {
				this.locations.add(entry.getValue());
			}
		}
	}
	
	public List<Region> getRegions() {
		return this.regions;
	}
	
	public List<Location> getLocations() {
		return this.locations;
	}
}
