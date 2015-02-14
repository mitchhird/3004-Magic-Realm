package models.characterModels;

import java.awt.Image;
import java.util.LinkedList;
import java.util.Queue;

import models.BoardModels.Clearing;
import models.characterModels.playerEnums.CharacterClass;
import models.characterModels.playerEnums.Weights;
import models.chitModels.Chit;
import models.otherEntities.Denizen;
import utils.GameUtils;

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
	
	// Player's Name And Class
	protected String playerName;
	protected String playerClass;
	protected String tradeRelationship;
	
	// Compound Data Types For The Object
	protected Chit[] armorChit;
	protected Chit[] combatChit;
	protected Chit[] weaponChit;
	protected Weights weight;
	protected Weights vulnerability;
	protected Queue<String> commandList;
	protected CharacterClass characterClass;
	protected Clearing currentClearing;
	
	//controllable units might need might not
	//big part of combat system
	//might also include natives?
	protected Denizen[] hired;
	
	protected String history;
	protected String discovery;
	
	// Boolean Flags
	protected boolean hidden;
	
	// Default Constructor
	public PlayerBase () {
		initPlayerStats();
	}
	
	// Initialize The Player Stats
	protected void initPlayerStats () {
		currentFame = 0;
		currentNotirity = 0;
		currentGold = 10;
		hidden = false;
		commandList = new LinkedList<>();
		characterClass = CharacterClass.SWORDSMAN;
	}
	
	// Starts The Player's Turn And Wipes Out There Player's Commands
	protected void startPlayerTurn () {
		hidden = false;
		commandList.clear();
	}
	
	// Attempts To Hide The Player, Consult Die Table For Reasoning For Result
	public boolean attemptHide () {
		int dieRoll = GameUtils.createRandomInt(1, 6);
		hidden = (hidden) ? true : dieRoll < 6;
		return hidden;
	}
	
	// Attempts To Move The Player To The Designated Clearing
	public boolean moveToClearing (Clearing newClearing) {
		if (currentClearing.isVaildMove(newClearing)) {
			currentClearing.playerMovedOff();
			currentClearing = newClearing;
			currentClearing.playerMovedToThis(this);
			return true;
		} else{
			return false;
		}
	}
	
	/*-------------- Getters And Setters -------------- */
	public void setClass(CharacterClass newPlayerClass) {
		characterClass = newPlayerClass;
	}
	
	public void setName(String newPlayerName){
		playerName = newPlayerName;
	}
	
	// Can't Be Negative
	public void setGold (int amount) {
		currentGold = Math.max(amount, 0);
	}
	
	public CharacterClass getPlayerClass(){
		return characterClass;
	}
	
	public Weights getVulnerability(){
		return vulnerability;
	}
	
	public void setVulnerability(Weights vul){
		this.vulnerability = vul;
	}

	public Clearing getCurrentClearing() {
		return currentClearing;
	}

	public void setCurrentClearing(Clearing currentClearing) {
		this.currentClearing = currentClearing;
	}
	
	public Image getImage() {
		return characterClass.getReadyTile();
	}
	
	public String getName(){
		return playerName;
	}
}
