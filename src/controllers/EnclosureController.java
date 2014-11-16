package controllers;

import consoles.ConsoleEvents;
import views.EnclosureView;
import models.EnclosureModel;

public abstract class EnclosureController {

	private EnclosureModel model;
	private EnclosureView view;
	
	public EnclosureController(EnclosureModel modele, EnclosureView vue) {
		this.model = modele; 
		this.view = vue;
	}

	public void displayInformations() {
		this.view.showEnclosureStats( this.model.getName(), 
									""+this.model.getArea(), 
									""+this.model.getNbAnimalMax(), 
									""+this.model.getNbAnimalNow(), 
									convertDirtyness(this.model.getDirtyness()),
									this.model.getFoodValue()
									);
		
	}
	
	public void displayAnimals() {
		for (int i = 0 ; i < this.model.getAnimalList().size(); ++i) {
			this.model.getAnimalList().get(i).updateView();
		}
	}
	
	// Conversion dirtyness en texte (entre 0 et 5) 
	private String convertDirtyness(int faim) {
		final String[] tabDi = {"Propre","Normal", "Poussiéreux", "Sale", "Crade", "Dégueulasse"};
		return tabDi[faim];
	}

	@Override
	public String toString() {
		return this.view.returnEnclosureStats(this.model.getName(), 
				""+this.model.getArea(), 
				""+this.model.getNbAnimalMax(), 
				""+this.model.getNbAnimalNow(), 
				convertDirtyness(this.model.getDirtyness()),
				this.model.getFoodValue()
				);
	}
	
	// Utilisation de valeurs
	public int getStockFood() {
		return this.model.getFoodValue();
	}
	
	// Ajout/retrait animal
	public void addAnimal(AnimalController aniToAdd) {
		if(this.model.getNbAnimalNow() < this.model.getNbAnimalMax()) {
			this.model.addAnimal(aniToAdd);
			aniToAdd.setEnclosure(this);
		}
		else ConsoleEvents.getInstance().print("Enclos plein, vous ne pouvez pas ajouter cet animal");
	}
	
	
	// Gestion nourriture
	public void setFood(int FoodChange, boolean isPositive) {
		if (!isPositive) {
			this.model.setStockFood(this.model.getFoodValue()-FoodChange);
		} else {
			this.model.setStockFood(this.model.getFoodValue()+FoodChange);
		} // Si on retire
	}

	public void healAllInEnclosure() {
		for (int i = 0 ; i < this.model.getAnimalList().size(); ++i ) {
			this.model.getAnimalList().get(i).heal();
		}
		
	}
}
