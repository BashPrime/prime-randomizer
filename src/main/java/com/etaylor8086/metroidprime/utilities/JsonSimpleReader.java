package com.etaylor8086.metroidprime.utilities;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class JsonSimpleReader {
	JSONParser parser;
	
	public JSONArray readJsonArrayFromFile(InputStream inputStream) {
		parser = new JSONParser();
		JSONArray jsonArray = null;
		try {
			jsonArray = (JSONArray) parser.parse(new InputStreamReader(inputStream, "UTF-8"));	
		}
		catch (Exception e) {
			System.out.println("Error reading JSON Array from file: " + e);
			System.exit(1);
		}
		
		return jsonArray;
	}
}