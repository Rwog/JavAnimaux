package models;


public abstract class MammalModel extends AnimalModel {

	public MammalModel(String newName, Sex newSex) {
		super(newName, newSex);
	}
	
	public abstract void giveBirth();

}
