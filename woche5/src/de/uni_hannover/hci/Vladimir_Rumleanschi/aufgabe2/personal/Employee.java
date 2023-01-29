package de.uni_hannover.hci.Vladimir_Rumleanschi.aufgabe2.personal;
/**Class CEO_Manager describe how the data of a CEO_Manager looks like.
 */
public abstract class Employee {
    public String name;
    public String rang;
    public double gehalt;
    public int urlaubskontingent;
    /**Constructor function for the class
     * @param name name of employee;
     * @param vorame vorname of employee;
     * @param gehalt wage per month;
     * @param urlaubskontingent hollyday pro year;
     */
    public Employee(String name, String vorame, String rang,double gehalt,int urlaubskontingent){
        this.name = name + " " + vorame;
        this.rang = rang;
        this.gehalt = gehalt;
        this.urlaubskontingent = urlaubskontingent;
    }
    //getter for the class
    public String getName() {
        return this.name;
    }

    public String getRang() {
        return this.rang;
    }

    public double getGehalt() {
        return this.gehalt;
    }

    public int getUrlaubskontingent() {
        return this.urlaubskontingent;
    }

    /**Represent the inforamtion of class as Sting
     * @return a srting with the class variables
     */
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", rang='" + rang + '\'' +
                ", gehalt=" + gehalt +
                ", urlaubskontingent=" + urlaubskontingent +
                '}';
    }
}