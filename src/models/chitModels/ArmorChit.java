package models.chitModels;

import com.sun.org.apache.bcel.internal.generic.DMUL;

import models.characterModels.playerEnums.Weights;

public class ArmorChit {

	private ArmorType armourType;
	private boolean damaged;
	private boolean destoryed;
	private Weights armourWeight;
	
	public ArmorChit (ArmorType aType, Weights aWeight) {
		armourType = aType;
		armourWeight = aWeight;
		damaged = false;
		destoryed = false;
	}

	public void damageArmor () {
		destoryed = (damaged) ? true : destoryed;
		damaged = true;
	}
	
	public void destoryArmor () {
		destoryed = true;
	}
	
	/*---------------- Getters And Setters -------------------*/
	public ArmorType getArmourType() {
		return armourType;
	}

	public void setArmourType(ArmorType armourType) {
		this.armourType = armourType;
	}

	public Weights getArmourWeight() {
		return armourWeight;
	}

	public void setArmourWeight(Weights armourWeight) {
		this.armourWeight = armourWeight;
	}

	public boolean isDamaged() {
		return damaged;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}

	public boolean isDestoryed() {
		return destoryed;
	}

	public void setDestoryed(boolean destoryed) {
		this.destoryed = destoryed;
	}
}
