package com.etaylor8086.metroidprime;

import com.beust.jcommander.JCommander;

import com.etaylor8086.metroidprime.randomizer.Randomizer;

/**
 * Randomizer entry point
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	CommandLineArgs cla = new CommandLineArgs();
    	JCommander jc = new JCommander(cla);
    	jc.setProgramName("randomizer");
    	jc.parse(args);
    	
    	// Print usage
    	if (args.length < 2 || cla.help) {
    		jc.usage();
    	}
    	
    	// Run randomizer using provided seed value
    	else if (cla.getSeed() != null) {
    		Randomizer randomizer = new Randomizer();
    		randomizer.randomize(cla.getSeed());
    	}
    }
}
