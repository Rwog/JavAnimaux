package controllers;

import models.AnimalModel;
import views.AnimalView;

public abstract class MammalController extends AnimalController implements Runnable {

	public MammalController(AnimalModel modele, AnimalView vue) {
		super(modele, vue);
	}

}
