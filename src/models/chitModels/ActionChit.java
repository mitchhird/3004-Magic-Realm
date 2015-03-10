package models.chitModels;

import models.characterModels.playerEnums.Weights;

public class ActionChit {
	protected int stars;
	protected int speed;
	protected Weights capacity;
	private boolean fight;
	
	public ActionChit(Weights cap, int speed, int stars, boolean fight){
		capacity = cap;
		this.speed = speed;
		this.stars = stars;
		this.fight = fight;
	}
	
	public boolean isFight(){
		return fight;
	}
	
	public Weights getCapacity(){
		return capacity;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public int getStars(){
		return stars;
	}
}
