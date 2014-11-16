package views;

import consoles.ConsoleEvents;

public abstract class AnimalView {
	
	// Exemple d'output:  - Tigre59 (m) - Sant� [59%] Faim [Affam�] _ Lourd, Grand, Adolescent _ Endormi.
	public void displayInformations(String nom, String poids, String taille, String sexe, String age, String faim, String estEndormi, String sante) {
		ConsoleEvents.getInstance().print("- " + nom + " ("+ sexe +") - Sant� [" 
							+ sante + " %] Faim ["+ faim +"] _ " 
							+ poids + ", " + taille + ", " + age + estEndormi + ".");
	}
	
	public void sendInformation(String message) {
		ConsoleEvents.getInstance().print(message);
	};
	
}
