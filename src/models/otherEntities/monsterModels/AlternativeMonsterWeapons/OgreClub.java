package models.otherEntities.monsterModels.AlternativeMonsterWeapons;

import models.characterModels.playerEnums.Weights;
import models.otherEntities.monsterModels.MonsterBase;

public class OgreClub extends AdditionalAttacks {
	
	public OgreClub(MonsterBase owner){
		super(Weights.TREMENDOUS, owner);
	}
}
