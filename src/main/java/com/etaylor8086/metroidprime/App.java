package com.etaylor8086.metroidprime;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import com.etaylor8086.metroidprime.randomizer.Randomizer;

/**
 * Randomizer entry point
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// create Options object
    	Options options = new Options();

    	// add options
    	options.addOption("seed", true, "use a user-defined seed");
    	options.addOption("help", false, "print this message");
    	
    	CommandLineParser parser = new DefaultParser();
    	Randomizer randomizer = new Randomizer();
    	
    	try {
    		CommandLine cmd = parser.parse( options, args);
    		// get seed option value
    		String seedVal = cmd.getOptionValue("seed");
    		
    		if (cmd.hasOption("help")) {
    			HelpFormatter formatter = new HelpFormatter();
    			formatter.printHelp( "randomizer", options );
    			System.exit(0);
    		}

    		if(seedVal == null) {
    		    randomizer.randomize();
    		}
    		else {
    		    randomizer.randomize(Integer.parseInt(seedVal));
    		}
    		
    	}
    	catch (Exception e) {
    		System.out.println("Error parsing command line args: " + e);
    	}
    }
}
