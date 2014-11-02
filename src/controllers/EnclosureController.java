package controllers;

import views.EnclosureView;
import models.EnclosureModel;

public class EnclosureController {

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
									convertDirtyness(this.model.getDirtyness())
									);
		
	}
	
	
	// Conversion dirtyness en texte (entre 0 et 5) 
	private String convertDirtyness(int faim) {
		final String[] tabDi = {"Propre","Normal", "Poussiéreux", "Sale", "Crade", "Dégueulasse"};
		return tabDi[faim];
	}
	
}
