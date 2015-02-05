package controller;

import models.characterModels.Player;

public class clientController {

	private Player thePlayer;
	
	public clientController(){
		thePlayer = new Player();
	}
	
	public void setPlayer(String playerClass){
		thePlayer.setClass(playerClass);
	}
	
	public Player getPlayer(){
		return thePlayer;
	}
}
