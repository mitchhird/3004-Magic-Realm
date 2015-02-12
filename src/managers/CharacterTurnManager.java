package managers;

import models.characterModels.PlayerBase;

/**
 * Main class that will handle the player's turn when implemented
 * Basically serves as a layer that will determine player action based on the input given
 * @author Mitchell
 */
public class CharacterTurnManager {

	private String commandString;
	private final String commandDelmiter = ",";
	private PlayerBase currentCharacter;
	
	// Base Constructor For The Manager
	public CharacterTurnManager (PlayerBase p, String commandString) {
		currentCharacter = p;
	}
}
