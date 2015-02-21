package models.otherEntities;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Attacks;

/**
 * Just A Small Container That Holds Helpful Data
 * @author Mitchell
 */
public class CombatDataContainer {
	private PlayerBase thePlayer;
	private Attacks attack;
	private Attacks defense;
	
	public CombatDataContainer (PlayerBase p, Attacks attack, Attacks defense) {
		thePlayer = p;
		this.attack = attack;
		this.defense = defense;
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

	public Attacks getDefense() {
		return defense;
	}

	public void setDefense(Attacks defense) {
		this.defense = defense;
	}
}
