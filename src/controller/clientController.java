package controller;

import java.util.ArrayList;

import utils.GameUtils;
import views.MainViews.GameView;
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
		addPlayer(playerClass, playerName, "localhost");
	}
	
	// Adds The Player To The Game 
	public void addPlayer (CharacterClass playerClass, String playerName, String ip) {
		// Add The Player Into The List
		PlayerBase aPlayer = new PlayerBase(playerName, playerClass, ip);
		addPlayer(aPlayer);
		
		// Boardcast The Message Back Out
		if (parent.isNetworkedGame()) {
			parent.sendMessage(aPlayer);
		}
	}
	
	// Adds A Player That Is Already Known To The System
	public void addPlayer(PlayerBase aPlayer) {
		thePlayers.add(aPlayer);
		setCurrentPlayer(aPlayer);
		parent.getPlayerList().updateTable();
	}
	
	// Returns The player List From The Game
	public ArrayList<PlayerBase> getPlayers(){
		return thePlayers;
	}
	
	// Returns The Last Player
	public PlayerBase getLastPlayer () {
		return thePlayers.get(thePlayers.size() - 1);
	}
	
	// Moves To Next Player's Turn, Using Modulo Math
	public void moveToNextPlayer () {
		currentPlayerIndex++;
		if(currentPlayerIndex % thePlayers.size() == 0){
			for(int i = 0; i < thePlayers.size(); i++){
				thePlayers.get(i).newDay();
			}
		}
		currentPlayer = thePlayers.get(currentPlayerIndex % thePlayers.size());
		currentPlayer.startPlayerTurn();

		if(currentPlayer.getDay()==28){
			parent.displayWinner(getWinner());
			parent.dispose();
		}
		
		// TODO: Add The Proper Object For Board Interaction
		parent.sendMessage("Switching To Next Player");
	}
	
	private String getWinner() {		
		int maxGold = -1;
		String winner = "";
		for (int i = 0; i<thePlayers.size();i++) {
		   if (thePlayers.get(i).getGold() > maxGold) {
		      maxGold  =thePlayers.get(i).getGold();
		      winner = thePlayers.get(i).getName();
		   }
		}
		
		return winner;
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
	
	private void setCurrentPlayer(PlayerBase aPlayer) {
		// If That Is The First Player, Set The Current Player To That
		if (thePlayers.size() == 1) {
			currentPlayer = aPlayer;
		}
	}
}
