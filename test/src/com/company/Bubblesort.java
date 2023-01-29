package com.company;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;

public class Bubblesort {
    //Aufgabe 1
    //to do (a):
    //Die Funktion den Inhalt eines beiebigen Integer Arrays als String zurückgibt:
    static String arrayToString(int[] arr){
        String str = "[" ;// es ist ein String mit den char: '[' initialisiert.
        for (int i = 0; i < arr.length; i++) { // mit der for-Loop wird jedes Element aus der Array in den String eingesetzt.
            if(i == arr.length - 1) {// wenn es letztes Element der Array ist, wird kein weitere Kommer eingesetzt.
                str = str + arr[i];
            } else {
                str = str + arr[i] + ",";// in der String wird ein neues Char aus der Array und eine neue Kommer eingesetzt.
            }
        }
        str = str + "]";
        return str;
    }
    //to do (b):
    //Die Funktion ein Integer-Array der Länge n zurückgibt:
    static int[] randomArray(int n){
        int[] arr = new int[n]; //es wird einen Array mit der länge n initialiesiert.
        int limit = n - 1;
        Random dice = new Random();//Random generiert neue Zahlen.
        for(int i = 0; i < limit; i++){ //Die for-Loop zuweist auf die Stellen des Arrays neue zufällige Zahlen.
            arr[i] = dice.nextInt(100);//Die Funktion nextInt generiert Zahlen im gewählten Interval(Hier bis 100)
        }
        return arr;

    }

    //to do (c):
    //Die Funktion sortiert Arrays korrekt absteigend:
    static void bubbleSort(int[] arr){
        int runde = 1;
        while(runde != 0){//die While-loop läuft bis wann runde(Anzahl der Wechsel in der Schleife ) 0 ist;
            runde = 0;
            for(int i = 0; i < arr.length - 1; i++){//die for-loop untersucht ob arr[i] > als arr[i+1], wenn nicht dann ändert die Stellen.
                int var = arr[i + 1];
                if(arr[i] < var){
                    arr[i + 1] = arr[i];
                    arr[i] = var;
                    runde++;
                }
            }
        }
    }



    public static void main(String[] args) {
        System.out.println("Aufgabe 1 :");
        int [] test = { 1 , 2 , 3 , 4, 5 }; //es wird einen Array-Pointer initialisiert.
        System.out.println(arrayToString(test));
        int varr1[] = randomArray(10);
        int varr2[] = randomArray(20);
        int varr3[] = randomArray(30);

        System.out.println(arrayToString(varr1));
        bubbleSort(varr1);
        System.out.println(arrayToString(varr1));
        System.out.println(arrayToString(varr2));
        bubbleSort(varr2);
        System.out.println(arrayToString(varr2));
        System.out.println(arrayToString(varr3));
        bubbleSort(varr3);
        System.out.println(arrayToString(varr3));
    }
}
