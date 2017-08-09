package com.etaylor8086.metroidprime.randomizer.regions;

import java.util.HashMap;

import com.etaylor8086.metroidprime.randomizer.Item;
import com.etaylor8086.metroidprime.randomizer.Location;
import com.etaylor8086.metroidprime.randomizer.Region;
import com.etaylor8086.metroidprime.randomizer.collection.ItemCollection;

public class PhazonMines extends Region {
	public PhazonMines() {
		this.name = "Phazon Mines";
	}
	
	public void initNormal() {
		this.locations = new HashMap<String, Location>();
		
		this.locations.put("Main Quarry", new Location("Main Quarry", "b2701146.mrea", 0x0000007e, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return (items.hasMinesFromTallonReqs() && items.has("spider")) || (items.hasMinesFromMagmoorReqs() && items.has("thermal"));
			}
		});
		
		this.locations.put("Security Access A", new Location("Security Access A", "b2701146.mrea", 0x0000007e, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return (items.hasMinesFromTallonReqs() && items.canLayPowerBombs() && items.has("boost")) || (items.hasMinesFromMagmoorReqs() && items.canLayBombs());
			}
		});
		
		this.locations.put("Storage Depot A", new Location("Storage Depot A", "b2701146.mrea", 0x0000007e, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return (items.hasMinesFromTallonReqs() && items.has("plasmaBeam")) || (items.hasMinesFromMagmoorReqs() && items.canLayBombs() && items.has("grapple") && items.has("plasma"));
			}
		});
	}
}
