package models.otherEntities.monsterModels;

import java.io.IOException;

import javax.imageio.ImageIO;

import models.otherEntities.monsterModels.AlternativeMonsterWeapons.AdditionalAttacks;
import models.otherEntities.monsterModels.AlternativeMonsterWeapons.OgreClub;

public class Giant extends MonsterBase {
	
	public Giant(){
		super();
		monsterType = "Giant";
		try {
			monsterImage = ImageIO.read(getClass().getResource("/monsters_c/giant.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		extraWeapon = true;
		extraAttack = new OgreClub(this);
	}

}
