package KlasurA;

import  KlasurA.MergeSort;
import  KlasurA.Eimer;
import java.util.Random;
import java.util.ArrayList;

public class Applikation {

    private static final Random rand = new Random();

    public static void main(String[] args){

      /*  Eimer[] list = new Eimer[10];

        for(int i = 0; i < 10; i++){
            list[i] = new Eimer(rand.nextInt(20));
        }

        for(int i = 0; i < 10; i++){
            System.out.println(list[i].toSring());
        }

       */

        ArrayList<Eimer> list = new ArrayList<>(10);

        for(int count = 0 ; count < 10; count++ ){
            list.add(new Eimer(rand.nextInt(20)));
        }

        System.out.println("random list:");

        for(Eimer eimer : list){
            System.out.println(eimer.toSring());
        }

        list = MergeSort.mergeSort(list);

        System.out.println("mergesorted list:");
        for(Eimer eimer : list){
            System.out.println(eimer.toSring());
        }

    }

}
