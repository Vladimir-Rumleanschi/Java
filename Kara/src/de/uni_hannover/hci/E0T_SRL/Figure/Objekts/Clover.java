package de.uni_hannover.hci.E0T_SRL.Figure.Objekts;


/**The Class Clover describe the Clover figure.
 * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
 * @version 29.04.2021
 */
public class Clover {
    /**pwert represents the score of clover.
     */
    private int pwert;

    /**Constructor for Clover.
     * @param pwert score.
     */
    public Clover(int pwert){
      this.pwert = pwert;
    }

    /**Getter for pwert.
     * @return actual score.
     */
    public int get(){
      return this.pwert;
    }

    /**Setter for pwert
     * @param nwert new Score for pwert.
     */
    public void set(int nwert){
      this.pwert = nwert;
    }

    /** The function gives the symbol for clover as string back.
     * @return symbol
     */
    public String strCLP(){
      return"C";
    }
    /** The function prints the score of clover back.
     */
    public void strClw(){
      System.out.println(this.pwert);
    }
}
