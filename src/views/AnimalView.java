package views;

public abstract class AnimalView {
	
	public void showAnimalStats(String nom, String poids, String taille, String sexe, String age, String faim, String estEndormi, String sante) {
		System.out.println("- " + nom + " ("+ sexe +") - Santé [" 
							+ sante + " %] Faim ["+ faim +"] _ " 
							+ poids + ", " + taille + ", " + age + estEndormi + ".");
	}
	
	public void sendInformation(String message) {
		System.out.println(message);
	};
	
}
