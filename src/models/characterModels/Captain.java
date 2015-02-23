package models.characterModels;

import models.characterModels.playerEnums.CharacterClass;
import models.characterModels.playerEnums.Weights;

public class Captain extends PlayerBase {
	public Captain() {
		super();
		vulnerability = Weights.MEDIUM;
		setClass(CharacterClass.CAPTAIN);
	}
}
