package models.otherEntities;

import java.util.ArrayList;

import models.characterModels.PlayerBase;

/**
 * These are the specific treasures, like the cloak of mist, and magic specticals
 * @author Mitchell
 */
public class SpecificTreasure extends TreasureModel {

	private String treasureName;
	private int hideIncrease;
	private int searchIncrease;
	private static final long serialVersionUID = -8453164004659956006L;

	// Specific Treasure Constructor
	public SpecificTreasure(boolean greatTreasure, String name) {
		super (true);
		treasureName = name;
		hideIncrease = 0;
		searchIncrease = 0;
	}
	
	@Override
	public TreasureModel clone() {
		SpecificTreasure returnVal = new SpecificTreasure(true, treasureName);
		
		returnVal.hideIncrease = hideIncrease;
		returnVal.searchIncrease = searchIncrease;
		returnVal.playersFoundThis = new ArrayList<PlayerBase>();
		returnVal.fameAmount = getFameAmount();
		returnVal.notorietyAmount = getNotorietyAmount();
		returnVal.treasureGoldValue = getTreasureGoldValue();
		
		return returnVal;
	}

	public int getHideIncrease() {
		return hideIncrease;
	}


	public void setHideIncrease(int hideIncrease) {
		this.hideIncrease = hideIncrease;
	}


	public int getSearchIncrease() {
		return searchIncrease;
	}


	public void setSearchIncrease(int searchIncrease) {
		this.searchIncrease = searchIncrease;
	}

	@Override
	public String toString() {
		return treasureName;
	}
}
