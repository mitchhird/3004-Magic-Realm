package models.BoardModels;

import java.util.ArrayList;
import java.util.Collections;

import models.chitModels.EnvironmentChit.EnvironmentChit;

public class EntityHolder {

	protected ArrayList<EnvironmentChit> lostCity;
	protected ArrayList<EnvironmentChit> lostCastle;
	
	/**
	 * need to do something for the prowling here
	 * as well as ghost
	 * dwellings
	 * natives
	 * treasures
	 * 
	 */
	
	//add treasures later
	public EntityHolder(ArrayList<EnvironmentChit> init, boolean random){
		if (random)
			initRandom(init);
		else
			initSet(init);
		
		
	}
	
	private ArrayList<EnvironmentChit> initRandom(ArrayList<EnvironmentChit> init){
		Collections.shuffle(init);
		return initSet(init);
	}
	
	//takes the first 5 to lostCity next 5 to lostCastle
	private ArrayList<EnvironmentChit> initSet(ArrayList<EnvironmentChit> init){
		for(int i = 0; i < 5; ++i)
			lostCity.add(init.remove(0));
		for(int i = 0; i < 5; ++i)
			lostCastle.add(init.remove(0));
		return init;
	}
	
	// Monster Functions
	private void resetMonsters(){
		
	}
	
	// Getters
	public ArrayList<EnvironmentChit> getLostCity(){
		return lostCity;
	}
	
	public ArrayList<EnvironmentChit> getLostCastle(){
		return lostCastle;
	}
	
}
