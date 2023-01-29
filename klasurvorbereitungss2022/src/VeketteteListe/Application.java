package VeketteteListe;

import java.util.*;

public class Application {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args){

        NodeList list = null;
        InsertInList iIL = new InsertInList();
        while(true){
            System.out.println("Weiteres Element: ");
            String value = scan.nextLine();
            if(value.equals("exit"))break;

            list = iIL.addList(list,value);
            System.out.println(list.toString(list));
        }

    }
}
