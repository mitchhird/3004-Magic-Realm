package models.characterModels;

import models.characterModels.playerEnums.CharacterClass;
import models.characterModels.playerEnums.Weights;

public class Dwarf extends PlayerBase {
	public Dwarf() {
		super();
		vulnerability = Weights.HEAVY;
		setClass(CharacterClass.DWARF);
	}
}
