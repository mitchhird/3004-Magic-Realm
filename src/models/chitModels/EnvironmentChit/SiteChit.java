package models.chitModels.EnvironmentChit;

public class SiteChit extends EnvironmentChit {

	public SiteChit(int num, String description, String imageToLoad) {
		super(num, description, imageToLoad);
		// TODO Auto-generated constructor stub
	}
	
	public SiteChit clone () {
		return new SiteChit(this.clearingNum, this.description, this.imageToLoad);
	}

}
