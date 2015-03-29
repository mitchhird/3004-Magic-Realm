package models.otherEntities.monsterModels;


public class Ghost extends MonsterBase {

	private static final long serialVersionUID = 8076776123094247202L;

	public Ghost(String clearingOn){
		super(clearingOn);
		monsterType = "Giant";
		monsterImage = "/monsters_c/ghost.gif";
	}

	@Override
	public MonsterBase clone() {
		Ghost newGhost = new Ghost(this.clearningThisOn);
		newGhost.monsterType = this.monsterType;
		newGhost.monsterImage = this.monsterImage;
		return newGhost;
	}
}
