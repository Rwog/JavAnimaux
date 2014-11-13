package controllers;

import models.TigerModel;
import models.WolfModel;
import models.AnimalModel.Sex;
import views.MammalView;
import views.TigerView;
import views.WolfView;

public class TigerController extends MammalController {

	public TigerController(String newTigerName, Sex sexe) {
		super(new TigerModel(newTigerName, sexe), new TigerView());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
