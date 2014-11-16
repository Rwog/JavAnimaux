package controllers;

import models.AnimalModel;
import views.AnimalView;

public abstract class OtherController extends AnimalController implements Runnable {

	public OtherController(AnimalModel modele, AnimalView vue) {
		super(modele, vue);
	}

}
