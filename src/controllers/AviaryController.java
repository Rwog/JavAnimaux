package controllers;

import models.AviaryModel;
import models.EnclosureModel;
import views.AviaryView;
import views.EnclosureView;

public class AviaryController extends EnclosureController {

	public AviaryController(String nom, int superficie, int nbrAnimauxMax) {
		super(new AviaryModel(nom, superficie, nbrAnimauxMax), new AviaryView());
		
	}

}
