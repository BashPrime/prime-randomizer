package com.etaylor8086.metroidprime.util;

public class DataTypeConversion {
	public static String convertIntAsciiToStr(int val) {
		char[] chars = new char[4];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char) ((val >> (24 - (i * 8))) & 0xFF);
		}
		
		return new String(chars).trim();
	}
}
