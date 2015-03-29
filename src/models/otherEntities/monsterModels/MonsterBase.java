package models.otherEntities.monsterModels;

import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import models.BoardModels.Clearing;
import models.otherEntities.EntityBase;
import models.otherEntities.monsterModels.AlternativeMonsterWeapons.AdditionalAttacks;

public abstract class MonsterBase extends EntityBase implements Serializable {
	
	protected String monsterType;
	protected String monsterImage;
	protected String clearningThisOn;
	
	//combat
	protected boolean extraWeapon;
	protected AdditionalAttacks extraAttack;
	
	private static final long serialVersionUID = -2882968954485623329L;

	public MonsterBase (String name) {
		clearningThisOn = name;
	}
	
	public Image getImage() {
		try {
			return ImageIO.read(getClass().getResource(monsterImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void setHomeClearing(Clearing homeClearing) {
		this.homeClearing = homeClearing;
	}
	public void setCurrentClearing(Clearing currentClearing) {
		this.currentClearing = currentClearing;
	}
	
	public String getClearningThisOn() {
		return clearningThisOn;
	}

	public void setClearningThisOn(String clearningThisOn) {
		this.clearningThisOn = clearningThisOn;
	}

	public abstract MonsterBase clone();
}
