package controllers;

import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

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
	public void kill() {
		/* Animal mort ! //TODO */
	}

	// Vieillissement
	public void growOld() {
		this.model.setAge(this.model.getAge()+1);
		if (this.model.getAge() == AnimalModel.MAX_AGE) { this.kill(); }

	}

	// Grandir
	public void growHigher() {
		if (this.model.getHeight() == AnimalModel.MAX_HEIGHT) {
			return;
		} else {
			this.model.setHeight(this.model.getHeight()+1);
		}
	}

	// Grossir
	public void growBigger() {
		if (this.model.getWeight() == AnimalModel.MAX_WEIGHT) {
			kill(); //Mort par obésité
		} else {
			this.model.setWeight(this.model.getWeight()+1);
		}
	}

	// Maigrir
	public void growThinner() {
		if (this.model.getWeight() == 0) {
			kill(); //Mort par anorexie
		} else {
			this.model.setWeight(this.model.getWeight()-1);
		}
	}

	// Augmenter faim
	public void moreHungry() {
		if (this.model.getHunger() == AnimalModel.MAX_HUNGER) {
			kill(); //Mort de faim
		} else {
			this.model.setHunger(this.model.getHunger()+1);
		}
	}

	// Diminuer faim
	public void lessHungry() {
		if (this.model.getHunger() == 0) {
			return;
		} else {
			this.model.setHunger(this.model.getHunger()-1);
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


	///////////////////////////////////
	// ACTIONS RANDOM  [0-15] =
	// 1 = Faim  + 1
	// 2 = Santé - 1
	// 3 = Santé - 3
	// 4 = Santé - 5
	// 5 = Age   + 1
	// 6 = Dodo !
	// 7 = Grossir si faim == 0 ou 1
	// 8 = Grandir si santé > 75
	// Reste = Rien !
	////////////////////
	private void evolveState() {
		int nbchanges = new Random().nextInt(2);
		Random choixaction = new Random();
		for (int i = 0 ; i < nbchanges  ; ++i ) {
			switch (choixaction.nextInt(16)) {
			/* 1 = FAIM + 1 */
			case 1: 
				this.moreHungry();
				break;
			
			/* 2 = SANTE - 1 */
			case 2:
				this.model.setHealth(this.model.getHealth()-1);
				break;
			
			/* 3 = SANTE - 3 */
			case 3:
				this.model.setHealth(this.model.getHealth()-3);
				break;
				
			/* 4 = SANTE - 5 */
			case 4:
				this.model.setHealth(this.model.getHealth()-5);
				break;			
			
			/* 5 = AGE + 1 */
			case 5:
				this.growOld();
				break;
				
			/* 6 = Dormir ! */
			case 6:
				this.model.setAsleep(true);
				break;
				
			/* 7 = POIDS + 1 si faim == 0 ou 1 */
			case 7:
				if (this.model.getHunger() <= 1) {
					this.growBigger();
				}
				break;
				
			/* 8 = TAILLE + 1 si santé > 75% */
			case 8:
				if (this.model.getHealth() >= 75) {
					this.growHigher();
				}
				break;
			default:
				/* Autres (0,9,10,11,12,13,14,15) = Rien !*/
				break;
			}

		}
	}

}
