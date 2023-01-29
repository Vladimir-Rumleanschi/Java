import java.util.ArrayList;

public class Eimer implements Comparable <Eimer> {

    int volum;

    public Eimer()

    public void toString(Eimer eimer){
        System.out.println("Eimer mit Volumen" + eimer.volum);
    }


    @Override
    public int compareTo(Eimer o) {
        return 0;
    }
}
