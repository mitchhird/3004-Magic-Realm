package models.chitModels;

import java.util.ArrayList;

import models.characterModels.playerEnums.ArmorType;
import models.characterModels.playerEnums.Weights;
import models.chitModels.EnvironmentChit.EnvironmentChit;
import models.chitModels.EnvironmentChit.SiteChit;
import models.chitModels.EnvironmentChit.SoundChit;
import models.chitModels.EnvironmentChit.WarningChit;
import models.chitModels.SpecialActionChits.DuckChit;

public class ChitFactory {

	// Action Chits
	// (fight/move),weight,speed,stars
	public static ActionChit MoveL = new ActionChit("ML1", Weights.LIGHT, /* speed */
			4, /* stars */2, false);

	// move
	public static ActionChit getMoveML2() {
		return new ActionChit("ML2", Weights.LIGHT, 2, 2, false);
	}

	public static ActionChit getMoveML21() {
		return new ActionChit("ML21", Weights.LIGHT, 2, 1, false);
	}

	public static ActionChit getMoveML31() {
		return new ActionChit("ML31", Weights.LIGHT, 3, 1, false);
	}

	public static ActionChit getMoveML40() {
		return new ActionChit("ML40", Weights.LIGHT, 4, 0, false);
	}

	public static ActionChit getMoveMM31() {
		return new ActionChit("MM31", Weights.MEDIUM, 3, 1, false);
	}

	public static ActionChit getMoveMM32() {
		return new ActionChit("MM32", Weights.MEDIUM, 3, 2, false);
	}

	public static ActionChit getMoveMM40() {
		return new ActionChit("MM40", Weights.MEDIUM, 4, 0, false);
	}

	public static ActionChit getMoveMM41() {
		return new ActionChit("MM41", Weights.MEDIUM, 4, 1, false);
	}

	public static ActionChit getMoveMM50() {
		return new ActionChit("MM50", Weights.MEDIUM, 5, 0, false);
	}

	public static ActionChit getMoveMH42() {
		return new ActionChit("MH42", Weights.HEAVY, 4, 2, false);
	}

	public static ActionChit getMoveMH51() {
		return new ActionChit("MH51", Weights.HEAVY, 5, 1, false);
	}

	public static ActionChit getMoveMH60() {
		return new ActionChit("MH60", Weights.HEAVY, 6, 0, false);
	}

	public static ActionChit getMoveMT52() {
		return new ActionChit("MT52", Weights.TREMENDOUS, 5, 2, false);
	}

	public static ActionChit getMoveMT61() {
		return new ActionChit("MT61",Weights.TREMENDOUS, 6, 1, false);
	}

	// fight
	public static ActionChit FL22 = new ActionChit("FL22", Weights.LIGHT, 2, 2, true);
	public static ActionChit FL31 = new ActionChit("FL21", Weights.LIGHT, 3, 1, true);
	public static ActionChit FL40 = new ActionChit("FL40", Weights.LIGHT, 4, 0, true);
	public static ActionChit FM32 = new ActionChit("FM32", Weights.MEDIUM, 3, 2, true);
	public static ActionChit FM31 = new ActionChit("FM31", Weights.MEDIUM, 3, 1, true);
	public static ActionChit FM40 = new ActionChit("FM40", Weights.MEDIUM, 4, 0, true);
	public static ActionChit FM41 = new ActionChit("FM41", Weights.MEDIUM, 4, 1, true);
	public static ActionChit FM50 = new ActionChit("FM50", Weights.MEDIUM, 5, 0, true);
	public static ActionChit FH42 = new ActionChit("FH42", Weights.HEAVY, 4, 2, true);
	public static ActionChit FH51 = new ActionChit("FH51", Weights.HEAVY, 5, 1, true);
	public static ActionChit FH60 = new ActionChit("FH60", Weights.HEAVY, 6, 0, true);
	public static ActionChit FT52 = new ActionChit("FT52", Weights.TREMENDOUS, 5, 2,true);
	public static ActionChit FT61 = new ActionChit("FT61", Weights.TREMENDOUS, 6, 1,true);

	// special
	public static DuckChit DT31 = new DuckChit("Duck", Weights.TREMENDOUS, 3, 1);

	// Weapon Chits
	public static WeaponChit AXE = new WeaponChit("Axe", 2, 1, Weights.MEDIUM);
	public static WeaponChit SPEAR = new WeaponChit("Spear", 10, 1, Weights.MEDIUM);
	public static WeaponChit LIGHT_BOW = new WeaponChit("Light Bow", 14, 2,
			Weights.LIGHT);
	public static WeaponChit THRUSTING_SWORD = new WeaponChit("Thrusting Sword", 4, 1, Weights.LIGHT);

	/* ----------------------------- Armor Chits ----------------------------- */
	public static ArmorChit getHelmet() {
		return new ArmorChit(ArmorType.HELMET, Weights.MEDIUM);
	}

	public static ArmorChit getBreastPlate() {
		return new ArmorChit(ArmorType.BREASTPLATE, Weights.MEDIUM);
	}

	public static ArmorChit getShield() {
		return new ArmorChit(ArmorType.SHIELD, Weights.MEDIUM);
	}

	public static ArmorChit getArmor() {
		return new ArmorChit(ArmorType.ARMOUR, Weights.MEDIUM);
	}

	// Environment Chits
	// Site
	public static SiteChit LostCity = new SiteChit(0, "Lost Castle", "/chits/lostcity.jpg");
	public static SiteChit LostCastle = new SiteChit(0, "Lost City", "/chits/lostcastle.jpg");
	
	// Sound
	public static SoundChit flutter1 = new SoundChit(1, "Flutter1", "/chits/flutter.jpg");
	public static SoundChit flutter2 = new SoundChit(2, "Flutter2", "/chits/flutter.jpg");
	
	/*
	public static SoundChit howl4 = new SoundChit(4, "Howl4");
	public static SoundChit howl5 = new SoundChit(5, "Howl5");
	public static SoundChit patter2 = new SoundChit(2, "Patter2");
	public static SoundChit patter5 = new SoundChit(5, "Patter5");
	public static SoundChit roar4 = new SoundChit(4, "Roar4");
	public static SoundChit roar6 = new SoundChit(6, "Roar6");
	public static SoundChit slither3 = new SoundChit(3, "Slither3");
	public static SoundChit slither6 = new SoundChit(6, "Slither6");
	*/
	
	// Warning
	public static WarningChit bonesV = new WarningChit(0, "BonesV", "/chits/bonesV.jpg");
	public static WarningChit bonesW = new WarningChit(0, "BonesW", "/chits/bonesW.jpg");

	/*
	public static WarningChit bonesC = new WarningChit(0, "BonesC");
	public static WarningChit bonesM = new WarningChit(0, "BonesM");
	public static WarningChit dankC = new WarningChit(0, "DankC");
	public static WarningChit dankM = new WarningChit(0, "DankM");
	public static WarningChit dankV = new WarningChit(0, "DankV");
	public static WarningChit dankW = new WarningChit(0, "DankW");
	public static WarningChit ruinsC = new WarningChit(0, "RuinsC");
	public static WarningChit ruinsM = new WarningChit(0, "RuinsM");
	public static WarningChit ruinsV = new WarningChit(0, "RuinsV");
	public static WarningChit ruinsW = new WarningChit(0, "RuinsW");
	public static WarningChit smokeC = new WarningChit(0, "SmokeC");
	public static WarningChit smokeM = new WarningChit(0, "SmokeM");
	public static WarningChit smokeV = new WarningChit(0, "SmokeV");
	public static WarningChit smokeW = new WarningChit(0, "SmokeW");
	public static WarningChit stinkC = new WarningChit(0, "StinkC");
	public static WarningChit stinkM = new WarningChit(0, "StinkM");
	public static WarningChit stinkV = new WarningChit(0, "StinkV");
	public static WarningChit stinkW = new WarningChit(0, "StinkW");
	*/

	public ArrayList<EnvironmentChit> getWarning() {
		ArrayList<EnvironmentChit> rlist = new ArrayList<EnvironmentChit>();
		rlist.add(bonesV);
		rlist.add(bonesW);
		
		/*
		rlist.add(bonesC);
		rlist.add(bonesM);
		rlist.add(dankC);
		rlist.add(dankM);
		rlist.add(dankV);
		rlist.add(dankW);
		rlist.add(ruinsC);
		rlist.add(ruinsM);
		rlist.add(ruinsV);
		rlist.add(ruinsW);
		rlist.add(smokeC);
		rlist.add(smokeM);
		rlist.add(smokeV);
		rlist.add(smokeW);
		rlist.add(stinkC);
		rlist.add(stinkM);
		rlist.add(stinkV);
		rlist.add(stinkW);
		*/
		
		return rlist;
	}

	public ArrayList<EnvironmentChit> getMap() {
		ArrayList<EnvironmentChit> rlist = new ArrayList<EnvironmentChit>();
		
		// Site
		/*
		rlist.add(alter);
		rlist.add(cairns);
		rlist.add(hoard);
		rlist.add(lair);
		rlist.add(pool);
		rlist.add(shrine);
		rlist.add(statue);
		rlist.add(vault);
		*/
		
		// Sound
		rlist.add(flutter1);
		rlist.add(flutter2);
		
		/*
		rlist.add(howl4);
		rlist.add(howl5);
		rlist.add(patter2);
		rlist.add(patter5);
		rlist.add(roar4);
		rlist.add(roar6);
		rlist.add(slither3);
		rlist.add(slither6);
		*/
		
		return rlist;
	}

	public ArrayList<EnvironmentChit> addCityCastle(
			ArrayList<EnvironmentChit> start) {
		start.add(LostCity);
		start.add(LostCastle);
		return start;
	}

}
