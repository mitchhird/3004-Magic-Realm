package models.chitModels;

import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.Weights;

public class Chit {

	public Weights getHarmLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getStars() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setStars(int i) {
		// TODO Auto-generated method stub
		
	}

	public Attacks getAttack() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	//need to have a group of these for every tile(might be for only clearnings)
	//these can contain treasure sites/sounds/ warning of monsters that may arrive
	//can also contain runes for learning new spells
	
	//***************
	//required chits for the game (might not be there for classes game!!!!!!!!!!!!!!!!
	//************************
	
	/*
	 * monster warnings(yellow)
	 * -Bones
	 * -Ruins
	 * -Smoke
	 * -Stink
	 * -Dank
	 * 
	 * sounds(red)
	 * -Howl
	 * -Flutter
	 * -Roar
	 * -Patter
	 * -Slither
	 * 
	 * combat
	 * 
	 * site
	 * -Lost City
	 * -Lost Castle
	 * 
	 * monster roll
	 * 
	 * Day(turn)
	 * 
	 * weather
	 * 
	 * visitor(pg 9)
	 * 
	 * natives(pg 9)
	 * 
	 * number
	 * 
	 * weapon
	 * 
	 * armor
	 * -helmets
	 * -breastplates
	 * -Shields
	 * -suits of armor
	 * 
	 * treasure(some treasures CAN be weapons/armor/some horses can be pg 13)
	 * -lots of different treasures will have to look at table
	 *   to see what is relevant
	 * 
	 * ***horses(has a walking and running(*))
	 * 
	 * 
	 */
	
	//all armor/weapon/treasure/horse chits
	//also need an active property
	//this allows for immediately or not (active == true)
	//riding horse = active
}
