package models;

import animal_behaviour.Wanderer;


public class TigerModel extends MammalModel implements Wanderer {
	
	public TigerModel(String nom, Sex sexe) {
		super(nom, sexe);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void roam() {
		/* L'animal tourne en rond dans son enclos... quelle cruauté ! */
		
	}

	@Override
	public void giveBirth() {
		// TODO Auto-generated method stub
		
	}



	
}
