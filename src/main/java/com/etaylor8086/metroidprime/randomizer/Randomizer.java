package com.etaylor8086.metroidprime.randomizer;

import java.util.Random;

public class Randomizer {
	/**
	 * Runs the randomizer with a random seed.
	 */
	public void randomize() {
		this.randomize(new Random().nextInt());
	}
	
	/**
	 * Runs the Prime item randomizer.
	 * @param seed
	 */
	public void randomize(int seed) {
		System.out.println("Using seed: " + seed);
	}
}
