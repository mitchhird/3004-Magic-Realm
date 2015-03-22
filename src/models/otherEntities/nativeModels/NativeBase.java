package models.otherEntities.nativeModels;

import java.awt.Image;

import models.otherEntities.EntityBase;

public class NativeBase extends EntityBase{
	protected String nativeType;
	protected Image nativeImage;
	
	public Image getImage(){
		return nativeImage;
	}
}
