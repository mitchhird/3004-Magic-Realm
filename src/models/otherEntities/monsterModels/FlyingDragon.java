package models.otherEntities.monsterModels;

public class FlyingDragon extends MonsterBase {
	
	private static final long serialVersionUID = 1236103107833384753L;

	public FlyingDragon(String clearingName){
		super(clearingName);
		monsterType = "FlyingDragon";
		monsterImage = "/monsters_c/dragon_flying.gif";
	}

	@Override
	public MonsterBase clone() {
		FlyingDragon returnVal = new FlyingDragon(this.clearningThisOn);
		returnVal.monsterType = this.monsterType;
		returnVal.monsterImage = this.monsterImage;
		return null;
	}
}
