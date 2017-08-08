package com.etaylor8086.metroidprime.randomizer.fillers;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.etaylor8086.metroidprime.randomizer.Filler;
import com.etaylor8086.metroidprime.randomizer.Item;
import com.etaylor8086.metroidprime.randomizer.World;

public class RandomAssumed extends Filler {
	
	public RandomAssumed(World world, Random rng) {
		super(world, rng);
	}

	@Override
	public void fill(List<Item> artifacts, List<Item> priorityItems, List<Item> luxuryItems, List<Item> expansions) {
		Collections.shuffle(this.world.getLocations(), this.rng);
		
		this.fastFillItemsInLocations(artifacts, this.world.getLocations());
	}
	
}
