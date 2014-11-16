package controllers;

import views.SharkView;
import models.SharkModel;
import models.AnimalModel.Sex;

public class SharkController extends OtherController {

	public SharkController(String newSharkName, Sex sexe) {
		super(new SharkModel(newSharkName, sexe), new SharkView());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
