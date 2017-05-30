package com.etaylor8086.metroidprime.randomizer;

import org.json.simple.JSONObject;

import com.etaylor8086.metroidprime.utilities.NumberUtilities;

public class PrimeItem {
	public String name;
	public Long count;
	public Long remaining;
	public Integer item;
	public Long capacity;
	public Long amount;
	public Integer model;
	public Integer animSet;
	public Long animCharacter;
	public Object rotation;
	public Integer xrayModel;
	public Integer xraySkin;
	
	public PrimeItem() {
		this.name = null;
		this.count = null;
		this.remaining = null;
		this.item = null;
		this.capacity = null;
		this.amount = null;
		this.model = null;
		this.animSet = null;
		this.animCharacter = null;
		this.rotation = null;
		this.xrayModel = null;
		this.xraySkin = null;
	}
	
	public PrimeItem(JSONObject primeItemObj) {
		NumberUtilities numberUtils = new NumberUtilities();
		
		// name, count, item, model, animSet are all used, rest are optional
		this.name = (String) primeItemObj.get("name");
		this.count = (Long) primeItemObj.get("count");
		this.remaining = this.count;
		this.item = numberUtils.parseHexString((String) primeItemObj.get("item"));
		this.model = numberUtils.parseHexString((String) primeItemObj.get("model"));
		this.animSet = numberUtils.parseHexString((String) primeItemObj.get("animSet"));
		this.capacity = primeItemObj.get("capacity") != null ? (Long) primeItemObj.get("capacity") : null;
		this.amount = primeItemObj.get("amount") != null ? (Long) primeItemObj.get("amount") : null;
		this.animCharacter = primeItemObj.get("animCharacter") != null ? (Long) primeItemObj.get("animCharacter") : null;
		this.rotation = primeItemObj.get("rotation") != null ? primeItemObj.get("rotation") : null;
		this.xrayModel = primeItemObj.get("xrayModel") != null ? numberUtils.parseHexString((String) primeItemObj.get("xrayModel")) : null;
		this.xraySkin = primeItemObj.get("xraySkin") != null ? numberUtils.parseHexString((String) primeItemObj.get("xraySkin")) : null;
	}
}
