package controllers;

import consoles.ConsoleEvents;
import views.ZooView;
import models.ZooModel;

public class ZooController {

	private ZooModel model;
	private ZooView view;
	
	public ZooController(ZooModel mod, ZooView vie) {
		this.model = mod;
		this.view = vie;
	}
	
	
	public void showMaxEnclosure() {
		view.showNbEnclosMax(model.getNbEnclosureMax());
	}
	
	
}
