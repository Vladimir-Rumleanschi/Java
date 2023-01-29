import java.util.ArrayList;

/**
 * @author Vladimir Rumleanschi
 * Mat.nr: 10037218
 */


public class Main {



    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        ArrayList<Eimer> eimers = new ArrayList<Eimer>(10);
        Eimer X = new Eimer()

}

    public static Eimer binaereSuche(ArrayList<Eimer> eimers, Eimer eimer,  int links, int rechts){

        int m = (links +  rechts )/2;

        if(eimers.get(links).compareTo(eimers.get(m)) == 0)return eimers.get(links);
    }


}
