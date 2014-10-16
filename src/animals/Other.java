package animals;

public abstract class Other extends Animal {

	public Other(String newName, Sex newSex, int newWeight, int newHeight) {
		super(newName, newSex, newWeight, newHeight);
	}

	public abstract void layEgg();
}
