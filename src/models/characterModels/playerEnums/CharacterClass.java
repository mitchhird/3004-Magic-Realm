package models.characterModels.playerEnums;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

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
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","amazonUnhidden.png"));
			case BLACKNIGHT:
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","black_knightUnhidden.png"));
			case CAPTAIN:
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","captainUnhidden.png"));
			case DWARF:
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","dwarfUnhidden.png"));
			case ELF:
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","elfUnhidden.png"));
			case SWORDSMAN:
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","swordsmanUnhidden.png"));
			default:
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","amazonUnhidden.png"));
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
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","amazonHidden.png"));
			case BLACKNIGHT:
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","black_knightHidden.png"));
			case CAPTAIN:
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","captainHidden.png"));
			case DWARF:
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","dwarfHidden.png"));
			case ELF:
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","elfHidden.png"));
			case SWORDSMAN:
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","swordsmanHidden.png"));
			default:
				return ImageIO.read(new File(baseDir + "/images/characterGameTiles","amazonHidden.png"));
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
				return ImageIO.read(new File(baseDir + "/images/characterdetail","amazon.jpg"));
			case BLACKNIGHT:
				return ImageIO.read(new File(baseDir + "/images/characterdetail","black_knight.jpg"));
			case CAPTAIN:
				return ImageIO.read(new File(baseDir + "/images/characterdetail","captain.jpg"));
			case DWARF:
				return ImageIO.read(new File(baseDir + "/images/characterdetail","dwarf.jpg"));
			case ELF:
				return ImageIO.read(new File(baseDir + "/images/characterdetail","elf.jpg"));
			case SWORDSMAN:
				return ImageIO.read(new File(baseDir + "/images/characterdetail","swordsman.jpg"));
			default:
				return ImageIO.read(new File(baseDir + "/images/characterdetail","amazon.jpg"));
			}
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
		return null;
   }
   
	public WeaponChit getStartingWeapon() {
		switch (this) {
		case AMAZON:
			return new WeaponChit(14, 2, Weights.LIGHT);
		case BLACKNIGHT:
			return new WeaponChit(10, 1, Weights.MEDIUM);
		case CAPTAIN:
			return new WeaponChit(10, 1, Weights.MEDIUM);
		case DWARF:
			return new WeaponChit(2, 1, Weights.MEDIUM);
		case ELF:
			return new WeaponChit(14, 2, Weights.LIGHT);
		case SWORDSMAN:
			return new WeaponChit(4, 1, Weights.LIGHT);
		default:
			return new WeaponChit(10, 1, Weights.MEDIUM);
		}
   }
}
