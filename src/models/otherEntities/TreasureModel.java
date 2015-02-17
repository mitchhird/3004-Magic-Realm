package models.otherEntities;

import java.util.ArrayList;

import utils.GameUtils;
import models.characterModels.PlayerBase;

/**
 * Basic Model For The Treasures In The Game
 * Players find treasure by looking in a clearing and then looting it
 * @author Mitchell
 */
public class TreasureModel {

	private int treasureGoldValue;
	private ArrayList<PlayerBase> playersFoundThis;
	
	// Static Array of Values For The Treasure Amounts
	private int[] goldAmounts = {10, 20, 30, 40, 50};
	
	public TreasureModel (boolean greatTreasure) {
		playersFoundThis = new ArrayList<PlayerBase>();
		
		// Determine The Gold Amount, Rando For Now
		int endRange = (greatTreasure) ? goldAmounts.length - 1: 2;
		treasureGoldValue = GameUtils.createRandomInt(0, endRange);
	}
	
	// Adds The Player To The Found Array
	public void playerFound (PlayerBase p) {
		playersFoundThis.add(p);
	}
	
	// Returns True If The Player Has Found This Treasure
	public boolean hasPlayerFound (PlayerBase p) {
		return playersFoundThis.contains(p);
	}

	public int getTreasureGoldValue() {
		return treasureGoldValue;
	}
}
