package com.etaylor8086.metroidprime.randomizer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.etaylor8086.metroidprime.utilities.JsonSimpleReader;

public class Randomizer {
	private final String PRIME_1_ITEM_LOCATIONS_JSON_FILE = "/items/prime1ItemLocations.json";
	private final String PRIME_1_ITEMS_JSON_FILE = "/items/prime1Items.json";
	private List<PrimeItem> primeItems;
	private List<PrimeItemLocation> primeItemLocations;
	
	
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
		primeItems = new ArrayList<PrimeItem>();
		primeItemLocations = new ArrayList<PrimeItemLocation>();
		System.out.println("Using seed: " + seed);
		
		InputStream primeItemsStream = Randomizer.class.getResourceAsStream(PRIME_1_ITEMS_JSON_FILE);
		InputStream primeItemLocationsStream = Randomizer.class.getResourceAsStream(PRIME_1_ITEM_LOCATIONS_JSON_FILE);
		
		JSONArray itemsArrayJson = new JsonSimpleReader().readJsonArrayFromFile(primeItemsStream);
		JSONArray itemLocationsArrayJson = new JsonSimpleReader().readJsonArrayFromFile(primeItemLocationsStream);
		
		// Add item locations to primeItemLocations array
		for (int i = 0; i < itemLocationsArrayJson.size(); i++) {
			primeItemLocations.add(new PrimeItemLocation((JSONObject) itemLocationsArrayJson.get(i)));
		}
		
		// Output item locations array
		for (PrimeItemLocation primeItemLocation: primeItemLocations) {
			System.out.println(primeItemLocation.toString());
		}
	}
}
