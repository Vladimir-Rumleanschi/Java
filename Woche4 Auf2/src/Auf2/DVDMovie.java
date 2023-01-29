package Auf2;

/**Class is extended from movie, represents how a DVDmovie must be defined
 */
public class DVDMovie extends Movie {
    /**Constructor function
     * @param Titel titel
     * @param Identifer identifier
     * @param Preis preis
     */
    DVDMovie(String Titel, String Identifer, double Preis) {
        super(Titel, Identifer, Preis);
        if (Preis == 0.0){
            super.Preis = 9.99;
        }else{
            super.Preis = Preis;
        }
    }
}
