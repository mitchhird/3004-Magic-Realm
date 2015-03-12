package models.BoardModels;

import java.awt.Image;

import utils.GameUtils;
import views.PlacementView;

/**
 * The Dwelling Objects That A Clearing Can Have On It
 * @author Mitchell
 */
public class Dwelling {
	private Clearing clearingThisOn;
	private Image imageRepresentation;
	
	// Constructor For The Clearing Object
	public Dwelling (Clearing theClearing, Image imageRep, String theName) {
		if(GameUtils.getCheatMode()){
			PlacementView thePlacer = new PlacementView(new String[]{theName});
			thePlacer.setVisible(true);
		}else{
			clearingThisOn = theClearing;
		}
		imageRepresentation = imageRep;
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
	
	
}
