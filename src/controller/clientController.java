package controller;

import models.characterModels.PlayerBase;

public class clientController {

	private PlayerBase thePlayer;
	
	public clientController(){
		thePlayer = new PlayerBase();
	}
	
	public void setPlayer(String playerClass){
		thePlayer.setClass(playerClass);
	}
	
	public PlayerBase getPlayer(){
		return thePlayer;
	}
}
