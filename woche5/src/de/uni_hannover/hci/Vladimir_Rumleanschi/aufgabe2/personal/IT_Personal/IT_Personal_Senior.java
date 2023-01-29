package de.uni_hannover.hci.Vladimir_Rumleanschi.aufgabe2.personal.IT_Personal;
import de.uni_hannover.hci.Vladimir_Rumleanschi.aufgabe2.personal.*;


/**Class IT_Personal_Senior describe how the data of a Guard employee looks like.
 */
public class IT_Personal_Senior extends Employee {
    private String name;
    private String rang;
    private  double gehalt;
    private int urlaubskontigent;
    private int jahr;
    private int hours;

    /**Constructor function for the class
     * @param name name of it personal
     * @param vorame vorname of it personal
     * @param jahr year
     * @param hours hours
     */
    public IT_Personal_Senior(String name, String vorame,int jahr,int hours) {
        super(name, vorame, "Senior Developer", 0, 0);
        this.hours = hours;
        this.jahr = jahr;
        super.name = name + "," + vorame;
        int workedages = 2021 - this.jahr;
        super.gehalt =  4 * ((32 + workedages) * hours);
        int plusholyday = (int) Math.round(workedages / 3);
        if(plusholyday > 5 )plusholyday = 5;
        super.urlaubskontingent = 22 + plusholyday ;
    }
    //getter for the class
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
    /**Overrided function what prints the information about employee for class It_Personal Senior
     * @return the information of class as string
     */
    @Override
    public String toString( ){
        return String.format("%s(%s) : Weekhours = %d; Monthly Salary = %.2f EUR; %d offdays.",super.name,super.rang,this.hours,super.gehalt,super.urlaubskontingent);
    }
}

