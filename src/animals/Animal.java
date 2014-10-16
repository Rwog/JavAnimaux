package animals;

public abstract class Animal implements I_Animal {
	
	public enum Sex{m,f};

	// Vars
	private String name;
	private int weight;
	private int height;
	private Sex sex;
	private int age;
	private int hunger;
	private boolean isAsleep;
	private int health;
	
	// Functs
	public abstract void eat();
	public abstract void cry();
	public abstract void heal();
	public abstract void toggleSleepMode();
	
	// Const
	public Animal(String newName, Sex newSex, int newWeight, int newHeight) {
		this.name = newName;
		this.sex = newSex;
		this.weight = newWeight;
		this.height = newHeight;
		this.age = 0;
		this.hunger = 0;
		this.health = 100;
		this.isAsleep = false;		
	}
	
}
