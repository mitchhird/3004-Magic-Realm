package models.characterModels;

import models.characterModels.playerEnums.Weights;

/*
 * update
 */

public class Swordsman extends PlayerBase {
	//starting equipment value
	//1st-lvl-10 2nd-10 3rd-16 4th-16
	/*
	 * Weight/Vulnerability: Light
	 * Special:
	 * 1 Barter:
	 * rolls one die instead of two whenever uses the
	 * meeting table during a trade activity. only for
	 * TRADE
	 * 2 Clever:
	 * if the attention chit is picked can pick when to
	 * take turn.
	 * -at sunrise he keeps his attention chit.
	 * -when new attention chit is about to be picked
	 * can during daylight preempt and take his turn
	 * at this point. can only do once per day.
	 * -no interruptting another player once the other
	 * character's chit has been picked, and if he has not
	 * taken his turn when all of the attention chits played
	 * must take his turn
	 * -can only work during Daylight no other times
	 * -if more then one person can do this. start with the last
	 * character to take a turn and move "left" to ppl that
	 * have this ability. most take turn if no one left
	 * 
	 * start location: Inn
	 * 
	 * trade relation:
	 * Friendly:
	 * Rouges, Company, Warlock
	 * Enemy:
	 * Patrol
	 * 
	 * Development/Combat Chits:
	 * Wanderer:
	 * MoveL4, MoveL3*,FightL3*
	 * Thief:
	 * MoveL3*, FightL2**, MoveL2**
	 * Adventurer:
	 * Thrusting Sword, MoveM4*, FightM4, FightM3**
	 * Swordsman:
	 * Thrusting Sword, FightL4, FightM5, FightL2**
	 * 
	 */
	public Swordsman(){
		vulnerability = Weights.LIGHT;
	}
}
