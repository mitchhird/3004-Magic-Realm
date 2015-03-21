package models.otherEntities.monsterModels.AlternativeMonsterWeapons;

import models.characterModels.playerEnums.Weights;
import models.otherEntities.monsterModels.MonsterBase;

public class AdditionalAttacks {
	protected Weights attack;
	protected MonsterBase owner;
	
	public AdditionalAttacks(Weights attack, MonsterBase owner){
		this.attack = attack;
		this.owner = owner;
	}
	
	public Weights getAttack(){
		return attack;
	}
}
