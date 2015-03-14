package models.otherEntities;

import models.BoardModels.Clearing;
import models.characterModels.playerEnums.Weights;
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
	protected Weights vulnerability;
	
	// Compound Data Types For The Object
	protected Chit horse;
	
	// Boolean Flag
	protected Boolean armored;
	protected boolean hidden;
	
	//will have to have the ability to have all entities move to any clearing
	
	
	/*------------Getter and Setters------------*/
	
	public boolean isHidden() {
		return hidden;
	}
	
	public void unHide(){
		hidden = false;
	}//look into getting rid of this

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	public Weights getVulnerability(){
		return vulnerability;
	}
	
	public void setVulnerability(Weights vul){
		this.vulnerability = vul;
	}
}
