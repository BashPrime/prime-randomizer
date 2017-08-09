package com.etaylor8086.metroidprime.randomizer.regions;

import java.util.HashMap;

import com.etaylor8086.metroidprime.randomizer.Location;
import com.etaylor8086.metroidprime.randomizer.Region;

public class ChozoRuins extends Region {
	public ChozoRuins() {
		this.name = "Chozo Ruins";
	}
	public void initNormal() {
		this.locations = new HashMap<String, Location>();
	}

}
