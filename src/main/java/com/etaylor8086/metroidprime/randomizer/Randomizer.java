package com.etaylor8086.metroidprime.randomizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Randomizer {
	protected String difficulty;
	protected World world;
	protected Integer seed;
	protected Random rng;
	
	/**
	 * Default constructor. Loads randomizer class with a psuedorandom seed
	 */
	public Randomizer() {
		this.difficulty = "normal";
		this.seed = this.getRandomSeed();
		this.rng = new Random(this.seed);
	}
	
	/**
	 * Overloaded constructor to load class with user-defined seed
	 * @param seed
	 */
	public Randomizer(Integer seed) {
		this.seed = seed % 1000000000;
		this.rng = new Random(this.seed);
	}
	
	public void randomize() {
		
	}
	
//	public void writeSpoilerLog(RandomItemLocation[] locations) {
//		try {
//			String outDirName = "out";
//			String fileName = "Prime_" + this.seed + ".json";
//			File outDir = new File(outDirName);
//			
//			// Create out directory if it doesn't exist
//			if (outDir.mkdir())
//				System.out.println("Created out" + File.separator + " directory for spoiler logs");
//			
//			// Write spoiler log
//			BufferedWriter out = new BufferedWriter(new FileWriter(outDirName + File.separator + fileName));
//			RandomizedGame game = new RandomizedGame(this.seed, locations);
//			ObjectMapper mapper = new ObjectMapper();
//			String jsonResult = mapper.writeValueAsString(game);
//			out.write(jsonResult);
//			out.close();
//			System.out.println("Successfully wrote spoiler log to " + outDirName + File.separator + fileName);
//		}
//		catch (Exception e) {
//			System.out.println(e);
//		}
//	}
	
	public Map<String, Integer> getPriorityItems() {
		Map<String, Integer> priorityItems = new HashMap<String, Integer>();
		priorityItems.put("missileLauncher", 1);
		priorityItems.put("morph", 1);
		priorityItems.put("bomb", 1);
		priorityItems.put("phazon", 1);
		priorityItems.put("spacejump", 1);
		priorityItems.put("waveBeam", 1);
		priorityItems.put("iceBeam", 1);
		priorityItems.put("plasmaBeam", 1);
		priorityItems.put("charge", 1);
		priorityItems.put("superMissile", 1);
		priorityItems.put("xray", 1);
		priorityItems.put("pb", 1);
		
		// Artifacts
		priorityItems.put("truth", 1);
		priorityItems.put("strength", 1);
		priorityItems.put("elder", 1);
		priorityItems.put("wild", 1);
		priorityItems.put("lifegiver", 1);
		priorityItems.put("warrior", 1);
		priorityItems.put("chozo", 1);
		priorityItems.put("nature", 1);
		priorityItems.put("sun", 1);
		priorityItems.put("world", 1);
		priorityItems.put("spirit", 1);
		priorityItems.put("newborn", 1);
		return priorityItems;
	}
	
	public Map<String, Integer> getLuxuryItems() {
		Map<String, Integer> luxuryItems = new HashMap<String, Integer>();
		luxuryItems.put("varia", 1);
		luxuryItems.put("gravity", 1);
		luxuryItems.put("thermal", 1);
		luxuryItems.put("boost", 1);
		luxuryItems.put("spider", 1);
		luxuryItems.put("grapple", 1);
		luxuryItems.put("wavebuster", 1);
		luxuryItems.put("iceSpreader", 1);
		luxuryItems.put("flamethrower", 1);
		return luxuryItems;
	}
	
	public Map<String, Integer> getExpansions() {
		Map<String, Integer> expansions = new HashMap<String, Integer>();
		expansions.put("missileExpansion", 49);
		expansions.put("eTank", 14);
		expansions.put("pbExpansion", 4);
		return expansions;
	}
	
	public int getRandomSeed() {
		int seedNum = new Random().nextInt((999999999 - 1) + 1) + 1;
		return seedNum;
	}
	
	public int randomInt(int min, int max) {
		return this.rng.nextInt((max - min) + 1) + min;
	}
}
