package de.uni_hannover.hci.E0T_SRL.Spielfeld;
import de.uni_hannover.hci.E0T_SRL.Figure.Ladybug;

/**The Class Game describe the board.
 * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
 * @version 29.04.2021
 */
public class Game {
    /**
     * board A double array what represent the game board.
     */
   private String[][] board ;

    /**Game is a Constructor for class Game
     * @param x describe the x coordinate in the board
     * @param y describe the y coordinate in the board
     */
   public Game(int x,int y){
       this.board = new String[x][y];

       for(int j = 0;j < board.length;j++) {
           for (int i = 0; i < board.length; i++) {
               this.board[i][j] = " ";
           }
       }
   }


    /**Getter for Board
     * @return the board
     */
   public  String[][] getBoard(){
       return this.board;
    }

    /**Setter for board, becomes a String with coordinates and replace the string in the board
     * @param x x coordinate in the board
     * @param y y coordinate in the board
     * @param sym the string what must be replaced
     */
    public void setBoard(int x,int y,String sym) {
        for(int j = 0;j < board.length;j++) {
            for (int i = 0; i < board.length; i++) {
                if (x == i && y == j) this.board[i][j] = sym ;
            }
        }
    }

    /**Search the Ladybugs Strings in the Board
     * @return an array with the coordinates of the String
     */
    public int[] searchld(){
       int[] pos = new int[2];
        for(int j = 0;j < board.length;j++) {
            for (int i = 0; i < board.length; i++) {
                if (this.board[i][j].equals("Ln") || this.board[i][j].equals("Lw") || this.board[i][j].equals("Ls") || this.board[i][j].equals("Lo")) {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        return pos;
    }

    /**Calculate the sum of Ladybug Points
     * @param arr the loot of Ladybug
     * @return int value (sum)
     */
    public int arraysum(int[] arr){
       int sum = 0;
       if(arr != null){
           for(int i = 0; i < arr.length; i++){
               sum = arr[i] + sum;
           }
       }
        return sum;
    }

    /**Represent a array as a String
     * @param arr the Array of int values
     * @return Array as String format.
     */
    static String arrayToString(int[] arr){
        String str = "[" ;
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1) {
                str = str + arr[i];
            } else {
                str = str + arr[i] + ",";
            }
        }
        str = str + "]";
        return str;
    }

    /**Prints the Board
     * @param ld describes the ladybug
     */
    public void printboard(Ladybug ld){
       for(int j = 0;j < board.length;j++) {
            for(int i = 0; i < board.length; i++) {
               System.out.print(this.board[i][j]);
               System.out.print("\t");
           }
           System.out.println();

       }
        System.out.println("Ladybug's Loot: ");
        if(ld.getLoot() == null){
            System.out.println("[ ]");
        }else {
            System.out.println(arrayToString(ld.getLoot()));
        }
        System.out.println("Give your command:");

   }
}
