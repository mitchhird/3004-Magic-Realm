package models.characterModels;

/*
 * will have the initial information about the player
 * such as their character
 * history
 * inventory etc.
 * testing
 */

public class PlayerBase {

	private String playerClass;
	private int currentFame;
	private int currentNotirity;
	private int currentGold;
	
	protected void initPlayerStats () {
		currentFame = 0;
		currentNotirity = 0;
		currentGold = 0;
	}
	
	public void setClass(String newPlayerClass) {
		playerClass = newPlayerClass;
	}
	
	public String getPlayerClass(){
		return playerClass;
	}
	
	// Simply adds the amount to the player's gold
	public void addGold (int amount) {
		currentGold += amount;
	}

}
