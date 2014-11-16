package models;

import java.util.ArrayList;

import controllers.AnimalController;

public abstract class EnclosureModel {

	private String name;
	private int area;
	private int dirtyness; 		// 0-5 > degueulasse
	private int nbAnimalMax;
	private int nbAnimalNow; 
	private int stockFood; // Max 100 (set à 100 quand l'employé le remplit, même s'il en reste)

	private ArrayList<AnimalController> listAnimal;

	// Constructeur
	public EnclosureModel(String nom, int superficie, int nbAnimauxMax) {
		this.name = nom;
		this.area = superficie;
		this.dirtyness = 0 ;
		this.nbAnimalMax = nbAnimauxMax;
		this.nbAnimalNow = 0;
		this.stockFood = 0;
		this.listAnimal = new ArrayList<AnimalController>();
	}

	// getters
	public String getName() 	{ return this.name; }
	public int getArea() 		{ return this.area; }
	public int getDirtyness() 	{	return this.dirtyness; }
	public int getNbAnimalMax() { return this.nbAnimalMax; }
	public int getNbAnimalNow() { return this.nbAnimalNow; }
	public ArrayList<AnimalController> getAnimalList() { return this.listAnimal;}
	public int getFoodValue() { return this.stockFood;}


	// setters 
	public void setName(String name) 			{ this.name = name; }
	public void setArea(int area) 				{ this.area = area; }
	public void setDirtyness(int dirtyness) 	{ this.dirtyness = dirtyness; }
	public void setNbAnimalMax(int nbAnimalMax) { this.nbAnimalMax = nbAnimalMax; }
	public void setNbAnimalNow(int nbAnimalNow) { this.nbAnimalNow = nbAnimalNow; }
	public void setStockFood(int newStockFood) { 
		// A 100 max !
		if (newStockFood > 100)
			newStockFood = 100;
		else if (newStockFood < 0)
			newStockFood = 0;
		this.stockFood = newStockFood; 
	}

	// add/rem
	public void addAnimal(AnimalController aniToAdd) {if (this.nbAnimalNow < this.nbAnimalMax) this.listAnimal.add(aniToAdd); ++this.nbAnimalNow;}
	public void delAnimal(AnimalController aniToDel) {this.listAnimal.remove(aniToDel);}

}
