package utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import models.characterModels.PlayerBase;
import models.chitModels.WeaponChit;

/*
 * Utility Class For The Game That Has Static Methods For Ease Of Acesss
 */
public class GameUtils {
	
	public static String SEARCH_LOCATE = "LOCATE";
	public static String SEARCH_LOOT = "LOOT";
	
	// Returns A Random Value Between Ranges
	public static int createRandomInt (int beginRange, int endRange) {
		Random randomizer = new Random();
		return (randomizer.nextInt((endRange - beginRange) + 1) + beginRange);
	}
	
	// Returns That Valid Move Clearing Image
	public static Image getValidClearingImg (JButton mapButton) {
		File imageFile = new File(System.getProperty("user.dir") + "/images", "moveableClearing.png");
		try {
			Image image = ImageIO.read(imageFile);
			return image.getScaledInstance(mapButton.getWidth(), mapButton.getHeight(), Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//Returns A Random Array of Players From Another Array
	public static PlayerBase[] randomOrder(PlayerBase[] currPlayers){
		int total = currPlayers.length;
		PlayerBase[] rList = {};
		for(int i = 0; i < total; ++i){
			int turn = createRandomInt(0, currPlayers.length);
			rList[rList.length] = currPlayers[turn];
			for(int f = turn; turn < currPlayers.length; ++f){
				currPlayers[f] = currPlayers[f + 1];
			}
		}
		return rList;
	}
}
