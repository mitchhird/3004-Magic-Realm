package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import networking.sendables.MessageType;
import networking.sendables.UpdateDataObject;
import utils.GameUtils;
import utils.Pair;
import views.CombatViews.CombatMonsterView;
import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.Defences;
import models.chitModels.ArmorChit;
import models.otherEntities.CombatDataContainer;
import models.otherEntities.monsterModels.MonsterBase;

public class CombatPvMHandler extends CombatHandler {

	private int attackingMonsterAt;
	private PlayerBase attacker;
	private ArrayList<MonsterBase> monsters;
	private CombatMonsterView parent;
	
	public CombatPvMHandler (CombatMonsterView parent, PlayerBase p, ArrayList<MonsterBase> m) {
		attacker = p;
		monsters = m;
		this.parent = parent;
		
		// Initial Combat Values
		attackingMonsterAt = 0;
		attacker.setCombatData(new CombatDataContainer(p, p, Attacks.SMASH, Defences.DUCK));
	}
	
	// Executes All Of Attacks
	public void executeAttacks () {
		parent.println("");
		parent.println("Beginning Combat:");
		boolean woundChits = false;
		
		// Randomize All Our Monsters Locations
		for (MonsterBase m: monsters) {
			m.setCombatDirection(getRandomAttack());
		}
		
		// Execute The Player Attack
		executePlayerAttackMonster();
		
		// Now For The Monsters To Hit You
		for (MonsterBase m: monsters) {
			
			// Check To See If Hit The Player
			if (playerHitsOpponent(m.getCombatDirection(), attacker.getCombatData().getDefense())) {
				ArmorChit armorHit = null;
				Pair<ArmorChit, Attacks> defenderShield = attacker.getShield();

				// Check To See If We Have A Shield For The Monster To Hit
				if (defenderShield != null && attacker.isShieldReady()) {
					// If We Are Successfully Blocking With Our Shield
					if (defenderShield.getSecond() == m.getCombatDirection()) {
						armorHit = defenderShield.getFirst();
					}
				} else {
					armorHit = checkIfArmorProtects(attacker,m.getCombatDirection());
				}
				
				// Check To See If We Actually Have Valid Armor
				if (armorHit == null) {
					parent.println("   --- Monster Hit Our Fleshy Bits");
					JOptionPane.showMessageDialog(new JTextArea(), "Monster Has Killed You, You Will Spawn At Home Location");
					attacker.moveToHome();
					
					// Move The Player Back Home When They Die
					parent.sendMessage(new UpdateDataObject(attacker, MessageType.MOVE_PLAYER));
				} else {
					// Register The Hit
					hitPlayersArmor(attacker, armorHit, m.getMonsterDamage());
					
					// Display Into the Screen
					parent.println("   --- Hit " + attacker.getName() + "'s " + armorHit.getArmourType());
					parent.println("   --- Armour Status: " + armorHit.getArmorStatus());
					woundChits = true;
				}			
			} else {
				parent.println("   --- Monster Missed You");
			}
		}
		
		// If We Need To Wound Our Chits, The Do So
		if (woundChits) {
			if (attacker.getCurrentMovementChit() != null) {
				attacker.getCurrentMovementChit().woundChit();
				parent.println("   --- Chit Wounded: " + attacker.getCurrentMovementChit().getChitStatus());
			}
			
			if (attacker.getCurrentFightChit() != null) {
				attacker.getCurrentFightChit().woundChit();
				parent.println("   --- Chit Wounded: " + attacker.getCurrentFightChit().getChitStatus());
			}
		}
		
		// Combat Is Done So Set The Player Data Back To Normal
		attacker.setCurrentFightChit(null);
		attacker.setCurrentMovementChit(null);
	}

	// Executes The Player Attack Against The Monster
	private void executePlayerAttackMonster() {
		// Player Attack Monster 
		if (playerHitsOpponent(attacker.getCombatData().getAttack(), monsters.get(attackingMonsterAt).getDefenseDirection())) {
			parent.println ("   --- " + attacker.getName() + " Has Killed  Monster");
			
			// Monster Is Hit, Kill And Remove From List, Closing If We Are Done
			MonsterBase killedMonster = monsters.remove(attackingMonsterAt);
			killedMonster.killMe();
			
			// Send The Message if We Need To
			UpdateDataObject newMessage = new UpdateDataObject(attacker, MessageType.KILL_MONSTER);
			newMessage.setMonsterRemovalIndex(attackingMonsterAt);
			parent.sendMessage(newMessage);
			
			// Then Check To See If Have Any More Monsters To Fight
			if (monsters.size() == 0) {
				JOptionPane.showMessageDialog(parent, "No Monsters Remain, You Win!");
				parent.dispose();
			}
			
		} else {
			parent.println ("   --- " + attacker.getName() + " Missed Monster");
		}
	}
	
	// Gather A Random Attack Direction When Called
	private Attacks getRandomAttack() {
		int randRoll = GameUtils.createRandomInt(1, 3);
		
		if (randRoll >=0 && randRoll <= 1) {
			return Attacks.SWING;
		} else if (randRoll >= 1 && randRoll <= 2) {
			return Attacks.SMASH;
		} else {
			return Attacks.THRUST;
		}
	}
	
	// Sets The Monster Were Attacking
	public void setAttackingMonster (int index) {
		attackingMonsterAt = index;
	}
}
