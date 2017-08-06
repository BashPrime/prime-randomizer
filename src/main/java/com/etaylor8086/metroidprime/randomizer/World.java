package com.etaylor8086.metroidprime.randomizer;

import java.util.HashMap;
import java.util.Map;

import com.etaylor8086.metroidprime.randomizer.regions.MagmoorCaverns;
import com.etaylor8086.metroidprime.randomizer.regions.TallonOverworld;

public class World {
	protected String difficulty;
	protected Map<String, Region> regions;
	
	public World(String difficulty) {
		this.difficulty = difficulty;
		
		this.regions = new HashMap<String, Region>();
		this.regions.put("Tallon Overworld", new TallonOverworld());
		this.regions.put("Magmoor Caverns", new MagmoorCaverns());
		
		for(Map.Entry<String, Region> entry : this.regions.entrySet()) {
			entry.getValue().init(difficulty);
		}
	}
}
