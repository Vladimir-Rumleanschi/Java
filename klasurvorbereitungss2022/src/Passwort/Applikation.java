package Passwort;
import java.util.*;


public class Applikation {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        while(true){


            System.out.println("Eingabe: ");
            String value = scan.nextLine();
            Generator gen = new Generator(value);
            String passwort = gen.toString();
            System.out.println("Ausgabe: " + passwort);
            System.out.println("nochmal? (j/n)");
            String count = scan.nextLine();
            if(count.equals("n"))break;
        }
    }
}
