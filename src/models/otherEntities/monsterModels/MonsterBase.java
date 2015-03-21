package models.otherEntities.monsterModels;

import java.awt.Image;

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
}
