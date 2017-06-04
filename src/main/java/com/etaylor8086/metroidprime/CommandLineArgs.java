package com.etaylor8086.metroidprime;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

public class CommandLineArgs {
	@Parameter
	private List<String> parameters = new ArrayList<String>();
	
	@Parameter(names = {"--seed", "-s"}, description = "Seed number")
	private Integer seed = null;
	
	@Parameter(names = {"--help", "-h"}, description = "Prints this message", help = true)
	private boolean help;
	
	@Parameter(names = {"--version", "-v"}, description = "Prints the randomizer version")
	private boolean version;
	
	@Parameter(names = {"--input-file", "-i"}, description = "Input .iso file")
	private String inputFile;
	
	/**
	 * Getter for CLI seed number
	 * @return The seed value, or null if one wasn't defined in the CLI argument
	 */
	public Integer getSeed() {
		return this.seed;
	}
	
	/**
	 * Getter for CLI help argument
	 * @return True if the help argument is entered by the user
	 */
	public boolean getHelp() {
		return this.help;
	}
	
	/**
	 * Getter for CLI version argument
	 * @return True if the version argument is entered by the user
	 */
	public boolean getVersion() {
		return this.version;
	}
	
	/**
	 * Getter for CLI inputFile argument
	 * @return String value, or null if one wasn't defined
	 */
	public String getInputFile() {
		return this.inputFile;
	}
}
