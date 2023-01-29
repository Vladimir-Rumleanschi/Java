package com.company;

    class Debug {

        // Method prints all numbers in an array that are even.
        static void printEvenNumbers(int[] numbers) {
            for (int i = 0; i < numbers.length; ++i) {
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i]);
                    }
                }
            }
        public static void main(String[] args) {
            System.out.println("Aufgabe 3 :");
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            //output should be as follows:
            //2
            //4
            //6
            //8
            Debug.printEvenNumbers(arr);
        }
    }
    /*
    ...
    Zeile 3: class Keyword falsch geschrieben (ckass):
    Fehlermeldung:
    **************
    Debug.java:1: error: class , interface , or enum expected
    public ckass Debug {
    ^
    **************
    Der Compiler erwartet eines der drei oben angegebenen Keywords , hat aber nur das falsch
    → geschriebene ckass bekommen.
    ...

    ...
    Zeile 6: identifier falsch geschrieben(1printEvenNumbers)
    Fehlermeldung:
    **************
    java: <identifier> expected
    **************
    Der Compiler erkennt eine Falsche Eingabe der Funktionsname
    ...

    ...
    Zeile 8: Syntaxfehler('\')
    Fehlermeldung:
    **************
    java: illegal character: '\'
    **************
    Der Compiler erkennt eine Syntaxfehler
    ...

    ...
    Zeile 16: Die Funktion kann nicht aufgeruden werden
    Fehlermeldung:
    **************
    java: <identifier> expected
    **************
    Der Compiler braucht eine main Funktion um die printEvenNumbers-Funktion aufzurufen
    ...

    ...
    Zeile 5: Falsche Bedingung bei if-Condition
    Fehlermeldung:
    **************
    Es müssen die graden Zahlen als output erscheinen
    **************
    Der Compiler gibt die ungeraden Zahlen zuruck.
    ...
    */
