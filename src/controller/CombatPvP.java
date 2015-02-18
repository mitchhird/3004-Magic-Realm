package controller;

import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Weights;
import models.chitModels.Chit;

public class CombatPvP {
	private Clearing currClearing;
	//will be the entry point in the end for pvp combat
	public void combatPvP(PlayerBase[] players, Clearing clearing){
		currClearing = clearing;
		preparation(players);
		currClearing = null;
	}
	
	/*
	 * Encounter
	 * TODO
	 * Albert - look into preparation
	 * preparation
	 * -determine first character for clearing
	 *
	 */
	
	private void preparation(PlayerBase[] players){
		
		
		luring(players);
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
	
	//assumed can only lure unhidden characters/entity
	private void luring(PlayerBase[] players) {
		PlayerBase currPlayer = findPlayer(players);
		while (currPlayer != null){
			if (unhidden players in clearing){
				can lure any natives or characters
				will make both unhidden and will get each to target one another
			}
			
			
			
			currPlayer = findPlayer(players);
		}
		
		if (unassigned non-player controlled entities in clearing){
			if (unhidden in clearing){
				randomAssignments(players);
			}
		}
		
		deployment(players);
	}
	
	private void randomAssignments(PlayerBase[] players/*, EntityBase[] unassigned*/){
		//this will take the unassigned and will assign them to attack one of the players/hirings
		//for that clearing
		//assigned to UNHIDDEN characters in the clearing
	}

	private PlayerBase findPlayer(PlayerBase[] players) {
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
	
	private void deployment(PlayerBase[] players){
		rotate through all the players
		PlayerBase[] chargeAble;
		if(found "hidden enemies"){//something to do with the search phase of the day
			chargeAble = clearing.getEnties();
		} else {
			if (unhidden in clearing){
				chargeAble = all unhidden;
			}
		}
		
		for each see if they want to charge player
			if so both unhidden
		
		encounter(players);
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
	
	private void encounter(PlayerBase[] players) {
		rotate through and check if charged another
			if so then continue
			else
				see if alert weapon, run, or fly (can cast spell here)
				if not
					may alert any 1 belonging or abandon any number of belongings
		
		melee(players);
	}
	
	/* TODO
	 * Albert - Have to do the melee steps
	 * Melee Step
	 * -denizen horses turn galloping side up hirelings horses turn over
	 * -Denizens Target!!!*****
	 * mix attention chits of all involved characters. pick first
	 * 
	 */
	
	private void melee(PlayerBase[] players) {
		rotate through attention chits and select attack targets
		
		secrete attack, manuever, and armor for each character
		
		reveal
		
		roll for repositioning and change of tactics
		
		resolveAttacks(players);
	}
	
	//will have to have something in regards to the clearing and attack order
	//all the clearing attacks go to resolve attacks and then when the clearning is
	//done then go to the next clearing to resolve attacks
	
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
	
	private void resolveAttacks(PlayerBase[] players) {
		PlayerBase currplayer = findPlayer(players);
		PlayerBase attacker, defender;
		int damage;
		check how the currplayer is attacking
		who is the attacker and who is defender
		int currBest = 0;
		for(int i = 0; i < currClearing.getPlayers().length(); ++i){
			if(currClearing.getPlayer(i).getWeapon().getLength() > currBest){
				currBest = currClearing.getPlayer(i).getWeapon().getLength();
				attacker = currClearing.getPlayer(i);
			}
		}
		defender = attacker.attackList(1);
		
		check all the lengths of weapons in clearning
		check length then speed if equal
		then if same for both both attack and hit the other
		both can die
		while(currplayer != null){
			if(!(defender.isLiving())){
				continue;
			}
			
			if(!(attacker.isLiving())){
				continue;
			}
			
			int wounds1, wounds2;
			if(defender.getWeapon().getLength() == attacker.getWeapon().getLength() &&
			   defender.getWeapon().getSpeed()  == attacker.getWeapon().getSpeed()){
				wounds1 = checkAttack(attacker, defender);
				wounds2 = checkAttack(defender, attacker);
			}
			
			attacker.setWounds(wounds1);
			defender.setWounds(wounds2);
			
			attacker = nextAttacker(players);
			defender = attacker.attackList(1);
		}
	}
	
	private PlayerBase nextAttacker(PlayerBase[] entities){
		PlayerBase nAttacker = null;
		check for more attacks at this speed and length
		
		check for more attacks at highest speed
		currplayer = findPlayer(players);
		return nAttacker;
	}
	
	private void setWounds(PlayerBase player, int wounds){
		if(wounds == 1){
			player.increaseWounds(wounds);
		}
		if(wounds == 2){
			//no horse
		}
		if(wounds == 3){
			player.isDead();
		}
	}
	
	private int checkAttack(PlayerBase attacker, PlayerBase defender){
		int damage = 0;
		if (attack time vs manuever time){
			damage = attackHits(attacker, defender);
		} else if (attack direction vs manuever direction) {
			damage = attackHits(attacker, defender);
		} else {
			attacker.getWeapon().setAlert(true);
		}
		return damage;
	}
	
	
	/* will return 0 if unwounded
	 * 1 if 1 wound
	 * 2 if horse dies
	 * 3 if defender dies */
	private int attackHits(PlayerBase attacker, PlayerBase defender) {
		Weights harm;
		//TODO CHIT THINGS - Albert
		harm = attacker.getWeapon().getHarmLevel();
		
		if (attacker.getWeapon().getStars() > 0) {
			if (defender.armorBlocks(attacker.getWeapon().getAttack())){//have to see what these conditions are
				attacker.getWeapon().setStars(attacker.getWeapon().getStars() - 1);
			}
			for(int i =0; i < attacker.getWeapon().getStars(); ++i)
				harm = harm.next();
		}
		
		if (attacker.getWeapon().hasMissles()){
			//do some roll thing here
		}
		
		if (attacker.getStrength() > defender.getStrength()){
			harm = harm.next();
		}
		
		//out till add horses
		/*if(defender.onHorse()){
			if(harm > defender.getHorse().getVulnerability()){
				return 2;
			}
		} else */ 
		if(true){//will have to change this to check if the defender is a character when denizens
			//are added
			if(defender.checkArmor(harm)){
				defender.checkIfDamaged(harm);
				if (harm == Weights.MEDIUM || harm == Weights.HEAVY ||
						harm == Weights.TREMENDOUS){
					return 1;
				}
			} else {
				if (defender.getVulnerability().compareTo(harm) >= 0){
					return 3;
				}
				if (!(harm == Weights.NEGLIGABLE)){
					return 1;
				}
				attacker.getWeapon().setAlert(false);
			}
		} /*else {
			if(defender.getVulnerability().compareTo(harm) >= 0){
				return 3;
			}
		}  add this when the denizens are added*/
		
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
