package models;

public abstract class EnclosureModel {

	private String name;
	private int area;
	private int dirtyness; 		// 0-5 > dégueulasse
	private int nbAnimalMax;
	private int nbAnimalNow;
	
	// Constructeur
	public EnclosureModel(String nom, int superficie, int nbAnimauxMax) {
		this.name = nom;
		this.area = superficie;
		this.dirtyness = 0 ;
		this.nbAnimalMax = nbAnimauxMax;
		this.nbAnimalNow = 0;
	}

	// getters
	public String getName() 	{ return name; }
	public int getArea() 		{ return area; }
	public int getDirtyness() 	{	return dirtyness; }
	public int getNbAnimalMax() { return nbAnimalMax; }
	public int getNbAnimalNow() { return nbAnimalNow; }
	
	// setters 
	public void setName(String name) 			{ this.name = name; }
	public void setArea(int area) 				{ this.area = area; }
	public void setDirtyness(int dirtyness) 	{ this.dirtyness = dirtyness; }
	public void setNbAnimalMax(int nbAnimalMax) { this.nbAnimalMax = nbAnimalMax; }
	public void setNbAnimalNow(int nbAnimalNow) { this.nbAnimalNow = nbAnimalNow; }
	
}
