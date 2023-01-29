package klasusws2022;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Main class
 *
 * @author Vldimir Rumleanschi {@literal <rumleanschi@stud.uni-hannover.de{@literal >}
 *         Mat. nr: 10037218
 * @version 0.0.1, 2020 Feb 04
 *
 */


public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Mposition> datalist = new ArrayList<Mposition>();
        Mposition p = new Mposition(0,0);

        while(true){
            System.out.println("Neue Position x y");
            String order = scan.next();
            if(order.equals("E")){
                System.out.println("Eingabe Positionen");
                System.out.println(p.toString(datalist));
                System.out.println("Sortiere Positionen");
                p.sortPosition(datalist);
                System.out.println(p.toString(datalist));
            }
            p.setX(Double.parseDouble(order));
            order = scan.next();
            p.setY(Double.parseDouble(order));
            p.getDistance(p);

        }
    }
}
