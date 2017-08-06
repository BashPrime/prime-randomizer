package com.etaylor8086.metroidprime.randomizer;

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
	
	public int getRandomSeed() {
		int seedNum = new Random().nextInt((999999999 - 1) + 1) + 1;
		return seedNum;
	}
	
	public int randomInt(int min, int max) {
		return this.rng.nextInt((max - min) + 1) + min;
	}
}
