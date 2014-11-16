package controllers;

import models.PenModel;
import views.PenView;

public class PenController extends EnclosureController {

	public PenController(String nom, int superficie, int nbrAnimauxMax) {
		super(new PenModel(nom, superficie, nbrAnimauxMax), new PenView());
	}

}
