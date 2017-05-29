package com.etaylor8086.metroidprime.randomizer;

import java.io.File;
import java.io.InputStream;
import java.util.Random;

import org.json.simple.JSONArray;

import com.etaylor8086.metroidprime.utilities.JsonSimpleReader;

public class Randomizer {
	final String PRIME_1_ITEMS_JSON_FILE = "/prime1ItemLocations.json";
	
	
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
		
		InputStream primeItemsStream = Randomizer.class.getResourceAsStream(PRIME_1_ITEMS_JSON_FILE);
		
		JSONArray itemsArrayJson = new JsonSimpleReader().readJsonArrayFromFile(primeItemsStream);
	}
}
