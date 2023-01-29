package Auf2;
/**Class is extended from MusicAlbum, represents how a CDAlbum must be defined
 */
public class CDAlbum extends MusicAlbum{
    /**Constructor function
     * @param Alb_name name of album
     * @param Artist_name name of artist
     * @param Titel titel
     * @param Identifer identifier
     * @param Preis preis
     */
    CDAlbum(String Alb_name, String Artist_name,String Titel, String Identifer, double Preis) {
        super(Alb_name,Artist_name,Titel, Identifer, Preis);
        if (Preis == 0.0){
            super.Preis = 14.99;
        }else{
            super.Preis = Preis;
        }
    }
}
