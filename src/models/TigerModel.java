package models;

import interfaces.Wanderer;


public class TigerModel extends MammalModel implements Wanderer {
	
	public TigerModel(String nom, Sex sexe) {
		super(nom, sexe);
	}

	@Override
	public void roam() {
		/* L'animal tourne en rond dans son enclos... quelle cruaut� ! */
		
	}

	@Override
	public void giveBirth() {
		// TODO Auto-generated method stub
		
	}



	
}
