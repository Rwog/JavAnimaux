package views;

public class AnimalView {
	
	public void showAnimalStats(String nom, String poids, String taille, String sexe, String age, String faim, String estEndormi, String sante) {
		System.out.println("- " + nom + " ("+ sexe +") - Sant� [" 
							+ sante + " %] Faim ["+ faim +"] _ " 
							+ poids + ", " + taille + ", " + age + estEndormi + ".");
	}
}
