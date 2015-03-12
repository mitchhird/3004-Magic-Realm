package utils;

import java.util.Random;

import views.RollView;
import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.TradeRelation;

/*
 * Utility Class For The Game That Has Static Methods For Ease Of Acesss
 */
public class GameUtils {
	
	public static String SEARCH_LOCATE = "LOCATE";
	public static String SEARCH_LOOT = "LOOT";
	private static boolean cheatMode = false;
	private static RollView theRoller;
	private static int cheatRoll = 0;
	
	// Returns A Random Value Between Ranges
	public static int createRandomInt (int beginRange, int endRange) {
		if(cheatMode){
			theRoller = new RollView(endRange);
			theRoller.setVisible(true);
			return cheatRoll;
		}else{
			Random randomizer = new Random();
			return (randomizer.nextInt((endRange - beginRange) + 1) + beginRange);
		}
	}
	
	public static boolean getCheatMode(){
		return cheatMode;
	}
	
	public static void setCheatMode(boolean theMode){
		cheatMode = theMode;
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
	
	//Tables that are constant and all will return a string for result
	public static int missleTable(int roll){
		int result = 0;
		switch (roll){
		case 1:
			result = 2;
			break;
		case 2:
			result = 1;
			break;
		case 3:
			result = 0;
			break;
		case 4:
			result = -1;
			break;
		case 5:
			result = -2;
			break;
		case 6:
			result = -3;
			break;
		}
		return result;
	}
	
//	X# = price*#
//	B# = can free
//	OPP = reRoll one greater
//	No = no deal
//	Trouble = to Unfriendly
//	Fight = block/Attack
//	Challenge = fame-5 or Fight
//	Insult = Notoriety-5 or Fight
	public static String meetingTable(TradeRelation relation, int roll){
		String result = null;
		switch (relation){
		case ENEMY:
			result = meetingEnemy(roll);
			break;
		case UNFRIENDLY:
			result = meetingUnfriendly(roll);
			break;
		case NEUTRAL:
			result = meetingNeutral(roll);
			break;
		case FRIENDLY:
			result = meetingFriendly(roll);
			break;
		case ALLY:
			result = meetingAlly(roll);
			break;
		}
		return result;
	}

	public static String meetingEnemy(int roll){
		String result = null;
		switch (roll){
		case 1:
			result = "Insult";
			break;
		case 2:
			result = "Challenge";
			break;
		case 3:
			result = "Fight";
			break;
		case 4:
			result = "Fight";
			break;
		case 5:
			result = "Fight";
			break;
		case 6:
			result = "Fight";
			break;
		}
		return result;
	}
	
	public static String meetingUnfriendly(int roll){
		String result = null;
		switch (roll){
		case 1:
			result = "X4";
			break;
		case 2:
			result = "No";
			break;
		case 3:
			result = "No";
			break;
		case 4:
			result = "Insult";
			break;
		case 5:
			result = "Challenge";
			break;
		case 6:
			result = "Fight";
			break;
		}
		return result;
	}
	
	public static String meetingNeutral(int roll){
		String result = null;
		switch (roll){
		case 1:
			result = "OPP";
			break;
		case 2:
			result = "X3";
			break;
		case 3:
			result = "X4";
			break;
		case 4:
			result = "No";
			break;
		case 5:
			result = "No";
			break;
		case 6:
			result = "Trouble";
			break;
		}
		return result;
	}
	
	public static String meetingFriendly(int roll){
		String result = null;
		switch (roll){
		case 1:
			result = "OPP";
			break;
		case 2:
			result = "X2";
			break;
		case 3:
			result = "X2";
			break;
		case 4:
			result = "X3";
			break;
		case 5:
			result = "X4";
			break;
		case 6:
			result = "No";
			break;
		}
		return result;
	}
	
	public static String meetingAlly(int roll){
		String result = null;
		switch (roll){
		case 1:
			result = "B1";
			break;
		case 2:
			result = "X1";
			break;
		case 3:
			result = "X2";
			break;
		case 4:
			result = "X3";
			break;
		case 5:
			result = "X4";
			break;
		case 6:
			result = "X4";
			break;
		}
		return result;
	}

	public static String changeTacTable(int roll){
		String result = null;
		switch (roll){
		case 6:
			result = "No";
			break;
		default:
			result = "Change";
		}
		return result;
	}
	
	//moves where will attack from
	// TODO add comments on the number mean
	public static String repositionDenizen(int roll){
		String result = null;
		switch (roll){
		case 1:
			result = "0-3-2";
			break;
		case 2:
			result = "3-0-1";
			break;
		case 3:
			result = "2-1-0";
			break;
		case 4:
			result = "0-0-0";
			break;
		case 5:
			result = "2-3-1";
			break;
		case 6:
			result = "3-1-2";
			break;
		}
		return result;
	}
	
//	check what search table to look through
	public static String seachTable(int selected, int roll){
		String result = null;
		switch (selected){
		case 1:
			result = peerTable(roll);
			break;
		case 2:
			result = locateTable(roll);
			break;
//			add with magic
		/*case 3:
			result = magicSightTable(roll);
			break;
		case 4:
			result = readRuneTable(roll);
			break;*/
		}
		return result;
	}
	
	public static String peerTable(int roll){
		String result = null;
		switch (roll){
		case 1:
			result = "Choice";
			break;
		case 2:
			result = "Clues-Paths";
			break;
		case 3:
			result = "Hidden-Paths";
			break;
		case 4:
			result = "Hidden";
			break;
		case 5:
			result = "Clues";
			break;
		case 6:
			result = "No";
			break;
		}
		return result;
	}
	public static String locateTable(int roll){
		String result = null;
		switch (roll){
		case 1:
			result = "Choice";
			break;
		case 2:
			result = "Passages-Clues";
			break;
		case 3:
			result = "Passages";
			break;
		case 4:
			result = "Discover";
			break;
		case 5:
			result = "No";
			break;
		case 6:
			result = "No";
			break;
		}
		return result;
	}
	
	//TODO set to public with magic
	private static String magicSightTable(int roll){
		String result = null;
		switch (roll){
		case 1:
			result = "Choice";
			break;
		case 2:
			result = "Counters";
			break;
		case 3:
			result = "Tresure";
			break;
		case 4:
			result = "Perceive";
			break;
		case 5:
			result = "Discover";
			break;
		case 6:
			result = "No";
			break;
		}
		return result;
	}
	
	//TODO set to public with magic
	private static String readRuneTable(int roll){
		String result = null;
		switch (roll){
		case 1:
			result = "Learn";
			break;
		case 2:
			result = "Learn";
			break;
		case 3:
			result = "Learn";
			break;
		case 4:
			result = "Awaken";
			break;
		case 5:
			result = "Curse";
			break;
		case 6:
			result = "No";
			break;
		}
		return result;
	}

	public static int getCheatRoll() {
		return cheatRoll;
	}

	public static void setCheatRoll(int cheatRoll) {
		GameUtils.cheatRoll = cheatRoll;
	}
}
