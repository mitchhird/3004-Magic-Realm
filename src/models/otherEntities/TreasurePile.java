package models.otherEntities;

import java.util.ArrayList;

import models.characterModels.PlayerBase;

/**
 * Treasure Pile That Spawns When A Player Dies
 * 		--- Extension On Treasure Model, So We Don't Have To Change Much Code
 * @author Mitchell
 *
 */
public class TreasurePile extends TreasureModel {

	private String creatorName;
	private ArrayList<TreasureModel> treasureListing;
	
	public TreasurePile (PlayerBase p) { 
		super(false);
		treasureListing = new ArrayList<TreasureModel>();
		treasureListing.addAll(p.getAccquiredTreasures());
	}

	// Treasure Pile For Testing Purposes
	public TreasurePile () {
		super (false);
		treasureListing = new ArrayList<TreasureModel>();
		treasureListing.add(new TreasureModel(true));
		treasureListing.add(new TreasureModel(true));
		treasureListing.add(new TreasureModel(true));
		treasureListing.add(new TreasureModel(true));
	}
	
	public ArrayList<TreasureModel> getTreasureListing() {
		return treasureListing;
	}

	public void setTreasureListing(ArrayList<TreasureModel> treasureListing) {
		this.treasureListing = treasureListing;
	}
	
	public int getTotalGold () {
		int returnVal = 0;
		for (TreasureModel t: treasureListing) {
			returnVal += t.getTreasureGoldValue();
		}
		return returnVal;
	}
	
	public int getTotalFame () {
		int returnVal = 0;
		for (TreasureModel t: treasureListing) {
			returnVal += t.getFameAmount();
		}
		return returnVal;
	}
	
	public int getTotalNot () {
		int returnVal = 0;
		for (TreasureModel t: treasureListing) {
			returnVal += t.getNotorietyAmount();
		}
		return returnVal;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Treasure Pile: (Gold:" + treasureGoldValue + ", Fame: " + fameAmount + ", Notoriety: " + notorietyAmount + ")";
	}
}
