package Auf2;

/**Class is extended from item, represents how a movie must be defined
 */
public class Movie extends Item {
    /**Constructor function
     * @param Titel titel
     * @param Identifer identifier
     * @param Preis preis
     */
    Movie(String Titel, String Identifer, double Preis) {
        super(Titel, Identifer, Preis);
        super.Identifier =  "IMBD-ID:" + Identifer;
    }

}
