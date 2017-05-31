package com.etaylor8086.metroidprime.randomizer;

import java.util.LinkedHashMap;
import java.util.Map;

public class RandomizedGame {
	public Integer seed;
	public Map<String, Map<String, String>> locations;
	
	public RandomizedGame(Integer seed, RandomItemLocation[] locations) {
		this.seed = seed;
		this.populateLocations(locations);
	}
	
	private void populateLocations(RandomItemLocation[] locations) {
		this.locations = new LinkedHashMap<String, Map<String, String>>();
		for (RandomItemLocation location : locations) {
			String area = location.getLocation().area;
			String description = location.getLocation().description;
			String itemName = location.getItem().name;
			if (this.locations.get(area) == null)
				this.locations.put(area, new LinkedHashMap<String, String>());
			this.locations.get(area).put(description, itemName);
		}
	}
}
