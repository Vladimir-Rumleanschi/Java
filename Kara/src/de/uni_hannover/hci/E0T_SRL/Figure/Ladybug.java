package de.uni_hannover.hci.E0T_SRL.Figure;

/**This Class describe the Ladybug.
 * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
 * @version 29.04.2021
 */
public class Ladybug {
    /**The enum Direction describe the direction, where can move the Ladybug .
     */
    public enum Direction{
        N,W,S,O
    }

    /**
     */
    private Direction direction ;
    private int[] loot;

    /**The function is used to create a new Ladybug datatype(constructor)
     *
     * @param direction tag for the direction where the Ladybug is looking for.
     * @param loot The array with actual points in the inventory.
     */
    public Ladybug(Direction direction,int[] loot){
        this.direction = direction;
        this.loot = loot;
    }

    /**Getter for direction.
     * @return actual direction.
     */
    public Direction getDirection(){
        return direction;
    }

    /**Setter for Direction.
     * @param direction new direction of ladybug
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**Getter for loot.
     * @return actual loot.
     */
    public int[] getLoot(){
        return this.loot;
    }
    /**Setter for Direction.
     * @param wert new thing with a score in the loot of ladybug
     */
    public void setLoot(int wert) {
        if(this.loot == null){
            int[] temparr = new int[1];
            temparr[0] = wert;
            this.loot = temparr;
        }else {
            int[] temparr = new int[this.loot.length + 1];
            for (int i = 0; i < this.loot.length; i++) {
                temparr[i] = this.loot[i];
            }
            temparr[this.loot.length] = wert;
            this.loot = temparr;
        }
    }

    /**Print function what print the Symbol that describe the direction of the Ladybug.
     * @param ld Ladybug datatype.
     * @return the passed String.
     */
    public String strLb(Ladybug ld){
        if(ld.direction == Direction.N) return "Ln";
        if(ld.direction == Direction.W) return "Lw";
        if(ld.direction == Direction.S)  return "Ls";
        return "Lo";
    }
}
