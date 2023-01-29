package Auf2;

/**Class is extended from movie, represents how a Digitalmovie must be defined
 */
public class DigitalMovie extends Movie{
    /**Constructor function
     * @param Titel titel
     * @param Identifer identifier
     * @param Preis preis
     */
    DigitalMovie(String Titel, String Identifer, double Preis) {
        super(Titel, Identifer, Preis);
        super.Titel = Titel  + " Digital Edition";
        if (Preis == 0.0){
            super.Preis = 12.99;
        }else{
            super.Preis = Preis;
        }
    }
}
