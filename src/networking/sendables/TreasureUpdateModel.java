package networking.sendables;

import java.io.Serializable;

import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;

/**
 * Object That Is Used Remove Treasures From A Clearing In A Network Envriroment
 * @author Mitchell
 */
public class TreasureUpdateModel implements Serializable {

	private PlayerBase playerToAddTreasureTo;
	private int indexOfTreasureToRemove;
	private static final long serialVersionUID = 1524988547373942556L;
	
		
	public TreasureUpdateModel (PlayerBase p, int treasureIndex) {
		indexOfTreasureToRemove = treasureIndex;
		playerToAddTreasureTo = p;
	}

	public PlayerBase getPlayerToAddTreasureTo() {
		return playerToAddTreasureTo;
	}

	public void setPlayerToAddTreasureTo(PlayerBase playerToAddTreasureTo) {
		this.playerToAddTreasureTo = playerToAddTreasureTo;
	}

	public int getIndexOfTreasureToRemove() {
		return indexOfTreasureToRemove;
	}

	public void setIndexOfTreasureToRemove(int indexOfTreasureToRemove) {
		this.indexOfTreasureToRemove = indexOfTreasureToRemove;
	}
	
	
}
