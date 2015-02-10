package models.characterModels;

import models.Weights;

/*
 * info
 */

public class BaseChar {
	
	private Weights weight;
	private Weights vulnerability;
	private Chit[] weapon;
	private Chit[] armor;
	//private chit[] spells;
	
	private boolean hidden;
	private boolean attention;
	private Chit[] combat;
	
	public BaseChar(Weights vuln) {
		setVulnerability(vuln);
		setWeight(vuln);
		setHidden(false);
		setAttention(false);
	}

	public Chit[] getWeapon() {
		return weapon;
	}

	public void setWeapon(Chit[] weapon) {
		this.weapon = weapon;
	}

	public Chit[] getArmor() {
		return armor;
	}

	public void setArmor(Chit[] armor) {
		this.armor = armor;
	}

	public Chit[] getCombat() {
		return combat;
	}

	public void setCombat(Chit[] combat) {
		this.combat = combat;
	}

	public boolean isAttention() {
		return attention;
	}

	public void setAttention(boolean attention) {
		this.attention = attention;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public Weights getVulnerability() {
		return vulnerability;
	}

	public void setVulnerability(Weights vulnerability) {
		this.vulnerability = vulnerability;
	}

	public Weights getWeight() {
		return weight;
	}

	public void setWeight(Weights weight) {
		this.weight = weight;
	}
}
