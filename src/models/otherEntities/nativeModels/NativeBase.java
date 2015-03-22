package models.otherEntities.nativeModels;

import java.awt.Image;

import models.BoardModels.Clearing;
import models.otherEntities.EntityBase;

public class NativeBase extends EntityBase{
	protected String nativeType;
	protected Image nativeImage;
	
	public Image getImage(){
		return nativeImage;
	}
	
	public void setHomeClearing(Clearing homeClearing) {
		this.homeClearing = homeClearing;
	}
	public void setCurrentClearing(Clearing currentClearing) {
		this.currentClearing = currentClearing;
	}
}
