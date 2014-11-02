package consoles;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class ConsoleEvents implements ActionListener, FocusListener {

	private JFrame frame1;
	private JFrame frame2;
	private JFrame frame3;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextField textArea3;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JScrollPane scrollPane3;

	public ConsoleEvents() {

		// Création de la fenêtre de logs
		this.frame1 = new JFrame("Événements Zoo");
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

		// Pour que l'affichage suive le défilement de texte
		DefaultCaret caret1 = (DefaultCaret)textArea1.getCaret();
		caret1.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		DefaultCaret caret2 = (DefaultCaret)textArea2.getCaret();
		caret2.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		DefaultCaret caret3 = (DefaultCaret)textArea3.getCaret();
		caret3.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		// Mise en place de la fenêtre (position/taille)
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
						} 
					}


				}
				);
	};


	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.clear();
	}

	public void log(String message) {
		this.textArea1.append(message+"\n");
	}
	public void print(String message) {
		this.textArea2.append(message+"\n");
	}
	public void clear() {
		this.textArea3.setText(null);
	}

	private void traiter() {
		print("Vous avez fait : "+ textArea3.getText());
		
	}
	@Override
	public void focusGained(FocusEvent e) {	}

	@Override
	public void focusLost(FocusEvent e) { }

	/*
	// Test
	public static void main(String[] args) throws InterruptedException {
		ConsoleEvents con = new ConsoleEvents();
		con.setConsole();
		con.textArea.append("===> Let's gooo !\n");
		for (int i = 1; i < 100; i++) {
			con.textArea.append("Ceci est la "+i+"ème itération !\n");
			Thread.sleep(100);
		}
		con.textArea.append("Ceci est la 100ème, et dernière itération !\n");


	}
	 */
}