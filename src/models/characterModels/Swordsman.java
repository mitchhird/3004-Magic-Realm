package models.characterModels;

import models.characterModels.playerEnums.CharacterClass;
import models.characterModels.playerEnums.Weights;

public class Swordsman extends PlayerBase {
	public Swordsman(){
		super();
		vulnerability = Weights.LIGHT;
		setClass(CharacterClass.SWORDSMAN);
	}
}
