package models.characterModels;

import java.util.ArrayList;

import models.characterModels.playerEnums.CharacterClass;

public class Elf extends PlayerBase {
	
	private static final long serialVersionUID = -8064874737098635104L;

	public Elf(String name, ArrayList<Integer> points){
		super(name, CharacterClass.ELF,points);
	}
	
	public Elf (String name, String ip, ArrayList<Integer> points) {
		super(name, CharacterClass.ELF, ip,points);
		amountOfExtraHidesLeft = amountOfExtraHides = 1;
	}
	
	@Override
	// Override This Player With Extra Move Amount
	public void startPlayerTurn() {
		super.startPlayerTurn();
		amountOfExtraHidesLeft = amountOfExtraHides;
	}
}
