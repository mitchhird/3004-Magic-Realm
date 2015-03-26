package models.characterModels;

import models.characterModels.playerEnums.CharacterClass;

public class Elf extends PlayerBase {
	
	private static final long serialVersionUID = -8064874737098635104L;

	public Elf(String name){
		super(name, CharacterClass.ELF);
	}
	
	public Elf (String name, String ip) {
		super(name, CharacterClass.ELF, ip);
		amountOfExtraHidesLeft = amountOfExtraHides = 1;
	}
	
	@Override
	// Override This Player With Extra Move Amount
	public void startPlayerTurn() {
		super.startPlayerTurn();
		amountOfExtraHidesLeft = amountOfExtraHides;
	}
}
