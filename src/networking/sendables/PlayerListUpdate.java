package networking.sendables;

import java.io.Serializable;
import java.util.ArrayList;

import models.characterModels.PlayerBase;

/**
 * Update Object Used For Updating Turn-Order Lists
 * @author Mitchell
 */
public class PlayerListUpdate implements Serializable {

	private int playerPriority;
	private PlayerBase thePlayers;
	private static final long serialVersionUID = -6985049408618926269L;
	
	public PlayerListUpdate (PlayerBase p) {
		thePlayers = p;
		playerPriority = p.getPlayerPriority();
	}

	public PlayerBase getThePlayers() {
		return thePlayers;
	}

	public void setThePlayers(PlayerBase p) {
		this.thePlayers = p;
	}
	
	public int getPlayerPriority () {
		return playerPriority;
	}
}
