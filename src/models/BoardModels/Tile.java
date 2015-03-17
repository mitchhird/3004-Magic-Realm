package models.BoardModels;

import java.util.HashSet;
import java.util.Set;

import models.characterModels.playerEnums.TileType;

public class Tile {
	
	/*
	 * this is going to have to have something for storing a group of clearings
	 * and a few environment chits
	 * and if its a mountains caves valley or forest
	 */
	
	private Set <Clearing> clearings;
	private TileType type;
	
	public Tile(){
		type = null;
		clearings = new HashSet<Clearing>();
	}
	
	// These can be null if not there
	public Tile(TileType tile, Clearing ... clearings){
		type = tile;
		this.clearings = new HashSet<Clearing>();
		
		// Add everything In
		for (Clearing c: clearings) {
			this.clearings.add(c);
		}
	}
	
	public TileType getType(){
		return type;
	}
	
	
}
