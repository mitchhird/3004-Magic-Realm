package models.characterModels;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;

import models.BoardModels.Clearing;
import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.CharacterClass;
import models.characterModels.playerEnums.Weights;
import models.chitModels.ActionChit;
import models.chitModels.ArmorChit;
import models.chitModels.Chit;
import models.chitModels.WeaponChit;
import models.otherEntities.Denizen;
import models.otherEntities.EntityBase;
import models.otherEntities.TreasureModel;
import utils.GameUtils;

/*
 * will have the initial information about the player
 * such as their character
 * history
 * inventory etc.
 * testing
 */

public class PlayerBase extends EntityBase implements Serializable {
	
	//fame/not can be negative and are public to others, gold can't be neg
	protected int currentFame;
	protected int currentNotirity;
	protected int currentGold;
	protected int currentDay;
	
	//weapons/armor/horses/treasure cards
	//reading runes at treasure sites
	//magical artifacts/spell books
	//fighting and killing monsters, natives, or characters
	//winner of the game is the one with most points above the amount to win
	//i.e. some one that needs 20 and gets 21 will lose to someone that
	//    need 15 and gets 17
	protected int vicotryPoints;
	protected int winVictoryPoints;
	protected int killCount;
	protected int availableActions;
	
	// Player's Name And Class
	protected String playerName;
	protected String playerClass;
	protected String tradeRelationship;
	protected String playerIP;
	
	//Action Chits in different statuses
	protected transient ActionChit[] Active;
	protected transient ActionChit[] InActive;
	protected transient ActionChit[] Wounded;
	
	// Compound Data Types For The Object
	protected Chit[] combatChit;
	protected Chit horse;
	protected Weights wounds;
	protected Weights vulnerability;
	protected CharacterClass characterClass;
	protected WeaponChit activeWeapon;

	// Lists For The Player
	protected ArrayList<ArmorChit> armorChits;
	protected ArrayList<WeaponChit> weaponChit;
	protected ArrayList<TreasureModel> accquiredTreasures;
	protected ArrayList<PlayerBase> listAttacks;
	protected PlayerBase chargeTarget;
	
	// Clearing Stuff
	protected Clearing homeClearing;
	protected Clearing currentClearing;
	
	// Log Recording
	protected String currentTurn;
	protected ArrayList<String> turnLog;
	
	protected String history;
	protected String discovery;
	
	// Boolean Flags
	protected boolean moving;
	protected boolean living;
	protected boolean foundHidden;
	
	// Non Serialization Data
	protected transient Denizen[] hired;	
	protected transient Image hiddenImage;
	protected transient Image unhiddenImage;

	// Serialization Flag
	private static final long serialVersionUID = 1087220843681586963L;

	// Default Constructor
	public PlayerBase () {
		initPlayerStats();
	}
	
	// Constructor When Multiple Instances For The Player Are Known
	public PlayerBase (String playerName, CharacterClass c) {
		setName(playerName);
		setClass(c);
		initPlayerStats();
	}
	
	// Constructor When Making A Network Based Model
	public PlayerBase (String playerName, CharacterClass c, String playerIP) {
		setName(playerName);
		setClass(c);
		initPlayerStats();
		
		setPlayerIP(playerIP);
	}
	
	
	//sould have a starting location on a dwelling
	// Initialize The Player Stats
	protected void initPlayerStats () {
		currentFame = 0;
		currentNotirity = 0;
		currentGold = 10;
		killCount = 0;
		currentDay = 0;
        availableActions = 5;
		
        // Boolean Values
        foundHidden = false;
		hidden = false;
		living = true;
		
		// String Values
		currentTurn = "";
		playerIP = "localhost";
		
		// Setup the lists
		turnLog = new ArrayList<>();
		accquiredTreasures = new ArrayList<>();

		initializePlayer();
	}

	// Initializes Player Transient Objects
	public void initializePlayer() {
		// Setup The Image
		hiddenImage = characterClass.getHiddenTile();
		unhiddenImage = characterClass.getReadyTile();
	}
	
	// Starts The Player's Turn And Wipes Out There Player's Commands
	public void startPlayerTurn () {
		hidden = false;
		currentTurn = "";
		currentClearing.playerMovedToThis(this);

		// Set The Available Actions To 0
		availableActions = 5;
	}
	
	// Do All The Things For Ending The Player's Turn
	public void endPlayerTurn () {
		turnLog.add(currentTurn);
		currentTurn = "";
	}
	
	// Attempts To Hide The Player, Consult Die Table For Reasoning For Result
	public boolean attemptHide () {
		availableActions--;
		
		int dieRoll = GameUtils.createRandomInt(1, 6);
		setHidden((hidden) ? true : dieRoll < 6);		
		logAction ("H");
		
		return hidden;
	}
	
	// Attempts To Move The Player To The Designated Clearing
	public boolean moveToClearing (Clearing newClearing) {
		// Log The Turn On The Player's Log And Subtract An Action
		availableActions--;
		logAction("M-" + newClearing.getClearingName());

		updateConnectedClearings();
		currentClearing.updateImage();
		currentClearing.playerMovedOffOf(this);
		currentClearing = newClearing;
		currentClearing.playerMovedToThis(this);
		return true;
	}
	
	// Moves The Player Straight To Home When Called
	public void moveToHome() {
		forceMove(homeClearing);
	}

	// Forces A Move To The Clearing Provided
	public void forceMove(Clearing moveTo) {
		updateConnectedClearings();
		currentClearing.updateImage();
		currentClearing.playerMovedOffOf(this);
		currentClearing = moveTo;
		currentClearing.playerMovedToThis(this);
	}
	
	// Resets The Players Values When Called
	public void reset() {
		hidden = false;
		moving = false;
		updateConnectedClearings();
	}
	
	// Kills The Player And Adds All Of The Values To This
	public void killPlayer (PlayerBase oppoent) {
		this.currentFame += oppoent.currentFame;
		this.currentGold += oppoent.currentGold;
		this.currentNotirity += oppoent.currentNotirity;
		killCount++;
		oppoent.moveToHome();
	}
	
	// Treasure Functions
	public void addTreasure (TreasureModel t) {
		accquiredTreasures.add(t);
		currentGold += t.getTreasureGoldValue();
		currentFame += t.getFameAmount();
		currentNotirity += t.getNotorietyAmount();
	}
	
	public ArrayList<TreasureModel> searchCurrentClearing () {
		logAction("S-" + currentClearing.getClearingName());
		availableActions--;
		return currentClearing.searchClearing(this);
	}
	
	public void logAction (String logMessage) {
		currentTurn += (currentTurn.equals("")) ? logMessage : "," + logMessage;
	}
	
	// Updates All Of The Connected 
	public void updateConnectedClearings() {
		currentClearing.updateConnectedTiles();
	}
	
	//can be changed to something else if weight is not an issue;
	//have to change this so that it will do things to the action chits
	public void increaseWounds(int d){
		for(int i = 0; i < d; ++i){
			wounds = wounds.next();
			if (wounds == vulnerability){
				isDead();
				return;
			}
		}
	}
	
	public void resetWounds(){
		wounds = Weights.NEGLIGABLE;
	}
	
	public void setCharge() {
		// TODO Auto-generated method stub
		Set<EntityBase> chargeAble = getSelectable();
		//have to take the chargeAble to view for selection or none
	}
	
	public void selectTarget(){
		// TODO
		Set<EntityBase> targetAble = getSelectable();
		//have to send to view to see if selection
	}
	
	private Set<EntityBase> getSelectable(){
		Set<EntityBase> Selectable = new HashSet<EntityBase>();
		if(foundHidden){//something to do with the search phase of the day
			Selectable.addAll(getCurrentClearing().getEntitiesInClearing());
		} else {
			if (getCurrentClearing().getUnhiddenEntities() != null){
				Selectable.addAll(getCurrentClearing().getUnhiddenEntities());
			}
		}
		return Selectable;
	}
	
	/*-------------- Getters And Setters -------------- */
	public ArrayList<String> getRecordLog () {
		return turnLog;
	}
	
	public String getPlayerIP() {
		return playerIP;
	}

	public void setPlayerIP(String playerIP) {
		this.playerIP = playerIP;
	}

	public void setHomeClearing(Clearing homeClearing) {
		this.homeClearing = homeClearing;
	}

	public void setClass(CharacterClass newPlayerClass) {
		characterClass = newPlayerClass;
		vulnerability = newPlayerClass.getVulner();
		
		// Weapon For This Player
		weaponChit = new ArrayList<>();
		weaponChit.add(newPlayerClass.getStartingWeapon());
		activeWeapon = weaponChit.get(0);

		// Armor Chits
		armorChits = new ArrayList<>();
		armorChits.addAll(newPlayerClass.getArmour());
		System.out.println();
	}
	
	public void setName(String newPlayerName){
		playerName = newPlayerName;
	}
	
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
		return (hidden) ? hiddenImage : unhiddenImage;
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
	
	public Clearing getHomeClearing() {
		return homeClearing;
	}

	public void addAttack(PlayerBase toAttack){
		listAttacks.add(toAttack);
	}
	
	public PlayerBase attackList(){
		return listAttacks.remove(0);
	}
	
	public boolean isLiving(){
		return living;
	}
	
	public void unHide(){
		hidden = false;
	}

	public WeaponChit getWeapon() {
		return activeWeapon;
	}

	public ArrayList<ArmorChit> getArmorChits() {
		return armorChits;
	}

	public void setArmorChits(ArrayList<ArmorChit> armorChits) {
		this.armorChits = armorChits;
	}

	public int getStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void checkIfDamaged(Weights harm) {
		// TODO Auto-generated method stub
	}

	public void isDead() {
		living = false;
	}	
	
	public int getKillCount() {
		return killCount;
	}

	public void setKillCount(int killCount) {
		this.killCount = killCount;
	}

	public int getAvailableActions() {
		return availableActions;
	}

	public void setAvailableActions(int availableActions) {
		this.availableActions = availableActions;
	}

	public boolean armorBlocks(Attacks attack) {
		// TODO Auto-generated method stub
		//should loop through what can be blocked in the attack types
		//if blockable attack then return true
		return true;
	}

	//will return 0 if not able to change
	public int rollTacChange() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int selection() {
		// TODO Auto-generated method stub
		//will ask if player wants to alert weapon, run, or fly (can cast spell here) or nothing
		//will do what is selected and return 1
		//will return 0 if do nothing
		return 0;
	}

	public void selection2() {
		// TODO Auto-generated method stub
		//must alert something or abandon an amount of belongings
	}

	public void toCharge(Set<EntityBase> chargeAble) {
		// TODO Auto-generated method stub
		//will change charge target to something
		
	}

	public PlayerBase chargingPlayer() {
		return chargeTarget;
	}

	public void setWounds(int wounds) {
		// TODO Auto-generated method stub
		if(wounds == 1){
			increaseWounds(wounds);
		}
		if(wounds == 2){
			//no horse
		}
		if(wounds == 3){
			isDead();
		}
		
	}

	public Attacks getAttackDirection() {
		// TODO Auto-generated method stub
		//have to set it up so that you can get your weapon to swing a set direction
		return null;
	}

	public boolean checkIfHit(Attacks attackDirection) {
		// TODO Auto-generated method stub
		// will check manuever vsv attackDirection and if hit then return true
		return false;
	}

	public int getSpeed() {
		// TODO Auto-generated method stub
		// this is the manuever speed of the player that round
		return 0;
	}

	public int checkLure(Set<EntityBase> unhidden) {
		// TODO Auto-generated method stub
		// will ask the player if they want to lure any monsters/natives
		return 0;
	}

	@Override
	public String toString() {
		return "(Player: " + getName() + ", Class: " + getPlayerClass() + ")";
	}

	public void newDay() {
		currentDay++;
	}

	public int getDay() {
		return currentDay;
	}

	public int getGold() {
		return currentGold;
	}
	
	@Override
	public void setHidden(boolean hidden) {
		super.setHidden(hidden);
		currentClearing.updateImage();
	}
}
