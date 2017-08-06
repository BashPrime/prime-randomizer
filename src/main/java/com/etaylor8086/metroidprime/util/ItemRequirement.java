package com.etaylor8086.metroidprime.util;

import com.etaylor8086.metroidprime.randomizer.Item;

public class ItemRequirement {
	public static Item[] ANY_SUIT = new Item[]{ Item.get("varia"), Item.get("gravity"), Item.get("phazon") };
	public static Item[] MISSILES = new Item[]{ Item.get("missileExpansion"), Item.get("missileLauncher") };
	public static Item[] MBB_OR_PB = new Item[]{ Item.get("bomb"), Item.get("pb"), Item.get("pbExpansion") };
	public static Item[] POWER_BOMBS = new Item[]{ Item.get("pb"), Item.get("pbExpansion") };
	
	public static Item[][] mergeRequirements(Item[][] req1, Item[][] req2) {
		Item[][] result = new Item[req1.length + req2.length][];
		System.arraycopy(req1, 0, result, 0, req1.length);
		System.arraycopy(req2, 0, result, req1.length, req2.length);
		return result;
	}
}
