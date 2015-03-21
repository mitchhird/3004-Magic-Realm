package models.BoardModels;

import java.util.ArrayList;
import java.util.Collections;

import models.chitModels.EnvironmentChit.EnvironmentChit;
import models.chitModels.EnvironmentChit.SiteChit;

public class EntityHolder {

	protected ArrayList<EnvironmentChit> lostCity;//caves
	protected ArrayList<EnvironmentChit> lostCastle;//mountain
	protected int currentProwling;
	
	protected SiteChit alter;
	protected SiteChit cairns;
	protected SiteChit hoard;
	protected SiteChit lair;
	protected SiteChit pool;
	protected SiteChit shrine;
	protected SiteChit statue;
	protected SiteChit vault;
	
	/*
	 * group 1
	 * hoard 5 large 4 small T flying dragon
	 * lair 3 large 4 small T dragon
	 * 
	 * castle
	 * smoke M/flutter Heavy flying dragons 2
	 * 
	 * city
	 * 
	 * 
	 * natives 2 small 1 helm 1 b 1 s company
	 * 
	 * groupp 2
	 * alter 4 large 0 small demon
	 * shrine 2 large 2 small flying demon
	 * 
	 * castle
	 * dank w medium vipers
	 * 
	 * city
	 * 
	 * 
	 * natives 2 small 2 L bow 1 M bow woodfolk
	 * 
	 * group 3
	 * pool 3 large 6 small T octopus
	 * 
	 * castle
	 * ruins W 6 wolves
	 * bones W  2 medium ogres
	 * 
	 * city
	 * 
	 * 
	 * natives 2 small 1 h 1 b 1 s patrol
	 * 
	 * roup4
	 * vault 5 large 0 small T troll
	 * 
	 * castle
	 * 
	 * city
	 * 
	 * 
	 * natives 2 small 4 spears lancers
	 * 
	 * group 5
	 * cairns 1 large 6 small T spider
	 * statue 1 large 2 small imp
	 * 
	 * castle
	 * city
	 * 
	 * natives 2 small 6 ponies bashkar
	 * 
	 * group 6
	 * 
	 * visitor
	 * scholar 1 small
	 * 
	 * garison add later
	 * chapel 2 small 3 warhorse 2 suites 5 H weapons order
	 * inn 2 small 6 horses soliders
	 * house 2 small 3 h 2 s 7 light weapons rouges
	 * guard 2 small 1 h 1 b 5 M weapons guard
	 * 
	 * 
	 */
	
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
		//creating monsters
		/*
		 * Tremendous
		 * demon
		 * giant*2 + club
		 * octopus
		 * T dragon*2 + head
		 * T flying dragon + head
		 * T Serpent
		 * T spider
		 * T troll * 2
		 * winged demon
		 * 
		 * heavy
		 * Giant Bats * 6
		 * H Dragon
		 * H dragon + head * 2
		 * H Serpents * 2
		 * H Spider * 3
		 * H Troll * 2
		 * 
		 * Medium
		 * Ghosts * 2
		 * Goblins with Axes * 6
		 * Goblins with Great Swords * 6
		 * Goblins with Spears * 6
		 * Imp
		 * Ogres
		 * Vipers * 2
		 * Wolves L4,3/M4,4 * 3
		 * Wolves M5,3/L3,4 * 3
		 */
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
	
	public void setProwling(int roll){
		currentProwling = roll;
	}
	
	public int getProwling(){
		return currentProwling;
	}
	
}
