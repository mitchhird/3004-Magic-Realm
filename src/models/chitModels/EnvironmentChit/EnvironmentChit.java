package models.chitModels.EnvironmentChit;

import java.io.Serializable;

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
	private static final long serialVersionUID = -5815201812959893662L;
	
	public EnvironmentChit(int num, String description){
		this.description = description;
		clearingNum = num;
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
}
