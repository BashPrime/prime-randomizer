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
		System.out.println("Using seed: " + seed);
		primeItems = this.buildPrimeItemsArray();
		primeItemLocations = this.buildPrimeItemLocationsArray();
		
		System.out.println("Items array created with size " + primeItems.size());
		System.out.println("Item locations array created with size " + primeItemLocations.size());
	}
	
	public List<PrimeItem> buildPrimeItemsArray() {
		List<PrimeItem> items = new ArrayList<PrimeItem>();
		InputStream primeItemsStream = Randomizer.class.getResourceAsStream(this.PRIME_1_ITEMS_JSON_FILE);
		JSONArray itemsArrayJson = new JsonSimpleReader().readJsonArrayFromFile(primeItemsStream);
		
		for (int i = 0; i < itemsArrayJson.size(); i++) {
			items.add(new PrimeItem((JSONObject) itemsArrayJson.get(i)));
		}
		
		return items;
	}
	
	public List<PrimeItemLocation> buildPrimeItemLocationsArray() {
		List<PrimeItemLocation> itemLocations = new ArrayList<PrimeItemLocation>();
		InputStream primeItemLocationsStream = Randomizer.class.getResourceAsStream(PRIME_1_ITEM_LOCATIONS_JSON_FILE);
		JSONArray itemLocationsArrayJson = new JsonSimpleReader().readJsonArrayFromFile(primeItemLocationsStream);
		
		for (int i = 0; i < itemLocationsArrayJson.size(); i++) {
			itemLocations.add(new PrimeItemLocation((JSONObject) itemLocationsArrayJson.get(i)));
		}
		
		return itemLocations;
	}
}
