package models.characterModels.playerEnums;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

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
				return ImageIO.read(new File(baseDir + "/images/characters","amazon.png"));
			case BLACKNIGHT:
				return ImageIO.read(new File(baseDir + "/images/characters","black_knight.png"));
			case CAPTAIN:
				return ImageIO.read(new File(baseDir + "/images/characters","captain.png"));
			case DWARF:
				return ImageIO.read(new File(baseDir + "/images/characters","dwarf.png"));
			case ELF:
				return ImageIO.read(new File(baseDir + "/images/characters","elf.png"));
			case SWORDSMAN:
				return ImageIO.read(new File(baseDir + "/images/characters","swordsman.png"));
			default:
				return ImageIO.read(new File(baseDir + "/images/characters","amazon.png"));
			}
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
		return null;
   }
}
