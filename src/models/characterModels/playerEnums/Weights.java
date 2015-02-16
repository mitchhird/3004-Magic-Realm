package models.characterModels.playerEnums;

//specific weights for character classes

public enum Weights {
	NEGLIGABLE,
	LIGHT,
	MEDIUM,
	HEAVY,
	TREMENDOUS;
	
	public Weights next() {
		return values()[ordinal() +1];
	}

}
