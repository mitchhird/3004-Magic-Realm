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
	
	private static final long serialVersionUID = -1231513221625115158L;
	private PlayerBase thePlayer;
	private PlayerBase theDefender;
	private String attack;
	private String defense;
	
	public CombatDataContainer (PlayerBase p, PlayerBase d, Attacks attack, Defences currentDefence) {
		thePlayer = p;
		theDefender = d;
		this.attack = attack.name();
		this.defense = currentDefence.name();
	}

	/*---------------------- Getters And Setters ---------------------------*/
	public PlayerBase getThePlayer() {
		return thePlayer;
	}

	public void setThePlayer(PlayerBase thePlayer) {
		this.thePlayer = thePlayer;
	}

	public Attacks getAttack() {
		return Attacks.valueOf(attack);
	}

	public void setAttack(Attacks attack) {
		this.attack = new String(attack.name());
	}

	public Defences getDefense() {
		return Defences.valueOf(defense);
	}

	public void setDefense(Defences defense) {
		this.defense = new String(defense.name());
	}

	public PlayerBase getTheDefender() {
		return theDefender;
	}

	public void setTheDefender(PlayerBase theDefender) {
		this.theDefender = theDefender;
	}
}
