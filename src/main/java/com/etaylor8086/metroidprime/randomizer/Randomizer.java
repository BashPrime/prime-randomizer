package com.etaylor8086.metroidprime.randomizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.etaylor8086.metroidprime.randomizer.filler.RandomAssumed;

public class Randomizer {
	protected String difficulty;
	protected World world;
	protected Random rng;
	
	/**
	 * Default constructor. Loads randomizer class with a psuedorandom seed
	 */
	public Randomizer() {
		this.difficulty = "normal";
		this.world = new World(this.difficulty);
	}
	
	/**
	 * Overloaded constructor to load class with user-defined difficulty
	 * @param difficulty
	 */
	public Randomizer(String difficulty) {
		this.difficulty = difficulty;
		this.world = new World(difficulty);
	}
	
	public void randomize() {
		this.rng = new Random();
		int seed = this.getRandomInt(1, 999999999);
		this.randomize(seed);
	}
	
	public void randomize(int seed) {
		this.rng = new Random(seed);
		
		new RandomAssumed(this.world, this.rng).fill(this.getArtifacts(), this.getPriorityItems(), this.getLuxuryItems(), this.getExpansions());
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
	
	public List<Item> getArtifacts() {
		List<Item> artifacts = new ArrayList<Item>();
		Map<String, Integer> artifactsMap = new HashMap<String, Integer>();
		artifactsMap.put("truth", 1);
		artifactsMap.put("strength", 1);
		artifactsMap.put("elder", 1);
		artifactsMap.put("wild", 1);
		artifactsMap.put("lifegiver", 1);
		artifactsMap.put("warrior", 1);
		artifactsMap.put("chozo", 1);
		artifactsMap.put("nature", 1);
		artifactsMap.put("sun", 1);
		artifactsMap.put("world", 1);
		artifactsMap.put("spirit", 1);
		artifactsMap.put("newborn", 1);
		
		for(Map.Entry<String, Integer> entry : artifactsMap.entrySet())
			for (int i = 0; i < entry.getValue(); i++)
				artifacts.add(Item.get(entry.getKey()));
				
		return artifacts;
	}
	
	public List<Item> getPriorityItems() {
		List<Item> priorityItems = new ArrayList<Item>();
		Map<String, Integer> priorityItemsMap = new HashMap<String, Integer>();
		priorityItemsMap.put("missileLauncher", 1);
		priorityItemsMap.put("morph", 1);
		priorityItemsMap.put("bomb", 1);
		priorityItemsMap.put("phazon", 1);
		priorityItemsMap.put("spacejump", 1);
		priorityItemsMap.put("waveBeam", 1);
		priorityItemsMap.put("iceBeam", 1);
		priorityItemsMap.put("plasmaBeam", 1);
		priorityItemsMap.put("charge", 1);
		priorityItemsMap.put("superMissile", 1);
		priorityItemsMap.put("xray", 1);
		priorityItemsMap.put("pb", 1);
		
		for(Map.Entry<String, Integer> entry : priorityItemsMap.entrySet())
			for (int i = 0; i < entry.getValue(); i++)
				priorityItems.add(Item.get(entry.getKey()));
				
		return priorityItems;
	}
	
	public List<Item> getLuxuryItems() {
		List<Item> luxuryItems = new ArrayList<Item>();
		Map<String, Integer> luxuryItemsMap = new HashMap<String, Integer>();
		luxuryItemsMap.put("varia", 1);
		luxuryItemsMap.put("gravity", 1);
		luxuryItemsMap.put("thermal", 1);
		luxuryItemsMap.put("boost", 1);
		luxuryItemsMap.put("spider", 1);
		luxuryItemsMap.put("grapple", 1);
		luxuryItemsMap.put("wavebuster", 1);
		luxuryItemsMap.put("iceSpreader", 1);
		luxuryItemsMap.put("flamethrower", 1);
		
		for(Map.Entry<String, Integer> entry : luxuryItemsMap.entrySet())
			for (int i = 0; i < entry.getValue(); i++)
				luxuryItems.add(Item.get(entry.getKey()));
		
		return luxuryItems;
	}
	
	public List<Item> getExpansions() {
		List<Item> expansions = new ArrayList<Item>();
		Map<String, Integer> expansionsMap = new HashMap<String, Integer>();
		expansionsMap.put("missileExpansion", 49);
		expansionsMap.put("eTank", 14);
		expansionsMap.put("pbExpansion", 4);
		
		for(Map.Entry<String, Integer> entry : expansionsMap.entrySet())
			for (int i = 0; i < entry.getValue(); i++)
				expansions.add(Item.get(entry.getKey()));
		
		return expansions;
	}
	
	public int getRandomInt(int min, int max) {
		return this.rng.nextInt((max - min) + 1) + min;
	}
}
