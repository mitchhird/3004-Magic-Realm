package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.Weights;
import models.chitModels.ArmorChit;
import models.chitModels.ArmorType;
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
	
	private JFrame parentView; 
	
	// Constructor For The Combat Handler
	public CombatPVPHandler (ArrayList <PlayerBase> combattingPlayers, JFrame parentView) {
		this.combattingPlayers = combattingPlayers;
		currentAttacker = getFirstAttacker();
				
		currentAttack = null;
		combatData = new HashSet<CombatDataContainer> ();
		readyPlayers = new HashSet<>();
		
		this.parentView = parentView;
	}
	
	// Gets The Next Attacker
	public void setNextAttacker () {
		combatData.add(new CombatDataContainer(currentAttacker, currentAttack, null));
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
				boolean defenderDead = checkForPlayerDeath (attacker, defender);
				
				// If The Defender Died Let The Player Now
				if (defenderDead) {
					JOptionPane.showMessageDialog(parentView, "Player " + defender.getName() + " Has Died");
					combattingPlayers.remove(defender);
					
					// If We have Only One Player Left Then Close This
					if (combattingPlayers.size() < 2) {
						parentView.dispose();
						break;
					}
				}
			} else {
				Weights weaponWeight = calculateWeaponHarm(attackerData.getThePlayer(), defender);
				hitPlayersArmor(defender, armorHit, weaponWeight.prev());
			}
			
			System.out.println("Combatting Players");
		}
		
		// Now Purge The List Of Ready Players And Get Ready For The Next Round
		readyPlayers.clear();
	}
	
	// See If Player Dies, Do The According Stuff 
	private boolean checkForPlayerDeath (PlayerBase attackingPlayer, PlayerBase defendingPlayer){
		Weights weaponWeight = calculateWeaponHarm (attackingPlayer, defendingPlayer);
		
		// If Harm Is Higher Then Or Equal To Vulernability Then The Player Is Dead
		if (weaponWeight.getWeightValue() >= defendingPlayer.getVulnerability().getWeightValue()) {
			return true;
		} else {
			return false;
		}
	}
	
	// Hit This Armor So Register The Hit
	private void hitPlayersArmor (PlayerBase p, ArmorChit a, Weights incomingDamage) {
		p.hitArmor(a, incomingDamage);
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
	private Weights calculateWeaponHarm(PlayerBase attacker, PlayerBase defender) {
		int addStars = 0;
		Weights harm = attacker.getWeapon().getWeaponDamage();
		
		// Find The Stars Amount For The Player's Attack
		if (attacker.getWeapon().getSharpnessStars() > 0) {
			addStars = attacker.getWeapon().getSharpnessStars();
		}
		
		// If The Attacker's Strength Is Higher, Increment Harm level
		if (attacker.getStrength() > defender.getStrength()){
			harm = harm.next();
		}
		
		// Next Calculate The Harm Level Based On The Stars
		for(int i =0; i < addStars; ++i){
			harm = harm.next();
		}
		return harm;
	}
	
	// Check To See If The Armor Protects
	private ArmorChit checkIfArmorProtects (PlayerBase p, Attacks incomingAttack) {
		ArrayList<ArmorChit> playerArmor = p.getArmorChits();
		
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

	// TODO: TEMP HOLDER FOR DEFENDER
	public void setDefender (PlayerBase p) {
		currentDefender = p;
		
	}
	
	/*---------------------------- Getters And Setters ---------------------- */
	public void setCurrentAttack (Attacks attack) {
		currentAttack = attack;
	}
} 
