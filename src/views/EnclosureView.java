package views;

public abstract class EnclosureView {

	// Exemple d'output:  => Enclos 'Voli�re3' [10/25] _ Etat : Crade _ Superficie : 25m�.
	public void showEnclosureStats(String nom, String area, String nbAnimauxMax, String nbAnimauxActuel, String salete) {
		System.out.println("=> Enclos \'"+ nom +"\' ["+ nbAnimauxActuel + "/" + nbAnimauxMax + " _ Etat : " + salete + " _ Superficie : " + area + "m�.");
	}
}
