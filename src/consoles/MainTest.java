package consoles;

import views.ZooView;
import controllers.ZooController;
import models.ZooModel;

public class MainTest {

	public static void main(String[] args) {
		
		ZooController zc = new ZooController("Abc", 3);
		
		zc.showMaxEnclosure();		
	} // main()

} // class MainTest
