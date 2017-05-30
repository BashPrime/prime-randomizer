package com.etaylor8086.metroidprime.randomizer;

import java.math.BigInteger;

import org.json.simple.JSONObject;

import com.etaylor8086.metroidprime.utilities.NumberUtilities;

public class PrimeItem {
	private String name;
	private Long count;
	private Integer item;
	private Long capacity;
	private Long amount;
	private Integer model;
	private Integer animSet;
	private Long animCharacter;
	private Object rotation;
	private Integer xrayModel;
	private Integer xraySkin;
	
	public PrimeItem(JSONObject primeItemObj) {
		NumberUtilities numberUtils = new NumberUtilities();
		
		// name, count, item, model, animSet are all used, rest are optional
		this.name = (String) primeItemObj.get("name");
		this.count = (Long) primeItemObj.get("count");
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
