package com.etaylor8086.metroidprime.utilities;

public class NumberUtilities {
	public Integer parseHexString(String hex) {
		int parsedNumber = -1;
		try {
			parsedNumber = (int) Long.parseLong(hex.substring(2), 16);
		}
		catch (Exception e) {
			System.err.println("Error attempting to parse string " + hex + ": " + e);
			System.exit(1);
		}
		return parsedNumber;
	}
}
