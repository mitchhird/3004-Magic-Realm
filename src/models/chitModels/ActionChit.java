package models.chitModels;

import models.characterModels.playerEnums.Weights;

public class ActionChit {
	protected int stars;
	protected int speed;
	protected Weights capacity;
	protected boolean fight;
	protected boolean fatigued;
	protected boolean wounded;
	protected int magic;//add this with magic
	
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
	
	private int getMagicVal(){
		return magic;
	}

	public boolean isFatigued() {
		return fatigued;
	}

	public void setFatigued(boolean fatigued) {
		this.fatigued = fatigued;
	}

	public boolean isWounded() {
		return wounded;
	}

	public void setWounded(boolean wounded) {
		this.wounded = wounded;
	}
}
