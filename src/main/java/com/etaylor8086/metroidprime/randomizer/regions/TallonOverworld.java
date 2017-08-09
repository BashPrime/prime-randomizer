package com.etaylor8086.metroidprime.randomizer.regions;

import java.util.HashMap;

import com.etaylor8086.metroidprime.randomizer.Item;
import com.etaylor8086.metroidprime.randomizer.Location;
import com.etaylor8086.metroidprime.randomizer.Region;
import com.etaylor8086.metroidprime.randomizer.collection.ItemCollection;
import com.etaylor8086.metroidprime.util.ItemRequirement;

public class TallonOverworld extends Region {
	public TallonOverworld() {
		this.name = "Tallon Overworld";
	}
	
	public void initNormal() {
		this.locations = new HashMap<String, Location>();
		this.locations.put("Landing Site", new Location("Landing Site", "b2701146.mrea", 0x0000007e, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.has("morph");
			}
		});
		
		this.locations.put("Alcove", new Location("Alcove", "c44e7a07.mrea", 0x00040007, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return (items.canLayBombs() && items.has("boost")) || items.has("spaceJump");
			}
		});
		
		this.locations.put("Artifact Temple", new Location("Artifact Temple", "2398e906.mrea", 0x41001d4, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles();
			}
		});
		
		this.locations.put("Root Cave", new Location("Root Cave", "bd8c8625.mrea", 0x000f0032, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.has("spaceJump") && items.has("grapple") && items.has("xray");
			}
		});
		
		this.locations.put("Arbor Chamber", new Location("Arbor Chamber", "24f8aff3.mrea", 0x00140015, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.has("spaceJump") && items.has("grapple") && items.has("xray") && items.has("plasmaBeam");
			}
		});
		
		this.locations.put("Transport Tunnel B", new Location("Transport Tunnel B", "c7e821ba.mrea", 0x00130136, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles();
			}
		});
		
		this.locations.put("Frigate Crash Site",  new Location("Frigate Crash Site", "b9abcd56.mrea", 0x000801fb, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.has("morph") && items.has("gravity") && items.has("spaceJump");
			}
		});
		
		this.locations.put("Overgrown Cavern", new Location("Overgrown Cavern", "cea263e3.mrea", 0x000d00c6, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.canLayBombs() && items.has("boost") && items.has("spider") &&
						items.has("waveBeam") && items.has("iceBeam") && items.has("spaceJump");
			}
		});
		
		this.locations.put("Cargo Freight Lift to Deck Gamma", new Location("Cargo Freight Lift to Deck Gamma", "37b3afe6.mrea", 0x001b0015, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.canLayBombs() && items.has("spaceJump") && items.has("waveBeam") &&
						items.has("iceBeam") && items.has("thermal");
			}
		});
		this.locations.put("Biohazard Containment", new Location("Biohazard Containment", "ac2c58fe.mrea", 0x001e02ec, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.canFireSuperMissiles() && items.canLayBombs() && items.has("spaceJump") && items.has("gravity") &&
						items.has("waveBeam") && items.has("iceBeam") && items.has("thermal");
			}
		});
		this.locations.put("Hydro Access Tunnel", new Location("Hydro Access Tunnel", "ffb4a966.mrea", 0x00230053, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.canLayBombs() && items.has("gravity") && items.has("spaceJump") &&
						items.has("waveBeam") && items.has("iceBeam") && items.has("thermal");
			}
		});
		
		this.locations.put("Great Tree Chamber", new Location("Great Tree Chamber", "c5d6a597.mrea", 0x0025000d, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.canLayBombs() && items.has("spaceJump") && items.has("waveBeam") &&
						items.has("iceBeam") && items.has("xray");
			}
		});
		this.locations.put("Life Grove Tunnel", new Location("Life Grove Tunnel", "b4fbbef5.mrea", 0x00270036, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.canLayBombs() && items.canLayPowerBombs() && items.has("boost") &&
						items.has("spider") && items.has("spaceJump") && items.has("waveBeam") && items.has("iceBeam");
						
			}
		});

		this.locations.put("Life Grove (Start)", new Location("Life Grove (Start)", "86eb2e02.mrea", 0x002a0021, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.canLayBombs() && items.canLayPowerBombs() && items.has("boost") &&
						items.has("spider") && items.has("spaceJump") && items.has("waveBeam") && items.has("iceBeam");
			}
		});
		
		this.locations.put("Life Grove (Underwater Spinner)", new Location("Life Grove (Underwater Spinner)", "86eb2e02.mrea", 0x002a0234, null){
			@Override
			public boolean canFillItem(Item item, ItemCollection items) {
				return items.hasMissiles() && items.canLayBombs() && items.canLayPowerBombs() && items.has("boost") &&
						items.has("spider") && items.has("spaceJump") && items.has("waveBeam") && items.has("iceBeam");
			}
		});
	}
}
