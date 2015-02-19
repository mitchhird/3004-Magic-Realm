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
			 * -move
			 * -hide
			 * -alert
			 * -rest
			 * -search
			 * -trade
			 * -hire
			 * -follow
			 * -fly
			 * -use spell
			 * 
			 */
		}
		//will have to add things about moving all hired to
		//same place
		
		//add a thing for prowling creatures
		if(day%7 == 0){
			
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
		
		for(int i = 0; i < maxPhases; ++i){
			
			for(int p = 0; p < totalPlayers; ++p){
				trade with players in clearing
				rearange belongings
			}
			
			for(int p = 0; p < totalPlayers; ++p){
				if(can do recorded){
					orderPlayers[i].unHide();
					orderPlayers[i].getRecord();
				}
			}
			
//			for(int p = 0; p < totalPlayers; ++p){
//				check if want to block
//			}
			
			
		}
		
//		warning and sound chit become active
//		more things about monsters moving to hexes
	}
	
	private void evening(){
		CombatPvP combat = new CombatPvP();
		combat.combatPvP(orderPlayers, activeClearings);
	}
	
	private void midnight(){
		for(int i = 0; i < totalPlayers; ++i){
			rearrangeBelongins();
			weapon unalerted;
		}
//		curses removed from chapel
	}
}
