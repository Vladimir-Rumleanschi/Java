package battleships.gui;

import battleships.MainApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * The class represents a controller for the waiting view.
 *
 * @author Alaa,Vladimir
 */
public class WaitingController extends BaseView {

    @FXML
    AnchorPane anchorPane;
    @FXML
    Button ready;
    @FXML
    Button hori, verti;
    @FXML
    TextField textShip;

    @FXML
    public Button ca1, ca2, ca3, ca4, ca5, ca6, ca7, ca8, ca9, ca10,
            cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10,
            cc1, cc2, cc3, cc4, cc5, cc6, cc7, cc8, cc9, cc10,
            cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9, cd10,
            ce1, ce2, ce3, ce4, ce5, ce6, ce7, ce8, ce9, ce10,
            cf1, cf2, cf3, cf4, cf5, cf6, cf7, cf8, cf9, cf10,
            cg1, cg2, cg3, cg4, cg5, cg6, cg7, cg8, cg9, cg10,
            ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10,
            ci1, ci2, ci3, ci4, ci5, ci6, ci7, ci8, ci9, ci10,
            cj1, cj2, cj3, cj4, cj5, cj6, cj7, cj8, cj9, cj10;


    String[][] field = {{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};

    MainApplication mainApp = BaseView.getMainApp();

    private Scene thirdScene;

    /**
     * Sets the new scene to GameView
     * @param scene
     */
    public void setThirdScene(Scene scene) {
        thirdScene = scene;
    }

    /**
     * When the ready button is pressed the new window opens
     * @throws IOException
     */
    public void handleButton() throws IOException {
        Stage primaryStage = (Stage) ready.getScene().getWindow();
        primaryStage.setScene(thirdScene);
        String css = WaitingController.class.getResource("gameviewbg.css").toExternalForm();
        thirdScene.getStylesheets().add(css);
        mainApp.getChatClient().sendMessage("getpriority;" + "\n" );
    }


    private int x;
    private String y = "";
    int shipLengthCounter = 0;
    /**
     * Saves the coordinates of the placed ship
     * @param e
     */
    public void changeButtonLayout(ActionEvent e)throws Exception{
        Button save = (Button) e.getSource();
        String temp = save.getId();
        String temp1 = temp.substring(1);
        x = charToInt(temp1.charAt(0));
        y = "" + temp1.charAt(1);
        if(temp1.length() == 3) y = y + temp1.charAt(2);

        hori.setDisable(false);
        verti.setDisable(false);
    }

    private int charToInt(char x) {
        switch (x) {
            case 'a':
                return 1;
            case 'b':
                return 2;
            case 'c':
                return 3;
            case 'd':
                return 4;
            case 'e':
                return 5;
            case 'f':
                return 6;
            case 'g':
                return 7;
            case 'h':
                return 8;
            case 'i':
                return 9;
            case 'j':
                return 10;
        }
        return 0;
    }

    public String direction;
    int shipLength = 5;
    /**
     * After a ship is placed it saves the direction and transmits all parameters and the ship length to the server.
     * @param e
     * @throws Exception
     */
    public void handleDir(ActionEvent e) throws Exception{
        if (e.getSource() == hori) direction = "h";
        else direction = "v";

        mainApp.getChatClient().sendMessage("set;" + toString(field) + ";" + direction + ";" + x + ";" + y + ";" + shipLength + ";" + "\n" );

    }


    /**
     * Converts the two-dimensional array to a string.
     * String[][] --> String.
     * @param strings a two-dimensional array that represents the game's field
     */
    public String toString(String[][] strings){
        String s = "";
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10 ; j++){
                if(j == 9){
                    s = s + strings[i][j];
                }else {
                    s = s + strings[i][j]  + "_";
                }
            }
            if(i != 9){
                s = s + "/";
            }
        }
        return s;
    }

    /**
     * Converts the string to a two-dimensional array.
     * String --> String[][].
     * @param s a String that represents the game's field
     */
    public String[][] to2DStringArray(String s){
        String[] fill = s.split("/");
        String[][] field = {{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};

        for(int i = 0; i < 10; i++){
            String[] cals = fill[i].split("_");
            for(int j = 0; j < 10 ; j++){
                field[i][j] = cals[j];
            }
        }
        return field;
    }


    public  void setField(String[][] tempField){
        this.field = tempField;
    }

    /**
     * Sets the own ships.
     * @param setMessage the String that represents the actual state of the game's field.
     */
    public void printField(String setMessage){
        String[] separate = setMessage.split(";");

        if(toString(this.field).equals(separate[1])){
            textShip.setText("Invalid position!");
        } else {
            setField(to2DStringArray(separate[1]));
            print2DStringArray();
            shipLengthCounter++;
            switch (shipLengthCounter) {
                case 1:
                    shipLength = 4;
                    textShip.setPrefWidth(187.0);
                    textShip.setText("Please set the first battleship! (4)");
                    break;
                case 2:
                    shipLength = 4;
                    textShip.setPrefWidth(205.0);
                    textShip.setText("Please set the second battleship! (4)");
                    break;
                case 3:
                    shipLength = 3;
                    textShip.setPrefWidth(171.0);
                    textShip.setText("Please set the first cruiser! (3)");
                    break;
                case 4:
                    shipLength = 3;
                    textShip.setPrefWidth(187.0);
                    textShip.setText("Please set the second cruiser! (3)");
                    break;
                case 5:
                    shipLength = 3;
                    textShip.setPrefWidth(193.0);
                    textShip.setText("Please set the first submarine! (3)");
                    break;
                case 6:
                    shipLength = 3;
                    textShip.setPrefWidth(208.0);
                    textShip.setText("Please set the second submarine! (3)");
                    break;
                case 7:
                    shipLength = 2;
                    textShip.setPrefWidth(186.0);
                    textShip.setText("Please set the first destroyer! (2)");
                    break;
                case 8:
                    shipLength = 2;
                    textShip.setPrefWidth(205.0);
                    textShip.setText("Please set the second destroyer! (2)");
                    break;
                case 9:
                    shipLength = 2;
                    textShip.setPrefWidth(193.0);
                    textShip.setText("Please set the third destroyer! (2)");
                    break;
                default:
                    disableAllButtons();
                    textShip.setPrefWidth(81.0);
                    textShip.setText("All ships set.");
                    ready.setDisable(false);
                    break;
            }

            hori.setDisable(true);
            verti.setDisable(true);
        }

    }

    /**
     * The method prints the ships on the buttons and disables them.
     */
    public void print2DStringArray(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10 ; j++){
                try {
                    if (Integer.parseInt(field[j][i]) != 0) {
                        int finalI = i;
                        int finalJ = j;
                        Platform.runLater(
                                () -> {
                                    getTheButton(finalJ, finalI).setDisable(true);
                                    getTheButton(finalJ, finalI).setStyle("-fx-background-color: #ff8c00; ");
                                }
                        );
                    }
                }
                catch (NumberFormatException ex) {
                }
            }
        }
    }

    /**
     * The method disables all buttons on the field and sets the color to blue.
     */
    public void disableAllButtons(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10 ; j++){
                if(Integer.parseInt(field[j][i]) == 0 ){
                    int finalI = i;
                    int finalJ = j;
                    Platform.runLater(
                            () -> {
                                getTheButton(finalJ, finalI).setDisable(true);
                                getTheButton(finalJ, finalI).setStyle("-fx-background-color: #0037ff; ");
                            }
                    );
                }
            }
        }
        mainApp.getChatClient().sendMessage("sendtome;" + toString(field) + "\n" );
        mainApp.getChatClient().sendMessage("sendtoenemy;" + toString(field) + "\n" );
    }

    /**
     * Returns the button that corresponds to x- and y-coordinate.
     * @param x x-coordinate of the Button
     * @param y y-coordinate of the Button
     * @return the Button
     */
    public Button getTheButton(int x, int y){
        if(x == 0 && y == 0 )return ca1;
        if(x == 0 && y == 1 )return ca2;
        if(x == 0 && y == 2 )return ca3;
        if(x == 0 && y == 3 )return ca4;
        if(x == 0 && y == 4 )return ca5;
        if(x == 0 && y == 5 )return ca6;
        if(x == 0 && y == 6 )return ca7;
        if(x == 0 && y == 7 )return ca8;
        if(x == 0 && y == 8 )return ca9;
        if(x == 0 && y == 9 )return ca10;
        if(x == 1 && y == 0 )return cb1;
        if(x == 1 && y == 1 )return cb2;
        if(x == 1 && y == 2 )return cb3;
        if(x == 1 && y == 3 )return cb4;
        if(x == 1 && y == 4 )return cb5;
        if(x == 1 && y == 5 )return cb6;
        if(x == 1 && y == 6 )return cb7;
        if(x == 1 && y == 7 )return cb8;
        if(x == 1 && y == 8 )return cb9;
        if(x == 1 && y == 9 )return cb10;
        if(x == 2 && y == 0 )return cc1;
        if(x == 2 && y == 1 )return cc2;
        if(x == 2 && y == 2 )return cc3;
        if(x == 2 && y == 3 )return cc4;
        if(x == 2 && y == 4 )return cc5;
        if(x == 2 && y == 5 )return cc6;
        if(x == 2 && y == 6 )return cc7;
        if(x == 2 && y == 7 )return cc8;
        if(x == 2 && y == 8 )return cc9;
        if(x == 2 && y == 9 )return cc10;
        if(x == 3 && y == 0 )return cd1;
        if(x == 3 && y == 1 )return cd2;
        if(x == 3 && y == 2 )return cd3;
        if(x == 3 && y == 3 )return cd4;
        if(x == 3 && y == 4 )return cd5;
        if(x == 3 && y == 5 )return cd6;
        if(x == 3 && y == 6 )return cd7;
        if(x == 3 && y == 7 )return cd8;
        if(x == 3 && y == 8 )return cd9;
        if(x == 3 && y == 9 )return cd10;
        if(x == 4 && y == 0 )return ce1;
        if(x == 4 && y == 1 )return ce2;
        if(x == 4 && y == 2 )return ce3;
        if(x == 4 && y == 3 )return ce4;
        if(x == 4 && y == 4 )return ce5;
        if(x == 4 && y == 5 )return ce6;
        if(x == 4 && y == 6 )return ce7;
        if(x == 4 && y == 7 )return ce8;
        if(x == 4 && y == 8 )return ce9;
        if(x == 4 && y == 9 )return ce10;
        if(x == 5 && y == 0 )return cf1;
        if(x == 5 && y == 1 )return cf2;
        if(x == 5 && y == 2 )return cf3;
        if(x == 5 && y == 3 )return cf4;
        if(x == 5 && y == 4 )return cf5;
        if(x == 5 && y == 5 )return cf6;
        if(x == 5 && y == 6 )return cf7;
        if(x == 5 && y == 7 )return cf8;
        if(x == 5 && y == 8 )return cf9;
        if(x == 5 && y == 9 )return cf10;
        if(x == 6 && y == 0 )return cg1;
        if(x == 6 && y == 1 )return cg2;
        if(x == 6 && y == 2 )return cg3;
        if(x == 6 && y == 3 )return cg4;
        if(x == 6 && y == 4 )return cg5;
        if(x == 6 && y == 5 )return cg6;
        if(x == 6 && y == 6 )return cg7;
        if(x == 6 && y == 7 )return cg8;
        if(x == 6 && y == 8 )return cg9;
        if(x == 6 && y == 9 )return cg10;
        if(x == 7 && y == 0 )return ch1;
        if(x == 7 && y == 1 )return ch2;
        if(x == 7 && y == 2 )return ch3;
        if(x == 7 && y == 3 )return ch4;
        if(x == 7 && y == 4 )return ch5;
        if(x == 7 && y == 5 )return ch6;
        if(x == 7 && y == 6 )return ch7;
        if(x == 7 && y == 7 )return ch8;
        if(x == 7 && y == 8 )return ch9;
        if(x == 7 && y == 9 )return ch10;
        if(x == 8 && y == 0 )return ci1;
        if(x == 8 && y == 1 )return ci2;
        if(x == 8 && y == 2 )return ci3;
        if(x == 8 && y == 3 )return ci4;
        if(x == 8 && y == 4 )return ci5;
        if(x == 8 && y == 5 )return ci6;
        if(x == 8 && y == 6 )return ci7;
        if(x == 8 && y == 7 )return ci8;
        if(x == 8 && y == 8 )return ci9;
        if(x == 8 && y == 9 )return ci10;
        if(x == 9 && y == 0 )return cj1;
        if(x == 9 && y == 1 )return cj2;
        if(x == 9 && y == 2 )return cj3;
        if(x == 9 && y == 3 )return cj4;
        if(x == 9 && y == 4 )return cj5;
        if(x == 9 && y == 5 )return cj6;
        if(x == 9 && y == 6 )return cj7;
        if(x == 9 && y == 7 )return cj8;
        if(x == 9 && y == 8 )return cj9;
        return cj10;
    }
}
