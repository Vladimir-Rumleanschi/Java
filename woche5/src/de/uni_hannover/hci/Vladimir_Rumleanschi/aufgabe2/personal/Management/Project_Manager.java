package de.uni_hannover.hci.Vladimir_Rumleanschi.aufgabe2.personal.Management;

import de.uni_hannover.hci.Vladimir_Rumleanschi.aufgabe2.personal.*;

/**Class Project_Manager describe how the data of a Project_Manager looks like.
 */
public class Project_Manager extends Employee {

    private String name;
    private String rang;
    private  double gehalt;
    private int urlaubskontigent;
    private int projects_done;

    /**Constructor function for the class
     * @param name name of employee
     * @param vorame vorname of employee
     * @param projects_done projects done by the employee
     */
    public Project_Manager(String name, String vorame,int projects_done ) {
        super(name, vorame, "Project Manager", 0, 0);
        this.projects_done = projects_done;
        super.name = name + "," + vorame;
        super.gehalt = 8000 + 800 * this.projects_done;
        super.urlaubskontingent = 20 + 2 * this.projects_done;
    }
    //getter for the class'variablen
    @Override
    public double getGehalt() {
        return super.gehalt;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public String getRang() {
        return super.rang;
    }

    @Override
    public int getUrlaubskontingent() {
        return super.urlaubskontingent;
    }

    /**Overrided function what prints the information about employee for class project_manager
     * @return the information of class as string
     */
    @Override
    public String toString( ){
        return String.format("%s(%s) : Projekts done = %d; Monthly Salary = %.2f EUR; %d offdays.",super.name,super.rang,this.projects_done,super.gehalt,super.urlaubskontingent);
    }
}

