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
	Integer seed;
	Random rng;
	private List<PrimeItem> primeItems;
	private List<PrimeItemLocation> primeItemLocations;
	
	/**
	 * Default constructor. Loads randomizer class with a psuedorandom seed
	 */
	public Randomizer() {
		this.seed = new Random().nextInt();
		this.rng = new Random(this.seed);
	}
	
	/**
	 * Overloaded constructor to load class with user-defined seed
	 * @param seed
	 */
	public Randomizer(Integer seed) {
		this.seed = seed;
		this.rng = new Random(this.seed);
	}
	
	/**
	 * The primary randomizer method, wraps around other submethods to build the original item, location, and randomized location arrays.
	 */
	public void runRandomizer() {
		System.out.println("Using seed: " + this.seed);
		primeItems = this.buildPrimeItemsArray();
		primeItemLocations = this.buildPrimeItemLocationsArray();
		
		System.out.println("Items array created with size " + primeItems.size());
		System.out.println("Item locations array created with size " + primeItemLocations.size());
		
		this.buildRandomizedLocationsArray();
	}
	
	/**
	 * Builds the Prime items ArrayList from the given JSON file.
	 * @return ArrayList of Prime items and relevant data (model, animations, etc.)
	 */
	public List<PrimeItem> buildPrimeItemsArray() {
		List<PrimeItem> items = new ArrayList<PrimeItem>();
		InputStream primeItemsStream = Randomizer.class.getResourceAsStream(this.PRIME_1_ITEMS_JSON_FILE);
		JSONArray itemsArrayJson = new JsonSimpleReader().readJsonArrayFromFile(primeItemsStream);
		
		for (int i = 0; i < itemsArrayJson.size(); i++) {
			items.add(new PrimeItem((JSONObject) itemsArrayJson.get(i)));
		}
		
		return items;
	}
	
	/**
	 * Builds the original Prime item locations ArrayList from the given JSON file.
	 * @return ArrayList of the original item locations
	 */
	public List<PrimeItemLocation> buildPrimeItemLocationsArray() {
		List<PrimeItemLocation> itemLocations = new ArrayList<PrimeItemLocation>();
		InputStream primeItemLocationsStream = Randomizer.class.getResourceAsStream(PRIME_1_ITEM_LOCATIONS_JSON_FILE);
		JSONArray itemLocationsArrayJson = new JsonSimpleReader().readJsonArrayFromFile(primeItemLocationsStream);
		
		for (int i = 0; i < itemLocationsArrayJson.size(); i++) {
			itemLocations.add(new PrimeItemLocation((JSONObject) itemLocationsArrayJson.get(i)));
		}
		
		return itemLocations;
	}
	
	/**
	 * Builds the randomized item locations array using the Prime items array as an item pool.
	 * @return Array of Prime item locations
	 */
	public void buildRandomizedLocationsArray() {
		// Initialize random array
		boolean[] isRandomized = new boolean[this.primeItemLocations.size()];
		PrimeItemLocation[] randomizedItemLocations = new PrimeItemLocation[this.primeItemLocations.size()];
		
		// Iterate through Prime items. Use as a pool to fill the locations until the array is filled with pseudorandom data
		for (PrimeItem item : this.primeItems) {
			while (item.remaining > 0) {
				Integer randomIndex = this.getRandomIndex(this.primeItemLocations.size() - 1);
				// Location index not randomized, fill it with random item and mark randomized
				if (!isRandomized[randomIndex]) {
					randomizedItemLocations[randomIndex] = this.primeItemLocations.get(randomIndex);
					randomizedItemLocations[randomIndex].randomizedItemId = item.item;
					randomizedItemLocations[randomIndex].randomizedItemName = item.name;
					isRandomized[randomIndex] = true;
					item.remaining -= 1;
				}
			}
		}
		
		// Output randomized items
		System.out.println("--- Randomized item locations ---");
		for (PrimeItemLocation location : randomizedItemLocations) {
			System.out.println(location.description + ": " + location.randomizedItemName);
		}
	}
	
	/**
	 * Returns an Integer limited to a range between 0 and an upper bound, both inclusive.
	 * @param upperBound. The (inclusive) upper bound of the random range. The random location array's size (usually 100)
	 * @return Next integer in pseudorandom sequence, limited to the given range.
	 */
	public Integer getRandomIndex(Integer upperBound) {
		Integer lowerBound = 0;
		return this.rng.nextInt((upperBound - lowerBound) + 1) + lowerBound;
	}
}
