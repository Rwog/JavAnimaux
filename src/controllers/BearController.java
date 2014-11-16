package controllers;

import models.BearModel;
import models.AnimalModel.Sex;
import views.MammalView;
import views.BearView;

public class BearController extends MammalController {

	public BearController(String newBearName, Sex sexe) {
		super(new BearModel(newBearName, sexe), new BearView());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
