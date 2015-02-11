package models.otherEntities;

import models.characterModels.PlayerBase;

public class Denizen extends EntityBase {
	//if hiredBy is null then the ai will have to controll them
	//else controlled by the player that is hiredBy
	private PlayerBase hiredBy;
	
	public Denizen(){
		setHiredBy(null);
	}

	//setters and getters
	public PlayerBase getHiredBy() {
		return hiredBy;
	}

	public void setHiredBy(PlayerBase hiredBy) {
		this.hiredBy = hiredBy;
	}
	
}
