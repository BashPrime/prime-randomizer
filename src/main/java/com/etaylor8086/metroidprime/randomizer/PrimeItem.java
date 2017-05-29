package com.etaylor8086.metroidprime.randomizer;

import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;

public class PrimeItem {
	private String name;
	private Integer count;
	private Integer item;
	private Integer capacity;
	private Integer amount;
	private Integer model;
	private Integer animSet;
	private Integer animCharacter;
	private Object rotation;
	private Integer xrayModel;
	private Integer xraySkin;
	
	public PrimeItem(JSONObject primeItemObj) {
		this.name = (String) primeItemObj.get("name");
		this.count = (Integer) primeItemObj.get("count");
		this.item = Integer.decode((String) primeItemObj.get("item"));
		this.capacity = (Integer) primeItemObj.get("capacity");
		this.amount = (Integer) primeItemObj.get("amount");
		this.model = Integer.decode((String) primeItemObj.get("model"));
		this.animSet = Integer.decode((String) primeItemObj.get("animSet"));
		this.animCharacter = (Integer) primeItemObj.get("animCharacter");
		this.rotation = primeItemObj.get("rotation");
		this.xrayModel = Integer.decode((String) primeItemObj.get("xrayModel"));
		this.xraySkin = Integer.decode((String) primeItemObj.get("xraySkin"));
	}
}
