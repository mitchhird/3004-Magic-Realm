package models.characterModels;

import java.util.ArrayList;

import models.characterModels.playerEnums.CharacterClass;
import models.characterModels.playerEnums.Weights;

public class Dwarf extends PlayerBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3216032802846856372L;

	public Dwarf(String name, ArrayList<Integer> points) {
		super(name, CharacterClass.DWARF, points);
	}
	
	public Dwarf (String name, String ip, ArrayList<Integer> points) {
		super(name, CharacterClass.DWARF, ip,points);
		amountOfExtraSearchesLeft = amountOfExtraSearchs = 1;
	}
	
	@Override
	// Override This Player With Extra Move Amount
	public void startPlayerTurn() {
		super.startPlayerTurn();
		amountOfExtraSearchesLeft = amountOfExtraSearchs;
	}
	
}
