package controller;

import java.util.ArrayList;

import views.GameView;
import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.CharacterClass;

public class clientController {
	
	private GameView parent;
	private int currentPlayerIndex;
	private PlayerBase currentPlayer;
	private ArrayList<PlayerBase> thePlayers;
	
	private boolean gameStarted;

	public clientController(GameView theView){
		parent = theView;
		currentPlayerIndex = 0;
		thePlayers = new ArrayList<PlayerBase>();
	}
	
	// Adds The Player to The Game
	public void addPlayer(CharacterClass playerClass, String playerName){
		// Add The Player Into The List
		PlayerBase aPlayer = new PlayerBase(playerName, playerClass);
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
		currentPlayer.startPlayerTurn();
	}
	
	// Starts The Game When Called
	public void startGame () {
		gameStarted = true;
		for (PlayerBase p: thePlayers) {
			Clearing playerStart = parent.getBoardView().getDefaultClearingForClass(p.getPlayerClass());
			p.setCurrentClearing(playerStart);
			p.setHomeClearing(playerStart);
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
	
	// Get Player By Name 
	public PlayerBase getPlayer (String name, CharacterClass charClass) {
		for (PlayerBase p: thePlayers) {
			if (p.getName().equals(name) && p.getPlayerClass() == charClass) {
				return p;
			}
		}
		return null;
	}
	
	// Gather All Of The Unhidden Players
	public ArrayList<PlayerBase> getUnhiddenPlayers () {
		ArrayList<PlayerBase> returnVal = new ArrayList<>();
		for (PlayerBase p: thePlayers) {
			if (!p.isHidden()) {
				returnVal.add(p);
			}
		}
		return returnVal;
	}
	
	/*-----------------  Getters And Setters -------------------------*/
	public PlayerBase getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean isGameStarted() {
		return gameStarted;
	}

	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}
}
