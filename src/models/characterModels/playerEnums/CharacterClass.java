package models.characterModels.playerEnums;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;

import models.chitModels.ActionChit;
import models.chitModels.ArmorChit;
import models.chitModels.ChitFactory;
import models.chitModels.WeaponChit;

/**
 * A Basic Enumeration That Will Allow For Character Specific 
 * Functionality If Needed
 * @author Mitchell
 */
public enum CharacterClass {
   AMAZON,
   BLACKNIGHT,
   CAPTAIN,
   DWARF,
   ELF,
   SWORDSMAN;
   
   // Method That Will Return The Ready Tile For The Class
   public Image getReadyTile () {
	   String baseDir = System.getProperty("user.dir");
		try {
			switch (this) {
			case AMAZON:
				return ImageIO.read(getClass().getResource("/characterGameTiles/amazonUnhidden.png"));
			case BLACKNIGHT:
				return ImageIO.read(getClass().getResource("/characterGameTiles/black_knightUnhidden.png"));
			case CAPTAIN:
				return ImageIO.read(getClass().getResource("/characterGameTiles/captainUnhidden.png"));
			case DWARF:
				return ImageIO.read(getClass().getResource("/characterGameTiles/dwarfUnhidden.png"));
			case ELF:
				return ImageIO.read(getClass().getResource("/characterGameTiles/elfUnhidden.png"));
			case SWORDSMAN:
				return ImageIO.read(getClass().getResource("/characterGameTiles/swordsmanUnhidden.png"));
			default:
				return ImageIO.read(getClass().getResource("/characterGameTiles/amazonUnhidden.png"));
			}
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
		return null;
   }
   
   // Method That Will Return The Ready Tile For The Class
   public Image getHiddenTile () {
	   String baseDir = System.getProperty("user.dir");
		try {
			switch (this) {
			case AMAZON:
				return ImageIO.read(getClass().getResource("/characterGameTiles/amazonHidden.png"));
			case BLACKNIGHT:
				return ImageIO.read(getClass().getResource("/characterGameTiles/black_knightHidden.png"));
			case CAPTAIN:
				return ImageIO.read(getClass().getResource("/characterGameTiles/captainHidden.png"));
			case DWARF:
				return ImageIO.read(getClass().getResource("/characterGameTiles/dwarfHidden.png"));
			case ELF:
				return ImageIO.read(getClass().getResource("/characterGameTiles/elfHidden.png"));
			case SWORDSMAN:
				return ImageIO.read(getClass().getResource("/characterGameTiles/swordsmanHidden.png"));
			default:
				return ImageIO.read(getClass().getResource("/characterGameTiles/amazonHidden.png"));
			}
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
		return null;
   }
   
   public Image getDetailImage () {
	   String baseDir = System.getProperty("user.dir");
		try {
			switch (this) {
			case AMAZON:
				return ImageIO.read(getClass().getResource("/characterdetail/amazon.jpg"));
			case BLACKNIGHT:
				return ImageIO.read(getClass().getResource("/characterdetail/black_knight.jpg"));
			case CAPTAIN:
				return ImageIO.read(getClass().getResource("/characterdetail/captain.jpg"));
			case DWARF:
				return ImageIO.read(getClass().getResource("/characterdetail/dwarf.jpg"));
			case ELF:
				return ImageIO.read(getClass().getResource("/characterdetail/elf.jpg"));
			case SWORDSMAN:
				return ImageIO.read(getClass().getResource("/characterdetail/swordsman.jpg"));
			default:
				return ImageIO.read(getClass().getResource("/characterdetail/amazon.jpg"));
			}
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
		return null;
   }
   
	public WeaponChit getStartingWeapon() {
		switch (this) {
		case AMAZON:
			return ChitFactory.LIGHT_BOW;
		case BLACKNIGHT:
			return ChitFactory.SPEAR;
		case CAPTAIN:
			return ChitFactory.SPEAR;
		case DWARF:
			return ChitFactory.AXE;
		case ELF:
			return ChitFactory.LIGHT_BOW;
		case SWORDSMAN:
			return ChitFactory.SPEAR;
		default:
			return ChitFactory.SPEAR;
		}
   }
	
	public Weights getVulner () {
		switch (this) {
		case AMAZON:
			return Weights.MEDIUM;
		case BLACKNIGHT:
			return Weights.MEDIUM;
		case CAPTAIN:
			return Weights.MEDIUM;
		case DWARF:
			return Weights.HEAVY;
		case ELF:
			return Weights.LIGHT;
		case SWORDSMAN:
			return Weights.LIGHT;
		default:
			return Weights.LIGHT;	
		}
	}
	
	// Gather The Armour Chits For This Player Class
	public ArrayList<ArmorChit> getArmour () {
		ArrayList<ArmorChit> returnVal = new ArrayList<>();
		switch (this) {
		case AMAZON:
			returnVal.add(ChitFactory.getHelmet());
			returnVal.add(ChitFactory.getShield());
			returnVal.add(ChitFactory.getBreastPlate());
			break;
		case BLACKNIGHT:
			returnVal.add(ChitFactory.getHelmet());
			returnVal.add(ChitFactory.getBreastPlate());
			break;
		case CAPTAIN:
			returnVal.add(ChitFactory.getShield());
			break;
		case DWARF:
			returnVal.add(ChitFactory.getHelmet());
			break;
		case ELF:
			break;
		case SWORDSMAN:
			break;
		default:
			break;
		}
		return returnVal;
	}
	
	// Starting Action Chits
	public ArrayList<ActionChit> getStartingChit() {
		ArrayList<ActionChit> rList = new ArrayList<>();
		switch (this) {
		case AMAZON:
			rList.add(ChitFactory.MM40);
			rList.add(ChitFactory.MM31);
			rList.add(ChitFactory.MM40);
			rList.add(ChitFactory.MM31);
			rList.add(ChitFactory.MM31);
			rList.add(ChitFactory.FL40);
			rList.add(ChitFactory.FM50);
			rList.add(ChitFactory.FM41);
			rList.add(ChitFactory.FM32);
			rList.add(ChitFactory.FH42);
			rList.add(ChitFactory.FM41);
			rList.add(ChitFactory.FM32);
			break;
		case BLACKNIGHT:
			rList.add(ChitFactory.MM50);
			rList.add(ChitFactory.MH51);
			rList.add(ChitFactory.MH60);
			rList.add(ChitFactory.MM41);
			rList.add(ChitFactory.MH42);
			rList.add(ChitFactory.FH51);
			rList.add(ChitFactory.FH60);
			rList.add(ChitFactory.FM41);
			rList.add(ChitFactory.FM41);
			rList.add(ChitFactory.FM50);
			rList.add(ChitFactory.FH42);
			rList.add(ChitFactory.FM32);
			break;
		case CAPTAIN:
			rList.add(ChitFactory.MM41);
			rList.add(ChitFactory.MM50);
			rList.add(ChitFactory.MM32);
			rList.add(ChitFactory.MM41);
			rList.add(ChitFactory.MM41);
			rList.add(ChitFactory.FH51);
			rList.add(ChitFactory.FM50);
			rList.add(ChitFactory.FM32);
			rList.add(ChitFactory.FH51);
			rList.add(ChitFactory.FM41);
			rList.add(ChitFactory.FH60);
			rList.add(ChitFactory.FM41);
			break;
		case DWARF:
			rList.add(ChitFactory.MT52);
			rList.add(ChitFactory.MH60);
			rList.add(ChitFactory.MT61);
			rList.add(ChitFactory.MH51);
			rList.add(ChitFactory.DT31);
			rList.add(ChitFactory.FH51);
			rList.add(ChitFactory.FH60);
			rList.add(ChitFactory.FH42);
			rList.add(ChitFactory.FT61);
			rList.add(ChitFactory.FH42);
			rList.add(ChitFactory.FT52);
			rList.add(ChitFactory.FT52);
			break;
		case ELF:
//			rList.add(ChitFactory.MM40); Magic
//			rList.add(ChitFactory.MM31);
//			rList.add(ChitFactory.FL40);
//			rList.add(ChitFactory.MM40);
//			rList.add(ChitFactory.FM50);
//			rList.add(ChitFactory.FM41);
			rList.add(ChitFactory.ML31);
			rList.add(ChitFactory.ML21);
			rList.add(ChitFactory.MM40);
			rList.add(ChitFactory.FL31);
			rList.add(ChitFactory.FM31);
			rList.add(ChitFactory.FM40);
			break;
		case SWORDSMAN:
			rList.add(ChitFactory.ML40);
			rList.add(ChitFactory.ML31);
			rList.add(ChitFactory.MM41);
			rList.add(ChitFactory.ML31);
			rList.add(ChitFactory.ML22);
			rList.add(ChitFactory.FL31);
			rList.add(ChitFactory.FL22);
			rList.add(ChitFactory.FM41);
			rList.add(ChitFactory.FM32);
			rList.add(ChitFactory.FL40);
			rList.add(ChitFactory.FM50);
			rList.add(ChitFactory.FL22);
			break;
		default:
			break;
		}
		return rList;
	}
}
