package models.otherEntities;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.Defences;

/**
 * Just A Small Container That Holds Helpful Data
 * @author Mitchell
 */
public class CombatDataContainer {
	private PlayerBase thePlayer;
	private Attacks attack;
	private Defences defense;
	
	public CombatDataContainer (PlayerBase p, Attacks attack, Defences currentDefence) {
		thePlayer = p;
		this.attack = attack;
		this.defense = currentDefence;
	}

	/*---------------------- Getters And Setters ---------------------------*/
	public PlayerBase getThePlayer() {
		return thePlayer;
	}

	public void setThePlayer(PlayerBase thePlayer) {
		this.thePlayer = thePlayer;
	}

	public Attacks getAttack() {
		return attack;
	}

	public void setAttack(Attacks attack) {
		this.attack = attack;
	}

	public Defences getDefense() {
		return defense;
	}

	public void setDefense(Defences defense) {
		this.defense = defense;
	}
}
