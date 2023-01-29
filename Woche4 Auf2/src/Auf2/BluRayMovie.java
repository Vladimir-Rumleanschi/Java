package Auf2;

/**Class is extended from movie, represents how a BluRaymovie must be defined
 */
public class BluRayMovie extends Movie{
    /**Constructor function
     * @param Titel titel
     * @param Identifer identifier
     * @param Preis preis
     */
    BluRayMovie(String Titel, String Identifer, double Preis) {
        super(Titel, Identifer, Preis);
        super.Titel = Titel  + " BD Edition";
        if (Preis == 0.0){
            super.Preis = 16.99;
        }else{
            super.Preis = Preis;
        }
    }
}
