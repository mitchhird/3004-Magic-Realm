package models.chitModels.EnvironmentChit;

import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import models.BoardModels.Tile;

public class EnvironmentChit implements Serializable {

	/*
	 * have to get either random or not random and then from there
	 * send the list to the entity holder for setup and
	 * after that have to get the remaining and add the lost city and casle
	 * to the back of the list then "random" again
	 * and set the remaining list of site and sound into the mountains and
	 * caves tiles
	 * the warnings need to go to the right tiles and then the dwellings and
	 * ghosts can be added
	 * 5 or 4 if not able to go to the middle
	 */
	protected Tile tilePlacement;
	protected int clearingNum;
	protected String description;
	protected String imageToLoad;
	protected transient Image chitImage;
	private static final long serialVersionUID = -5815201812959893662L;
	
	public EnvironmentChit(int num, String description, String imageToLoad){
		clearingNum = num;
		this.description = description;
		this.imageToLoad = imageToLoad;
		
		// Load In The Image 
		try {
			chitImage = ImageIO.read(getClass().getResource(imageToLoad));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getClearing(){
		return clearingNum;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setTile(Tile nTile){
		tilePlacement = nTile;
	}
	
	public Tile getTile(){
		return tilePlacement;
	}

	public String getImageToLoad() {
		return imageToLoad;
	}

	public void setImageToLoad(String imageToLoad) {
		this.imageToLoad = imageToLoad;
	}

	public Image getChitImage() {
		return chitImage;
	}

	public void setChitImage(Image chitImage) {
		this.chitImage = chitImage;
	}
	
	
}
