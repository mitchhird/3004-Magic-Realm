package models.chitModels;

import java.io.Serializable;

import models.characterModels.playerEnums.ArmorType;
import models.characterModels.playerEnums.Weights;

public class ArmorChit implements Serializable {

	private ArmorType armourType;
	private boolean damaged;
	private boolean destoryed;
	private Weights armourWeight;
	private static final long serialVersionUID = -7767434016059709312L;
	
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

	public String getArmorStatus () {
		if (destoryed) {
			return "Destroyed";
		} else if (damaged) {
			return "Damaged";
		}
		
		return "Undamaged";
	}
	
	public void setDestoryed(boolean destoryed) {
		this.destoryed = destoryed;
	}
	
	@Override
	public String toString() {
		return armourType.name();
	}
}
