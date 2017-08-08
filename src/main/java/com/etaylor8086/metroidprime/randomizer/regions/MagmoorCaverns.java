package com.etaylor8086.metroidprime.randomizer.regions;

import java.util.HashMap;

import com.etaylor8086.metroidprime.randomizer.Item;
import com.etaylor8086.metroidprime.randomizer.Location;
import com.etaylor8086.metroidprime.randomizer.Region;
import com.etaylor8086.metroidprime.util.ItemRequirement;

public class MagmoorCaverns extends Region {
	public MagmoorCaverns() {
		this.name = "Magmoor Caverns";
		this.locations = new HashMap<String, Location>();
		this.locations.put("Lava Lake", new Location("Lava Lake", "a4719c6a.mrea", 0x0004287c, null));
		this.locations.put("Triclops Pit", new Location("Triclops Pit", "bad9edbf.mrea", 0x0006010c, null));
		this.locations.put("Storage Cavern", new Location("Storage Cavern", "adef843e.mrea", 0x0008000f, null));
		this.locations.put("Transport Tunnel A", new Location("Transport Tunnel A", "47f2c087.mrea", 0x000a0006, null));
		this.locations.put("Shore Tunnel", new Location("Shore Tunnel", "901040df.mrea", 0x000c0028, null));
		this.locations.put("Fiery Shores (Morph Track)", new Location("Fiery Shores (Morph Track)", "f5ef1862.mrea", 0x000e01da, null));
		this.locations.put("Fiery Shores (Warrior Shrine Tunnel)", new Location("Fiery Shores (Warrior Shrine Tunnel)", "f5ef1862.mrea", 0x000e023f, null));
		this.locations.put("Warrior Shrine", new Location("Warrior Shrine", "89a6cb8d.mrea", 0x000b0037, null));
		this.locations.put("Plasma Processing", new Location("Plasma Processing", "4cc18e5a.mrea", 0x0015001f, null));
		this.locations.put("Magmoor Workstation", new Location("Magmoor Workstation", "8abeb3c3.mrea", 0x0017028e, null));
	}
	
	public void initNormal() {
		this.locations.get("Lava Lake").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				ItemRequirement.ANY_SUIT,
				{ Item.get("morph") },
				ItemRequirement.MBB_OR_PB,
				{ Item.get("spacejump") }
			}
		);
		
		this.locations.get("Triclops Pit").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				ItemRequirement.ANY_SUIT,
				{ Item.get("morph") },
				{ Item.get("spacejump") },
				{ Item.get("xray") }
			}
		);
		
		this.locations.get("Storage Cavern").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				ItemRequirement.ANY_SUIT,
				{ Item.get("morph") },
			}
		);
		
		this.locations.get("Transport Tunnel A").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				ItemRequirement.ANY_SUIT,
				{ Item.get("morph") },
				{ Item.get("bomb") }
			}
		);
		
		this.locations.get("Warrior Shrine").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				ItemRequirement.ANY_SUIT,
				{ Item.get("morph") },
				{ Item.get("boost") },
				{ Item.get("spacejump") }
			}
		);
		
		this.locations.get("Shore Tunnel").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				ItemRequirement.ANY_SUIT,
				{ Item.get("morph") },
				ItemRequirement.POWER_BOMBS,
				{ Item.get("spacejump") }
			}
		);
		
		this.locations.get("Fiery Shores (Morph Track)").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				ItemRequirement.ANY_SUIT,
				{ Item.get("morph") },
				{ Item.get("bomb") }
			}
		);
		
		this.locations.get("Fiery Shores (Warrior Shrine Tunnel)").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				ItemRequirement.ANY_SUIT,
				{ Item.get("morph") },
				{ Item.get("boost") },
				ItemRequirement.POWER_BOMBS,
				{ Item.get("spacejump") }
			}
		);
		
		this.locations.get("Plasma Processing").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				ItemRequirement.ANY_SUIT,
				{ Item.get("morph") },
				{ Item.get("boost") },
				{ Item.get("spider") },
				{ Item.get("spacejump") },
				{ Item.get("grapple") },
				{ Item.get("waveBeam") },
				{ Item.get("iceBeam") }
			}
		);
		this.locations.get("Plasma Processing").setEscape(
			new Item[][] {
				{ Item.get("plasmaBeam") }
			}
		);
		
		this.locations.get("Magmoor Workstation").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				ItemRequirement.ANY_SUIT,
				{ Item.get("morph") },
				{ Item.get("spider") },
				{ Item.get("spacejump") },
				{ Item.get("grapple") },
				{ Item.get("waveBeam") },
				{ Item.get("thermal") }
			}
		);
	}
}
