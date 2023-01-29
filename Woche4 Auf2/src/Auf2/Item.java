package Auf2;

/**Class describe what consist a item(Titel,Identifier,Preis)
 */
public class Item {
    public String Titel;
    public String Identifier;
    public double Preis;


    /**Constructorfuncion
     * @param Titel titel
     * @param Identifer identifer
     * @param Preis preis
     */
    public Item(String Titel, String Identifer,double Preis){
        this.Titel = Titel;
        this.Identifier = Identifer;
        this.Preis  = Preis;
    }

    /**Represent item as a string
     * @return String
     */
    String Object_toString(){
        System.out.println("\n");
        String itempresentaion = "Titel:\t" + this.Titel + "\n"
                                 + "Identifier:\t" + this.Identifier +"\n"
                                 +  "Preis:\t" + this.Preis +"\n";
        return itempresentaion;
    }

}