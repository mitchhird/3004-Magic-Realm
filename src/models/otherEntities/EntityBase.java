package models.otherEntities;


/*
 * super class for all other entities that exist in the world
 * could be natives, monsters, etc.
 */
public class EntityBase {
	protected boolean hidden;
	
	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
}
