package controllers;

import models.AnimalModel;
import views.AnimalView;

public abstract class MammalController extends AnimalController {

	public MammalController(AnimalModel modele, AnimalView vue) {
		super(modele, vue);
	}

}
