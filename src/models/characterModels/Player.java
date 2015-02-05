package models.characterModels;

/*
 * will have the initial information about the player
 * such as their character
 * history
 * inventory etc.
 * testing
 */

public class Player {

	private String playerClass;
	
	public void setClass(String newPlayerClass) {
		playerClass = newPlayerClass;
	}
	
	public String getPlayerClass(){
		return playerClass;
	}

}
