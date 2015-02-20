package models.chitModels;

import models.characterModels.playerEnums.Weights;

public class GlobalChits {
	public static WeaponChit AXE = new WeaponChit(2, 1, Weights.MEDIUM);
	public static WeaponChit SPEAR = new WeaponChit(10, 1, Weights.MEDIUM);
	public static WeaponChit LIGHT_BOW = new WeaponChit(14, 2, Weights.LIGHT);
	public static WeaponChit THRUSTING_SWORD = new WeaponChit(4, 1, Weights.LIGHT);
}
