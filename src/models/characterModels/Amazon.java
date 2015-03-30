package models.characterModels;

import java.util.ArrayList;

import models.characterModels.playerEnums.CharacterClass;

public class Amazon extends PlayerBase {

	private static final long serialVersionUID = -6169646850928944441L;

	public Amazon(String name, ArrayList<Integer> points){
		super (name, CharacterClass.AMAZON,points);
	}
	
	public Amazon(String name, String ip, ArrayList<Integer> points) {
		super (name, CharacterClass.AMAZON, ip,points);
		amountOfExtraMovesLeft = amountOfExtraMoves = 1;
	}
	
	@Override
	// Override This Player With Extra Move Amount
	public void startPlayerTurn() {
		super.startPlayerTurn();
		amountOfExtraMovesLeft = amountOfExtraMoves;
	}
}
