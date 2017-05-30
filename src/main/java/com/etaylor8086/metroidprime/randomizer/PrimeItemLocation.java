package com.etaylor8086.metroidprime.randomizer;

import org.json.simple.JSONObject;

import com.etaylor8086.metroidprime.utilities.NumberUtilities;

public class PrimeItemLocation {
	public String area;
	public String description;
	public String room;
	public Integer id;
	public Integer originalItem;
	public Integer randomizedItemId;
	public String randomizedItemName;
	
	public PrimeItemLocation() {
		this.area = null;
		this.description = null;
		this.room = null;
		this.id = null;
		this.originalItem = null;
		this.randomizedItemId = null;
		this.randomizedItemName = null;
		
	}
	
	public PrimeItemLocation(JSONObject primeItemLocationObj) {
		NumberUtilities numberUtils = new NumberUtilities();
		
		this.area = (String) primeItemLocationObj.get("area");
		this.description = (String) primeItemLocationObj.get("description");
		this.room = (String) primeItemLocationObj.get("room");
		this.id = numberUtils.parseHexString((String) primeItemLocationObj.get("id"));
		this.originalItem = numberUtils.parseHexString((String) primeItemLocationObj.get("originalItem"));
		this.randomizedItemId = null;
		this.randomizedItemName = null;
	}
}
