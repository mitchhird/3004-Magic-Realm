package models.otherEntities.monsterModels;

import java.io.IOException;

import javax.imageio.ImageIO;

public class FlyingDragon extends MonsterBase {
	public FlyingDragon(){
		super();
		monsterType = "FlyingDragon";
		try {
			monsterImage = ImageIO.read(getClass().getResource("/monsters_c/dragon_flying.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
