package models.characterModels;

import models.characterModels.playerEnums.Weights;

/*
 * update
 */

public class Dwarf extends PlayerBase {
	//starting equipment value
	//1st-lvl-19 2nd-19 3rd-23 4th-23
	/*
	 * weight/Vulnerability: Heavy
	 * Special:
	 * 1. Short Legs:
	 * -no sunlight phasesonly basic plus any
	 * extra due to belongings or spells
	 * can follow characters normally.
	 * even if they are using sunlight phases
	 * can use sheltered phases if season/wether rules
	 * -gets extra effort asterisk for Rest activity
	 * -can use duck shit as a special move chit
	 * only for "Duck" maneuver during melee step
	 * can not be used to carry items, to charge,
	 * or run away during the encounter step.
	 * does count as a move chit(fatigue)
	 * 2 CAVE KNKOWLEDGE:
	 * rolls one die instead of two whenever
	 * he uses the hid table, the meeting table, or
	 * any search table when he is in a cave clearing
	 * 
	 * Starting Location: Innor Guardhouse
	 * 
	 * Trade Relationships:
	 * Friendly:
	 * Company, Guard, Scholar
	 * Unfriendly:
	 * Woodfolk, Bashkars
	 * 
	 * Development/Combat Chits:
	 * Youngster:
	 * Axe, Helmet, DuckT3*, MoveH6, FightH5*
	 * Smith:
	 * Axe, Helmet, MoveT6*, FightH6, FightH4**
	 * Warrior:
	 * Great Axe, Helmet, MoveH5*, FightT6*, FightH4**
	 */
	public Dwarf() {
		weight = Weights.HEAVY;
	}
}
