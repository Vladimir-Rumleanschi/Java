package KlasurD;
import java.util.*;
public class MPosition implements Position {

    double x;
    double y;

    public MPosition(double x,double y ){
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }
    @Override
    public double getDistance(){
        double eukDis = Math.sqrt(Math.pow(this.getX() - 0,2) + Math.pow(this.getY() - 0,2));
        return eukDis;
    }


    @Override
    public int compareTo(Position o) {
        return Double.compare(this.getDistance(),o.getDistance());
    }

    public  String toString(){
        return "Position: ( " + this.getX() + " ; " + this.getY() + " ) "  + "Dist: " + this.getDistance();
    }

}
