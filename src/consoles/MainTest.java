package consoles;

import views.ZooView;
import controllers.ZooController;
import models.ZooModel;

public class MainTest {

	public static void main(String[] args) {
		
		ZooModel zoo = new ZooModel("A",7);
		ZooView zv = new ZooView();
		ZooController zc = new ZooController(zoo, zv);
		
		zc.showMaxEnclosure();		
	} // main()

} // class MainTest
