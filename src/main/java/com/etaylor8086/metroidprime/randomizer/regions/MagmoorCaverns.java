package com.etaylor8086.metroidprime.randomizer.regions;

import com.etaylor8086.metroidprime.randomizer.Location;
import com.etaylor8086.metroidprime.randomizer.Region;

public class MagmoorCaverns extends Region {
	public MagmoorCaverns() {
		this.name = "Magmoor Caverns";
		this.locations = new Location[] {
			new Location("Lava Lake", "a4719c6a.mrea", 0x0004287c, null),
			new Location("Triclops Pit", "bad9edbf.mrea", 0x0006010c, null),
			new Location("Storage Cavern", "adef843e.mrea", 0x0008000f, null),
			new Location("Transport Tunnel A", "47f2c087.mrea", 0x000a0006, null),
			new Location("Shore Tunnel", "901040df.mrea", 0x000c0028, null),
			new Location("Fiery Shores (Morph Track)", "f5ef1862.mrea", 0x000e01da, null),
			new Location("Fiery Shores (Warrior Shrine Tunnel)", "f5ef1862.mrea", 0x000e023f, null),
			new Location("Warrior Shrine", "89a6cb8d.mrea", 0x000b0037, null),
			new Location("Plasma Processing", "4cc18e5a.mrea", 0x0015001f, null),
			new Location("Magmoor Workstation", "8abeb3c3.mrea", 0x0017028e, null)
		};
	}
}
