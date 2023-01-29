package Aufgabe2;


public class List {

    protected String word;
    protected List next;


    public  List(String word,List next){
        this.next = next;
        this.word = word;
    }

    public void printList(List list){
        if(list == null)return;
        if(list.next == null){
            if(list.word != null)System.out.println(list.word );
            return;
        }
        System.out.println(list.word + " ");
        printList(list.next);
    }
    public List addToList(List list, String word){
        list.next = new List(word,null);
        return list;
    }

}