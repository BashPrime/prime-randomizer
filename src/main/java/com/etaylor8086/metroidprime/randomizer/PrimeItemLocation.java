package com.etaylor8086.metroidprime.randomizer;

import org.json.simple.JSONObject;

public class PrimeItemLocation {
	private String area;
	private String description;
	private String room;
	private Integer id;
	private Integer originalItem;
	
	public PrimeItemLocation(JSONObject primeItemLocationObj) {
		this.area = (String) primeItemLocationObj.get("area");
		this.description = (String) primeItemLocationObj.get("description");
		this.room = (String) primeItemLocationObj.get("room");
		this.id = Integer.decode((String) primeItemLocationObj.get("id"));
		this.originalItem = Integer.decode((String) primeItemLocationObj.get("originalItem"));
	}
	
	public String toString() {
		return "area: " + this.area + ", description: " + this.description + ", room: " + this.room + ", id: " + this.id + ", originalItem: " + this.originalItem;
	}
}
