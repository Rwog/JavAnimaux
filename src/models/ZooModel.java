package models;

import java.util.ArrayList;


public class ZooModel {
	private String name;
	/*private EmployeeModel employee;*/
	private int nbEnclosureMax;
	private ArrayList<EnclosureModel> listEnclosure;
	
	public ZooModel(String nam, /*Employee emp ,*/ int nbEncMax) {
		this.name = nam;
		/* this.employee = emp; */
		this.nbEnclosureMax = nbEncMax;
		this.listEnclosure = new ArrayList<EnclosureModel>();
		
	}

	// getters
	public String 							  getName() { return name; }
	public int 						getNbEnclosureMax() { return nbEnclosureMax; }
	public ArrayList<EnclosureModel> getListEnclosure() { return listEnclosure; }

	
	// setters
	public void setName(String name)						 			  { this.name = name; }
	public void setNbEnclosureMax(int nbEnclosureMax) 					  { this.nbEnclosureMax = nbEnclosureMax; }
	public void setListEnclosure(ArrayList<EnclosureModel> listEnclosure) { this.listEnclosure = listEnclosure; }
	

	
}
