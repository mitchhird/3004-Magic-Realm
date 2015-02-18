package models.characterModels;

import models.characterModels.playerEnums.Weights;

/*
 * update
 */

public class Captain extends PlayerBase {
	//starting equipment value
	//1st-lvl-23 2nd-35 3rd-35 4th-35
	/*
	 * weight/vulnerability: Medium
	 * Special
	 * 1 AIM:
	 * subtracts one from die roll whenever he
	 * rolls on the missle table
	 * 2 REPUTATION:
	 * can record and do an extra phase each day
	 * he is at a Dwelling(includes campfire)
	 * he must be at the Dwelling when he starts
	 * the phase. not when recording it.
	 * can use extra phase to do any normal activity
	 * 
	 * Starting Location: Inn, House, or Guardhouse
	 * 
	 * Trading Relationships:
	 * Friendly:
	 * Patrol, Soldiers, Guard, Scholar
	 * Unfriendly:
	 * woodfolk
	 * Enemy:
	 * Bashkars
	 * 
	 * Development/Combat Chits:
	 * Spearman:
	 * Spear, Sheild, MoveM4*, MoveM5, FightH5*
	 * Soldier:
	 * Short Sword, Helmet, Breastplate, Sheild, FightM5,
	 * FightM5, FightM3**, MoveM3**
	 * Lieutenant: Short Sword, Helmet, Breastplate, Shield, MoveM4*,
	 * FightH5*, FightM4*
	 * Captain:
	 * Short Sword, Helmet, Breastplate, Shield, MoveM4*, FightH6, FightM4*
	 * 
	 */
	public Captain() {
		vulnerability = Weights.MEDIUM;
	}
}
