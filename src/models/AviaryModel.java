package models;

public class AviaryModel extends EnclosureModel {

	private int height;
	
	public AviaryModel(String nom, int superficie, int nbAnimauxMax) {
		super(nom, superficie, nbAnimauxMax);
	}

	// getter
	public int getHeight() { return this.height; }
	
	// setter
	public void setHeight(int newHeight) { this.height = newHeight; }
}
