package com.etaylor8086.metroidprime.randomizer;

import org.json.simple.JSONObject;

import com.etaylor8086.metroidprime.utilities.NumberUtilities;

public class PrimeItemLocation {
	private String area;
	private String description;
	private String room;
	private Integer id;
	private Integer originalItem;
	
	public PrimeItemLocation(JSONObject primeItemLocationObj) {
		NumberUtilities numberUtils = new NumberUtilities();
		
		this.area = (String) primeItemLocationObj.get("area");
		this.description = (String) primeItemLocationObj.get("description");
		this.room = (String) primeItemLocationObj.get("room");
		this.id = numberUtils.parseHexString((String) primeItemLocationObj.get("id"));
		this.originalItem = numberUtils.parseHexString((String) primeItemLocationObj.get("originalItem"));
	}
	
	public String toString() {
		return "area: " + this.area + ", description: " + this.description + ", room: " + this.room + ", id: " + this.id + ", originalItem: " + this.originalItem;
	}
}
