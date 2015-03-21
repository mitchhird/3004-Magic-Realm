package models.otherEntities.monsterModels;

import java.awt.Image;

import models.otherEntities.EntityBase;

public class MonsterBase extends EntityBase{
	
	protected String monsterType;
	protected Image monsterImage;
	
	public Image getImage(){
		return monsterImage;
	}
}
