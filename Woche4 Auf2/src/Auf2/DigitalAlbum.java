package Auf2;

/**Class is extended from MusicAlbum, represents how a DigitalAlbum must be defined
 */
public class DigitalAlbum extends MusicAlbum {
    /**Constructor function
     * @param Alb_name name of album
     * @param Artist_name name of artist
     * @param Titel titel
     * @param Identifer identifier
     * @param Preis preis
     */
    DigitalAlbum(String Alb_name, String Artist_name,String Titel, String Identifer, double Preis) {
        super( Alb_name,Artist_name,Titel, Identifer, Preis);
        if (Preis == 0.0){
            super.Preis = 12.99;
        }else{
            super.Preis = Preis;
        }
        super.Titel = Titel + " Digital Edition";
    }
}
