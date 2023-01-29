package Auf2;
import java.util.Scanner;

/**Class main represents a virtual shop
 */
public class main {


    /**Main starts the shop
     * @param args string
     */
    public static void main(String[] args) {
        //Item it = new Item("haha","1122333-122",12.99);
        //MusicAlbum ma = new MusicAlbum("paradise","john", "haha","1122333-122",12.99);
        //System.out.println(ma.Object_toString());

        Scanner scan = new Scanner(System.in);
        Item[] list = new Item[0];
        int i = 0;
        while( i < 5){
            System.out.println("Please enter your command:");
            System.out.println("<CDAlbum, DigitalAlbum, BluRayMovie, DVDMovie, DigitalMovie,eval>");
            String command = scan.next();


            if(command.equals("CDAlbum")) {
                i++;
                System.out.println("\nAdding a paperback book to the inventory.");
                System.out.println("\nPlease enter the album name: ");
                String albumname = scan.next();
                System.out.println("\nPlease enter the album artist: ");
                String albumartist = scan.next();
                System.out.println("\nPlease enter the MBID code:");
                String identifier = scan.next();
                System.out.println("\nPlease enter a price (d for default):");
                String price = scan.next();
                if (price.equals("d")) {
                    CDAlbum cd = new CDAlbum(albumname, albumartist, "", identifier, 0.0);
                    list = setlist(list, cd);
                    System.out.println(String.format("You added the CD album %s with %s and a price of %.2f EUR to the list.\n",cd.Titel,cd.Identifier,cd.Preis));
                } else {
                    CDAlbum cd = new CDAlbum(albumname, albumartist, "", identifier, Double.parseDouble(price));
                    list = setlist(list, cd);
                    System.out.println(String.format("You added the CD album %s with %s and a price of %.2f EUR to the list.\n",cd.Titel,cd.Identifier,cd.Preis));
                }
            }


            if(command.equals("DigitalAlbum")) {
                i++;
                System.out.println("\nAdding a paperback book to the inventory.");
                System.out.println("\nPlease enter the album name: ");
                String dalbumname = scan.next();
                System.out.println("\nPlease enter the album artist: ");
                String dalbumartist = scan.next();
                System.out.println("\nPlease enter the MBID code:");
                String didentifier = scan.next();
                System.out.println("\nPlease enter a price (d for default):");
                String dprice = scan.next();
                if (dprice.equals("d")) {
                    DigitalAlbum da = new DigitalAlbum(dalbumname, dalbumartist, "", didentifier, 0.0);
                    list = setlist(list, da);
                    System.out.println(String.format("You added the digital album %s with %s and a price of %.2f EUR to the list.\n",da.Titel,da.Identifier,da.Preis));
                } else {
                    DigitalAlbum da = new DigitalAlbum(dalbumname, dalbumartist, "", didentifier, Double.parseDouble(dprice));
                    list = setlist(list, da);
                    System.out.println(String.format("You added the digital album %s with %s and a price of %.2f EUR to the list.\n",da.Titel,da.Identifier,da.Preis));
                }
            }


            if(command.equals("DigitalMovie")){
                i++;
                System.out.println("\nAdding a paperback book to the inventory.");
                System.out.println("\nPlease enter the title: ");
                String dmtitle = scan.next();
                System.out.println("\nPlease enter the IMBD-ID code:");
                String dmidentifier = scan.next();
                System.out.println("\nPlease enter a price (d for default):");
                String dmprice = scan.next();
                if (dmprice.equals("d")) {
                    DigitalMovie dm = new DigitalMovie(dmtitle, dmidentifier,  0.0);
                    list = setlist(list, dm);
                    System.out.println(String.format("You added the digital movie < %s > with %s and a price of %.2f EUR to the list.\n",dm.Titel,dm.Identifier,dm.Preis));
                } else {
                    DigitalMovie dm = new DigitalMovie(dmtitle, dmidentifier,Double.parseDouble(dmprice));
                    list = setlist(list, dm);
                    System.out.println(String.format("You added the digital movie < %s > with %s and a price of %.2f EUR to the list.\n",dm.Titel,dm.Identifier,dm.Preis));
                }
            }


            if(command.equals("BluRayMovie")){
                i++;
                System.out.println("\nAdding a paperback book to the inventory.");
                System.out.println("\nPlease enter the title: ");
                String brmtitle = scan.next();
                System.out.println("\nPlease enter the IMBD-ID code:");
                String brmidentifier = scan.next();
                System.out.println("\nPlease enter a price (d for default):");
                String brmprice = scan.next();
                if (brmprice.equals("d")) {
                    BluRayMovie brm = new BluRayMovie(brmtitle, brmidentifier,  0.0);
                    list = setlist(list, brm);
                    System.out.println(String.format("You added the BluRay movie < %s > with %s and a price of %.2f EUR to the list.\n",brm.Titel,brm.Identifier,brm.Preis));
                } else {
                    BluRayMovie brm = new BluRayMovie(brmtitle, brmidentifier,Double.parseDouble(brmprice));
                    list = setlist(list, brm);
                    System.out.println(String.format("You added the BluRay movie < %s > with %s and a price of %.2f EUR to the list.\n",brm.Titel,brm.Identifier,brm.Preis));
                }
            }


            if(command.equals("DVDMovie")){
                i++;
                System.out.println("\nAdding a paperback book to the inventory.");
                System.out.println("\nPlease enter the title: ");
                String dvdtitle = scan.next();
                System.out.println("\nPlease enter the IMBD-ID code:");
                String dvdidentifier = scan.next();
                System.out.println("\nPlease enter a price (d for default):");
                String dvdprice = scan.next();
                if (dvdprice.equals("d")) {
                    DVDMovie dvd = new DVDMovie(dvdtitle, dvdidentifier,  0.0);
                    list = setlist(list, dvd);
                    System.out.println(String.format("You added the DVD movie < %s > with %s and a price of %.2f EUR to the list.\n",dvd.Titel,dvd.Identifier,dvd.Preis));
                } else {
                    DVDMovie dvd = new DVDMovie(dvdtitle, dvdidentifier,Double.parseDouble(dvdprice));
                    list = setlist(list, dvd);
                    System.out.println(String.format("You added the DVD movie < %s > with %s and a price of %.2f EUR to the list.\n",dvd.Titel,dvd.Identifier,dvd.Preis));
                }
            }


            if(command.equals("eval")) {
                if (list.length == 0) {
                    System.out.println("Y have to add an element to the inventory before the evaluation");

                } else {
                    double sum = 0;
                    for (int ind = 0; ind < list.length; ind++) {
                        sum += list[ind].Preis;
                    }
                    if (sum > 9.99) {
                        System.out.println(String.format("You would save %.2f EUR by subscribing for one month instead of buying these items individually.", sum - 9.99));
                    }
                    if (sum < 9.99) {
                        System.out.println(String.format("You would save %.2f EUR by  buying these items individually.", 9.99 - sum));
                    }
                    break;
                }
            }
        }

        if(i == 5){
            System.out.println("Do y want to see the difference of price buy by subscribing for one month ?\n " +
                               " Tape yes or no");
            String evaluate = scan.next();
            if(evaluate.equals("yes")){
                double sum = 0;
                for (int ind = 0; ind < list.length; ind++) {
                    sum += list[ind].Preis;
                }
                if (sum > 9.99) {
                    System.out.println(String.format("You would save %.2f EUR by subscribing for one month instead of buying these items individually.", sum - 9.99));
                }
                if (sum < 9.99) {
                    System.out.println(String.format("You would save %.2f EUR by  buying these items individually.", 9.99 - sum));
                }

            }
        }


        System.out.println("\nYour inventory:");
        if(list.length == 0) System.out.println("Your list is empty");
        for(int var = 0; var < list.length;var++) System.out.println(list[var].Object_toString());

    }

    /**Function what add an item to itemarray
     * @param list arrayitem
     * @param item item what must be add
     * @return new array with the added item
     */
    private static Item[] setlist(Item[] list ,Item item){
        if(item == null){
            Item[] tempitem = {item};
            return tempitem;
        }
        Item[] templist = new Item[list.length + 1];
        for(int i = 0; i < list.length; i++){
            templist[i] = list[i];
        }
        templist[list.length] = item;
        return templist;
    }

}
