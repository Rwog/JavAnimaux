package controllers;

import models.AnimalModel.Sex;
import models.WolfModel;
import views.MammalView;
import views.WolfView;

public class WolfController extends MammalController {

	public WolfController(String newWolfName, Sex sexe) {
		
		super(new WolfModel(newWolfName, sexe), new WolfView());
	}

}
