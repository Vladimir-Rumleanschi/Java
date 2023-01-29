package KlasurA;

public class Eimer implements Comparable<Eimer> {

    private int volum;

    public Eimer(int volume){
        this.volum = volume;
    }

    public int getVolum() {
        return this.volum;
    }

    public void setVolum(int volum){
        this.volum = volum;
    }


    @Override
    public int compareTo(Eimer o) {
        return Integer.compare(this.getVolum(),o.getVolum());
    }

    public String toSring(){
        return "Eimer mit Volumen " + this.getVolum();
    }
}
