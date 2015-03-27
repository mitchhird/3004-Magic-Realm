package models.otherEntities.monsterModels.AlternativeMonsterWeapons;

import models.characterModels.playerEnums.Weights;
import models.otherEntities.monsterModels.MonsterBase;

public class OgreClub extends AdditionalAttacks {

	private static final long serialVersionUID = 1111997362187023252L;

	public OgreClub(MonsterBase owner){
		super(Weights.TREMENDOUS, owner);
	}
}
