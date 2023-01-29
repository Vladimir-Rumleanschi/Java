package Aufgabe3;
import java.util.Scanner;
import Aufgabe3.*;


public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StringBilder strbild = new StringBilder();

        while(true){
            System.out.println("Wie lautet der Text, der formatiert werden soll?");
            String text = scan.nextLine();
            System.out.println(text);
            strbild.boxText(text,20);
            System.out.println("Wollen Sie noch einen Text formatieren (j/n)?");
            String command = scan.next();
            if(command.equals("j"))break;
        }
    }
}
