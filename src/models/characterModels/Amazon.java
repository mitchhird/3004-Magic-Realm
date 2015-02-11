package models.characterModels;

import models.characterModels.playerEnums.Weights;

/*
 * update
 */

public class Amazon extends PlayerBase {
	//starting equipment value
	//1st-lvl-16 2nd-37 3rd-37 4th-35
	/*
	 * weight/Vulnerability: medium
	 * special advantages:
	 * 1 AIM:
	 * The amazon subtracts one from each die roll
	 * whenever she rolls on missile table to attack
	 * with a missle weapon
	 * 2 STAMINA:
	 * The Amazon can record and do an extra Move
	 * phase each turn. She gets this bonus even
	 * when she is riding a horse. includes being
	 * an excellent horsewomen
	 * 
	 * Starting Location:
	 * Inn
	 * 
	 * Trading Relationships:
	 * Friendly:
	 * Lancers, Patrol, Shaman
	 * Unfriendly:
	 * Company, Bashkars
	 * 
	 * Development/Combat Chits:
	 * Scout:
	 * Light Bow,, MoveM4, MoveM3*, FightL4
	 * Warrior: 
	 * Spear, Helmet, Breastplate, Shield, MoveM4, FightM5, FightM4*
	 * Champion: 
	 * Spear, Helmet, Breastplate, Shield, MoveM3*, FightM3**, FightH4**
	 * Amazon: 
	 * Short Sword, Helmet, Breastplate, Shield, FightM4*, FightM3**, MoveM3*
	 */
	public Amazon(){
		weight = Weights.MEDIUM;
	}
}
