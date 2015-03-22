package models.otherEntities.nativeModels;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Knight extends NativeBase{
	public Knight(){
		super();
		try {
			nativeImage = ImageIO.read(getClass().getResource("/natives_c/knight_o.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
