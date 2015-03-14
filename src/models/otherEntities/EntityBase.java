package models.otherEntities;

import models.BoardModels.Clearing;
import models.chitModels.Chit;
import models.chitModels.WeaponChit;


/*
 * super class for all other entities that exist in the world
 * could be natives, monsters, etc.
 */
public class EntityBase {
	// Clearing Stuff
	protected Clearing homeClearing;
	protected Clearing currentClearing;
	
	// Compound Data Types For The Object
	protected Chit horse;
	protected WeaponChit activeWeapon;
	
	// Boolean Flag
	protected Boolean armored;
	
	//will have to have the ability to have all entities move to any clearing
	
	protected boolean hidden;
	
	public WeaponChit getWeapon() {
		return activeWeapon;
	}
	
	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
}
