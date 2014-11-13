package controllers;

import models.PenguinModel;
import models.AnimalModel.Sex;
import views.PenguinView;

public class PenguinController extends OtherController {

	public PenguinController(String newPenguinName, Sex sexe) {
		super(new PenguinModel(newPenguinName, sexe), new PenguinView());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
