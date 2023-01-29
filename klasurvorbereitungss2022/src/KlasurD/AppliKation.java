package KlasurD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AppliKation {
    private static final Scanner scan = new Scanner(System.in);

    public static <T extends Comparable<T>> void sortPositionsB(ArrayList<T> list){
        int len = list.size();
        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - i - 1; j++)
                if (list.get(j).compareTo(list.get(j + 1 )) > 0 ) {
                    Collections.swap(list,j,j+1);
                }
    }

    public static void main(String[] args){

        ArrayList<Position> list = new ArrayList<>();

        while(true){
            System.out.println("Neue Position x y: ");
            String valuex = scan.next();
            if(valuex.equals("E"))break;
            double x = Double.parseDouble(valuex);
            String valuey = scan.next();
            double y = Double.parseDouble(valuey);
            MPosition mp = new MPosition(x,y);
            list.add(mp);
        }

        System.out.println("Eingegebene Positionen:");

        for(Position p : list){
            System.out.println(p.toString());
        }

        sortPositionsB(list);

        System.out.println("Sortierte Positionen:");
        for(Position p : list){
            System.out.println(p.toString());
        }
    }
}
