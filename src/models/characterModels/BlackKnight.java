package models.characterModels;

import models.characterModels.playerEnums.CharacterClass;
import models.characterModels.playerEnums.Weights;
import models.chitModels.Chit;

public class BlackKnight extends PlayerBase {
	public BlackKnight(Chit[] combat){
		super();
		vulnerability = Weights.MEDIUM;
		setClass(CharacterClass.BLACKNIGHT);
	}
}
