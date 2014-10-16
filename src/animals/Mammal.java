package animals;

public abstract class Mammal extends Animal {
	
	public Mammal(String newName, Sex newSex, int newWeight, int newHeight) {
		super(newName, newSex, newWeight, newHeight);
	}

	public abstract void giveBirth();
}
