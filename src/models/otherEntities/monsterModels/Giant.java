package models.otherEntities.monsterModels;

import models.otherEntities.monsterModels.AlternativeMonsterWeapons.OgreClub;

public class Giant extends MonsterBase {

	private static final long serialVersionUID = -2024255630335784797L;

	public Giant(String clearingThisOn){
		super(clearingThisOn, "/monsters_c/giant.gif");
		monsterType = "Giant";
		extraWeapon = true;
		extraAttack = new OgreClub(this);
	}
	
	@Override
	public String toString() {
		return "Giant, Attacking: " + combatDirection;
	}

	@Override
	public MonsterBase clone() {
		Giant newGiant = new Giant(this.clearningThisOn);
		newGiant.monsterType = this.monsterType;
		newGiant.extraWeapon = this.extraWeapon;
		newGiant.extraAttack = this.extraAttack;
		return newGiant;
	}

}
