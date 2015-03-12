package networking.sendables;

import java.io.Serializable;

import models.characterModels.PlayerBase;

/**
 * Update Object That Will Contain The Player Sending, And The Type Of Update
 * @author Mitchell
 */
public class UpdateDataObject implements Serializable {
	private PlayerBase sentPlayer;
	private MessageType updateType;
}
