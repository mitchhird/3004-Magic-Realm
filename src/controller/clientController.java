package controller;

import java.util.ArrayList;

import views.gameView;
import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.CharacterClass;

public class clientController {
	
	private gameView parent;
	private int currentPlayerIndex;
	private PlayerBase currentPlayer;
	private ArrayList<PlayerBase> thePlayers;

	public clientController(gameView theView){
		parent = theView;
		currentPlayerIndex = 0;
		thePlayers = new ArrayList<PlayerBase>();
	}
	
	// Adds The Player to The Game
	public void addPlayer(CharacterClass playerClass, String playerName){
		// Add The Player Into The List
		PlayerBase aPlayer = new PlayerBase();
		aPlayer.setClass(playerClass);
		aPlayer.setName(playerName);
		thePlayers.add(aPlayer);
		
		// If That Is The First Player, Set The Current Player To That
		if (thePlayers.size() == 1) {
			currentPlayer = aPlayer;
		}
	}
	
	// Returns The player List From The Game
	public ArrayList<PlayerBase> getPlayers(){
		return thePlayers;
	}
	
	// Moves To Next Player's Turn, Using Modulo Math
	public void moveToNextPlayer () {
		currentPlayerIndex++;
		currentPlayer = thePlayers.get(currentPlayerIndex % thePlayers.size());
	}
	
	// Starts The Game When Called
	public void startGame () {
		for (PlayerBase p: thePlayers) {
			Clearing playerStart = parent.getBoardView().getDefaultClearingForClass(p.getPlayerClass());
			p.setCurrentClearing(playerStart);
			playerStart.playerMovedToThis(p);
		}
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
	
	/*-----------------  Getters And Setters -------------------------*/
	public PlayerBase getCurrentPlayer() {
		return currentPlayer;
	}
}
