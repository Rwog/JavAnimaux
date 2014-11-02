package models;

import interfaces.Aquatic;
import interfaces.Flyer;
import interfaces.Wanderer;

public class PenguinModel extends OtherModel implements Flyer, Wanderer, Aquatic {

	public PenguinModel(String newName, Sex newSex) {
		super(newName, newSex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub

	}

	@Override
	public void roam() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub

	}

	@Override
	public void layEgg() {
		// TODO Auto-generated method stub
		
	}

}
