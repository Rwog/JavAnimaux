package controllers;

import models.EagleModel;
import models.AnimalModel.Sex;
import views.OtherView;
import views.EagleView;

public class EagleController extends OtherController {

	public EagleController(String newEagleName, Sex sexe) {
		super(new EagleModel(newEagleName, sexe), new EagleView());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
