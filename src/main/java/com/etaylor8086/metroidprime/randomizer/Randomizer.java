package com.etaylor8086.metroidprime.randomizer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Randomizer {
	private final String PRIME_1_ITEM_LOCATIONS_JSON_FILE = "/items/prime1ItemLocations.json";
	private final String PRIME_1_ITEMS_JSON_FILE = "/items/prime1Items.json";
	Integer seed;
	Random rng;
	private PrimeItem[] primeItems;
	private PrimeItemLocation[] primeItemLocations;
//	private List<PrimeItem> primeItems;
//	private List<PrimeItemLocation> primeItemLocations;
	
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
		this.primeItems = this.buildPrimeItemsArray();
		this.primeItemLocations = this.buildPrimeItemLocationsArray();
		System.out.print("Randomizing locations...");
		RandomItemLocation[] randomItemLocations = this.buildRandomizedLocationsArray();
		System.out.println(" randomized!");
		this.writeSpoilerLog(randomItemLocations);
	}
	
	/**
	 * Builds the Prime items array from the given JSON file.
	 * @return Array of Prime items and relevant data (model, animations, etc.)
	 */
	public PrimeItem[] buildPrimeItemsArray() {
		PrimeItem[] items = null;
		try {
			InputStream in = Randomizer.class.getResourceAsStream(this.PRIME_1_ITEMS_JSON_FILE);
			ObjectMapper mapper = new ObjectMapper();
			items = mapper.readValue(in, PrimeItem[].class);
			in.close();
		}
		catch (Exception e) {
			System.err.println("Error building prime items list: " + e);
			System.exit(1);
		}

		return items;
	}
	
	/**
	 * Builds the original Prime item locations array from the given JSON file.
	 * @return Array of the original item locations
	 */
	public PrimeItemLocation[] buildPrimeItemLocationsArray() {
		PrimeItemLocation[] itemLocations = null;
		
		try {
			InputStream in = Randomizer.class.getResourceAsStream(PRIME_1_ITEM_LOCATIONS_JSON_FILE);
			ObjectMapper mapper = new ObjectMapper();
			itemLocations = mapper.readValue(in, PrimeItemLocation[].class);
			in.close();
		}
		catch(Exception e) {
			System.err.println("Error building prime item locations list: " + e);
			System.exit(1);
		}
		
		return itemLocations;
	}
	
	/**
	 * Builds the randomized item locations array using the Prime items array as an item pool.
	 * @return Array of Prime item locations
	 */
	public RandomItemLocation[] buildRandomizedLocationsArray() {
		// Initialize random array
		boolean[] isRandomized = new boolean[this.primeItemLocations.length];
		RandomItemLocation[] randomizedItemLocations = new RandomItemLocation[this.primeItemLocations.length];
		
		// Iterate through Prime items. Use as a pool to fill the locations until the array is filled with pseudorandom data
		for (PrimeItem item : this.primeItems) {
			int remaining = item.count;
			while (remaining > 0) {
				Integer randomIndex = this.getRandomIndex(this.primeItemLocations.length - 1);
				// Location index not randomized, fill it with random item and mark randomized
				if (!isRandomized[randomIndex]) {
					randomizedItemLocations[randomIndex] = new RandomItemLocation(item, this.primeItemLocations[randomIndex]);
					isRandomized[randomIndex] = true;
					remaining -= 1;
				}
			}
		}
		
		return randomizedItemLocations;
	}
	
	public void writeSpoilerLog(RandomItemLocation[] locations) {
		try {
			String outDirName = "out";
			String fileName = "Prime_" + this.seed + ".json";
			File outDir = new File(outDirName);
			
			// Create out directory if it doesn't exist
			if (outDir.mkdir())
				System.out.println("Created out" + File.separator + " directory for spoiler logs");
			
			// Write spoiler log
			BufferedWriter out = new BufferedWriter(new FileWriter(outDirName + File.separator + fileName));
			RandomizedGame game = new RandomizedGame(this.seed, locations);
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = mapper.writeValueAsString(game);
			out.write(jsonResult);
			out.close();
			System.out.println("Successfully wrote spoiler log to " + outDirName + File.separator + fileName);
		}
		catch (Exception e) {
			System.out.println(e);
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
