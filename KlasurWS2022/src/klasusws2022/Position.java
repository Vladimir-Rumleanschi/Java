package klasusws2022;

import java.util.List;

/**
 *
 * Interface class that has the operation to calculate the distance of points.
 *
 * @author Vldimir Rumleanschi {@literal <rumleanschi@stud.uni-hannover.de{@literal >}
 *         Mat. nr: 10037218
 * @version 0.0.1, 2020 Feb 04
 *
 */
public interface Position<T> extends Comparable<T> {

    /**
     * Getter for x
     * @return x position
     */
    public double getX();

    /**
     * Getter for y
     * @return y position
     */
    public double getY();

    /**
     * Setter for x
     * @param x
     */
    public void setX(double x);
    /**
     * Setter for y
     * @param y
     */
    public void setY(double y);

    /**
     * Get the distance beetween point and source.
     * @param mposition objekt that has data of point
     * @return distance
     */
    public double getDistance(Mposition mposition);
    /**
     * Get the distance beetween point and source.
     * @param mposition1 objekt is that has data of point
     * @return distance
     */
    public int compareTo(Mposition mposition1, Mposition mposition2);

    /**
     * Macht die variable to string
     * @param data
     * @return
     */
    //public String toString(List<Mposition> data);
}
