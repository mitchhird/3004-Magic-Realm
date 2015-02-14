package controller;

import java.util.ArrayList;

import views.gameView;
import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.CharacterClass;

public class clientController {
	
	private ArrayList<PlayerBase> thePlayers;
	
	public clientController(gameView theView){
		thePlayers = new ArrayList<PlayerBase>();
	}
	
	// Adds The Player to The Game
	public void addPlayer(CharacterClass playerClass, String playerName){
		PlayerBase aPlayer = new PlayerBase();
		aPlayer.setClass(playerClass);
		aPlayer.setName(playerName);
	}
	
	public ArrayList<PlayerBase> getPlayers(){
		return thePlayers;
	}

	// Remove The Player From The List
	public void removePlayer(String playerToRemoveName) {
		for(int i = 0; i < thePlayers.size(); i++){
			if(thePlayers.get(i).getName() == playerToRemoveName){
				thePlayers.remove(i);
				return;
			}
		}
	}
}
