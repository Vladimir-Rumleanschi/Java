package textAnalyse;

import java.util.Scanner;

public class textInput {

    private static final Scanner scan = new Scanner(System.in);

    public String readLine(){
        String text = scan.nextLine();
        return  text;
    }
}
