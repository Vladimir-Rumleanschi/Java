package de.uni_hannover.hci.E0T_SRL;
import de.uni_hannover.hci.E0T_SRL.Figure.*;
import de.uni_hannover.hci.E0T_SRL.Figure.Objekts.*;
import de.uni_hannover.hci.E0T_SRL.Spielfeld.*;
import java.util.Scanner;

/**The Class Application starts the game.
 * @author Vladimir Rumleanschi {@literal}vrumleanschi@gmail.com{@literal}
 * @version 29.04.2021
 */
public class Application {

    /**Main function what starts the application.
     * @param args void
     */
    public static void main(String[] args) {
        //In the first part is generated a map 10*10 with Clovers Tree and a Ladybug on the board
        Ladybug ld = new Ladybug(Ladybug.Direction.N,null);
        Tree tr = new Tree();
        // System.out.println(cl.strCLP());// text Symbol: Clover
        //cl.strClw();
        //System.out.println(tr.strTree()); // text Symbol: Tree
        //System.out.println(ld.strLb(ld));//// text Symbol: Ladybug
        //ld.setDirection(Ladybug.Direction.W);
        //System.out.println(ld.strLb(ld));
        //ld.setDirection(Ladybug.Direction.S);
        //System.out.println(ld.strLb(ld));
        //ld.setDirection(Ladybug.Direction.O);
        //System.out.println(ld.strLb(ld));
        Game g = new Game(10,10);
        Clover cl1 = new Clover(5);
        int c1 = 0;
        Clover cl2 = new Clover(7);
        int c2 = 0;
        Clover cl3 = new Clover(20);
        int c3 = 0;
        Clover cl4 = new Clover(50);
        int c4 = 0;
        Clover cl5 = new Clover(40);
        int c5 = 0;
        Clover cl6 = new Clover(15);
        int c6 = 0;
        Clover cl7 = new Clover(1);
        int c7 = 0;
        Clover cl8 = new Clover(12);
        int c8 = 0;
        Clover cl9 = new Clover(100);
        int c9 = 0;
        Clover cl10 = new Clover(10);
        int c10 = 0;
        Clover cl11 = new Clover(20);
        int c11 = 0;
        g.setBoard(1,2, cl1.strCLP());
        g.setBoard(1,4, cl2.strCLP());
        g.setBoard(2,8, cl3.strCLP());
        g.setBoard(3,1, cl4.strCLP());
        g.setBoard(5,8, cl5.strCLP());
        g.setBoard(6,5, cl6.strCLP());
        g.setBoard(7,1, cl7.strCLP());
        g.setBoard(7,7, cl8.strCLP());
        g.setBoard(8,1, cl9.strCLP());
        g.setBoard(8,7, cl10.strCLP());
        g.setBoard(8,8, cl11.strCLP());
        g.setBoard(0,1, ld.strLb(ld));
        g.setBoard(0,0, tr.strTree());
        g.setBoard(0,2, tr.strTree());
        g.setBoard(0,3, tr.strTree());
        g.setBoard(0,4, tr.strTree());
        g.setBoard(0,5, tr.strTree());
        g.setBoard(0,6, tr.strTree());
        g.setBoard(0,7, tr.strTree());
        g.setBoard(0,8, tr.strTree());
        g.setBoard(0,9, tr.strTree());
        g.setBoard(1,0, tr.strTree());
        g.setBoard(1,3, tr.strTree());
        g.setBoard(1,9, tr.strTree());
        g.setBoard(2,0, tr.strTree());
        g.setBoard(2,1, tr.strTree());
        g.setBoard(2,5, tr.strTree());
        g.setBoard(2,6, tr.strTree());
        g.setBoard(2,7, tr.strTree());
        g.setBoard(2,9, tr.strTree());
        g.setBoard(3,0, tr.strTree());
        g.setBoard(3,2, tr.strTree());
        g.setBoard(3,3, tr.strTree());
        g.setBoard(3,4, tr.strTree());
        g.setBoard(3,9, tr.strTree());
        g.setBoard(4,0, tr.strTree());
        g.setBoard(4,6, tr.strTree());
        g.setBoard(4,8, tr.strTree());
        g.setBoard(4,9, tr.strTree());
        g.setBoard(5,0, tr.strTree());
        g.setBoard(5,1, tr.strTree());
        g.setBoard(5,3, tr.strTree());
        g.setBoard(5,4, tr.strTree());
        g.setBoard(5,5, tr.strTree());
        g.setBoard(5,6, tr.strTree());
        g.setBoard(5,9, tr.strTree());
        g.setBoard(6,0, tr.strTree());
        g.setBoard(6,4, tr.strTree());
        g.setBoard(6,6, tr.strTree());
        g.setBoard(6,7, tr.strTree());
        g.setBoard(6,8, tr.strTree());
        g.setBoard(6,9, tr.strTree());
        g.setBoard(6,4, tr.strTree());
        g.setBoard(6,6, tr.strTree());
        g.setBoard(6,7, tr.strTree());
        g.setBoard(6,8, tr.strTree());
        g.setBoard(6,9, tr.strTree());
        g.setBoard(7,0, tr.strTree());
        g.setBoard(7,2, tr.strTree());
        g.setBoard(7,4, tr.strTree());
        g.setBoard(7,8, tr.strTree());
        g.setBoard(7,9, tr.strTree());
        g.setBoard(8,0, tr.strTree());
        g.setBoard(8,2, tr.strTree());
        g.setBoard(8,6, tr.strTree());
        g.setBoard(9,0, tr.strTree());
        g.setBoard(9,1, tr.strTree());
        g.setBoard(9,2, tr.strTree());
        g.setBoard(9,3, tr.strTree());
        g.setBoard(9,4, tr.strTree());
        g.setBoard(9,5, tr.strTree());
        g.setBoard(9,6, tr.strTree());
        g.setBoard(9,7, tr.strTree());
        g.setBoard(9,8, tr.strTree());
        g.setBoard(9,9, tr.strTree());
        g.setBoard(8,9,"Fsh");
        g.printboard(ld);
        Scanner scan = new Scanner(System.in);
        //while Loop describe the game process
        while(true){
            //User input decide the Ladybug moving
            String direction = scan.next();
            //"R" command to move right
            if(direction.equals("R")){
                if(ld.getDirection() == Ladybug.Direction.N){
                    ld.setDirection(Ladybug.Direction.W);
                    int[]pos = g.searchld();
                    g.setBoard(pos[0],pos[1], ld.strLb(ld));
                }else if(ld.getDirection() == Ladybug.Direction.W){
                    ld.setDirection(Ladybug.Direction.S);
                    int[]pos = g.searchld();
                    g.setBoard(pos[0],pos[1], ld.strLb(ld));
                } else if(ld.getDirection() == Ladybug.Direction.S){
                    ld.setDirection(Ladybug.Direction.O);
                    int[]pos = g.searchld();
                    g.setBoard(pos[0],pos[1], ld.strLb(ld));
                } else if(ld.getDirection() == Ladybug.Direction.O){
                    ld.setDirection(Ladybug.Direction.N);
                    int[]pos = g.searchld();
                    g.setBoard(pos[0],pos[1], ld.strLb(ld));
                }

                g.printboard(ld);
            }
            // "L" command to move left
            if(direction.equals("L")){
                if(ld.getDirection() == Ladybug.Direction.N){
                    ld.setDirection(Ladybug.Direction.O);
                    int[]pos = g.searchld();
                    g.setBoard(pos[0],pos[1], ld.strLb(ld));
                }else if(ld.getDirection() == Ladybug.Direction.W){
                    ld.setDirection(Ladybug.Direction.N);
                    int[]pos = g.searchld();
                    g.setBoard(pos[0],pos[1], ld.strLb(ld));
                } else if(ld.getDirection() == Ladybug.Direction.S){
                    ld.setDirection(Ladybug.Direction.W);
                    int[]pos = g.searchld();
                    g.setBoard(pos[0],pos[1], ld.strLb(ld));
                } else if(ld.getDirection() == Ladybug.Direction.O){
                    ld.setDirection(Ladybug.Direction.S);
                    int[]pos = g.searchld();
                    g.setBoard(pos[0],pos[1], ld.strLb(ld));
                }
                g.printboard(ld);
            }
            //"V" command to move ahead
            if(direction.equals("V")){
                if(ld.getDirection() == Ladybug.Direction.N) {
                    int[] pos = g.searchld();
                    if (g.getBoard()[pos[0]][pos[1] - 1].equals(tr.strTree()) ) {
                        System.out.println("Invalid move Tree is ahead");
                    } else {
                        g.setBoard(pos[0], pos[1], " ");
                        g.setBoard(pos[0], pos[1] - 1, ld.strLb(ld));
                    }
                } else if(ld.getDirection() == Ladybug.Direction.W) {
                    int[] pos = g.searchld();
                    if (g.getBoard()[pos[0] + 1][pos[1]].equals(tr.strTree()) ) {
                        System.out.println("Invalid move Tree is ahead");
                    } else {
                        g.setBoard(pos[0], pos[1], " ");
                        g.setBoard(pos[0] + 1, pos[1], ld.strLb(ld));
                    }
                } else if(ld.getDirection() == Ladybug.Direction.S) {
                    int[] pos = g.searchld();
                    if (g.getBoard()[pos[0]][pos[1] + 1].equals(tr.strTree())) {
                        System.out.println("Invalid move Tree is ahead");
                    } else {
                        g.setBoard(pos[0], pos[1], " ");
                        g.setBoard(pos[0], pos[1] + 1, ld.strLb(ld));
                    }
                }else if(ld.getDirection() == Ladybug.Direction.O) {
                    int[] pos = g.searchld();
                    if( (pos[0] - 1 < 0)){
                        System.out.println("Invalid move out of Game board");
                    } else {
                        if (g.getBoard()[pos[0] - 1][pos[1]].equals(tr.strTree()) ) {
                            System.out.println("Invalid move Tree is ahead");
                        } else {
                            g.setBoard(pos[0], pos[1], " ");
                            g.setBoard(pos[0] - 1, pos[1], ld.strLb(ld));
                        }
                    }
                }
                // Conditions if Ladybug moves on Clover
                if( g.searchld()[0] == 1 && g.searchld()[1] == 2 && c1 == 0){
                    ld.setLoot(cl1.get());
                    c1++;
                }
                if( g.searchld()[0] == 1 && g.searchld()[1] == 4 && c2 == 0){
                    ld.setLoot(cl2.get());
                    c2++;
                }
                if( g.searchld()[0] == 2 && g.searchld()[1] == 8 && c3 == 0){
                    ld.setLoot(cl3.get());
                    c3++;
                }
                if( g.searchld()[0] == 3 && g.searchld()[1] == 1 && c4 == 0){
                    ld.setLoot(cl4.get());
                    c4++;
                }
                if( g.searchld()[0] == 5 && g.searchld()[1] == 8 && c5 == 0){
                    ld.setLoot(cl5.get());
                    c5++;
                }
                if( g.searchld()[0] == 6 && g.searchld()[1] == 5 && c6 == 0){
                    ld.setLoot(cl6.get());
                    c6++;
                }
                if( g.searchld()[0] == 7 && g.searchld()[1] == 1 && c7 == 0){
                    ld.setLoot(cl7.get());
                    c7++;
                }
                if( g.searchld()[0] == 7 && g.searchld()[1] == 7 && c8 == 0){
                    ld.setLoot(cl8.get());
                    c8++;
                }
                if( g.searchld()[0] == 8 && g.searchld()[1] == 1 && c9 == 0){
                    ld.setLoot(cl9.get());
                    c9++;
                }
                if( g.searchld()[0] == 8 && g.searchld()[1] == 7 && c10 == 0){
                    ld.setLoot(cl10.get());
                    c10++;
                }

                if( g.searchld()[0] == 8 && g.searchld()[1] == 8 && c11 == 0){
                    ld.setLoot(cl11.get());
                    c11++;
                }
                g.printboard(ld);
            }
            //break conditions:
            if(g.searchld()[0] == 8 && g.searchld()[1] == 9 || direction.equals("done")){
                System.out.println("Finish");
                System.out.println(String.format("Your Score is: %d",g.arraysum(ld.getLoot())));
                break;
            }
        }
    }
}
