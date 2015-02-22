package models.chitModels;

import models.characterModels.playerEnums.Weights;

/**
 * Base Weapon Chit
 * @author Mitchell
 */
public class WeaponChit extends Chit{
	
	private int weaponLength;
	private int sharpnessStars;
	private int weaponSpeed;
	private String weaponName;
	private Weights weaponHarm;
	
	private boolean alerted;
	private boolean missleBased;

	// Constructor For The Weapon Chit
	public WeaponChit (String weaponName, int length, int sharpnessLevel, Weights aWeapDmg) {
		weaponLength = length;
		sharpnessStars = sharpnessLevel;
		weaponHarm = aWeapDmg;
		this.weaponName = weaponName;
		
		alerted = false;
		missleBased = false;
	}

	/*-------------------------- Getters And Setters ------------------------------*/
	public int getWeaponLength() {
		return weaponLength;
	}

	public void setWeaponLength(int weaponLength) {
		this.weaponLength = weaponLength;
	}
	
	public boolean hasMissles() {
		return missleBased;
	}

	public int getSharpnessStars() {
		return sharpnessStars;
	}

	public void setSharpnessStars(int sharpnessStars) {
		this.sharpnessStars = sharpnessStars;
	}

	public boolean isAlerted() {
		return alerted;
	}

	public void setAlerted(boolean alerted) {
		this.alerted = alerted;
	}
	
	public Weights getWeaponDamage () {
		return weaponHarm;
	}

	public int getWeaponSpeed() {
		return weaponSpeed;
	}

	public void setWeaponSpeed(int weaponSpeed) {
		this.weaponSpeed = weaponSpeed;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
}
