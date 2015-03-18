package models.BoardModels;

import java.util.ArrayList;
import java.util.Collections;

import models.chitModels.EnvironmentChit.EnvironmentChit;
import models.chitModels.EnvironmentChit.SiteChit;

public class EntityHolder {

	protected ArrayList<EnvironmentChit> lostCity;
	protected ArrayList<EnvironmentChit> lostCastle;
	
	
	protected SiteChit alter;
	protected SiteChit cairns;
	protected SiteChit hoard;
	protected SiteChit lair;
	protected SiteChit pool;
	protected SiteChit shrine;
	protected SiteChit statue;
	protected SiteChit vault;
	
	/**
	 * need to do something for the prowling here
	 * as well as ghost
	 * dwellings
	 * natives
	 * treasures
	 * 
	 */
	
	//add treasures later
	public EntityHolder(){
		lostCity = new ArrayList<EnvironmentChit>();
		lostCastle = new ArrayList<EnvironmentChit>();
	}
	
	public ArrayList<EnvironmentChit> setupChits(boolean random, ArrayList<EnvironmentChit> start){
		if(random)
			Collections.shuffle(start);
		return setupEnvironment(start);
	}
	
	//takes the first 5 to lostCity next 5 to lostCastle
	private ArrayList<EnvironmentChit> setupEnvironment(ArrayList<EnvironmentChit> start){
		for(int i = 0; i < 5; ++i){
			lostCity.add(start.remove(0));
		}
		for(int i = 0; i < 5; ++i){
			lostCastle.add(start.remove(0));
		}
		return start;
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
