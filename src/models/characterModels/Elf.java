package models.characterModels;

import models.characterModels.playerEnums.CharacterClass;
import models.characterModels.playerEnums.Weights;

public class Elf extends PlayerBase {
	public Elf(){
		super();
		vulnerability = Weights.LIGHT;
		setClass(CharacterClass.ELF);
	}
}
