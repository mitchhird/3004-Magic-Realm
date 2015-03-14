package models.chitModels;

import models.characterModels.playerEnums.ArmorType;
import models.characterModels.playerEnums.Weights;
import models.chitModels.SpecialActionChits.DuckChit;

public class ChitFactory {
	
	//Action Chits
	//(fight/move),weight,speed,stars
	public static ActionChit MoveL = new ActionChit(Weights.LIGHT, /*speed*/4, /*stars*/2, false);
	
	//move
	public static ActionChit ML22 = new ActionChit(Weights.LIGHT, 2, 2, false);
	public static ActionChit ML21 = new ActionChit(Weights.LIGHT, 2, 1, false);
	public static ActionChit ML31 = new ActionChit(Weights.LIGHT, 3, 1, false);
	public static ActionChit ML40 = new ActionChit(Weights.LIGHT, 4, 0, false);
	public static ActionChit MM31 = new ActionChit(Weights.MEDIUM, 3, 1, false);
	public static ActionChit MM32 = new ActionChit(Weights.MEDIUM, 3, 2, false);
	public static ActionChit MM40 = new ActionChit(Weights.MEDIUM, 4, 0, false);
	public static ActionChit MM41 = new ActionChit(Weights.MEDIUM, 4, 1, false);
	public static ActionChit MM50 = new ActionChit(Weights.MEDIUM, 5, 0, false);
	public static ActionChit MH42 = new ActionChit(Weights.HEAVY, 4, 2, false);
	public static ActionChit MH51 = new ActionChit(Weights.HEAVY, 5, 1, false);
	public static ActionChit MH60 = new ActionChit(Weights.HEAVY, 6, 0, false);
	public static ActionChit MT52 = new ActionChit(Weights.TREMENDOUS, 5, 2, false);
	public static ActionChit MT61 = new ActionChit(Weights.TREMENDOUS, 6, 1, false);
	//fight
	public static ActionChit FL22 = new ActionChit(Weights.LIGHT, 2, 2, true);
	public static ActionChit FL31 = new ActionChit(Weights.LIGHT, 3, 1, true);
	public static ActionChit FL40 = new ActionChit(Weights.LIGHT, 4, 0, true);
	public static ActionChit FM32 = new ActionChit(Weights.MEDIUM, 3, 2, true);
	public static ActionChit FM31 = new ActionChit(Weights.MEDIUM, 3, 1, true);
	public static ActionChit FM40 = new ActionChit(Weights.MEDIUM, 4, 0, true);
	public static ActionChit FM41 = new ActionChit(Weights.MEDIUM, 4, 1, true);
	public static ActionChit FM50 = new ActionChit(Weights.MEDIUM, 5, 0, true);
	public static ActionChit FH42 = new ActionChit(Weights.HEAVY, 4, 2, true);
	public static ActionChit FH51 = new ActionChit(Weights.HEAVY, 5, 1, true);
	public static ActionChit FH60 = new ActionChit(Weights.HEAVY, 6, 0, true);
	public static ActionChit FT52 = new ActionChit(Weights.TREMENDOUS, 5, 2, true);
	public static ActionChit FT61 = new ActionChit(Weights.TREMENDOUS, 6, 1, true);
	//special
	public static DuckChit DT31 = new DuckChit(Weights.TREMENDOUS, 3, 1);
	
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
