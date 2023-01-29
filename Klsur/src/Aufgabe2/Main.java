package Aufgabe2;
import Aufgabe2.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List aaa = null;
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("Weiteres Element:");
            String command = scan.next();
            if(command.equals("Ende"))break;
            if(aaa == null)aaa = new List(command,null);
            aaa.addToList(aaa,command);
            System.out.println("Aktueller Liste:");
            aaa.printList(aaa);
        }
    }

}
