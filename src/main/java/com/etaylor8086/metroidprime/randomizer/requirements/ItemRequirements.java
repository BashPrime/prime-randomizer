package com.etaylor8086.metroidprime.randomizer.requirements;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ItemRequirements {
	public static final int MISSILE = 0;
	public static final int ENERGY_TANK = 1;
	public static final int THERMAL_VISOR = 2;
	public static final int XRAY_VISOR = 3;
	public static final int VARIA_SUIT = 4;
	public static final int GRAVITY_SUIT = 5;
	public static final int PHAZON_SUIT = 6;
	public static final int MORPH_BALL = 7;
	public static final int BOOST_BALL = 8;
	public static final int SPIDER_BALL = 9;
	public static final int MORPH_BALL_BOMB = 10;
	public static final int POWER_BOMB = 11;
	public static final int POWER_BOMB_EXPANSION = 12;
	public static final int CHARGE_BEAM = 13;
	public static final int SPACE_JUMP_BOOTS = 14;
	public static final int GRAPPLE_BEAM = 15;
	public static final int SUPER_MISSILE = 16;
	public static final int WAVEBUSTER = 17;
	public static final int ICE_SPREADER = 18;
	public static final int FLAMETHROWER = 19;
	public static final int WAVE_BEAM = 20;
	public static final int ICE_BEAM = 21;
	public static final int PLASMA_BEAM = 22;
	public static final int ARTIFACT_TRUTH = 23;
	public static final int ARTIFACT_STRENGTH = 24;
	public static final int ARTIFACT_ELDER = 25;
	public static final int ARTIFACT_WILD = 26;
	public static final int ARTIFACT_LIFEGIVER = 27;
	public static final int ARTIFACT_WARRIOR = 28;
	public static final int ARTIFACT_CHOZO = 29;
	public static final int ARTIFACT_NATURE = 30;
	public static final int ARTIFACT_SUN = 31;
    public static final int ARTIFACT_WORLD = 32;
    public static final int ARTIFACT_SPIRIT = 33;
    public static final int ARTIFACT_NEWBORN = 34;
        
    
    public static boolean anySuit(Set<Integer> items) {   	
    	Integer[] anySuit = new Integer[] { ItemRequirements.VARIA_SUIT, ItemRequirements.GRAVITY_SUIT, ItemRequirements.PHAZON_SUIT };
    	Set<Integer> ANY_SUIT = new HashSet<>(Arrays.asList(anySuit));
    	return !Collections.disjoint(items, ANY_SUIT);
    }
    
    public static boolean anyPowerBombs(Set<Integer> items) {
    	Integer[] anyPowerBombs = new Integer[] { ItemRequirements.POWER_BOMB, ItemRequirements.POWER_BOMB_EXPANSION };
    	Set<Integer> ANY_POWER_BOMBS = new HashSet<>(Arrays.asList(anyPowerBombs));
    	return !Collections.disjoint(items, ANY_POWER_BOMBS);
    }
    
    public static boolean mbbOrPbs(Set<Integer> items) {
    	Integer[] mbbOrPb = new Integer[] { ItemRequirements.MORPH_BALL_BOMB, ItemRequirements.POWER_BOMB };
    	Set<Integer> MBB_OR_PB = new HashSet<>(Arrays.asList(mbbOrPb));
    	return !Collections.disjoint(items, MBB_OR_PB);
    }
    
    
}
