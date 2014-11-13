package controllers;

import models.GoldfishModel;
import models.AnimalModel.Sex;
import views.GoldfishView;

public class GoldfishController extends OtherController {

	public GoldfishController(String newGoldfishName, Sex sexe) {
		super(new GoldfishModel(newGoldfishName, sexe), new GoldfishView());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
