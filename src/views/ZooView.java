package views;

import consoles.ConsoleEvents;

public class ZooView {

	public void showNbEnclosMax(int max) {
		// "Nb d'enclos max dans le zoo : 100 "
		ConsoleEvents.getInstance().print(("Nb d'enclos max dans le zoo :" + max));
	}
	
}
