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
	public boolean help;
	
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
}
