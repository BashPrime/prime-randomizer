package com.etaylor8086.metroidprime.randomizer;

import java.util.HashMap;
import java.util.Map;

public class Item {
	protected String name;
	protected String fullName;
	protected Integer id;
	protected Integer model;
	protected Integer animSet;
	protected Integer animCharacter;
	protected Rotation rotation;
	protected Integer xrayModel;
	protected Integer xraySkin;
	protected static Map<String, Item> items = null;
	
	public Item(String name, String fullName, Integer id, Integer model, Integer animSet, Integer animCharacter, Rotation rotation, Integer xrayModel, Integer xraySkin) {
		this.name = name;
		this.fullName = fullName;
		this.id = id;
		this.model = model;
		this.animSet = animSet;
		this.animCharacter = animCharacter;
		this.rotation = rotation;
		this.xrayModel = xrayModel;
		this.xraySkin = xraySkin;
	}
	
	public static Item get(String key) {
		Map<String, Item> items = all();
		if(items.containsKey(key))
			return items.get(key);
		return null;
	}
	
	public static Map<String, Item> all() {
		if (items != null)
			return items;
		
		items = new HashMap<String, Item>();
		items.put("missileExpansion", new Item("missileExpansion", "Missile Expansion", 0x04, 0x2d7e6590, 0xa9b8e446, null, null, null, null));
		items.put("eTank", new Item("eTank", "Energy Tank", 0x18, 0x86908399, 0xf37bcbc7, null, null, null, null));
		items.put("pbExpansion", new Item("pbExpansion", "Power Bomb Expansion", 0x07, 0x227d7116, 0x0b5bbf9e, null, null, null, null));
		items.put("missileLauncher", new Item("missileLauncher", "Missile Launcher", 0x04, 0x2d7e6590, 0xa9b8e446, null, new Rotation(-8.872797, 0, 0), null, null));
		items.put("waveBeam", new Item("waveBeam", "Wave Beam", 0x02, 0x009771b9, 0x09881302, null, null, null, null));
		items.put("iceBeam", new Item("iceBeam", "Ice Beam", 0x01, 0xda25b1be, 0x52a3b1a4, null, null, null, null));
		items.put("plasmaBeam", new Item("plasmaBeam", "Plasma Beam", 0x03, 0xa792116a, 0x6397cc1b, null, null, null, null));
		items.put("morph", new Item("morph", "Morph Ball", 0x10, 0x903e8ac5, 0x2d0fd5c9, null, null, null, null));
		items.put("bomb", new Item("bomb", "Morph Ball Bomb", 0x06, 0xb5544d27, 0xda110e43, null, null, null, null));
		items.put("pb", new Item("pb", "Power Bomb", 0x07, 0xd532bdb8, 0xf19131ad, null, null, null, null));
		items.put("charge", new Item("charge", "Charge Beam", 0x0a, 0xc5472401, 0xe3cbc3f3, null, null, null, null));
		items.put("superMissile", new Item("superMissile", "Super Missile", 0x0b, 0x853a56f0, 0x7c04e388, 0, null, null, null));
		items.put("wavebuster", new Item("waveBuster", "Wavebuster", 0x1c, 0x74a39f36, 0x7c04e388, 2, null, null, null));
		items.put("iceSpreader", new Item("iceSpreader", "Ice Spreader", 0x0e, 0x85ba7acb, 0x7c04e388, 3, null, null, null));
		items.put("flamethrower", new Item("flamethrower", "Flamethrower", 0x08, 0xc54bbf68, 0x7c04e388, 1, null, null, null));
		items.put("thermal", new Item("thermal", "Thermal Visor", 0x09, 0x61dab956, 0x9f0c908a, null, null, null, null));
		items.put("xray", new Item("xray", "X-Ray Visor", 0x0d, 0x61dab956, 0x9f0c908a, null, null, null, null));
		items.put("spaceJump", new Item("spaceJump", "Space Jump Boots", 0x0f, 0xa10715da, 0x999e81fe, null, null, null, null));
		items.put("grapple", new Item("grapple", "Grapple Beam", 0x0c, 0xf86621c9, 0xc5b5ed4d, null, null, null, null));
		items.put("boost", new Item("boost", "Boost Ball", 0x12, 0xbe57a2b2, 0xbe57a2b2, 0, null, null, null));
		items.put("spider", new Item("spider", "Spider Ball", 0x13, 0x79d95dec, 0xbe57a2b2, 1, null, null, null));
		items.put("varia", new Item("varia", "Varia Suit", 0x16, 0xcd995c16, 0xa3e787b7, null, null, null, null));
		items.put("gravity", new Item("gravity", "Gravity Suit", 0x15, 0x95946e41, 0x27a97006, null, null, null, null));
		items.put("phazon", new Item("phazon", "Phazon Suit", 0x17, 0x50535430, 0x50535433, null, null, null, null));
		items.put("truth", new Item("truth", "Artifact of Truth", 0x1d, 0x884e88dc, 0xfaa9c708, 3, null, 0x83210fce, 0xe80ea018));
		items.put("strength", new Item("strength", "Artifact of Strength", 0x1e, 0xffd05a2c, 0xfaa9c708, 1, null, 0x83210fce, 0xe80ea018));
		items.put("elder", new Item("elder", "Artifact of Elder", 0x1f, 0x64751643, 0xfaa9c708, 5, null, 0x83210fce, 0xe80ea018));
		items.put("wild", new Item("wild", "Artifact of Wild", 0x20, 0x10edffcc, 0xfaa9c708, 6, null, 0x83210fce, 0xe80ea018));
		items.put("lifegiver", new Item("lifegiver", "Artifact of Lifegiver", 0x21, 0x8b48b3a3, 0xfaa9c708, 7, null, 0x83210fce, 0xe80ea018));
		items.put("warrior", new Item("warrior", "Artifact of Warrior", 0x22, 0xfcd66153, 0xfaa9c708, 8, null, 0x83210fce, 0xe80ea018));
		items.put("chozo", new Item("chozo", "Artifact of Chozo", 0x23, 0x67732d3c, 0xfaa9c708, 9, null, 0x83210fce, 0xe80ea018));
		items.put("nature", new Item("nature", "Artifact of Nature", 0x24, 0x15e7b24d, 0xfaa9c708, 10, null, 0x83210fce, 0xe80ea018));
		items.put("sun", new Item("sun", "Artifact of Sun", 0x25, 0x8e42fe22, 0xfaa9c708, 11, null, 0x83210fce, 0xe80ea018));
		items.put("world", new Item("world", "Artifact of World", 0x26, 0x12174a4c, 0xfaa9c708, 0, null, 0x83210fce, 0xe80ea018));
		items.put("spirit", new Item("spirit", "Artifact of Spirit", 0x27, 0x89b20623, 0xfaa9c708, 2, null, 0x83210fce, 0xe80ea018));
		items.put("newborn", new Item("newborn", "Artifact of Newborn", 0x28, 0xfe2cd4d3, 0xfaa9c708, 4, null, 0x83210fce, 0xe80ea018));
		
		return items;
	}
}
