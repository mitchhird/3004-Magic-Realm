package models.characterModels;

import models.characterModels.playerEnums.Weights;

/*
 * no magic
 * update
 */

public class Elf extends PlayerBase {
	//starting equipment value
	//1st-lvl-10 2nd-10 3rd-16 4th-16
	/*
	 * weight/vulnerability: light
	 * Special:
	 * 1 Elusiveness: 
	 * can record and do an extra
	 * hide phase each day
	 * 2 Archer:
	 * The one die instead of two for
	 * missle table to make an attack with a bow
	 * crossbow
	 * 
	 * Starting Location: Inn
	 * 
	 * Trade Relationships:
	 * Ally:
	 * Woodfolk
	 * Friendly:
	 * Bashkars
	 * Unfriendly:
	 * Order, Scholar
	 * Enemy:
	 * Lancers
	 * 
	 * Development/Combat Chits:
	 * Stripling:
	 * Spell(III or VII), MagicIII3*, MagicIII4*, MagicVII4*
	 * Faerie:
	 * 2 Spell(III or VII), Magic VII3*, MagicIII3*, MagicIII2*
	 * Hunter:
	 * Light Bow, 2 Spells(III or VII), MoveL3*, FightL3*, Move:2*
	 * Elf:
	 * Light Bow, 2 Spells(III or VII), MoveM4, FightM3*, FightM4
	 * 
	 */
	public Elf(){
		weight = Weights.LIGHT;
	}
}
