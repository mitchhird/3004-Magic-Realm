package models.BoardModels;

import java.awt.Image;
import java.util.ArrayList;

import utils.GameUtils;
import views.PopupViews.PlacementView;

/**
 * The Dwelling Objects That A Clearing Can Have On It
 * @author Mitchell
 */
public class Dwelling {
	private String dwellingName;
	private Clearing clearingThisOn;
	private Image imageRepresentation;
	
	// Constructor For The Clearing Object
	public Dwelling (String dwellingName, Clearing theClearing, Image imageRep) {
		clearingThisOn = theClearing;
		imageRepresentation = imageRep;
		this.dwellingName = dwellingName;
	}

	/*------------------ Getters And Setters ----------------*/
	public Clearing getClearingThisOn() {
		return clearingThisOn;
	}

	public void setClearingThisOn(Clearing clearingThisOn) {
		this.clearingThisOn = clearingThisOn;
	}

	public Image getImageRepresentation() {
		return imageRepresentation;
	}

	public void setImageRepresentation(Image imageRepresentation) {
		this.imageRepresentation = imageRepresentation;
	}
	
	public void setClearing(Clearing newClearing){
		this.clearingThisOn = newClearing;
	}
	
	@Override
	public String toString() {
		return dwellingName;
	}
	
}
