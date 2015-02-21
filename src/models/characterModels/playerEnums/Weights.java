package models.characterModels.playerEnums;

//specific weights for character classes

public enum Weights {
	NEGLIGABLE(0),
	LIGHT(1),
	MEDIUM(2),
	HEAVY(3),
	TREMENDOUS(4);
	
	private int WEIGHT_VALUE;
	
	Weights (int weightValue) {
		WEIGHT_VALUE = weightValue;
	}
	
	public int getWeightValue (){
		return WEIGHT_VALUE;
	}
	
	public Weights next() {
		if (this == TREMENDOUS) {
			return TREMENDOUS;
		}
		return values()[(this.ordinal() + 1) % values().length];
	}
	
	public Weights prev() {
		if (this == NEGLIGABLE) {
			return NEGLIGABLE;
		}
		return values()[(this.ordinal() - 1) % values().length];
	}

}
