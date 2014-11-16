package consoles;

import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import controllers.ZooController;

public class ConsoleEvents {

	private static ConsoleEvents instance;

	private JFrame frame1;
	private JFrame frame2;
	private JFrame frame3;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextField textArea3;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JScrollPane scrollPane3;
	private ZooController zoo;
	private int menuphase = 0;

	public static ConsoleEvents setInstance(ZooController zcc) {
		instance = new ConsoleEvents(zcc);
		return instance;
	}

	public static ConsoleEvents getInstance() {
		return instance;
	}

	private ConsoleEvents(ZooController zcc) {
		this.zoo = zcc;
		// Crï¿½ation de la fenï¿½tre de logs
		this.frame1 = new JFrame("Evenements Zoo");
		this.frame2 = new JFrame("Ecran gardien");
		this.frame3 = new JFrame("Commandes");

		this.textArea1 = new JTextArea(); 
		this.textArea2 = new JTextArea();
		this.textArea3 = new JTextField();

		this.textArea1.setEditable(false); 
		this.textArea2.setEditable(false);
		this.textArea3.setEditable(true);

		this.scrollPane1 = new JScrollPane(this.textArea1);
		this.scrollPane2 = new JScrollPane(this.textArea2);
		this.scrollPane3 = new JScrollPane(this.textArea3);

		// Pour que l'affichage suive le dï¿½filement de texte
		DefaultCaret caret1 = (DefaultCaret)textArea1.getCaret();
		caret1.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		DefaultCaret caret2 = (DefaultCaret)textArea2.getCaret();
		caret2.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		DefaultCaret caret3 = (DefaultCaret)textArea3.getCaret();
		caret3.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		// Mise en place de la fenï¿½tre (position/taille)
		this.frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frame1.setLayout(new BorderLayout());
		this.frame2.setLayout(new BorderLayout());
		this.frame3.setLayout(new BorderLayout());

		this.frame1.add(this.scrollPane1);
		this.frame2.add(this.scrollPane2);
		this.frame3.add(this.scrollPane3);

		this.frame1.setAlwaysOnTop(true);
		this.frame2.setAlwaysOnTop(true);
		this.frame3.setAlwaysOnTop(true);

		this.frame1.setResizable(false);
		this.frame2.setResizable(false);
		this.frame3.setResizable(false);

		this.frame1.setSize(500, 350);
		this.frame1.setLocation(750,120);

		this.frame2.setSize(500, 350);
		this.frame2.setLocation(200,120);


		this.frame3.setSize(500, 60);
		this.frame3.setLocation(500,520);


		this.frame1.setVisible(true);
		this.frame2.setVisible(true);
		this.frame3.setVisible(true);

		this.textArea3.addKeyListener(
				new KeyAdapter()
				{
					public void keyReleased( KeyEvent e )
					{
						if( e.getKeyCode() == KeyEvent.VK_ENTER )
						{
							if (textArea3.getText().equals("")) { clear(); print("Entrez une commande...");}
							traiter();
							clear();
						} else if (e.getKeyCode() == KeyEvent.VK_R) {
							menuphase = 0;
							clearPrint();
							clear();
							menu("0");
							return;
						}
					}
				}
				);	
		FocusListener fock = new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// Recup le focus si une autre fenêtre est choisie
				textArea3.requestFocus();
			}

			@Override
			public void focusGained(FocusEvent arg0) {}
		};
		this.textArea3.addFocusListener(fock);
	};


	public void log(String message) {
		this.textArea1.append(message+"\n");
	}
	public void print(String message) {
		this.textArea2.append(message+"\n");
	}
	public void clear() {
		this.textArea3.setText(null);
	}
	public void clearPrint() {
		this.textArea2.setText(null);

	}

	private void traiter() {
		// Choix entré par le joueur
		if (textArea3.getText().equals("R")) {
			this.menuphase = 0;
			clearPrint();
			menu("0");
			return;
		}
		if (!MyTools.isNumeric(textArea3.getText())) { 
			print("\nChoix invalide !");
			return;
		}
		int parsedChoice = Integer.parseInt(textArea3.getText());
		// Traitements pour le menu de phase 0
		if (this.menuphase == 0) {
			switch (parsedChoice) {
			case 1:
				this.menu("0_1"); // Observer Enclos
				break;

			case 2:
				this.menu("0_2"); // Placer nourriture
				break;
				
			case 3:
				this.menu("0_3"); // Appeller médecin
				break;
				
			case 4:
				this.menu("0_4"); // Adopter nouvel animal
			
			default:
				print("Choix invalide");
				break;
			}
		} 
		// Traitement pour le menu de phase 1 (enclos)
		else if (this.menuphase == 1){
			if (parsedChoice < this.zoo.getListEnclosure().size() ) {
				clearPrint();
				menu("0_1");
				print("");
				this.zoo.getListEnclosure().get(parsedChoice).displayAnimals();
			} else {
				clearPrint();
				menu("0_1");
				print("Choix invalide");
			}
		}
		// Traitement pour le menu de phase 2 (remplir enclos de nourriture)
		else if (this.menuphase == 2) {
			this.zoo.getListEnclosure().get(parsedChoice).setFood(100, true);
			clearPrint();
			menu("0_2");
			print("");
			print("Enclos numéro " + parsedChoice + "rempli de nourriture !");
		} // Traitement pour le menu de phase 3 (soigner animaux d'un enclos)
		else if (this.menuphase == 3) {
			this.zoo.getListEnclosure().get(parsedChoice).healAllInEnclosure();
			clearPrint();
			menu("0_3");
			print("");
			print("Le médecin s'est occupé des animaux de l'enclos numéro" + parsedChoice + ".");
			print("Il vous enverra la douloureuse facture très bientôt !");
		}

	}

	public void menu(String choix) {
		// Menu racine : phase = 0
			switch (choix) {
			case "0":
				clearPrint();
				print("-- MENU PRINCIPAL --");
				print("1- Observer Enclos");
				print("2- Placer nourriture");
				print("3- Appel médecin");
				print("4- Adopter nouvel animal");
				this.menuphase = 0;
				break;
			case "0_1":
				clearPrint();
				print("-- OBSERVER ENCLOS --");
				print("[R] - Retour au menu principal.");
				print("Choisissez un enclos avec son numéro pour afficher les animaux à l'intérieur :");
				this.menuphase = 1;
				this.zoo.showAllEnclosures();
				clear();
				break;
			case "0_2":
				clearPrint();
				print("-- NOURRIR ANIMAUX --");
				print("[R] - Retour au menu principal.");
				print("Choisissez l'enclos que vous voulez remplir de nourriture :");
				this.menuphase = 2;
				this.zoo.showAllEnclosures();
				break;
			case "0_3":
				clearPrint();
				print("-- APPEL MEDECIN --");
				print("[R] - Retour au menu principal.");
				print("Choisissez l'enclos dont vous voulez soigner les animaux :");
				this.menuphase = 3;
				this.zoo.showAllEnclosures();
				break;
			default:
				break;
			}
		

	}




}