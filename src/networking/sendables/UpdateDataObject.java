package networking.sendables;

import java.io.Serializable;
import java.util.ArrayList;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.CharacterClass;

/**
 * Update Object That Will Contain The Player Sending, And The Type Of Update
 * @author Mitchell
 */
public class UpdateDataObject implements Serializable {
	
	private String clearingName;
	private boolean hidden;
	private PlayerBase sentPlayer;
	private MessageType updateType;
	private static final long serialVersionUID = -6607394420041280613L;
	
	public UpdateDataObject (PlayerBase sentPlayer, MessageType updateType) {
		this.sentPlayer = sentPlayer;
		this.updateType = updateType;
		this.hidden = sentPlayer.isHidden();
		this.clearingName = sentPlayer.getCurrentClearing().getClearingName();
	}

	// Varient that doesn't need to initialize player objects
	public UpdateDataObject (String playerName, MessageType updateType, ArrayList<Integer>points) {
		this.sentPlayer = new PlayerBase(playerName, CharacterClass.AMAZON,points);
		this.updateType = updateType;
		this.hidden = sentPlayer.isHidden();
	}
	
	public PlayerBase getSentPlayer() {
		return sentPlayer;
	}

	public void setSentPlayer(PlayerBase sentPlayer) {
		this.sentPlayer = sentPlayer;
	}

	public MessageType getUpdateType() {
		return updateType;
	}

	public void setUpdateType(MessageType updateType) {
		this.updateType = updateType;
	}

	public boolean isHidden() {
		return hidden;
	}

	public String getClearingName() {
		return clearingName;
	}
	
}
