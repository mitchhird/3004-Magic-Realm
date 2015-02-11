package utils;

import java.util.Random;

/*
 * Utility Class For The Game That Has Static Methods For Ease Of Acesss
 */
public class GameUtils {

	// Returns A Random Value Between Ranges
	public static int createRandomInt (int beginRange, int endRange) {
		Random randomizer = new Random();
		return (randomizer.nextInt((endRange - beginRange) + 1) + beginRange);
	}
}
