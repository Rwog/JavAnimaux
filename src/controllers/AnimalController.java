package controllers;

import models.AnimalModel;
import models.AnimalModel.Sex;
import views.AnimalView;

public abstract class AnimalController implements Runnable {

	// Mod�le et vue associ�e � ce contr�lleur
	private AnimalModel model;
	private AnimalView view;

	// Constructeur
	public AnimalController(AnimalModel modele, AnimalView vue) {
		this.model = modele;
		this.view = vue;

	}

	// Changer l'affichage
	public void updateView() {
		view.displayInformations(	model.getName(), 
									convertWeight(model.getWeight()), 
									convertHeight(model.getHeight()),	
									convertSex(model.getSex()), 
									convertAge(model.getAge()), 
									convertHunger(model.getHunger()), 
									convertIsAsleep(model.isAsleep()), 
									convertHealth(model.getHealth())
								);
	}

	// Mort de l'animal
	public void kill(AnimalModel animal) {
		/*Animal mort !*/
	}

	// Vieillissement
	public void growOld(AnimalModel animal) {
		int newAge = animal.getAge()+1;
		if (newAge == AnimalModel.MAX_AGE) { kill(animal); }
		animal.setAge(newAge);
	}

	// Grandir
	public void growHigher(AnimalModel animal) {
		int newHeight = animal.getHeight()+1;
		if (newHeight == AnimalModel.MAX_HEIGHT) {
			/* Not possible */
		}
		animal.setHeight(newHeight);
	}

	// Grossir
	public void growBigger(AnimalModel animal) {
		int newWeight = animal.getHeight()+1;
		if (newWeight == AnimalModel.MAX_WEIGHT) {
			/* Not possible */
		} else {
			animal.setWeight(newWeight);
		}
	}

	// Maigrir
	public void growThinner(AnimalModel animal) {
		int newWeight = animal.getHeight()-1;
		if (newWeight == 0) { 
			/* Not possible */ 
		} else { 
			animal.setWeight(newWeight); 
		}
	}

	// Augmenter faim
	public void moreHungry(AnimalModel animal) {
		int newHunger = animal.getHunger()+1;
		if (newHunger == AnimalModel.MAX_HUNGER) { 
			/* Not possible */ 
		} else { 
			animal.setHunger(newHunger); 
		}
	}

	// Diminuer faim
	public void lessHungry(AnimalModel animal) {
		int newHunger = animal.getHunger()-1;
		if (newHunger == 0) { 
			/* Not possible */ 
		} else { 
			animal.setHunger(newHunger); 
		}
	}

	//////////////////
////// Fonctions de //
////// conversions  //
	//////////////////

	// Le poids est un int entre 0 et 9
	private String convertWeight(int poids) {
		final String[] tabW = {"Anorexique", "Maigre","Mince","L�ger","Normal","Lourd","Enrob�","Surpoids", "Ob�se"};
		return tabW[poids];
	}

	// La taille est un int entre 0 et 6
	private String convertHeight(int taille) {
		final String[] tabH = {"Minuscule", "Tr�s petit","Petit","Normal","Grand","Tr�s grand","G�ant"};
		return tabH[taille];
	}

	// Le sexe est soit m ou f
	private String convertSex(Sex sexe) {
		if (sexe == Sex.m) {
			return "m";
		}
		return "f";
	}

	// L'�ge est un int entre 0 et 5
	private String convertAge(int age) {
		final String[] tabA = {"B�b�", "Jeune","Adolescent","Adulte","Senior","Ancien"};
		return tabA[age];
	}

	// La faim est un int entre 0 et 4 
	private String convertHunger(int faim) {
		final String[] tabHu = {"Plein" , "Repu", "Normal", "Ventre vide" , "Affam�"};
		return tabHu[faim];
	}

	// L'�tat de sommeil est soit true, soit false
	private String convertIsAsleep(boolean estEndormi) {
		if (estEndormi) {
			return "_ Endormi";
		}
		return "";
	}

	// Conversion d'int en Str pour la valeur de sant�
	private String convertHealth(int sante) {
		return (""+sante);
	}
}
