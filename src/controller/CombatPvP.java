package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import utils.GameUtils;
import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Weights;
import models.chitModels.Chit;
import models.otherEntities.EntityBase;

public class CombatPvP {
	private List<Clearing> currClearings;
	private boolean lastRound, currRound;
	private PlayerBase[] currOrder;
	//will be the entry point in the end for pvp combat
	public void combatPvP(PlayerBase[] players){
		currClearings = new ArrayList<Clearing>();
		lastRound = false;
		for(int i = 0; i < players.length; ++i)
			currClearings.add(players[i].getCurrentClearing());
		while(true){
			currRound = false;
			
			preparation(players);
			
			for(int i = 0; i < players.length; ++i){
				for(int j = 0; j < currClearings.size(); ++j){
					if(!currClearings.get(j).getEntitiesInClearing().contains(players[i])){
						currClearings.remove(j);
					}
				}
			}
			if((currRound && lastRound) || (currClearings.size() == 0)){
				break;
			}
			lastRound = currRound;
		}
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
		//have to see if natives will attack players
		//can increase how the natives will act "buy drinks"
		//non-alert native horses

		
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
		for(int i = 0; i < players.length; ++i){
			Set<EntityBase> unhidden = players[i].getCurrentClearing().getUnhiddenEntities();
			if(unhidden.size() != 0){
				int f = players[i].checkLure(unhidden);//-----------------------------view
				if(f > 0){
					players[i].unHide();
				}
			}
		}
		
//		if (unassigned non-player controlled entities in clearing){ more relevant for when monsters
//			if (unhidden in clearing){
//				randomAssignments(players);
//			}
//		}
		
		deployment(players);
	}
	
	private void randomAssignments(PlayerBase[] players/*, EntityBase[] unassigned*/){
		//this will take the unassigned and will assign them to attack one of the players/hirings
		//for that clearing
		//assigned to UNHIDDEN characters in the clearing
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
		for(int i = 0; i < players.length; ++i){
			
//			for each see if they want to charge player
//				if so both unhidden
			players[i].setCharge();//-----------------------------------
			if(players[i].chargingPlayer() != null){
				players[i].chargingPlayer().unHide();
				players[i].unHide();
			}
		}
		
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
		for(int i = 0; i < players.length; ++i){
			if(players[i].chargingPlayer() == null){
				continue;
			} else {
				int f = players[i].selection();//---------------------
				if(f != 0)
					continue;
			}
			players[i].selection2();//-------------------
		}
//		rotate through and check if charged another
//			if so then continue
//			else
//				see if alert weapon, run, or fly (can cast spell here)
//				if not
//					may alert any 1 belonging or abandon any number of belongings
		
		currOrder = GameUtils.randomOrder(players);
		
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
		//rotate through attention chits and select attack targets
		
//		will have to go through each player to setup their targets and defence/attack
		
		for(int i = 0; i < players.length; ++i){
			players[i].selectTarget();//------------------------------
			//should be visible to everyone and go in order
		}
		
		//secret attack, manuever, and armor for each character
		
		for(int i = 0; i < players.length; ++i){
			setTactics(players[i]);//------------------------
		}
		
		//have to send all information to all players
		
		//roll for repositioning and change of tactics
		for(int i = 0; i < players.length; ++i){
			int f = players[i].rollTacChange();//------------------------
			if (f > 0){
				setTactics(players[i]);//------------------------------
			}
		}
		
		//loops through the players and resolves attacks in each
		for(int i = 0; i < currOrder.length; ++i){
			PlayerBase[] clearingOrder = new PlayerBase[currOrder.length];
			int currNum = 0;
			//loops through all the players to see if they have are in the same clearing
			for(int j = 0; j < currOrder.length; j++){
				if(currOrder[i].getCurrentClearing() == currOrder[j].getCurrentClearing()){
					clearingOrder[currNum++] = currOrder[i];
				}
			}
			//sees if the current players clearing is in the list of current clearings
			//will remove if there and run the melee for that clearing else next
			for(int j = 0; j < currClearings.size(); ++j){
				if(currClearings.get(j) == currOrder[i].getCurrentClearing()){
					currClearings.remove(j);
					resolveAttacks(clearingOrder, currNum);
				}
			}
		}
	}
	
	private void setTactics(PlayerBase player){
//		TODO
//		player.setAttack();
//		player.setManuever();
//		player.setArmor();
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
	
	
	////TODO make sure this works properly - Albert
	private void resolveAttacks(PlayerBase[] players, int maxPlayers) {
		PlayerBase[] orderAttacks = new PlayerBase[maxPlayers];
		int firstAttack = 0, currAttackNum = 0;
		int firstAttacker = 0;
		PlayerBase attacker, defender;
		// check how the currplayer is attacking
		// who is the attacker and who is defender
		
		for(int i = 0; i < maxPlayers; ++i){
			for(int j = 0; j < maxPlayers; ++j){
				if(players[j].getWeapon().getWeaponLength() > firstAttack){
					firstAttacker = j;
					firstAttack = players[j].getWeapon().getWeaponLength();
				}
			}
			orderAttacks[currAttackNum++] = players[firstAttacker];
			firstAttack = 0;
		}
		
		attacker = orderAttacks[0];
		defender = attacker.attackList();
		orderAttacks = removeFirst(orderAttacks);
		
		//check all the lengths of weapons in clearning
		//check length then speed if equal
		//then if same for both both attack and hit the other
		//both can die
		while(true){
			if(!(defender.isLiving())){
				continue;
			}
			
			if(!(attacker.isLiving())){
				continue;
			}
			
			int wounds1 = 0, wounds2 = 0;
			if(defender.getWeapon().getWeaponLength() == attacker.getWeapon().getWeaponLength() &&
			   defender.getWeapon().getWeaponSpeed()  == attacker.getWeapon().getWeaponSpeed()){
				wounds1 = checkAttack(attacker, defender);
				wounds2 = checkAttack(defender, attacker);
			}
			
			attacker.setWounds(wounds1);
			defender.setWounds(wounds2);
			
			attacker = nextAttacker(players);
			defender = attacker.attackList();
		}
	}
	
	private PlayerBase[] removeFirst(PlayerBase[] players){
		int i = 0;
		while(true){
			players[i] = players[++i];
			if(players[i] == null)
				break;
		}
		return players;
	}
	
	private PlayerBase nextAttacker(PlayerBase[] entities){
		PlayerBase nAttacker = null;
		//check for more attacks at this speed and length
		
	//	check for more attacks at highest speed
		//currplayer = findPlayer(players);
		return nAttacker;
	}
	
	private int checkAttack(PlayerBase attacker, PlayerBase defender){
		int damage = 0;
		if (!(defender.checkIfHit(attacker.getAttackDirection()))){
			damage = attackHits(attacker, defender);
		} else if (attacker.getWeapon().getWeaponSpeed() == defender.getSpeed()) {
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
		int addStars = 0;
		
		harm = attacker.getWeapon().getHarmLevel();
		
		if (attacker.getWeapon().getStars() > 0) {
			if (defender.armorBlocks(attacker.getWeapon().getAttack())){//have to see what these conditions are
				addStars = attacker.getWeapon().getStars();
			}
		}
		
		if (attacker.getWeapon().hasMissles()){
			//do some roll thing here
			//GameUtils.missleTable(roll);
		}
		
		
		//TODO
		if (attacker.getStrength() > defender.getStrength()){
			harm = harm.next();
		}
		
		for(int i =0; i < addStars; ++i){
			if(harm != Weights.TREMENDOUS){
				harm = harm.next();
			} else {
				i = addStars;
			}
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
