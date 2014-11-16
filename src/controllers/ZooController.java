package controllers;

import java.util.ArrayList;

import consoles.ConsoleEvents;
import views.ZooView;
import models.ZooModel;

public class ZooController {

	private ZooModel model;
	private ZooView view;
	
	public ZooController(String nom, int maximum) {
		this.model = new ZooModel(nom, maximum);
		this.view = new ZooView();
	}
	
	public ArrayList<EnclosureController> getListEnclosure() {
		return this.model.getListEnclosure();
	}
	
	public void showMaxEnclosure() {
		view.showNbEnclosMax(model.getNbEnclosureMax());
	}
	
	public void showAllEnclosures() {
		for(int i = 0; i < this.model.getListEnclosure().size()+0 ;++i) {
			ConsoleEvents.getInstance().print("["+i+ "]  --- " + this.model.getListEnclosure().get(i));
			;
		}
	}
	
	public void addEnclosure(EnclosureController enccadd) {
		this.model.addEnclosure(enccadd);
	}
	
	public void removeEnclosure(EnclosureController enccdel) {
		this.model.delEnclosure(enccdel);
	}
	
}
