package controller;

import utils.GameUtils;
import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;

public class DayController {
	//for the actual controls of a game that loops for the days
	
	/*
	 * information on this is from pg 33 - 53 then combat
	 * 
	 * going to need an unhidden array of players and natives
	 * 
	 * end of the day the tile that the character is on will
	 * reveal chits from their pile
	 * 
	 * there is a monster roll for each day to determine prowling monsters
	 * may arrive at end of turns/in the evening for battle with characters
	 * 
	 * if there are prowling monsters already on board will move to character's clearing to block
	 * (unhidden only) players
	 * players can run/avoid/fight monsters
	 * 
	 * dwellings in valley or woods tiles can contain natives for trade with
	 * players can also hire natives to fight/search for things
	 * 
	 * unfriendly and enemy natives mayblock and battle a character unexpectedly
	 * 
	 * at some treasure sites/native groups visitors CAN be found
	 * these visitors can trade gold/spells/items gold/missions/campaigns(can have native groups as allies)
	 * visitors can not be hired/battled
	 * 
	 * people can work together and can backstab
	 * 
	 * monsters and natives can be hired and are considered denizen
	 * 
	 * some native groups (garrison natives) are the order/Guard/Soldiers/Rogues
	 * 
	 * native horses can not be used by anyone other then the native
	 */
	
	private int day;
	private int maxDays;
	private int maxPhases = 4;
	private PlayerBase[] allPlayers;
	private PlayerBase[] orderPlayers;
	private int totalPlayers;
	private Clearing activeClearings;
	//some view here currentView;
	
	public void startGame(PlayerBase[] newPlayers){
		day = 0;
		maxDays = 28;
		allPlayers = newPlayers;
		//will have to change this to have hired leaders
		totalPlayers = newPlayers.length;
		
		while(day != maxDays){
			++day;
			birdSong();
			dayLight();
			evening();
			midnight();
		}
		
		check all victory things
	}
	
	private void birdSong(){
		for(int i = 0; i < totalPlayers; ++i){
			allPlayers[i].record();
			
			//have to pick 2-4 phases out of 10
			/* the 10 are
			 * -move (adjacent clearing must be named)
			 * -hide (roll required)
			 * -alert
			 * -rest (1 star of action chit can change for wounded to inactive or inactive to active
			 *       can do with more stars but must pay back)
			 *       (if unable to rest and no active chits then dead/if all wounded then dead)
			 * -search (have to search to find the location or the secret path)
			 *         (you can also look abandoned belongings or locations discovered)
			 * -trade (can be cancelled)
			 * --buying (have to roll to see if can buy treasure, this is based
			 *        on how friendly that player is to the natives and can improve this
			 *        by buying a round of drinks to help one roll, this costs 1 gold per
			 *        native on the clearing)(if allowed to buy then have to trade and/or
			 *        pay the gold required, can get for free, if not will can decline
			 *        MUST try to buy)
			 *        (fame is also a part of this and will go up if sold and down if bought)
			 * -hire
			 * -follow
			 * -fly
			 * -use spell
			 * 
			 */
			allPlayers[i].unHide();
		}
		//will have to add things about moving all hired to
		//same place
		
		//add a thing for prowling creatures
		if(day%7 == 0){
			//natives and monsters respawn
		}
	}
	
	private void dayLight(){
		//this orders the players for the day
		//will have to change this to add for swordsman wanting to go
		for(int i = 0; i < totalPlayers; ++i){
			int turn = GameUtils.createRandomInt(0, allPlayers.length);
			orderPlayers[orderPlayers.length] = allPlayers[turn];
			for(int f = turn; turn < allPlayers.length; ++f){
				allPlayers[f] = allPlayers[f + 1];
			}
		}
		allPlayers = orderPlayers;
		
		for(int i = 0; i < totalPlayers; ++i){
			orderPlayers[i].unHide();
			for(int p = 0; p < orderPlayers[i].getMaxPhases(); ++p){//have to add phases and max phases with the record
				//also will have to check if illegal moves
//				trade with players in clearing
//				rearange belongings
				switch (orderPlayers[i].getPhase(p)){
				case "H":
//					roll on hide table
					break;
				case "M":
//					move to the clearing specified
					break;
				case "S":
//					can search on search table therefore roll
//					can loot things if discovered or if abandoned items roll loot table
//					loot table is a usual roll and then count down from the top of the stack
//					if roll > stack = nothing
					break;
				case "T":
//					trading with certain people gets initiated
					break;
				case "R":
//					have to do something with the rest can do later
					break;
				case "A":
					orderPlayers[i].getWeapon().setAlerted(true);
					break;
				case "F":
					//will set the following to true and the player they wish to follow
					break;

				}
				
//				blocking might occur
			}
			
//			for(int p = 0; p < totalPlayers; ++p){
//				check if want to block
//			}
			
//			map chits in tile to clearing where needed
//			more to do with monsters and natives when that needs to be added
		}
		
//		warning and sound chit become active
//		more things about monsters moving to hexes
	}
	
	private void evening(){
		CombatPvP combat = new CombatPvP();
		combat.combatPvP(orderPlayers);
	}
	
	private void midnight(){
		for(int i = 0; i < totalPlayers; ++i){
//			orderPlayers[i].rearrangeBelongings();
			orderPlayers[i].getWeapon().setAlerted(false);
		}
//		curses removed from players around chapel tile
	}
}
