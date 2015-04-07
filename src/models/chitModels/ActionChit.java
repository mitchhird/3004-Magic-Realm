package models.chitModels;

import models.characterModels.playerEnums.Weights;

public class ActionChit {
	protected int stars;
	protected int speed;
	protected int magic;//add this with magic
	protected Weights capacity;
	protected boolean fight;
	protected boolean fatigued;
	protected boolean wounded;
	protected String displayName;
	
	public ActionChit(String displayName, Weights cap, int speed, int stars, boolean fight){
		capacity = cap;
		this.speed = speed;
		this.stars = stars;
		this.fight = fight;
		this.displayName = displayName;
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

	public boolean isFatigued() {
		return fatigued && !wounded;
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
	
	public String getChitStatus () {
		return (wounded) ? "Wounded" : (fatigued) ? "Fatigued" : "Active";
	}
	
	// Wounds The Chit When Called
	public void woundChit () {
		wounded = fatigued;
		fatigued = true;
	}
	
	// Rests The Chit When Called
	public void restChit () {
		if (wounded) {
			wounded = false;
			fatigued = true;
		} else if (fatigued) {
			fatigued = false;
		}
	}
	
	@Override
	public String toString() {
		return displayName;
	}
}
