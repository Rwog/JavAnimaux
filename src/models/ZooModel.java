package models;

import java.util.ArrayList;
import controllers.EnclosureController;


public class ZooModel {
	private String name;
	/*private EmployeeModel employee;*/
	private int nbEnclosureMax;
	private ArrayList<EnclosureController> listEnclosure;
	
	public ZooModel(String nam, /*Employee emp ,*/ int nbEncMax) {
		this.name = nam;
		/* this.employee = emp; */
		this.nbEnclosureMax = nbEncMax;
		this.listEnclosure = new ArrayList<EnclosureController>();
		
	}

	// getters
	public String 							  getName() { return name; }
	public int 						getNbEnclosureMax() { return nbEnclosureMax; }
	public ArrayList<EnclosureController> getListEnclosure() { return listEnclosure; }

	
	// setters
	public void setName(String name)						 			  { this.name = name; }
	public void setNbEnclosureMax(int nbEnclosureMax) 					  { this.nbEnclosureMax = nbEnclosureMax; }
	public void setListEnclosure(ArrayList<EnclosureController> listEnclosure) { this.listEnclosure = listEnclosure; }
	
	// actions
	public void addEnclosure(EnclosureController enctoadd) { this.listEnclosure.add(enctoadd); }
	public void delEnclosure(EnclosureController enctodel) { this.listEnclosure.remove(enctodel); }
	
}
