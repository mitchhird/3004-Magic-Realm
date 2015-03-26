package models.chitModels;

import models.characterModels.playerEnums.Weights;

/**
 * Seperate Movement Chit Derived Class So We Can Override The ToString()
 * @author Mitchell
 *
 */
public class MovementChit extends ActionChit {

	public MovementChit(Weights cap, int speed, int stars, boolean fight) {
		super(cap, speed, stars, fight);
	}
	
	@Override
	public String toString() {
		String statusString = (wounded) ? "Wounded" : ((fatigued) ? "Fatigued" : "No Damage");
		return "Movement" + getSpeed() + getStars() + ", Status :" + statusString;
	}

}
