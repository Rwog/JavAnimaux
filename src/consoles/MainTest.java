package consoles;

import controllers.*;
import models.AnimalModel.Sex;

public class MainTest {

	public static void main(String[] args) {
		ZooController zc = new ZooController("OurZoo", 5);
		ConsoleEvents win = ConsoleEvents.setInstance(zc);
		
		// Initialisation
		WolfController wc = new WolfController("Aroo", Sex.f);
		TigerController tc = new TigerController("Tigrou", Sex.m);
		AviaryController e1 = new AviaryController("IMMAVIARY",50,10);
		PenController e2 = new PenController("IMMAPEN",50,10);
		PenController e3 = new PenController("IMMAPEN2",50,10);
		e3.addAnimal(wc);
		e2.addAnimal(tc);
		zc.addEnclosure(e1);
		zc.addEnclosure(e2);
		zc.addEnclosure(e3);
		
		// Envoi menu initial
		win.menu("0");
	} // main()

} // class MainTest
