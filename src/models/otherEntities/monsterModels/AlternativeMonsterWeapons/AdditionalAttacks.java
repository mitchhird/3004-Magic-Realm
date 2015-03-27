package models.otherEntities.monsterModels.AlternativeMonsterWeapons;

import java.io.Serializable;

import models.characterModels.playerEnums.Weights;
import models.otherEntities.monsterModels.MonsterBase;

public class AdditionalAttacks implements Serializable {
	protected Weights attack;
	protected MonsterBase owner;
	private static final long serialVersionUID = -1826021280242779017L;
	
	public AdditionalAttacks () {
		
	}
	public AdditionalAttacks(Weights attack, MonsterBase owner){
		this.attack = attack;
		this.owner = owner;
	}
	
	public Weights getAttack(){
		return attack;
	}
}
