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
import views.CombatView;

/**
 * Revised Combat System To Implement In Into The Game
 */
public class CombatPVPHandler {

	private Attacks currentAttack;
	private PlayerBase currentAttacker;
	private PlayerBase currentDefender;
	private ArrayList<PlayerBase> combattingPlayers;
	
	private Set<Pair<PlayerBase, PlayerBase>> readyPlayers;
	private Set<CombatDataContainer> combatData;
	
	private CombatView parentView;
	private Defences currentDefence; 
	
	// Constructor For The Combat Handler
	public CombatPVPHandler (ArrayList <PlayerBase> combattingPlayers, CombatView parentView) {
		this.combattingPlayers = combattingPlayers;
		currentAttacker = getFirstAttacker();
				
		currentAttack = null;
		combatData = new HashSet<CombatDataContainer> ();
		readyPlayers = new HashSet<>();
		
		this.parentView = parentView;
		//setArmor();
	}

	private void setArmor() {
		String suit = null;
		String breast = null;
		String helmet = null;
		for(int i = 0;i<currentDefender.getArmorChits().size();i++){
			if(currentDefender.getArmorChits().get(i).getArmourType().equals(ArmorType.HELMET)){
				helmet = currentDefender.getArmorChits().get(i).toString();
			}else if(currentDefender.getArmorChits().get(i).getArmourType().equals(ArmorType.BREASTPLATE)){
				breast = currentDefender.getArmorChits().get(i).toString();
			}else if(currentDefender.getArmorChits().get(i).getArmourType().equals(ArmorType.ARMOUR)){
				suit = currentDefender.getArmorChits().get(i).toString();
			}
		}
		parentView.setArmor(suit, breast, helmet);
	}

	// Gets The Next Attacker
	public void setNextAttacker () {
		combatData.add(new CombatDataContainer(currentAttacker, currentAttack, currentDefence));
		readyPlayers.add(new Pair<PlayerBase, PlayerBase>(currentAttacker, currentDefender));
		
		// If All The Players Have Submitted Then Start The Attack
		if (readyPlayers.size() == combattingPlayers.size()) {
			executeAttacks();
		}
		
		int currentPlayerIndex = combattingPlayers.indexOf(currentAttacker);
		currentAttacker = combattingPlayers.get((currentPlayerIndex + 1) % combattingPlayers.size());
	}
	
	// Executes The Combat When Everyone Is Done
	public void executeAttacks () {
		
		parentView.println("");
		parentView.println("Beginning Combat:");
		
		// Execute The Attacks For The Players
		for (Pair<PlayerBase, PlayerBase> p: readyPlayers) {
			PlayerBase attacker = p.getFirst();
			PlayerBase defender = p.getSecond();
			CombatDataContainer attackerData = findContainer(attacker);
			CombatDataContainer defenderData = findContainer(defender);
			
			// Gather The Armor That Might Have Been Hit On The Defender
			ArmorChit armorHit = checkIfArmorProtects(defenderData.getThePlayer(), attackerData.getAttack());
			
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
		}
		
		// Now Purge The List Of Ready Players And Get Ready For The Next Round
		readyPlayers.clear();
	}
	
	// See If Player Dies, Do The According Stuff 
	private boolean checkForPlayerDeath (CombatDataContainer attackingData, PlayerBase defendingPlayer){
		Weights weaponWeight = calculateWeaponHarm (attackingData, defendingPlayer);
		
		// If Harm Is Higher Then Or Equal To Vulernability Then The Player Is Dead
		if (weaponWeight.getWeightValue() >= defendingPlayer.getVulnerability().getWeightValue()) {
			attackingData.getThePlayer().killPlayer(defendingPlayer);
			return true;
		} else {
			return false;
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
		}
	}
	
	// Gathers The First Player For The Combat 
	private PlayerBase getFirstAttacker () {
		PlayerBase returnVal = combattingPlayers.get(0);
		return returnVal;
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
		if (theAttacker.getWeapon().getSharpnessStars() > 0) {
			addStars = theAttacker.getWeapon().getSharpnessStars();

			// If We Hit Armor, Then Sharpness Goes Down One Star
			if (checkIfArmorProtects(defender, attacker.getAttack()) != null) {
				addStars = Math.max(0, theAttacker.getWeapon().getSharpnessStars());
			}
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
	
	// Find The Data Container Assoicated With The Player
	private CombatDataContainer findContainer (PlayerBase p) {
		for (CombatDataContainer c: combatData) {
			if (c.getThePlayer() == p) {
				return c;
			}
		}
		return null;
	}
	
	/*---------------------------- Getters And Setters ---------------------- */
	public void setCurrentAttack (Attacks attack) {
		currentAttack = attack;
	}
	
	public Attacks getCurrentAttack () {
		return currentAttack;
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
		currentDefence = dodge;
	}
	public Defences getCurrentDefence() {
		return currentDefence;
	}
} 
