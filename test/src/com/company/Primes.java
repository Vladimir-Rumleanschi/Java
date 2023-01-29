package com.company;

public class Primes {
    //Aufgabe 2
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
    //Die Funktion gibt die Zahlen im interval[2,n] zuruck.
    static int[] fillArray(int n){
        int[] arr = new int[n - 1];//Es wird einen Array mit der länge n - 1 initialisiert.
        int index = 0;
        for(int i = 2; i < n + 1; i++){//Die for-Loop setzt in den Array die Zahlen von 2 bis n absteigend.
            arr[index] = i;
            index++;
        }
        return arr;
    }

    //to do (c):
    //Die Funktion ändert alle Vielfachen des Elements (außer das Element selbst) am angegebenen Index auf den Wert -1.
    static void filterArray(int[] arr, int index){
        if(index >= arr.length)return;
        for(int i = 0; i < arr.length;i++){
            if(arr[i] != arr[index] && arr[i] % arr[index] == 0 ){
                arr[i] = - 1;
            }
        }
    }
    //to do (d):
    //Die Funktion bekommt als Eingabe eine Zahl n und alle Primzahlen <= n in der Konsole ausgibt.
    static void primes(int n){

        int[] arr = fillArray(n);
        filterArray(arr,0);
        filterArray(arr,1);
        filterArray(arr,3);
        filterArray(arr,5);

        int var = 0;//Anzahl der -1 in den Array(var).

        for(int i = 0; i <arr.length; i++){ //Die for-Loop untersucht wie oft -1 vorkommt.
            if(arr[i] == - 1) {
                var++;
            }
        }

        int[] arr2 = new int[arr.length - var];//es wird eine Array der Lange n - Anzahl der -1 in den Array initialiesiert.
        int ind = 0;//index im arr2.

        for(int i = 0; i < arr.length; i++){//Die for-loop fühlt den Array mit die Werten die nicht -1 sind;
            if(arr[i] != -1){
                arr2[ind] = arr[i];
                ind++;
            }
        }
        System.out.println(arrayToString(arr2));
    }

    public static void main(String[] args){
        System.out.println("Aufgabe 2 :");
        int [] test = { 1 , 2 , 3 , 4, 5 }; //es wird einen Array-Pointer initialisiert.
        System.out.println(arrayToString(test));

        int[] varr1 = fillArray(10);
        System.out.println(arrayToString(varr1));

        int[] varr2 = fillArray(20);
        filterArray(varr2,0);
        System.out.println(arrayToString(varr2));
        filterArray(varr2,1);
        System.out.println(arrayToString(varr2));

        primes(20);
        primes(100);
        primes(1);
        primes(3);


    }
}
