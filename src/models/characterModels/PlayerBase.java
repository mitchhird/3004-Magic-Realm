package models.characterModels;

import java.awt.Image;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JButton;

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
	
	//weapons/armor/horses/treasure cards
	//reading runes at treasure sites
	//magical artifacts/spell books
	//fighting and killing monsters, natives, or characters
	//winner of the game is the one with most points above the amount to win
	//i.e. some one that needs 20 and gets 21 will lose to someone that
	//    need 15 and gets 17
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
	protected Chit horse;
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
	protected boolean moving;
	
	// Default Constructor
	public PlayerBase () {
		initPlayerStats();
	}
	
	public PlayerBase (String playerName, CharacterClass c) {
		initPlayerStats();
		setName(playerName);
		setClass(c);
	}
	
	
	//sould have a starting location on a dwelling
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
		
		// If The Player Hid Then Simply Refresh The Player's Image
		if (hidden) {
			JButton clearingButton = currentClearing.getButtonTiedToClearing();
			Image playerIcon = getImage().getScaledInstance(clearingButton.getWidth(), clearingButton.getHeight(), Image.SCALE_SMOOTH);
			currentClearing.getButtonTiedToClearing().setIcon(new ImageIcon (playerIcon));
			clearingButton.repaint();
		}
		
		return hidden;
	}
	
	// Attempts To Move The Player To The Designated Clearing
	public boolean moveToClearing (Clearing newClearing) {
		if (currentClearing.isVaildMove(newClearing)) {
			clearConnectedClearings();
			currentClearing.resetClearing();
			currentClearing = newClearing;
			currentClearing.playerMovedToThis(this);
			return true;
		} else{
			return false;
		}
	}
	
	// Resets The Players Values When Called
	public void reset() {
		hidden = false;
		moving = false;
		clearConnectedClearings();
	}

	private void clearConnectedClearings() {
		for (Clearing c: currentClearing.getConnectedClearings()) {
			c.resetClearing();
		}
	}
	
	//*********
	//if a player dies will start over again at the in as the same or different
	//character but will be forfeiring all his possessions/fame/notoriety/gold/discoveries
	
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
	
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Clearing getCurrentClearing() {
		return currentClearing;
	}

	public void setCurrentClearing(Clearing currentClearing) {
		this.currentClearing = currentClearing;
	}
	
	public Image getImage() {
		return (hidden) ? characterClass.getHiddenTile() :characterClass.getReadyTile();
	}
	
	public String getName(){
		return playerName;
	}
	
	public int getCurrentFame() {
		return currentFame;
	}

	public int getCurrentNotirity() {
		return currentNotirity;
	}

	public int getCurrentGold() {
		return currentGold;
	}
}
