package de.uni_hannover.hci.Vladimir_Rumleanschi.aufgabe2.personal.IT_Personal;
import de.uni_hannover.hci.Vladimir_Rumleanschi.aufgabe2.personal.*;


/**Class IT_Personal_Junior describe how the data of a Guard employee looks like.
 */
public class IT_Personal_Junior extends Employee {

    private String name;
    private String rang;
    private  double gehalt;
    private int urlaubskontigent;
    private int year;
    private int hours;
    /**Constructor function for the class
     * @param name name of it personal
     * @param vorame vorname of it personal
     * @param year year
     * @param hours hours
     */
    public IT_Personal_Junior(String name, String vorame, int year, int hours) {
        super(name, vorame, "Junior Developer", 0, 0);
        this.hours = hours;
        this.year = year;
        super.name = name + "," + vorame;
        super.gehalt =  4 * 25 * hours;
        super.urlaubskontingent = 22;
    }

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

    /**Overrided function what prints the information about employee for class It_Personal_Junior
     * @return the information of class as string
     */
    @Override
    public String toString( ){
        return String.format("%s(%s) : Weekhours = %d; Monthly Salary = %.2f EUR; %d offdays.",super.name,super.rang,this.hours,super.gehalt,super.urlaubskontingent);
    }
}

