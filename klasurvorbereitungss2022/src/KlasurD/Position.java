package KlasurD;
import java.util.*;

public interface Position extends Comparable<Position>{





    public double getX();


    public double getY();

    public void setX(double x);


    public void setY(double y);

    public double getDistance();
    @Override
    public int compareTo(Position o);

}
