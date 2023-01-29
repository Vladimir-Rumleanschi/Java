package Aufgabe2.Enums;
/**The Class Product describes the products from the shop.
 * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
 * @version 02.05.2021
 */
public class Product {
    /**
     *proname represents the name of product.
     *preis represents the preis of product.
     */
    private String proname;
    private int preis;

    /**Constructor for Clover.
     * @param proname name of new product.
     * @param preis preis of new product.
     * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
     */
    public  Product(String proname,int preis){
        this.proname = proname;
        this.preis = preis;
    }

    /**Getter for preis.
     * @return actual preis of product.
     */
    public int getPreis(){
        return this.preis;
    }

    /**Setter for preis.
     * @param preis new preis of product.
     */
    public void setPreis(int preis) {
        this.preis = preis;
    }

    /**Getter for proname.
     * @return actual preis of product.
     */
    public String getProname() {
        return proname;
    }

    /**Setter for proname.
     * @param proname new name of product.
     */
    public void setProname(String proname) {
        this.proname = proname;
    }

    /**Print of the product as string.
     */
    public void printpro(){
        System.out.println(String.format("%s\t\t\t\t\t%d Cent",this.proname,this.preis));
    }


}
