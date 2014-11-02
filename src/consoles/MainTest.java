package consoles;

public class MainTest {

	public static void main(String[] args) throws InterruptedException {
		ConsoleEvents logZoo = new ConsoleEvents();
		
		for (int i = 1; ; i++) {
			logZoo.log("Ceci est la "+i+"ème itération !");
			Thread.sleep(100);
		}
	} // main()

} // class MainTest
