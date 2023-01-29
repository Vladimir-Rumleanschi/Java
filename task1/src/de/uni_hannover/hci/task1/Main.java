package de.uni_hannover.hci.task1;
import de.uni_hannover.hci.task1.model.Fraction;
public class Main {
     public static void main(String[] args) {
         //str:
         System.out.println("str:");
         Fraction f = new Fraction(3, 6);
         System.out.println(f.str());
         //setNumerator:
         System.out.println("setNumerator:");
         f.setNumerator(4);
         System.out.println(f.str());
         //setDenominator:
         System.out.println("setDenominator:");
         f.setDenominator(2);
         System.out.println(f.str());
         //setValues:
         System.out.println("setValues:");
         f.setValues(3, 9);
         System.out.println(f.str());
         //add:
         System.out.println("add:");
         Fraction fa1 = new Fraction(1, 2);
         Fraction fa2 = new Fraction(2, 3);
         Fraction fa3 = Fraction.add(fa1, fa2);
         System.out.println(fa3.str());
         //multiply:
         System.out.println("multiply:");
         Fraction fm1 = new Fraction(1, 2);
         Fraction fm2 = new Fraction(2, 3);
         Fraction fm3 = Fraction.multiply(fm1, fm2);
         System.out.println(fm3.str());

     }
}
