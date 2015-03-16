package models.BoardModels;

import models.characterModels.playerEnums.TileType;

public class Tile {
	
	/*
	 * this is going to have to have something for storing a group of clearings
	 * and a few environment chits
	 * and if its a mountains caves valley or forest
	 */
	
	private Clearing clear1;
	private Clearing clear2;
	private Clearing clear3;
	private Clearing clear4;
	private Clearing clear5;
	private Clearing clear6;
	private TileType type;
	
	public Tile(){
		clear1 = null;
		clear2 = null;
		clear3 = null;
		clear4 = null;
		clear5 = null;
		clear6 = null;
	}
	
	// These can be null if not there
	public Tile(Clearing c1, Clearing c2, Clearing c3, 
			Clearing c4, Clearing c5, Clearing c6, TileType tile){
		addClearing(1, c1);
		addClearing(2, c3);
		addClearing(3, c3);
		addClearing(4, c4);
		addClearing(5, c5);
		addClearing(6, c6);
		type = tile;
	}
	
	public TileType getType(){
		return type;
	}
	
	public void addClearing(int num, Clearing clear){
		switch(num){
		case 1:
			clear1 = clear;
			break;
		case 2:
			clear2 = clear;
			break;
		case 3:
			clear3 = clear;
			break;
		case 4:
			clear4 = clear;
			break;
		case 5:
			clear5 = clear;
			break;
		case 6:
			clear6 = clear;
			break;
		}
	}
	
	public Clearing getClearing(int clear){
		Clearing rClearing = null;
		switch(clear){
		case 1:
			rClearing = clear1;
			break;
		case 2:
			rClearing = clear2;
			break;
		case 3:
			rClearing = clear3;
			break;
		case 4:
			rClearing = clear4;
			break;
		case 5:
			rClearing = clear5;
			break;
		case 6:
			rClearing = clear6;
			break;
		}
		return rClearing;
	}
	
}
