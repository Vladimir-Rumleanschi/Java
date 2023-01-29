package klasur2021.SicheresPasswort;

import klasur2021.SicheresPasswort.Generator;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Generator gen = new Generator();

        while (true) {
            System.out.println("Texteingabe:");
            Scanner scan = new Scanner(System.in);
            String text = scan.nextLine();
            gen.setText(text);
            gen.passwortGen();
            System.out.println(gen.passwort);
            System.out.println("nochmal(j/n)?");
            String check;
            while (true) {
                check = scan.nextLine();
                if (check.equals("j") || check.equals("n")) break;
            }
            if (check.equals("n")) break;
        }
    }
}
