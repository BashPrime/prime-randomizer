package com.etaylor8086.metroidprime.randomizer.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.etaylor8086.metroidprime.randomizer.Item;

public class ItemCollection extends ArrayList<Item> {
	private static final long serialVersionUID = -8355544820295639216L;

	public boolean hasAnySuit() {
		return !Collections.disjoint(this, Arrays.asList(new Item[]{Item.get("varia"), Item.get("gravity"), Item.get("phazon")}));
	}
	
	public boolean hasBombs() {
		return this.containsAll(Arrays.asList(new Item[]{Item.get("morph"), Item.get("bomb")}));
	}
	
	public boolean hasPowerBombs() {
		return this.contains(Item.get("morph")) && !Collections.disjoint(this, Arrays.asList(new Item[]{Item.get("pb"), Item.get("pbExpansion")}));
	}
	
	public boolean hasBombsOrPowerBombs() {
		return this.contains(Item.get("morph")) && !Collections.disjoint(this, Arrays.asList(new Item[]{Item.get("bomb"), Item.get("pb"), Item.get("pbExpansion")}));
	}
	
	public boolean canVMRNormal() {
		int counter = 0;
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).equals(Item.get("eTank")))
				counter++;
		}
			
		return counter >= 6 || (counter >= 5 && this.contains(Item.get("spaceJump")));
	}
}
