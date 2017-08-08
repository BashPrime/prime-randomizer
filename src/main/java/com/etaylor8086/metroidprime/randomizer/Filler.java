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
	
	protected void fastFillItemsInLocations(List<Item> fillItems, List<Location> locations) {
		for (Location location : locations) {
			if (location.hasItem())
				continue;
			
			if (fillItems.isEmpty())
				break;
			
			Item item = fillItems.remove(0);
			System.out.println("Placing " + item.getFullName() + " in " + location.getName());
			location.setItem(item);
		}
		
		
//		foreach($locations as $location) {
//			if ($location->hasItem()) {
//				continue;
//			}
//			$item = array_pop($fill_items);
//			if (!$item) {
//				break;
//			}
//			Log::debug(sprintf('Placing: %s in %s', $item->getNiceName(), $location->getName()));
//			$location->setItem($item);
//		}
	}
}
