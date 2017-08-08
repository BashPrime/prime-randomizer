package com.etaylor8086.metroidprime.randomizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.etaylor8086.metroidprime.randomizer.item.Artifact;
import com.etaylor8086.metroidprime.randomizer.regions.MagmoorCaverns;
import com.etaylor8086.metroidprime.randomizer.regions.TallonOverworld;

public class World {
	protected String difficulty;
	protected List<Region> regions;
	protected List<Location> locations;
	protected List<Location> collectableLocations;
	
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
	
	public List<Location> getCollectableLocations() {
		if (this.collectableLocations == null) {
			this.collectableLocations = new ArrayList<Location>();
			for(Location location : this.locations) {
				if (location.hasItem() && !(location.getItem() instanceof Artifact))
					collectableLocations.add(location);
			}
		}
		
		return this.collectableLocations;
	}
	
	public List<Item> collectItems(List<Item> collected) {
		List<Item> myItems = (collected != null) ? collected : new ArrayList<Item>();
		List<Location> availableLocations = this.getCollectableLocations();
		List<Item> newItems;
		
//		do {
//			
//		} while(newItems.size() > 0);
		
		return myItems;
	}
}
