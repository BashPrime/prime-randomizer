package com.etaylor8086.metroidprime;

import com.beust.jcommander.JCommander;
import com.etaylor8086.metroidprime.randomizer.Randomizer;

/**
 * Randomizer entry point
 */

public class App 
{
	/**
	 * Main entry point for application. Parse CLI arguments and run randomizer accordingly
	 * @param args - Arguments and/or options as part of invoking the application
	 */
    public static void main( String[] args )
    {
    	CommandLineArgs cla = new CommandLineArgs();
    	JCommander jc = new JCommander(cla);
    	
    	try {
        	jc.setProgramName("randomizer");
        	jc.parse(args);
    	}
    	catch (Exception e) {
    		exitWithError(e.getMessage());
    	}
    	
    	// Print usage
    	if (cla.help) {
    		jc.usage();
    	}
    	
    	// Run randomizer using provided seed value
    	else if (cla.getSeed() != null) {
    		Randomizer randomizer = new Randomizer(cla.getSeed());
    		randomizer.runRandomizer();
    	}
    	
    	// Run randomizer with random seed
    	else {
    		Randomizer randomizer = new Randomizer();
    		randomizer.runRandomizer();
    	}
    }
    
    /**
     * Method to handle any JCommander CLI parsing errors. Prints usage then exits with status code 1
     * @param msg - Exception message to print out
     */
    public static void exitWithError(String msg) {
    	System.err.println(msg);
    	usage();
    	System.exit(1);
    }
    
    /**
     * Prints out CLI/JCommander argument usage.
     */
    private static void usage() {
    	JCommander jc = new JCommander(new CommandLineArgs());
    	jc.usage();
    }
    
    
}
