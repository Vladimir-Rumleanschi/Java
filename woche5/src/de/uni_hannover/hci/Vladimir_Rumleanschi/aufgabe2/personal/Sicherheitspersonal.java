package de.uni_hannover.hci.Vladimir_Rumleanschi.aufgabe2.personal;
/**Class Sicherheitspersonal describe how the data of a Guard employee looks like.
 */
public class Sicherheitspersonal extends Employee{

    private String name;
    private String rang;
    private  double gehalt;
    private int urlaubskontigent;
    private int early;
    private  int late;
    private  int night;

    /**Constructor for the class
     * @param name name of guard
     * @param vorame vorname of guard
     * @param early early shifts
     * @param late late shifts
     * @param night night shifts
     */
    public Sicherheitspersonal(String name, String vorame,int early ,int late,int night) {
        super(name, vorame, "Guard", 0, 0);
        this.early = early;
        this.late = late;
        this.night = night;
        super.name = name + "," + vorame;
        super.gehalt = 100 * (this.early + this.late) + 160 * this.night;
        super.urlaubskontingent = (int) Math.round(20 + ((this.early + this.late + this.night)/4 ) + 0.5);
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

    /**Overrided function what prints the information about employee for class Sicherheitspersonal
     * @return the information of class as string
     */
    @Override
    public String toString( ){
        return String.format("%s(%s) : Shifts %d/ %d/ %d; Monthly salary = %.2f EUR ; %d offdays .",super.name,super.rang,this.early,this.late,this.night,super.gehalt,super.urlaubskontingent);
    }
}
