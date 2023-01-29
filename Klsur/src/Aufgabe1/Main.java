package Aufgabe1;//ACHTUNG: Ändern Sie nur Code in den dafür markierten Stellen

public class Main
{
    public static void main(String[] args) {
        java.util.Random rand = new java.util.Random();
        Integer[] a1 = new Integer[] {3, 5, 1, 7, 2, 9, 4, 6, 8};
        Integer[] a2 = new Integer[10]; //Zufälliges Integer Array mit Elementen zwischen 0 und 4
        Double[] a3 = new Double[] {3.1, 5.2, 3.1, 7.4, 2.5, 9.6, 4.7, 6.8, 8.9};
        Double[] a4 = new Double[10]; //Zufälliges Double Array mit Elementen zwischen 0.0 und 2.0 in 0.5 intervallen
        Character[] a5 = new Character[] {'h', 'a', 'g', 'b', 'c', 'j', 'd', 'e', 'f', 'i'};
        Character[] a6 = new Character[10]; //Zufälliges Character Array mit Elementen zwischen 'a' und 'e'
        for (int i = 0; i < 10; i++) {
            a2[i] = rand.nextInt(5);
            a4[i] = rand.nextInt(5) * 0.5;
            a6[i] = (char)(rand.nextInt(5) + (int)('a'));
        }
        System.out.println("Array a1: " + java.util.Arrays.toString(a1));
        System.out.println("Array a2: " + java.util.Arrays.toString(a2));
        System.out.println("Array a3: " + java.util.Arrays.toString(a3));
        System.out.println("Array a4: " + java.util.Arrays.toString(a4));
        System.out.println("Array a5: " + java.util.Arrays.toString(a5));
        System.out.println("Array a6: " + java.util.Arrays.toString(a6));
        //Hier dürfen Sie Ihren Code einfügen

        //Hier endet Ihr Code
        System.out.println("Array a1 (sorted): " + java.util.Arrays.toString(a1));
        System.out.println("Array a2 (sorted): " + java.util.Arrays.toString(a2));
        System.out.println("Array a3 (sorted): " + java.util.Arrays.toString(a3));
        System.out.println("Array a4 (sorted): " + java.util.Arrays.toString(a4));
        System.out.println("Array a5 (sorted): " + java.util.Arrays.toString(a5));
        System.out.println("Array a6 (sorted): " + java.util.Arrays.toString(a6));
    }
}

