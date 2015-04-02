package models.BoardModels;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;

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
	private ArrayList<SoundChit> sounds;
	private String theTileName;
	
	public Tile(String tileName){
		type = TileType.FOREST;
		clearings = new HashSet<Clearing>();
		this.sounds = new ArrayList<SoundChit>();
		theTileName = tileName;
	}
	
	// These can be null if not there
	public Tile(TileType tile, String tileName, Clearing ... clearings){
		type = tile;
		this.clearings = new HashSet<Clearing>();
		this.sounds = new ArrayList<SoundChit>();
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
	
	public void setWarningChit(WarningChit newWarning){
		warning = newWarning;
		setWarningImage(newWarning);
	}
	
	public void setWarningImage(WarningChit chit) {
		for (Clearing c: clearings) {
			c.setWarningChit(chit);
		}
	}
	
	public void addSoundChit(SoundChit newSound){
		sounds.add(newSound);
	}

	public Clearing getHighestClearing() {
		return (Clearing) clearings.toArray()[clearings.size()-1];
	}
}
