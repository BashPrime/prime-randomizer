package com.etaylor8086.metroidprime.randomizer.regions;

import java.util.HashMap;

import com.etaylor8086.metroidprime.randomizer.Item;
import com.etaylor8086.metroidprime.randomizer.Location;
import com.etaylor8086.metroidprime.randomizer.Region;
import com.etaylor8086.metroidprime.randomizer.collection.ItemCollection;
import com.etaylor8086.metroidprime.util.ItemRequirement;

public class MagmoorCaverns extends Region {
	public MagmoorCaverns() {
		this.name = "Magmoor Caverns";
	}
	
	public void initNormal() {
		this.locations = new HashMap<String, Location>();
		this.locations.put("Lava Lake", new Location("Lava Lake", "a4719c6a.mrea", 0x0004287c, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.hasAnySuit() && items.canLayBombsOrPowerBombs() && items.has("spaceJump");
			}
		});
		this.locations.put("Triclops Pit", new Location("Triclops Pit", "bad9edbf.mrea", 0x0006010c, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.hasAnySuit() && items.has("morph") && items.has("spacejump") && items.has("xray");
			}
		});
		this.locations.put("Storage Cavern", new Location("Storage Cavern", "adef843e.mrea", 0x0008000f, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.hasAnySuit() && items.has("morph");
			}
		});
		this.locations.put("Transport Tunnel A", new Location("Transport Tunnel A", "47f2c087.mrea", 0x000a0006, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.hasAnySuit() && items.canLayBombs();
			}
		});
		this.locations.put("Shore Tunnel", new Location("Shore Tunnel", "901040df.mrea", 0x000c0028, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.hasAnySuit() && items.canLayPowerBombs() && items.has("spaceJump");
			}
		});
		this.locations.put("Fiery Shores (Morph Track)", new Location("Fiery Shores (Morph Track)", "f5ef1862.mrea", 0x000e01da, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.hasAnySuit() && items.canLayBombs() && items.has("spaceJump");
			}
		});
		this.locations.put("Fiery Shores (Warrior Shrine Tunnel)", new Location("Fiery Shores (Warrior Shrine Tunnel)", "f5ef1862.mrea", 0x000e023f, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.hasAnySuit() && items.canLayPowerBombs() && items.has("boost") && items.has("spacejump");
			}
		});
		this.locations.put("Warrior Shrine", new Location("Warrior Shrine", "89a6cb8d.mrea", 0x000b0037, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.hasAnySuit() && items.has("morph") && items.has("boost") && items.has("spaceJump");
			}
		});
		this.locations.put("Plasma Processing", new Location("Plasma Processing", "4cc18e5a.mrea", 0x0015001f, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.hasAnySuit() && items.canLayBombs() && items.has("spacejump") &&
						items.has("waveBeam") && items.has("iceBeam") && items.has("boost") && items.has("spider") && items.has("grapple");
			}
		});
		this.locations.put("Magmoor Workstation", new Location("Magmoor Workstation", "8abeb3c3.mrea", 0x0017028e, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.hasAnySuit() && items.has("spaceJump") && items.has("waveBeam") && items.has("thermal");
			}
		});
	}
}
