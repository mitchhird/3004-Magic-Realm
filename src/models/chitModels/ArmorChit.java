package models.chitModels;

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
	
	
}
