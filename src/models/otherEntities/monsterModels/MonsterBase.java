package models.otherEntities.monsterModels;

import java.awt.Image;

import models.BoardModels.Clearing;
import models.otherEntities.EntityBase;
import models.otherEntities.monsterModels.AlternativeMonsterWeapons.AdditionalAttacks;

public class MonsterBase extends EntityBase{
	
	protected String monsterType;
	protected Image monsterImage;
	
	//combat
	protected boolean extraWeapon;
	protected AdditionalAttacks extraAttack;
	
	public Image getImage(){
		return monsterImage;
	}
	
	public void setHomeClearing(Clearing homeClearing) {
		this.homeClearing = homeClearing;
	}
	public void setCurrentClearing(Clearing currentClearing) {
		this.currentClearing = currentClearing;
	}
}
