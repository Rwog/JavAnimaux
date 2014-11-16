package models;


public abstract class OtherModel extends AnimalModel {

	public OtherModel(String newName, Sex newSex) {
		super(newName, newSex);
	}

	public abstract void layEgg();
}
