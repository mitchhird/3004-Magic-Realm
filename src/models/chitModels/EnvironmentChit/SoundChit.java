package models.chitModels.EnvironmentChit;

public class SoundChit extends EnvironmentChit {

	private static final long serialVersionUID = -407392454631599190L;

	public SoundChit(int num, String description, String imageToLoad) {
		super(num, description, imageToLoad);
		// TODO Auto-generated constructor stub
	}
	
	public SoundChit clone() {
		SoundChit returnVal = new SoundChit(this.clearingNum, this.description, this.imageToLoad);
		return returnVal;
	}

}
