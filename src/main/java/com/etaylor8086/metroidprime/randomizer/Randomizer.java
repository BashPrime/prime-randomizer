package com.etaylor8086.metroidprime.randomizer;

import java.io.InputStream;
import java.util.Random;

import org.json.simple.JSONArray;

import com.etaylor8086.metroidprime.utilities.JsonSimpleReader;

public class Randomizer {
	private final String PRIME_1_ITEM_LOCATIONS_JSON_FILE = "/items/prime1ItemLocations.json";
	private final String PRIME_1_ITEMS_JSON_FILE = "/items/prime1Items.json";
	private PrimeItem[] primeItems;
	private PrimeItemLocation[] primeItemLocations;
	
	
	/**
	 * Runs the randomizer with a random seed.
	 */
	public void runRandomizer() {
		this.runRandomizer(new Random().nextInt());
	}
	
	/**
	 * Runs the Prime item randomizer with a given seed.
	 * @param seed
	 */
	public void runRandomizer(int seed) {
		System.out.println("Using seed: " + seed);
		
		InputStream primeItemLocationsStream = Randomizer.class.getResourceAsStream(PRIME_1_ITEM_LOCATIONS_JSON_FILE);
		
		JSONArray itemLocationsArrayJson = new JsonSimpleReader().readJsonArrayFromFile(primeItemLocationsStream);
	}
}
