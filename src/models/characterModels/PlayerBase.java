package models.characterModels;

/*
 * will have the initial information about the player
 * such as their character
 * history
 * inventory etc.
 * testing
 */

public class PlayerBase {

	private String playerName;
	private String playerClass;
	private BaseChar character;
	private Chit[] combatChits;
	private int vicotryPoints;
	private int winVictoryPoints;
	private String tradeRelationship;
	
	//might need might not be needed
	//to change things on the discovery
	//table
	private String discovery;
	
	//might need to have a day class to
	//specify the history of the game
	private String history;
	
	//fame/not can be negative and are public
	//to others
	private int currentFame;
	private int currentNotirity;
	//can not be negative
	private int currentGold;
	
	protected void initPlayerStats () {
		currentFame = 0;
		currentNotirity = 0;
		currentGold = 10;
	}
	
	public void setClass(String newPlayerClass) {
		playerClass = newPlayerClass;
	}
	
	public void setName(String newPlayerName){
		playerName = newPlayerName;
	}
	
	public String getPlayerClass(){
		return playerClass;
	}
	
	// Simply adds the amount to the player's gold
	public void addGold (int amount) {
		currentGold += amount;
	}

}
