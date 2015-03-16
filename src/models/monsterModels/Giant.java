package models.monsterModels;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Giant extends MonsterBase {
	
	public Giant(){
		super();
		monsterType = "Giant";
		try {
			monsterImage = ImageIO.read(getClass().getResource("/monsters_c/giant.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
