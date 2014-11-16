package views;

import consoles.ConsoleEvents;

public abstract class EnclosureView {

	// Exemple d'output:  => Enclos 'Voli�re3' [10/25] _ Nourriture : 100% _ Etat : Crade _ Superficie : 25m�.
	public void showEnclosureStats(String nom, String area, String nbAnimauxMax, String nbAnimauxActuel, String salete, int food) {
		ConsoleEvents.getInstance().print("=> Enclos \'"+ nom +"\' ["+ nbAnimauxActuel + "/" + nbAnimauxMax + "] _ Nourriture : "+ food +" _ Etat : " + salete + " _ Superficie : " + area + "m�.");
	}
	
	public String returnEnclosureStats(String nom, String area, String nbAnimauxMax, String nbAnimauxActuel, String salete, int food) {
		return "=> Enclos \'"+ nom +"\' ["+ nbAnimauxActuel + "/" + nbAnimauxMax + "] _ Nourriture : "+ food +" _ Etat : " + salete + " _ Superficie : " + area + "m�.";
	}

}
