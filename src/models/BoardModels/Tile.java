package models.BoardModels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import models.characterModels.playerEnums.TileType;
import models.chitModels.EnvironmentChit.SoundChit;
import models.chitModels.EnvironmentChit.WarningChit;

public class Tile {
	
	/*
	 * this is going to have to have something for storing a group of clearings
	 * and a few environment chits
	 * and if its a mountains caves valley or forest
	 */
	
	private TileType type;
	private WarningChit warning;
	private Set <Clearing> clearings;
	private ArrayList<WarningChit> sounds;
	private String theTileName;
	
	public Tile(String tileName){
		type = TileType.FOREST;
		clearings = new HashSet<Clearing>();
		this.sounds = new ArrayList<WarningChit>();
		theTileName = tileName;
	}
	
	// These can be null if not there
	public Tile(TileType tile, String tileName, Clearing ... clearings){
		type = tile;
		this.clearings = new HashSet<Clearing>();
		this.sounds = new ArrayList<WarningChit>();
		theTileName = tileName;
		// Add everything In
		for (Clearing c: clearings) {
			this.clearings.add(c);
		}
	}
	
	public TileType getType(){
		return type;
	}

	public void add(Clearing c) {
		this.clearings.add(c);
	}
	
	public String toString(){
		return theTileName;
	}
	
	
}
