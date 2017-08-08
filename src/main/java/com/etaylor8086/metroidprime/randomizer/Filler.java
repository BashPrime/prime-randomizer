package com.etaylor8086.metroidprime.randomizer;

import java.util.List;
import java.util.Random;

public abstract class Filler {
	protected World world;
	protected Random rng;
	
	public Filler(World world, Random rng) {
		this.world = world;
		this.rng = rng;
	}
	
	public abstract void fill(List<Item> artifacts, List<Item> priorityItems, List<Item> luxuryItems, List<Item> expansions);
}
