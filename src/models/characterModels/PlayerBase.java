package models.characterModels;

import models.characterModels.playerEnums.Weights;
import models.chitModels.Chit;

/*
 * will have the initial information about the player
 * such as their character
 * history
 * inventory etc.
 * testing
 */

public class PlayerBase {
	
	//fame/not can be negative and are public to others, gold can't be neg
	protected int currentFame;
	protected int currentNotirity;
	protected int currentGold;
	protected int vicotryPoints;
	protected int winVictoryPoints;
	
	protected String playerName;
	protected String playerClass;
	protected String tradeRelationship;
	
	// Compound Data Types For The Object
	protected Chit[] armorChit;
	protected Chit[] combatChit;
	protected Chit[] weaponChit;
	protected Weights weight;
	protected Weights vulnerability;
	
	//might need might not be needed
	//to change things on the discovery
	//table
	protected String discovery;
	
	//might need to have a day class to
	//specify the history of the game
	protected String history;
	
	// Default Constructor
	public PlayerBase () {
		initPlayerStats();
	}
	
	// Initialize The Player Stats
	protected void initPlayerStats () {
		currentFame = 0;
		currentNotirity = 0;
		currentGold = 10;
	}
	
	/*-------------- Getters And Setters -------------- */
	public void setClass(String newPlayerClass) {
		playerClass = newPlayerClass;
	}
	
	public void setName(String newPlayerName){
		playerName = newPlayerName;
	}
	
	// Can't Be Negative
	public void setGold (int amount) {
		currentGold = Math.max(amount, 0);
	}
	
	public String getPlayerClass(){
		return playerClass;
	}

}
