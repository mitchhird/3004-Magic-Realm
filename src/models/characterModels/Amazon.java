package models.characterModels;

import models.characterModels.playerEnums.CharacterClass;
import models.characterModels.playerEnums.Weights;

public class Amazon extends PlayerBase {

	public Amazon(){
		vulnerability = Weights.MEDIUM;
		setClass(CharacterClass.AMAZON);
	}
}
