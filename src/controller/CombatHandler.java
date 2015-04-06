package controller;

import java.util.ArrayList;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.ArmorType;
import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.Defences;
import models.characterModels.playerEnums.Weights;
import models.chitModels.ArmorChit;

public class CombatHandler {

	// Called To See If Hit Our Opponent In The First Place
	public boolean playerHitsOpponent(Attacks incoming, Defences defense) {
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
	
	// Check To See If The Armor Protects
	protected ArmorChit checkIfArmorProtects (PlayerBase defendingPlayer, Attacks incomingAttack) {
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
	
	// Hit This Armor So Register The Hit
	protected void hitPlayersArmor (PlayerBase p, ArmorChit a, Weights incomingDamage) {
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
}
