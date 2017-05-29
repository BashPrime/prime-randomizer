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
    	try {
    		CommandLineArgs cla = new CommandLineArgs();
        	JCommander jc = new JCommander(cla);
        	jc.setProgramName("randomizer");
        	jc.parse(args);
        	
        	// Print usage
        	if (cla.help) {
        		jc.usage();
        	}
        	
        	// Run randomizer using provided seed value
        	else if (cla.getSeed() != null) {
        		Randomizer randomizer = new Randomizer();
        		randomizer.runRandomizer(cla.getSeed());
        	}
        	
        	else {
        		Randomizer randomizer = new Randomizer();
        		randomizer.runRandomizer();
        	}
    	}
    	catch (Exception e) {
    		exitWithError(e.getMessage());
    	}
    }
    
    public static void exitWithError(String msg) {
    	System.err.println(msg);
    	usage();
    	System.exit(1);
    }
    
    private static void usage() {
    	JCommander jc = new JCommander(new CommandLineArgs());
    	jc.usage();
    }
    
    
}
