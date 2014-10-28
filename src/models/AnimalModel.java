package models;

abstract public class AnimalModel implements Runnable {

	public enum Sex{m,f};

	// Glob
	public static final int MAX_HEIGHT 	= 6;
	public static final int MAX_WEIGHT 	= 9;
	public static final int MAX_AGE 	= 5;
	public static final int MAX_HUNGER 	= 4;
	
	// Vars
	private String name; 
	private int weight; 	  // 0-9 > obèse
	private int height; 	  // 0-6 > géant
	private Sex sex;		  // m/f
	private int age;		  // 0-5 > mort par vieillesse
	private int hunger; 	  // 0-4 > affamé
	private boolean isAsleep; // false-true > endormi
	private int health;       // 0-100 / 0 = mort non-naturelle
	
	//getters
	public String 	getName() 	{return name;}
	public int 		getWeight() {return weight;}
	public int 		getHeight() {return height;}
	public Sex 		getSex() 	{return sex;}
	public int 		getAge() 	{return age;}
	public int 		getHunger() {return hunger;}
	public boolean 	isAsleep() 	{return isAsleep;}
	public int 		getHealth() {return health;}
	
	//setters
	public void 	setName(String name) 		{this.name = name;}
	public void 	setWeight(int weight) 		{this.weight = weight;}
	public void 	setHeight(int height) 		{this.height = height;}
	public void 	setSex(Sex sex) 			{this.sex = sex;}
	public void 	setAge(int age) 			{this.age = age;}
	public void 	setHunger(int hunger) 		{this.hunger = hunger;}
	public void 	setAsleep(boolean isAsleep) {this.isAsleep = isAsleep;}
	public void 	setHealth(int health) 		{this.health = health;}
	
	//Functs
	public abstract void eat();
	public abstract void cry();
	public abstract void heal();
	public abstract void toggleSleepMode();
	
	// Const
	public AnimalModel(String newName, Sex newSex, int newWeight, int newHeight) {
		super();
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
