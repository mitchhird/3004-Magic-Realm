package models.chitModels.EnvironmentChit;

public class WarningChit extends EnvironmentChit {

	public WarningChit(int num, String description, String imageToLoad) {
		super(num, description,imageToLoad);
		// TODO Auto-generated constructor stub
	}

	public WarningChit clone () {
		return new WarningChit (this.clearingNum, this.description, this.imageToLoad);
	}
}
