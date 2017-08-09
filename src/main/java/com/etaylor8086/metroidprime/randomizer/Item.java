package com.etaylor8086.metroidprime.randomizer;

import java.util.HashMap;
import java.util.Map;

import com.etaylor8086.metroidprime.randomizer.item.Artifact;
import com.etaylor8086.metroidprime.randomizer.item.Expansion;
import com.etaylor8086.metroidprime.randomizer.item.Upgrade;
import com.etaylor8086.metroidprime.util.Constants;

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
		items.put(Constants.MISSILE_EXPANSION, new Expansion(Constants.MISSILE_EXPANSION, "Missile Expansion", 0x04, 0x2d7e6590, 0xa9b8e446, null, null, null, null));
		items.put(Constants.ENERGY_TANK, new Expansion(Constants.ENERGY_TANK, "Energy Tank", 0x18, 0x86908399, 0xf37bcbc7, null, null, null, null));
		items.put(Constants.POWER_BOMB_EXPANSION, new Expansion(Constants.POWER_BOMB_EXPANSION, "Power Bomb Expansion", 0x07, 0x227d7116, 0x0b5bbf9e, null, null, null, null));
		items.put(Constants.MISSILE_LAUNCHER, new Upgrade(Constants.MISSILE_LAUNCHER, "Missile Launcher", 0x04, 0x2d7e6590, 0xa9b8e446, null, new Rotation(-8.872797, 0, 0), null, null));
		items.put(Constants.WAVE_BEAM, new Upgrade(Constants.WAVE_BEAM, "Wave Beam", 0x02, 0x009771b9, 0x09881302, null, null, null, null));
		items.put(Constants.ICE_BEAM, new Upgrade(Constants.ICE_BEAM, "Ice Beam", 0x01, 0xda25b1be, 0x52a3b1a4, null, null, null, null));
		items.put(Constants.PLASMA_BEAM, new Upgrade(Constants.PLASMA_BEAM, "Plasma Beam", 0x03, 0xa792116a, 0x6397cc1b, null, null, null, null));
		items.put(Constants.MORPH_BALL, new Upgrade(Constants.MORPH_BALL, "Morph Ball", 0x10, 0x903e8ac5, 0x2d0fd5c9, null, null, null, null));
		items.put(Constants.MORPH_BALL_BOMB, new Upgrade(Constants.MORPH_BALL_BOMB, "Morph Ball Bomb", 0x06, 0xb5544d27, 0xda110e43, null, null, null, null));
		items.put(Constants.POWER_BOMB, new Upgrade(Constants.POWER_BOMB, "Power Bomb", 0x07, 0xd532bdb8, 0xf19131ad, null, null, null, null));
		items.put(Constants.CHARGE_BEAM, new Upgrade(Constants.CHARGE_BEAM, "Charge Beam", 0x0a, 0xc5472401, 0xe3cbc3f3, null, null, null, null));
		items.put(Constants.SUPER_MISSILE, new Upgrade(Constants.SUPER_MISSILE, "Super Missile", 0x0b, 0x853a56f0, 0x7c04e388, 0, null, null, null));
		items.put(Constants.WAVEBUSTER, new Upgrade(Constants.WAVEBUSTER, "Wavebuster", 0x1c, 0x74a39f36, 0x7c04e388, 2, null, null, null));
		items.put(Constants.ICE_SPREADER, new Upgrade(Constants.ICE_SPREADER, "Ice Spreader", 0x0e, 0x85ba7acb, 0x7c04e388, 3, null, null, null));
		items.put(Constants.FLAMETHROWER, new Upgrade(Constants.FLAMETHROWER, "Flamethrower", 0x08, 0xc54bbf68, 0x7c04e388, 1, null, null, null));
		items.put(Constants.THERMAL_VISOR, new Upgrade(Constants.THERMAL_VISOR, "Thermal Visor", 0x09, 0x61dab956, 0x9f0c908a, null, null, null, null));
		items.put(Constants.XRAY_VISOR, new Upgrade(Constants.XRAY_VISOR, "X-Ray Visor", 0x0d, 0x61dab956, 0x9f0c908a, null, null, null, null));
		items.put(Constants.SPACE_JUMP_BOOTS, new Upgrade(Constants.SPACE_JUMP_BOOTS, "Space Jump Boots", 0x0f, 0xa10715da, 0x999e81fe, null, null, null, null));
		items.put(Constants.GRAPPLE_BEAM, new Upgrade(Constants.GRAPPLE_BEAM, "Grapple Beam", 0x0c, 0xf86621c9, 0xc5b5ed4d, null, null, null, null));
		items.put(Constants.BOOST_BALL, new Upgrade(Constants.BOOST_BALL, "Boost Ball", 0x12, 0xbe57a2b2, 0xbe57a2b2, 0, null, null, null));
		items.put(Constants.SPIDER_BALL, new Upgrade(Constants.SPIDER_BALL, "Spider Ball", 0x13, 0x79d95dec, 0xbe57a2b2, 1, null, null, null));
		items.put(Constants.VARIA_SUIT, new Upgrade(Constants.VARIA_SUIT, "Varia Suit", 0x16, 0xcd995c16, 0xa3e787b7, null, null, null, null));
		items.put(Constants.GRAVITY_SUIT, new Upgrade(Constants.GRAVITY_SUIT, "Gravity Suit", 0x15, 0x95946e41, 0x27a97006, null, null, null, null));
		items.put(Constants.PHAZON_SUIT, new Upgrade(Constants.PHAZON_SUIT, "Phazon Suit", 0x17, 0x50535430, 0x50535433, null, null, null, null));
		items.put(Constants.ARTIFACT_OF_TRUTH, new Artifact(Constants.ARTIFACT_OF_TRUTH, "Artifact of Truth", 0x1d, 0x884e88dc, 0xfaa9c708, 3, null, 0x83210fce, 0xe80ea018));
		items.put(Constants.ARTIFACT_OF_STRENGTH, new Artifact(Constants.ARTIFACT_OF_STRENGTH, "Artifact of Strength", 0x1e, 0xffd05a2c, 0xfaa9c708, 1, null, 0x83210fce, 0xe80ea018));
		items.put(Constants.ARTIFACT_OF_ELDER, new Artifact(Constants.ARTIFACT_OF_ELDER, "Artifact of Elder", 0x1f, 0x64751643, 0xfaa9c708, 5, null, 0x83210fce, 0xe80ea018));
		items.put(Constants.ARTIFACT_OF_WILD, new Artifact(Constants.ARTIFACT_OF_WILD, "Artifact of Wild", 0x20, 0x10edffcc, 0xfaa9c708, 6, null, 0x83210fce, 0xe80ea018));
		items.put(Constants.ARTIFACT_OF_LIFEGIVER, new Artifact(Constants.ARTIFACT_OF_LIFEGIVER, "Artifact of Lifegiver", 0x21, 0x8b48b3a3, 0xfaa9c708, 7, null, 0x83210fce, 0xe80ea018));
		items.put(Constants.ARTIFACT_OF_WARRIOR, new Artifact(Constants.ARTIFACT_OF_WARRIOR, "Artifact of Warrior", 0x22, 0xfcd66153, 0xfaa9c708, 8, null, 0x83210fce, 0xe80ea018));
		items.put(Constants.ARTIFACT_OF_CHOZO, new Artifact(Constants.ARTIFACT_OF_CHOZO, "Artifact of Chozo", 0x23, 0x67732d3c, 0xfaa9c708, 9, null, 0x83210fce, 0xe80ea018));
		items.put(Constants.ARTIFACT_OF_NATURE, new Artifact(Constants.ARTIFACT_OF_NATURE, "Artifact of Nature", 0x24, 0x15e7b24d, 0xfaa9c708, 10, null, 0x83210fce, 0xe80ea018));
		items.put(Constants.ARTIFACT_OF_SUN, new Artifact(Constants.ARTIFACT_OF_SUN, "Artifact of Sun", 0x25, 0x8e42fe22, 0xfaa9c708, 11, null, 0x83210fce, 0xe80ea018));
		items.put(Constants.ARTIFACT_OF_WORLD, new Artifact(Constants.ARTIFACT_OF_WORLD, "Artifact of World", 0x26, 0x12174a4c, 0xfaa9c708, 0, null, 0x83210fce, 0xe80ea018));
		items.put(Constants.ARTIFACT_OF_SPIRIT, new Artifact(Constants.ARTIFACT_OF_SPIRIT, "Artifact of Spirit", 0x27, 0x89b20623, 0xfaa9c708, 2, null, 0x83210fce, 0xe80ea018));
		items.put(Constants.ARTIFACT_OF_NEWBORN, new Artifact(Constants.ARTIFACT_OF_NEWBORN, "Artifact of Newborn", 0x28, 0xfe2cd4d3, 0xfaa9c708, 4, null, 0x83210fce, 0xe80ea018));
		
		return items;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getFullName() {
		return this.fullName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animCharacter == null) ? 0 : animCharacter.hashCode());
		result = prime * result + ((animSet == null) ? 0 : animSet.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rotation == null) ? 0 : rotation.hashCode());
		result = prime * result + ((xrayModel == null) ? 0 : xrayModel.hashCode());
		result = prime * result + ((xraySkin == null) ? 0 : xraySkin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (animCharacter == null) {
			if (other.animCharacter != null)
				return false;
		} else if (!animCharacter.equals(other.animCharacter))
			return false;
		if (animSet == null) {
			if (other.animSet != null)
				return false;
		} else if (!animSet.equals(other.animSet))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rotation == null) {
			if (other.rotation != null)
				return false;
		} else if (!rotation.equals(other.rotation))
			return false;
		if (xrayModel == null) {
			if (other.xrayModel != null)
				return false;
		} else if (!xrayModel.equals(other.xrayModel))
			return false;
		if (xraySkin == null) {
			if (other.xraySkin != null)
				return false;
		} else if (!xraySkin.equals(other.xraySkin))
			return false;
		return true;
	}
	
	
}
