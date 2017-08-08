package com.etaylor8086.metroidprime.randomizer.filler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.etaylor8086.metroidprime.randomizer.Filler;
import com.etaylor8086.metroidprime.randomizer.Item;
import com.etaylor8086.metroidprime.randomizer.Location;
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
	
	public void fillItemsInLocations(List<Item> fillItems, List<Location> locations) throws Exception {
		List<Item> remainingFillItems = new ArrayList<Item>(fillItems);
		
		if (remainingFillItems.size() > locations.size()) {
			throw new Exception("There aren't enough locations to fill the given items list with.");
		}
		
//		for(Item item : fillItems) {
//			List<Item> assumedItems = this.world.
//			List<Location> availableLocations = this.getEmptyLocations(locations);
//		}
	}
	
}
