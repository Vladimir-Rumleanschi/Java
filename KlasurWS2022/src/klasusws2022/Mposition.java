package klasusws2022;

import klasusws2022.Position;
import java.util.*;
/**
 *
 * Interface class that has the operation to calculate the distance of points.
 *
 * @author Vldimir Rumleanschi {@literal <rumleanschi@stud.uni-hannover.de{@literal >}
 *         Mat. nr: 10037218
 * @version 0.0.1, 2020 Feb 04
 *
 */
public class Mposition implements Position<T> {
    private String pos;
    private double x;
    private double y;

    public Mposition(double x, double y){
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
    public double getDistance(Mposition mposition) {
        double x1 = 0;
        double y1 = 0;

        double x2 = mposition.getX();
        double y2 = mposition.getY();

        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    @Override
    public int compareTo(Mposition mposition1, Mposition mposition2){
        if(getDistance(mposition1 ) < getDistance(mposition2)) {
            return -1;
        } else {
            return 1;
        }
    }

    public void sortPosition(List<Mposition> data){
        int length = data.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; i++) {
                if (data.get(j).getDistance(data.get(j)) < data.get(j + 1).getDistance(data.get(j + 1))) {
                    Mposition temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public String toString(List<Mposition> data) {
        String outputs = "";
        if (data.isEmpty()) {
            for (int i = 0; i < data.size(); i++) {
                outputs = outputs + "Position:" + "(" + data.get(i).getX() + ";" + data.get(i).getY() + ")" + "Dist:" + data.get(i).getDistance(data.get(i));
            }
        }
        return outputs;
    }
}
