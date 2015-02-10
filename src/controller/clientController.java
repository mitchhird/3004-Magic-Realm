package controller;

import java.util.ArrayList;

import models.characterModels.PlayerBase;

public class clientController {

	private ArrayList<PlayerBase> thePlayers;
	
	public clientController(){
		thePlayers = new ArrayList<PlayerBase>();
	}
	
	public void addPlayer(String playerClass, String playerName){
		PlayerBase aPlayer = new PlayerBase();
		aPlayer.setClass(playerClass);
		aPlayer.setName(playerName);
	}
	
	public ArrayList<PlayerBase> getPlayers(){
		return thePlayers;
	}
}
