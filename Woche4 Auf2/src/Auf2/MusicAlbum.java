package Auf2;

/**Class is extended from item, represents how a MusicAlbum must be defined
 */
public class MusicAlbum extends Item{
    public  String Alb_name;
    public  String Artist_name;

    /**Constructor function
     * @param Alb_name name of album
     * @param Artist_name name of artist
     * @param Titel titel
     * @param Identifer identifier
     * @param Preis preis
     */
    MusicAlbum(String Alb_name, String Artist_name,String Titel,String Identifer, double Preis) {
        super(Titel, Identifer, Preis);
        super.Titel = Alb_name + "-" + Artist_name;
        super.Identifier =  "MBID:" + Identifer;
    }
}




