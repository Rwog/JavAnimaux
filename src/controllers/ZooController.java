package controllers;

import views.ZooView;
import models.ZooModel;

public class ZooController {

	private ZooModel model;
	private ZooView view;
	
	public ZooController(String nom, int maximum) {
		this.model = new ZooModel(nom, maximum);
		this.view = new ZooView();
	}
	
	
	public void showMaxEnclosure() {
		view.showNbEnclosMax(model.getNbEnclosureMax());
	}
	
	
}
