package controllers;

import models.AquariumModel;
import models.AviaryModel;
import models.EnclosureModel;
import views.AquariumView;
import views.AviaryView;
import views.EnclosureView;

public class AquariumController extends EnclosureController {

	public AquariumController(String nom, int superficie, int nbrAnimauxMax) {
		super(new AquariumModel(nom, superficie, nbrAnimauxMax), new AquariumView());
		
	}

}
