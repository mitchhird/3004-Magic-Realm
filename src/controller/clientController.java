package controller;

import java.util.ArrayList;

import models.characterModels.PlayerBase;

public class clientController {

	private ArrayList<PlayerBase> thePlayers;
	
	public clientController(){
		thePlayers = new ArrayList<PlayerBase>();
	}
	
	// Adds The Player to The Game
	public void addPlayer(String playerClass, String playerName){
		PlayerBase aPlayer = new PlayerBase();
		aPlayer.setClass(playerClass);
		aPlayer.setName(playerName);
	}
	
	public ArrayList<PlayerBase> getPlayers(){
		return thePlayers;
	}

	public void removePlayer(String playerToRemoveName, String playerToRemoveClass) {
		for(int i = 0; i < thePlayers.size(); i++){
			if(thePlayers.get(i).getPlayerClass() == playerToRemoveClass && thePlayers.get(i).getName() == playerToRemoveName){
				thePlayers.remove(i);
				return;
			}
		}
	}
}
