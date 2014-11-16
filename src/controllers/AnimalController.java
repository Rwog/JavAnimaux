package controllers;

import java.util.Random;

import consoles.ConsoleEvents;
import models.AnimalModel;
import models.AnimalModel.Sex;
import views.AnimalView;

public abstract class AnimalController implements Runnable {

	// Modele et vue associee à ce controlleur
	private AnimalModel model;
	private AnimalView view;
	private boolean running;
	private Thread t;

	// Constructeur
	public AnimalController(AnimalModel modele, AnimalView vue) {
		this.model = modele;
		this.view = vue;
		this.running=true;
		this.t = new Thread(this);
		t.start();
	}

	// Changer affichage
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

	// Mort animal
	public void kill(String newState) {
		this.model.setState(newState);
		this.running = false;
	}

	// Vieillissement
	public void growOld() {
		this.model.setAge(this.model.getAge()+1);
		if (this.model.getAge() == AnimalModel.MAX_AGE) { this.kill("mort de vieillesse"); }
	}

	// Grandir
	public void growHigher() {
		if (this.model.getHeight() == AnimalModel.MAX_HEIGHT) {
			return;
		} else {
			this.model.setHeight(this.model.getHeight()+1);
			ConsoleEvents.getInstance().log("!) " + this.model.getName() + " grandit.");
		}
	}

	// Grossir
	public void growBigger() {
		if (this.model.getWeight() == AnimalModel.MAX_WEIGHT) {
			kill("mort d'obésité");
		} else {
			this.model.setWeight(this.model.getWeight()+1);
			ConsoleEvents.getInstance().log("!) " + this.model.getName() + " grossit.");
		}
	}

	// Maigrir
	public void growThinner() {
		if (this.model.getWeight() == 0) {
			kill("mort d'anorexie"); 
		} else {
			this.model.setWeight(this.model.getWeight()-1);
		}
	}

	// Augmenter faim
	public void moreHungry() {
		if (this.model.getHunger() == AnimalModel.MAX_HUNGER) {
			kill("mort de faim");
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


	// Affecter enclos
	public void setEnclosure(EnclosureController newEnc) {
		this.model.setEnclosure(newEnc);
	}
	//////////////////
	////// Fonctions de //
	////// conversions  //
	//////////////////

	// Le poids est un int entre 0 et 8
	private String convertWeight(int poids) {
		final String[] tabW = {"Anorexique", "Maigre","Mince","Leger","Normal","Lourd","Enrobe","Surpoids", "Obese"};
		return tabW[poids];
	}

	// La taille est un int entre 0 et 6
	private String convertHeight(int taille) {
		final String[] tabH = {"Minuscule", "Tres petit","Petit","Normal","Grand","Tres grand","Geant"};
		return tabH[taille];
	}

	// Le sexe est soit m ou f
	private String convertSex(Sex sexe) {
		if (sexe == Sex.m) {
			return "m";
		}
		return "f";
	}

	// L'age est un int entre 0 et 5
	private String convertAge(int age) {
		final String[] tabA = {"Bebe", "Jeune","Adolescent","Adulte","Senior","Ancien"};
		return tabA[age/10];
	}

	// La faim est un int entre 0 et 4 
	private String convertHunger(int faim) {
		final String[] tabHu = {"Plein" , "Repu", "Normal", "Ventre vide" , "Affame"};
		return tabHu[faim];
	}

	// L'etat de sommeil est soit true, soit false
	private String convertIsAsleep(boolean estEndormi) {
		if (estEndormi) {
			return "_ Endormi";
		}
		return "";
	}

	// Conversion d'int en Str pour la valeur de sante
	private String convertHealth(int sante) {
		return (""+sante);
	}


	private void evolveState() {
		/////
		// I) Premieres modifications automatiques
		//// a) Sante + 1  s'il dormait
		//// b) 1/3 chances de réveil ou obligatoire s'il a faim (3 ou 4)
		if (this.model.isAsleep() && this.model.getHealth() < 100) {
			// a)
			this.model.setHealth(this.model.getHealth()+1);
			// b)
			if (new Random().nextInt(3) == 0 || this.model.getHunger() >= 3 ) {
				this.model.setAsleep(false);
			}
		}

		////
		// II) Faim et stock de nourriture (si faim = "Normal"/ "Ventre vide"/ "Affame" donc > 1)
		//// a) {EQUATION} Besoins nutritionnels = [Taille+1] + [(Poids+1)/3]
		////// min(minuscule/anorexique): [0+1] + [(0+1)/3] = 1 + 1 =  2 stock pour se nourrir.
		////// max(geant/obese):          [6+1] + [(8+1)/3] = 7 + 3 = 10 stock pour se nourrir
		//// b) 1/4 chances que l'animal se "gave" : mange 1.5x plus !
		////// valeurs possibles de besoin :  2 -   3 -  4 -   5 - 6 -    7 -  8 -    9 - 10 
		////// valeur gavé correspondantes :  3 - 4.5 -  6 - 7.5 - 9 - 10.5 - 12 - 13.5 - 15
		////// Pour garder en int (VAL/1)  :  3 -   4 -  6 -   7 - 9 -   10 - 12 -   13 - 15
		//// c) Retrait du besoin nutritionnel (1.5x s'il se gave) au stock de nourriture de l'enclos.
		////// Si l'enclos a moins de nourriture que nécessaire, l'animal mange tout
		////// Mais cela active la possibilité de ne perdre aucun point de faim.
		////// Et désactive l'effet de gavage.
		//// d) Diminution de la faim de l'animal (-2 s'il se gave)
		if (this.model.getHunger() >= 2) {
			// a)
			int foodNeed = (this.model.getHeight()+ 1) + ((this.model.getWeight()+1)/3); 
			// b)
			boolean isEatingLikeAFatAss = (new Random().nextInt(5) == 0);
			if (isEatingLikeAFatAss) { foodNeed = (int)(1.5*(double)foodNeed)/1; }
			// c)
			boolean isUnderFed = false;
			if (!this.model.isAsleep() && this.model.getEnclosure().getStockFood() >= foodNeed) {
				this.model.getEnclosure().setFood(foodNeed, false);
			} else if (this.model.getEnclosure().getStockFood() < foodNeed) {
				foodNeed = this.model.getEnclosure().getStockFood();
				isUnderFed = true;
			}
			// d)
			if (isUnderFed) { 
				if (new Random().nextBoolean()) {
					this.model.setHunger(this.model.getHunger()- 1);
				}
			} else {
				this.model.setHunger(this.model.getHunger() - ( (isEatingLikeAFatAss)?2:1 ) );
			}
		}

		////
		// III) Modificateurs "aléatoires"
		//// a) D'abord le nombre d'action est tiré aléatoirement entre 0, 1 et 2
		//// b) Pour chaque action, on lance un tirage aléatoire d'événement
		////// Il y a 15 événements possibles
		////// [Faim+1] [Santé-1] [Santé-3] [Santé-5] [Faim+2] [S'endormir*]
		////// [Poids+1*] [Taille+1*] ... 
		////// Les autres événements sont vides pour équilibrer et empêcher les morts trop rapides
		////// *S'endormir : Si l'animal dort déjà, il gagne +2 en santé.
		////// *Poids +1   : Uniquement si faim=0 ou faim=1 (donc Plein ou Repu)
		////// *Taille+1   : Uniquement si santé >= 75 (on ne grandit pas si on est en mauvaise santé)

		// a)
		int nbchanges = new Random().nextInt(3);

		for (int i = 0 ; i < nbchanges  ; ++i ) {
			int choixaction = new Random().nextInt(11);
			switch (choixaction) {
			case 1: // FAIM + 1
				this.moreHungry();
				ConsoleEvents.getInstance().log("- " + this.model.getName() + " s'est bien dépensé...");
				break;
			case 2: // SANTE - 1
				this.model.setHealth(this.model.getHealth()-1);
				ConsoleEvents.getInstance().log("!) " + this.model.getName() + " s'est cogné dans son enclos.");
				break;
			case 3: // SANTE - 3
				this.model.setHealth(this.model.getHealth()-3); 
				ConsoleEvents.getInstance().log("!) " + this.model.getName() + " s'est fait mal dans son enclos.");
				break;
			case 4: // SANTE - 5
				this.model.setHealth(this.model.getHealth()-5);
				ConsoleEvents.getInstance().log("!) " + this.model.getName() + " s'est fait assez mal dans son enclos.");
				break;
			case 5: // FAIM + 2
				this.moreHungry();
				this.moreHungry();
				ConsoleEvents.getInstance().log("!) " + this.model.getName() + " a le ventre qui gargouille...");
				break;
			case 6: // ENDORMIR ! (si endormi, santé +2 !)
				if (this.model.isAsleep()) {
					this.model.setHealth(this.model.getHealth()+2); 
					ConsoleEvents.getInstance().log("~ " + this.model.getName() + " profite d'un sommeil réparateur.");
				} else {
					this.model.setAsleep(true); 
					ConsoleEvents.getInstance().log("- " + this.model.getName() + " s'endort.");
				}
				break;
			case 7: // POIDS + 1 si faim=0 ou faim=1
				if (this.model.getHunger() <= 1) {
					this.growBigger();
				}
				break;
			case 8: // TAILLE + 1 si santé>=75
				if (this.model.getHealth() >= 75) {
					this.growHigher();
				}
				break;
			default: // AUTRES CAS
				break;
			}

		}
	}

	@Override
	public void run() {
		int val = 0;
		// Boucle tant que la valeur running est vraie
		while(this.running) {
			// Evolution de l'etat
			this.evolveState();
			try {
				// Attendre 15 secondes
				Thread.sleep(15000);
			}
			catch ( InterruptedException e ) {
			}
			++val; 
			// pour vieillir d'un point par minute
			if (val == 4) { 
				this.growOld();
				val = 0;
			}
			if (this.model.getHealth() < 15) {
				ConsoleEvents.getInstance().log("!!! > " + this.model.getName() + " est en très mauvaise santé.");
			}
			if (this.model.getHunger() > 3) {
				ConsoleEvents.getInstance().log("!!! > " + this.model.getName() + " a très faim.");
			}

		}
		// Affichage exemple : /!\ Tigre39 est mort de vieillesse...
		ConsoleEvents.getInstance().log("/!\\ " + this.model.getName() + " est " + this.model.getState() + "...");
	}

	public void heal() {
		this.model.setHealth(100);
	}

}

// Un animal ne vit qu'environ 50 minutes (15s * 4 * 50 (max age) = 3000s), 
// arrivé à 50 d'âge, le growOld le tuera avec un état "mort de vieillesse" 
// le Thread s'interrompra car la variable running sera à false, il y aura donc l'affichage de la raison de la mort, et fin du thread

