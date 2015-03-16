package models.monsterModels;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Ghost extends MonsterBase {
	public Ghost(){
		super();
		monsterType = "Giant";
		try {
			monsterImage = ImageIO.read(getClass().getResource("/monsters_c/ghost.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
