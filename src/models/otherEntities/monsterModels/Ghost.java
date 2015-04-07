package models.otherEntities.monsterModels;


public class Ghost extends MonsterBase {

	private static final long serialVersionUID = 8076776123094247202L;

	public Ghost(String clearingOn){
		super(clearingOn, "/monsters_c/ghost.gif");
		monsterType = "Giant";
	}
	
	@Override
	public String toString() {
		return "Ghost, Attacking: " + combatDirection;
	}

	@Override
	public MonsterBase clone() {
		Ghost newGhost = new Ghost(this.clearningThisOn);
		return newGhost;
	}
}
