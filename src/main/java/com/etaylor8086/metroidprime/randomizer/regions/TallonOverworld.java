package com.etaylor8086.metroidprime.randomizer.regions;

import java.util.HashMap;

import com.etaylor8086.metroidprime.randomizer.Item;
import com.etaylor8086.metroidprime.randomizer.Location;
import com.etaylor8086.metroidprime.randomizer.Region;
import com.etaylor8086.metroidprime.util.ItemRequirement;

public class TallonOverworld extends Region {
	public TallonOverworld() {
		this.name = "Tallon Overworld";
		this.locations = new HashMap<String, Location>();
		this.locations.put("Landing Site", new Location("Landing Site", "b2701146.mrea", 0x0000007e, null));
		this.locations.put("Alcove", new Location("Alcove", "c44e7a07.mrea", 0x00040007, null));
		this.locations.put("Root Cave", new Location("Root Cave", "bd8c8625.mrea", 0x000f0032, null));
		this.locations.put("Arbor Chamber", new Location("Arbor Chamber", "24f8aff3.mrea", 0x00140015, null));
		this.locations.put("Transport Tunnel B", new Location("Transport Tunnel B", "c7e821ba.mrea", 0x00130136, null));
		this.locations.put("Frigate Crash Site",  new Location("Frigate Crash Site", "b9abcd56.mrea", 0x000801fb, null));
		this.locations.put("Overgrown Cavern", new Location("Overgrown Cavern", "cea263e3.mrea", 0x000d00c6, null));
		this.locations.put("Cargo Freight Lift to Deck Gamma", new Location("Cargo Freight Lift to Deck Gamma", "37b3afe6.mrea", 0x001b0015, null));
		this.locations.put("Biohazard Containment", new Location("Biohazard Containment", "ac2c58fe.mrea", 0x001e02ec, null));
		this.locations.put("Hydro Access Tunnel", new Location("Hydro Access Tunnel", "ffb4a966.mrea", 0x00230053, null));
		this.locations.put("Great Tree Chamber", new Location("Great Tree Chamber", "c5d6a597.mrea", 0x0025000d, null));
		this.locations.put("Life Grove Tunnel", new Location("Life Grove Tunnel", "b4fbbef5.mrea", 0x00270036, null));
		this.locations.put("Life Grove (Start)", new Location("Life Grove (Start)", "86eb2e02.mrea", 0x002a0021, null));
		this.locations.put("Life Grove (Underwater Spinner)", new Location("Life Grove (Underwater Spinner)", "86eb2e02.mrea", 0x002a0234, null));
		this.locations.put("Artifact Temple", new Location("Artifact Temple", "2398e906.mrea", 0x41001d4, null));
	}
	
	public void initNormal() {
		this.locations.get("Landing Site").setRequired(
			new Item[][] {
				{ Item.get("morph") }
			}
		);
		
		this.locations.get("Root Cave").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				{ Item.get("spacejump") },
				{ Item.get("grapple") },
				{ Item.get("xray") }
			}
		);
		
		this.locations.get("Arbor Chamber").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				{ Item.get("spacejump") },
				{ Item.get("grapple") },
				{ Item.get("xray") },
				{ Item.get("plasmaBeam") }
			}
		);
		
		this.locations.get("Transport Tunnel B").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES
			}
		);
		
		this.locations.get("Frigate Crash Site").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				{ Item.get("morph") },
				{ Item.get("gravity") },
				{ Item.get("spacejump") }
			}
		);
		
		this.locations.get("Overgrown Cavern").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				{ Item.get("morph") },
				{ Item.get("boost") },
				{ Item.get("spider") },
				{ Item.get("bomb") },
				{ Item.get("waveBeam") },
				{ Item.get("iceBeam") },
				{ Item.get("spacejump") }
			}
		);
		
		this.locations.get("Cargo Freight Lift to Deck Gamma").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				{ Item.get("morph") },
				{ Item.get("gravity") },
				{ Item.get("spacejump") },
				{ Item.get("waveBeam") },
				{ Item.get("iceBeam") },
				{ Item.get("thermal") }
			}
		);
		
		this.locations.get("Biohazard Containment").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				{ Item.get("morph") },
				{ Item.get("gravity") },
				{ Item.get("spacejump") },
				{ Item.get("waveBeam") },
				{ Item.get("iceBeam") },
				{ Item.get("thermal") },
				{ Item.get("charge") },
				{ Item.get("superMissile") }
			}
		);
		
		this.locations.get("Hydro Access Tunnel").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				{ Item.get("morph") },
				{ Item.get("bomb") },
				{ Item.get("gravity") },
				{ Item.get("spacejump") },
				{ Item.get("waveBeam") },
				{ Item.get("iceBeam") },
				{ Item.get("thermal") },
			}
		);
		
		this.locations.get("Great Tree Chamber").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				{ Item.get("morph") },
				{ Item.get("bomb") },
				{ Item.get("spacejump") },
				{ Item.get("waveBeam") },
				{ Item.get("iceBeam") },
				{ Item.get("xray") }
			}
		);
		
		this.locations.get("Life Grove Tunnel").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				{ Item.get("morph") },
				{ Item.get("boost") },
				{ Item.get("spider") },
				{ Item.get("bomb") },
				ItemRequirement.POWER_BOMBS,
				{ Item.get("spacejump") },
				{ Item.get("waveBeam") },
				{ Item.get("iceBeam") },
			}
		);
		
		this.locations.get("Life Grove (Start)").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				{ Item.get("morph") },
				{ Item.get("boost") },
				{ Item.get("spider") },
				{ Item.get("bomb") },
				ItemRequirement.POWER_BOMBS,
				{ Item.get("spacejump") },
				{ Item.get("waveBeam") },
				{ Item.get("iceBeam") },
			}
		);
		
		this.locations.get("Life Grove (Underwater Spinner)").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES,
				{ Item.get("morph") },
				{ Item.get("boost") },
				{ Item.get("spider") },
				{ Item.get("bomb") },
				ItemRequirement.POWER_BOMBS,
				{ Item.get("spacejump") },
				{ Item.get("waveBeam") },
				{ Item.get("iceBeam") },
			}
		);
		
		this.locations.get("Artifact Temple").setRequired(
			new Item[][] {
				ItemRequirement.MISSILES
			}
		);
	}
}
