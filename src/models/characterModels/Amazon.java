package models.characterModels;

import models.characterModels.playerEnums.CharacterClass;

public class Amazon extends PlayerBase {

	private static final long serialVersionUID = -6169646850928944441L;

	public Amazon(String name){
		super (name, CharacterClass.AMAZON);
	}
	
	public Amazon(String name, String ip) {
		super (name, CharacterClass.AMAZON, ip);
		amountOfExtraMovesLeft = amountOfExtraMoves = 1;
	}
	
	@Override
	// Override This Player With Extra Move Amount
	public void startPlayerTurn() {
		super.startPlayerTurn();
		amountOfExtraMovesLeft = amountOfExtraMoves;
	}
}
