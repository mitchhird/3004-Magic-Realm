package models.chitModels;

import models.characterModels.playerEnums.Weights;

public class ChitFactory {
	
	// Weapon Chits
	public static WeaponChit AXE = new WeaponChit("Axe", 2, 1, Weights.MEDIUM);
	public static WeaponChit SPEAR = new WeaponChit("Spear", 10, 1, Weights.MEDIUM);
	public static WeaponChit LIGHT_BOW = new WeaponChit("Light Bow", 14, 2, Weights.LIGHT);
	public static WeaponChit THRUSTING_SWORD = new WeaponChit("Thrusting Sword", 4, 1, Weights.LIGHT);
	
	/* ----------------------------- Armor Chits ----------------------------- */
	public static ArmorChit getHelmet () {
		return new ArmorChit(ArmorType.HELMET, Weights.MEDIUM);
	}
	
	public static ArmorChit getBreastPlate () {
		return new ArmorChit(ArmorType.BREASTPLATE, Weights.MEDIUM);
	}
	
	public static ArmorChit getShield () {
		return new ArmorChit(ArmorType.SHIELD, Weights.MEDIUM);
	}
	
	public static ArmorChit getArmor () {
		return new ArmorChit(ArmorType.ARMOUR, Weights.MEDIUM);
	}
}
