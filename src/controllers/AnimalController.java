package controllers;
import models.AnimalModel;
import models.AnimalModel.Sex;
import views.AnimalView;


public class AnimalController {

	private AnimalModel model;
	private AnimalView view;
	
	public AnimalController(AnimalModel modele, AnimalView vue) {
		this.model = modele;
		this.view = vue;
		
	}
	
	public void updateView() {
		view.showAnimalStats(	model.getName(), 
								convertWeight(model.getWeight()), 
								convertHeight(model.getHeight()),	
								convertSex(model.getSex()), 
								convertAge(model.getAge()), 
								convertHunger(model.getHunger()), 
								convertIsAsleep(model.isAsleep()), 
								convertHealth(model.getHealth())
							);
	}
	
	
	// Conversions
	
	// Le poids est un int entre 0 et 9
	private String convertWeight(int poids) {
		final String[] tabW = {"Anorexique", "Maigre","Mince","Léger","Normal","Lourd","Enrobé","Surpoids", "Obèse"};
		return tabW[poids];
	}
	
	// La taille est un int entre 0 et 6
	private String convertHeight(int taille) {
		final String[] tabH = {"Minuscule", "Très petit","Petit","Normal","Grand","Très grand","Géant"};
		return tabH[taille];
	}
	
	// Le sexe est soit m ou f
	private String convertSex(Sex sexe) {
		if (sexe == Sex.m) {
			return "m";
		}
		return "f";
	}
	
	// L'âge est un int entre 0 et 5
	private String convertAge(int age) {
		final String[] tabA = {"Bébé", "Jeune","Adolescent","Adulte","Senior","Ancien"};
		return tabA[age];
	}
	
	// La faim est un int entre 0 et 4 
	private String convertHunger(int faim) {
		final String[] tabHu = {"Plein" , "Repu", "Normal", "Ventre vide" , "Affamé"};
		return tabHu[faim];
	}
	
	// L'état de sommeil est soit true, soit false
	private String convertIsAsleep(boolean estEndormi) {
		if (estEndormi) {
			return "Endormi";
		}
		return "Éveillé";
	}
	
	private String convertHealth(int sante) {
		return (""+sante);
	}
}
