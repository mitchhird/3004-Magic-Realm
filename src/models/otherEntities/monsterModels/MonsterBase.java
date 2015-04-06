package models.otherEntities.monsterModels;

import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import models.BoardModels.Clearing;
import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.Defences;
import models.characterModels.playerEnums.Weights;
import models.otherEntities.CombatDataContainer;
import models.otherEntities.EntityBase;
import models.otherEntities.monsterModels.AlternativeMonsterWeapons.AdditionalAttacks;

public abstract class MonsterBase extends EntityBase implements Serializable {
	
	protected String monsterType;
	protected String monsterImage;
	protected String clearningThisOn;
	
	//combat
	protected boolean extraWeapon;
	protected boolean readyForCombat;
	protected Attacks combatDirection;
	protected Defences defenseDirection;
	protected Weights monsterDamage;
	protected AdditionalAttacks extraAttack;
	protected Clearing actualClearingThisOn;
	
	protected transient Image imageRep;
	
	private static final long serialVersionUID = -2882968954485623329L;

	public MonsterBase (String name, String monsterImage) {
		clearningThisOn = name;
		
		// Initialize Combat Varaibles
		readyForCombat = false;
		combatDirection = Attacks.SMASH;
		monsterDamage = Weights.MEDIUM;
		
		// Initialize The Image
		this.monsterImage = monsterImage;
		try {
			imageRep = ImageIO.read(getClass().getResource(monsterImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Kills The Monster When Called
	public void killMe() {
		if (actualClearingThisOn != null) {
			actualClearingThisOn.removeMonsterFromlist(this);
		}
	}
	
	/****************************** Getters And Setters ****************************/
	public Image getImage() {
		return imageRep;
	}
	
	public void setHomeClearing(Clearing homeClearing) {
		this.homeClearing = homeClearing;
	}
	public void setCurrentClearing(Clearing currentClearing) {
		this.currentClearing = currentClearing;
	}
	
	public String getClearningThisOn() {
		return clearningThisOn;
	}

	public void setClearningThisOn(String clearningThisOn) {
		this.clearningThisOn = clearningThisOn;
	}
	
	public boolean isReadyForCombat() {
		return readyForCombat;
	}

	public void setReadyForCombat(boolean readyForCombat) {
		this.readyForCombat = readyForCombat;
	}

	public Attacks getCombatDirection() {
		return combatDirection;
	}

	public void setCombatDirection(Attacks combatDirection) {
		this.combatDirection = combatDirection;
		
		// Switch Statement To Set Defense Based On Attack
		switch (combatDirection) {
		case SMASH:
			defenseDirection = Defences.DODGE;
		case SWING:
			defenseDirection = Defences.DUCK;
			break;
		case THRUST:
			defenseDirection = Defences.CHARGE;
			break;
		default:
			defenseDirection = Defences.DODGE;
			break;
		}
		
		setReadyForCombat(true);
	}
	
	public Defences getDefenseDirection() {
		return defenseDirection;
	}

	public Weights getMonsterDamage() {
		return monsterDamage;
	}

	public void setMonsterDamage(Weights monsterDamage) {
		this.monsterDamage = monsterDamage;
	}

	public Clearing getActualClearingThisOn() {
		return actualClearingThisOn;
	}

	public void setActualClearingThisOn(Clearing actualClearingThisOn) {
		this.actualClearingThisOn = actualClearingThisOn;
	}

	public abstract MonsterBase clone();
}
