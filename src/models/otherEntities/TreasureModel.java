package models.otherEntities;

import java.io.Serializable;
import java.util.ArrayList;

import utils.GameUtils;
import models.characterModels.PlayerBase;

/**
 * Basic Model For The Treasures In The Game
 * Players find treasure by looking in a clearing and then looting it
 * @author Mitchell
 */
public class TreasureModel implements Serializable {

	protected int treasureGoldValue;
	protected boolean greatTreasure;
	protected ArrayList<PlayerBase> playersFoundThis;
	
	// Static Array of Values For The Treasure Amounts
	protected int fameAmount;
	protected int notorietyAmount;
	protected int[] goldAmounts = {10, 20, 30, 40, 50};
	
	protected static final long serialVersionUID = 4563361734587526172L;

	public TreasureModel (boolean greatTreasure) {
		playersFoundThis = new ArrayList<PlayerBase>();
		
		// Determine The Gold Amount, Rando For Now
		int startRange = (greatTreasure) ? 3 : 0;
		int endRange = (greatTreasure) ? goldAmounts.length - 1: 2;
		
		fameAmount = GameUtils.createRandomInt(1, 20);
		notorietyAmount = GameUtils.createRandomInt(-5, 30);
		treasureGoldValue = goldAmounts[GameUtils.createRandomInt(startRange, endRange)];
	}
	
	// Copy Constructor For Treasures
	public TreasureModel clone () {
		TreasureModel returnVal = new TreasureModel (greatTreasure);
		returnVal.playersFoundThis = new ArrayList<PlayerBase>();
		returnVal.fameAmount = getFameAmount();
		returnVal.notorietyAmount = getNotorietyAmount();
		returnVal.treasureGoldValue = getTreasureGoldValue();
		return returnVal;
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
	
	public int getFameAmount() {
		return fameAmount;
	}

	public int getNotorietyAmount() {
		return notorietyAmount;
	}
	
	public boolean isGreat(){
		return greatTreasure;
	}

	@Override
	public String toString() {
		String displayString = (greatTreasure) ? "Great Treasure - Value: " : "Normal Treasure - Value: ";
		return displayString + treasureGoldValue + ", Fame: " + fameAmount + ", Notoriety: " + notorietyAmount;
	}
}
