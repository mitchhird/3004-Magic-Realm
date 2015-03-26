package models.BoardModels;

import java.awt.Image;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * The Dwelling Objects That A Clearing Can Have On It
 * @author Mitchell
 */
public class Dwelling implements Serializable{

	private String dwellingName;
	private String resourceName;
	private Clearing clearingThisOn;
	private transient Image imageRepresentation;
	private static final long serialVersionUID = 6274437669560190867L;
	
	// Constructor For The Clearing Object
	public Dwelling (String dwellingName, String imageRep, Clearing theClearing) {
		clearingThisOn = theClearing;
		this.resourceName = imageRep;
		this.dwellingName = dwellingName;
		theClearing.addDwellingsOnThis(this);
		
		try {
			imageRepresentation = ImageIO.read(getClass().getResource(resourceName));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public String getDwellingName() {
		return dwellingName;
	}

	@Override
	public String toString() {
		return dwellingName;
	}

	public String getResourceName() {
		return resourceName;
	}
}
