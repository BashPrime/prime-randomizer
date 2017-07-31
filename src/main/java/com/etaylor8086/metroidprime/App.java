package com.etaylor8086.metroidprime;

import java.io.InputStream;
import java.util.Properties;

import com.beust.jcommander.JCommander;
import com.etaylor8086.metroidprime.patcher.Prime1Reader;
import com.etaylor8086.metroidprime.randomizer.Randomizer;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;

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
    	Properties properties = loadProperties();
    	
    	try {
        	jc.setProgramName("randomizer");
        	jc.parse(args);
    	}
    	catch (Exception e) {
    		exitWithError(e.getMessage());
    	}
    	
    	// Print usage
    	if (cla.getHelp()) {
    		jc.usage();
    	}
    	
    	// Print version
    	else if (cla.getVersion()) {
    		System.out.println("randomizer version " + properties.getProperty("randomizer.version"));
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
    	
//    	if (cla.getInputFile() != null) {
//    		Prime1Reader p1r = new Prime1Reader(cla.getInputFile());
//    	}
    	
    	Prime1Reader p1r = new Prime1Reader("mp1.iso");
    	
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
    
    /**
     * Loads application properties such as version information.
     * @return Loaded application properties
     */
    private static Properties loadProperties() {
    	Properties properties = new Properties();
    	try {
    		InputStream in = App.class.getResourceAsStream("/randomizer.properties");
    		properties.load(in);
    		in.close();
    	}
    	catch (Exception e) {
    		System.err.println("Error loading application properties: " + e);
    		System.exit(1);
    	}
    	
    	return properties;
    }
    
    
}
