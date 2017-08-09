package com.etaylor8086.metroidprime.randomizer.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.etaylor8086.metroidprime.randomizer.Item;
import com.etaylor8086.metroidprime.util.Constants;

public class ItemCollection extends ArrayList<Item> {
	private static final long serialVersionUID = -8355544820295639216L;
	
	public boolean has(String itemName) {
		return this.contains(Item.get(itemName));
	}

	public boolean hasMissiles() {
		return !Collections.disjoint(this, Arrays.asList(new Item[]{Item.get(Constants.MISSILE_EXPANSION), Item.get(Constants.MISSILE_LAUNCHER)}));
	}
	
	public boolean hasAnySuit() {
		return !Collections.disjoint(this, Arrays.asList(new Item[]{Item.get(Constants.VARIA_SUIT), Item.get(Constants.GRAVITY_SUIT), Item.get(Constants.PHAZON_SUIT)}));
	}
	
	public boolean canLayBombs() {
		return this.containsAll(Arrays.asList(new Item[]{Item.get(Constants.MORPH_BALL), Item.get(Constants.MORPH_BALL_BOMB)}));
	}
	
	public boolean canLayPowerBombs() {
		return this.has(Constants.MORPH_BALL) && !Collections.disjoint(this, Arrays.asList(new Item[]{Item.get(Constants.POWER_BOMB), Item.get(Constants.POWER_BOMB_EXPANSION)}));
	}
	
	public boolean canLayBombsOrPowerBombs() {
		return this.has(Constants.MORPH_BALL) && !Collections.disjoint(this, Arrays.asList(new Item[]{Item.get(Constants.MORPH_BALL_BOMB), Item.get(Constants.POWER_BOMB), Item.get(Constants.POWER_BOMB_EXPANSION)}));
	}
	
	public boolean canVMRNormal() {
		int counter = 0;
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).equals(Item.get(Constants.ENERGY_TANK)))
				counter++;
		}
			
		return counter >= 6 || (counter >= 5 && this.has(Constants.SPACE_JUMP_BOOTS));
	}
	
	public boolean canFireSuperMissiles() {
		return this.hasMissiles() && this.containsAll(Arrays.asList(new Item[]{Item.get(Constants.CHARGE_BEAM), Item.get(Constants.SUPER_MISSILE)}));
	}
	
	public boolean hasMinesFromTallonReqs() {
		return this.hasMissiles() && this.canLayBombs() && this.has(Constants.SPACE_JUMP_BOOTS) && this.has(Constants.GRAVITY_SUIT) &&
				this.has(Constants.THERMAL_VISOR) && this.has(Constants.WAVE_BEAM) && this.has(Constants.ICE_BEAM);
	}
	
	public boolean hasMinesFromMagmoorReqs() {
		return this.hasMissiles() && this.canLayPowerBombs() && this.hasAnySuit() && this.has(Constants.SPIDER_BALL) && 
				this.has(Constants.SPACE_JUMP_BOOTS) && this.has(Constants.WAVE_BEAM) && this.has(Constants.ICE_BEAM);
	}
}
