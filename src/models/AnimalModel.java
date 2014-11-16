package models;

import controllers.EnclosureController;

public abstract class AnimalModel {

	public enum Sex{m,f};

	// Glob
	public static final int MAX_HEIGHT 	= 6;
	public static final int MAX_WEIGHT 	= 9;
	public static final int MAX_AGE 	= 50;
	public static final int MAX_HUNGER 	= 4;

	// Vars
		private String name; 
		private int weight; 	  // 0-9 > ob�se
		private int height; 	  // 0-6 > g�ant
		private Sex sex;		  // m/f
		private int age;		  // 0-50 > mort par vieillesse
		private int hunger; 	  // 0-4 > affam�
		private boolean isAsleep; // false-true > endormi
		private int health;       // 0-100 / 0 = mort non-naturelle
		
		private String state;     // Etat pour le log de mort
		private EnclosureController encNow; // Son enclos actuel
		
	// Constructeur
	public AnimalModel(String newName, Sex newSex) {
		this.name = newName;
		this.sex = newSex;
		this.weight = 0;
		this.height = 0;
		this.age = 0;
		this.hunger = 0;
		this.health = 100;
		this.isAsleep = false;	
		this.state = "vivant";		
	}
	
	//getters
	public String 	getName() 	{return this.name;}
	public int 		getWeight() {return this.weight;}
	public int 		getHeight() {return this.height;}
	public Sex 		getSex() 	{return this.sex;}
	public int 		getAge() 	{return this.age;}
	public int 		getHunger() {return this.hunger;}
	public boolean 	isAsleep() 	{return this.isAsleep;}
	public int 		getHealth() {return this.health;}
	public String 	getState() 	{return this.state;}
	public EnclosureController getEnclosure() {return this.encNow;}

	//setters
	public void 	setName(String newName) 		{this.name = newName;}
	public void 	setWeight(int newWeight) 		{this.weight = newWeight;}
	public void 	setHeight(int newHeight) 		{this.height = newHeight;}
	public void 	setSex(Sex newSex) 			{this.sex = newSex;}
	public void 	setAge(int newAge) 			{this.age = newAge;}
	public void 	setHunger(int newHunger) 		{this.hunger = newHunger;}
	public void 	setAsleep(boolean newIsAsleep) {this.isAsleep = newIsAsleep;}
	public void 	setHealth(int newHealth) 	{this.health = newHealth;}
	public void 	setState(String newState) 	{this.state = newState;}
	public void 	setEnclosure(EnclosureController newEnc) {this.encNow = newEnc;}

}
