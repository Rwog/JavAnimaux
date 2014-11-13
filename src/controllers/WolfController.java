package controllers;

import models.AnimalModel.Sex;
import models.WolfModel;
import models.ZooModel;
import views.MammalView;
import views.WolfView;
import views.ZooView;

public class WolfController extends MammalController {

	public WolfController(String newWolfName, Sex sexe) {
		super(new WolfModel(newWolfName, sexe), new WolfView());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
