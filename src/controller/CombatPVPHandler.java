package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.ArmorType;
import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.Defences;
import models.characterModels.playerEnums.Weights;
import models.chitModels.ArmorChit;
import models.otherEntities.CombatDataContainer;
import utils.Pair;
import views.CombatViews.CombatView;

/**
 * Revised Combat System To Implement In Into The Game
 * 
 * Networking Notes:
 * 		--- In order to network this I need a couple of things, and they will be here
 * 		--- Whenever a change is made the view needs to be updated across the board
 * 		--- CombatDataContainer needs to be migrated to the actual player for ease of access
 * 		--- Push combatDataContainers across? Can set the player data out of it
 */
public class CombatPVPHandler {

	private CombatView parentView;
	private PlayerBase currentAttacker;
	private PlayerBase currentDefender;
	private ArrayList<PlayerBase> combattingPlayers;
	private Set<Pair<PlayerBase, PlayerBase>> readyPlayers;
	
	private int roundsGoneByWithoutHit;
	private boolean hitSomeoneThisRound;
	
	// Constructor For The Combat Handler
	public CombatPVPHandler (ArrayList <PlayerBase> combattingPlayers, CombatView parentView) {
		this.parentView = parentView;
		readyPlayers = new HashSet<>();
		this.combattingPlayers = combattingPlayers;

		resetNothingCheck();
		
		// First Attacker That Is Available
		currentAttacker = combattingPlayers.get(0);
		moveToNextAvailable();
		
		// Fully Set All Of The Containers Up For Combat
		initPlayerContainers();
	}

	// Initialize All Containers With Dummy Values 
	private void initPlayerContainers() {
		for (PlayerBase p: this.combattingPlayers) {
			p.setCombatData(new CombatDataContainer(p, p, Attacks.SMASH, Defences.CHARGE));
		}
	}

	// Gets The Next Attacker And Creates A New Combat Container For The Player
	// Network: Container Can Be Deposited Into The Player, That Way It Can Manipulated By The Client
	public void setNextAttacker () {
		currentAttacker.getCombatData().setThePlayer(currentAttacker);
		currentAttacker.getCombatData().setTheDefender(currentDefender);
		readyPlayers.add(new Pair<PlayerBase, PlayerBase>(currentAttacker, currentDefender));
		moveToNextAvailable();
	}
	
	public void addReadyPlayerSet (PlayerBase attacker, PlayerBase defender) {
		readyPlayers.add(new Pair<PlayerBase, PlayerBase>(attacker, defender));
		moveToNextAvailable();
	}
	
	// Executes The Combat When Everyone Is Done
	public void executeAttacks () {
		
		parentView.println("");
		parentView.println("Beginning Combat:");
		
		hitSomeoneThisRound = false;
		
		// Execute The Attacks For The Players
		for (Pair<PlayerBase, PlayerBase> p: readyPlayers) {
			PlayerBase attacker = p.getFirst();
			PlayerBase defender = p.getSecond();
			
			// TODO: Move Container Into The Players, Easy To Pull Out Then
			CombatDataContainer attackerData = attacker.getCombatData();
			CombatDataContainer defenderData = defender.getCombatData();
			
			// See If We Hit Our Opponent Or Not, If We Did Run Through The Calculations
			if (playerHitsOpponent(attackerData.getAttack(), defenderData.getDefense())) {
				hitSomeoneThisRound = true;
				
				ArmorChit armorHit = null;
				Pair<ArmorChit, Attacks> defenderShield = defenderData.getThePlayer().getShield();
				
				// Check To See If We Have A Shield
				if (defenderShield != null && defender.isShieldReady()) {
					// If We Are Successfully Blocking With Our Shield
					if (defenderShield.getSecond() == attackerData.getAttack()) {
						armorHit = defenderShield.getFirst();
					}
				} else {
					armorHit = checkIfArmorProtects(defenderData.getThePlayer(), attackerData.getAttack());
				}
			
				// If The Player's Armor Doesn't Prevent Damage Then They Get Hit
				if (armorHit == null){
					boolean defenderDead = checkForPlayerDeath (attackerData, defender);
				
					// If The Defender Died Let The Player Now
					if (defenderDead) {
						parentView.println("   --- Player " + defender.getName() + " Has Died");
						JOptionPane.showMessageDialog(parentView, "Player " + defender.getName() + " Has Died");
						combattingPlayers.remove(defender);
					
						// If We have Only One Player Left Then Close This
						if (combattingPlayers.size() < 2) {
							parentView.dispose();
							break;
						}
					}
				} else {
					Weights weaponWeight = calculateWeaponHarm(attackerData, defender);
					hitPlayersArmor(defender, armorHit, weaponWeight.prev());
				
					parentView.println("   --- Hit " + defender.getName() + "'s " + armorHit.getArmourType());
					parentView.println("   --- Armour Status: " + armorHit.getArmorStatus());
				}
			} else {
				parentView.println("   --- " + attacker.getName() + " Missed");
			}
		}
		
		// Set Everyone's Shield Back To Not Blocking
		for (PlayerBase p: combattingPlayers) {
			p.setShieldReady(false);
		}
		
		// Now Purge The List Of Ready Players And Get Ready For The Next Round
		readyPlayers.clear();
		
		if (!hitSomeoneThisRound) {
			roundsGoneByWithoutHit++;
			checkIfCombatShouldEnd();
		}
	}
	
	// See If Player Dies, Do The According Stuff 
	private boolean checkForPlayerDeath (CombatDataContainer attackingData, PlayerBase defendingPlayer){
		Weights weaponWeight = calculateWeaponHarm (attackingData, defendingPlayer);
		
		attackingData.getThePlayer().killPlayer(defendingPlayer);
		
		// If Harm Is Higher Then Or Equal To Vulernability Then The Player Is Dead
		// TODO: Get This Working Properly
		if (weaponWeight.getWeightValue() >= defendingPlayer.getVulnerability().getWeightValue()) {
			return true;
		} else {
			return true;
		}
		
	}
	
	// Hit This Armor So Register The Hit
	private void hitPlayersArmor (PlayerBase p, ArmorChit a, Weights incomingDamage) {
		// Register The Damage In The Correct Locations
		if (incomingDamage.getWeightValue() > a.getArmourWeight().getWeightValue()) {
			a.destoryArmor();
		}
		else if (incomingDamage.getWeightValue() == a.getArmourWeight().getWeightValue()) {
			a.damageArmor();
		}
		
		// If The Armor Is Destoryed Then Remove It
		if (a.isDestoryed()) {
			p.getArmorChits().remove(a);
			
			// If It Was A Shield Then Remove The Shield
			if (a.getArmourType() == ArmorType.SHIELD) {
			   p.setShield(null);
			}
		}
	}

	// Alerts The Current Player Weapon
	public void alertPlayerWeapon () {
		currentAttacker.getWeapon().setAlerted(true);
	}
	
	// Calculates The Weapon's Harm Value
	private Weights calculateWeaponHarm(CombatDataContainer attacker, PlayerBase defender) {
		int addStars = 0;
		PlayerBase theAttacker = attacker.getThePlayer();
		Weights harm = theAttacker.getWeapon().getWeaponDamage();
		
		// Find The Stars Amount For The Player's Attack
		if (theAttacker.getWeapon().getSharpnessStars() > 0 && theAttacker.getWeapon().isAlerted()) {
			addStars = theAttacker.getWeapon().getSharpnessStars();

		}
			
		// If We Hit Armor, Then Sharpness Goes Down One Star
		if (checkIfArmorProtects(defender, attacker.getAttack()) != null) {
			addStars = Math.max(0, theAttacker.getWeapon().getSharpnessStars());
		}
		
		
		// If The Attacker's Strength Is Higher, Increment Harm level
		if (theAttacker.getStrength() > defender.getStrength()){
			harm = harm.next();
		}
		
		// Next Calculate The Harm Level Based On The Stars
		for(int i =0; i < addStars; ++i){
			harm = harm.next();
		}
		return harm;
	}
	
	// Check To See If The Armor Protects
	private ArmorChit checkIfArmorProtects (PlayerBase defendingPlayer, Attacks incomingAttack) {
		ArrayList<ArmorChit> playerArmor = defendingPlayer.getArmorChits();
		
		// Iterate Over The Player's Armor And See If Blocks
		for (ArmorChit a: playerArmor) {
			if (a.getArmourType() == ArmorType.BREASTPLATE && (incomingAttack == Attacks.THRUST || incomingAttack == Attacks.SWING)) {
				return a;
			}
			else if (a.getArmourType() == ArmorType.HELMET && incomingAttack == Attacks.SMASH) {
				return a;
			} else if (a.getArmourType() == ArmorType.ARMOUR) {
				return a;
			}
		}
		
		return null;
	}
	
	private void resetNothingCheck () {
		roundsGoneByWithoutHit = 0;
		hitSomeoneThisRound = false;
	}
	
	private void checkIfCombatShouldEnd () {
		if (roundsGoneByWithoutHit >= 2) {
			JOptionPane.showMessageDialog(parentView, "No Progress Has Been Made For 2 Rounds. Combat Will Now End");
			parentView.dispose();
		}
	}
	
	/************************************ Networking Methods ******************************************/
	// Sets The Next Available Player That We Are Going To Be Using
	private void moveToNextAvailable() {
		
		//setArmor();
		
		// Initial Cycle
		int currentPlayerIndex = combattingPlayers.indexOf(currentAttacker);
		currentAttacker = combattingPlayers.get((currentPlayerIndex + 1) % combattingPlayers.size());
		
		// Loop until there is a player that we can manipulate
		while (currentAttacker.isNetworkedPlayer()) {
			currentPlayerIndex = combattingPlayers.indexOf(currentAttacker);
			currentAttacker = combattingPlayers.get((currentPlayerIndex + 1) % combattingPlayers.size());
		}
	}
	
	/*---------------------------- Getters And Setters ---------------------- */
	public void setCurrentAttack (Attacks attack) {
		currentAttacker.getCombatData().setAttack(attack);
	}
	
	public Attacks getCurrentAttack () {
		return currentAttacker.getCombatData().getAttack();
	}

	public PlayerBase getCurrentAttacker() {
		return currentAttacker;
	}
	
	public int getReadyPlayerNum () {
		return readyPlayers.size();
	}

	public void setCurrentAttacker(PlayerBase currentAttacker) {
		this.currentAttacker = currentAttacker;
	}

	public PlayerBase getCurrentDefender() {
		return currentDefender;
	}

	public void setCurrentDefender(PlayerBase currentDefender) {
		this.currentDefender = currentDefender;
	}

	public void setCurrentDefence(Defences dodge) {
		currentAttacker.getCombatData().setDefense(dodge);
	}
	public Defences getCurrentDefence() {
		return currentAttacker.getCombatData().getDefense();
	}
	
	// Called To See If Hit Our Opponent In The First Place
	public boolean playerHitsOpponent (Attacks incoming, Defences defense) {
		switch (incoming) {
		case SMASH:
			return defense == Defences.DUCK;
		case SWING:
			return defense == Defences.DODGE;
		case THRUST:
			return defense == Defences.CHARGE;
		default:
			return false;
		}
	}
} 
