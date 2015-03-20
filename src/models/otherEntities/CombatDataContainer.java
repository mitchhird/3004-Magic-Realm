package models.otherEntities;

import java.io.Serializable;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.Defences;

/**
 * Just A Small Container That Holds Helpful Data
 * @author Mitchell
 */
public class CombatDataContainer implements Serializable {
	
	private PlayerBase thePlayer;
	private PlayerBase theDefender;
	private Attacks attack;
	private Defences defense;
	private static final long serialVersionUID = 7918734058307032424L;
	
	public CombatDataContainer (PlayerBase p, PlayerBase d, Attacks attack, Defences currentDefence) {
		thePlayer = p;
		theDefender = d;
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

	public PlayerBase getTheDefender() {
		return theDefender;
	}

	public void setTheDefender(PlayerBase theDefender) {
		this.theDefender = theDefender;
	}
}
