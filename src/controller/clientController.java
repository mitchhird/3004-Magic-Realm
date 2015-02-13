package controller;

import java.util.ArrayList;

import views.boardView;
import views.gameView;
import models.characterModels.PlayerBase;

public class clientController {

	private gameView theView;
	private ArrayList<PlayerBase> thePlayers;
	
	public clientController(gameView view){
		theView = view;
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
}
