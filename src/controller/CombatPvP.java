package controller;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Weights;
import models.chitModels.Chit;

public class CombatPvP {
	
	//will be the entry point in the end for pvp combat
	public void combatPvP(PlayerBase attacker, PlayerBase defender){
		
	}
	
	/*
	 * Encounter
	 * TODO
	 * Albert - look into preparation
	 * preparation
	 * -determine first character for clearing
	 *
	 */
	
	private void preparation(){
		
	}
	
	/* luring
	 * -first character turn
	 * --character can lure unhired of any number to own sheet.
	 * --hirelings can lure only one
	 * --can not be relured to other hirelings
	 * --does not change hidden
	 * -repeat till all characters have had turn/no more the lure
	 * -pick unassigned unhired
	 * --all represented charcters roll
	 * --high roll takes
	 * --if character present move to sheet
	 * --else move to unhired sheet
	 * -repeat until all assigned
	 */ 
	
	//TODO
	//Albert - think about the return values and parameters for this
	private void luring() {
		PlayerBase currPlayer = findPlayer();
		while (currPlayer != null){
			
		}
		
		deployment();
	}

	private PlayerBase findPlayer() {
		// TODO have to send to view for swordsman about starting turn
		//some kind of random
		return null;
	}
	
	 /*
	 * Deployment & Charging
	 ***can charge or deploy any order 
	 * -first player
	 * --if charge hidden = false
	 * --if hireling deploy?
	 * ---if character
	 * ----distribute hireling in red boxes of character's sheet
	 * ---if denizen
	 * ----moves to own sheet hireling on top of attackers
	 * ----if last attacker on another denizen's sheet other
	 * 		denizen becomes first on thrust pile
	 * 		attackers controller places attacker either side up
	 * 		when it is moved to be to another attacker on new sheet
	 * ---deployed hireling and target hidden = false
	 * --else if more characters to charge/deploy continue
	 * --else Encounter Actions
	 */
	
	private void deployment(){
		
	}
	
	/* Encounter Action
	 * -character may play any number of enchated magic chits (not this iteration)
	 * -if charged
	 * --check if more character to do actions
	 * -else
	 * --chose 1 (Alert weapon, run, fly away, or cast spell
	 * ---if not then most abandon any number of belongings(active or not)
	 * --check if more characters to do actions
	 * -repeat till no more
	 */
	
	private void encounter() {
		
	}
	
	/* TODO
	 * Albert - Have to do the melee steps
	 * Melee Step
	 * -denizen horses turn galloping side up hirelings horses turn over
	 * -Denizens Target!!!*****
	 * mix attention chits of all involved characters. pick first
	 * 
	 */
	
	private void melee() {
		
	}
	
	/* Resolve Attacks
	 * -start with weapon length = 17 
	 * -Attack Speed = 0
	 * -if first combat weapon length > speed
	 * -else speed > length
	 * -choose attacker
	 * --attack undercut?
	 * ---Attack Hits
	 * --attack intercept maneuver?
	 * ---attack Hits
	 * --if attacker is character + weapon
	 * ---weapon = Alerted
	 * --MORE attacks to resolve at this length and speed?
	 * ---choose attacker
	 * --more attacks to resolve?
	 * ---length-1
	 * ---speed+1
	 * ---next combat round
	 * --Character pay for Fatigue and Wounds
	 * --Disengagement
	 * --Spoils of Combat
	 */
	
	private void resolveAttacks() {
		
	}
	
	
	/* will return 0 if unwounded
	 * 1 if 1 wound
	 * 2 if horse dies
	 * 3 if defender dies */
	private int attackHits(PlayerBase attacker, PlayerBase defender) {
		int harm;
		//TODO CHIT THINGS - Albert
		harm = attacker.getWeapon().getHarmLevel();
		
		if (attacker.getWeapon().getStars() > 0) {
			if (attack intercepts armor){
				attacker.getWeapon().setStars(attacker.getWeapon().getStars() - 1);
			}
			harm += attacker.getWeapon().getStars();
		}
		
		if (attacker.getWeapon().hasMissles()){
			//do some roll thing here
		}
		
		if (attacker.getStrength() > defender.getStrength()){
			++harm;
		}
		
		//out till add horses
		/*if(defender.onHorse()){
			if(harm > defender.getHorse().getVulnerability()){
				return 2;
			}
		} else */ 
		if(Attacker = character){
			if(defender.check armor hit){
				defender.checkAromor(Harm);
				if (harm >= Weights.MEDIUM){
					return 1;
				}
			} else {
				if (harm >= defender.getVulnerability()){
					defender.isDead();
					return 3;
				}
				if (harm > Weights.NEGLIGABLE){
					return 1;
				}
				attacker.getWeapon().setAlert(false);
			}
		} else {
			if(harm > defender.getVulnerability()){
				return 3;
			}
		}
		
		return 0;
	}
	
	/* Attack Hits
	 * -Determine Harm Level(Harm Letter)
	 * -Stars?
	 * --attack intercepts armor?
	 * ---stars-1
	 * --level + stars
	 * -Missle Weapon?
	 * --missle table roll + level
	 * --else fight strength higher?
	 * ---level+1
	 * -Inflict Harm
	 * -target on horse?
	 * --harm hits horse
	 * --HARMVVUL--
	 * ---harm > vul
	 * ----target killed
	 * ----MORE
	 * ---target unharmed
	 * ---unalerted Weapon
	 * ---MORE
	 * -character or denizen?
	 * --denizen -> HARMVVUL
	 * -hit armor?
	 * --armor damaged
	 * --if harm >= M
	 * ---1 wound
	 * --unharmed
	 * --MORE
	 * -Harm > VUL?
	 * --target killed
	 * --else harm negligible?
	 * ---unharmed
	 * ---MORE
	 * ---else 1 wound
	 * ---MORE
	 * 
	 * 
	 */
}
