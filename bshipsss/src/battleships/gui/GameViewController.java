package battleships.gui;

import battleships.MainApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.nio.file.Paths;


/**
 * This class represents the controller for the GameView.fxml which displays the game field.
 *
 * @author Alaa,Vladimir
 */
public class GameViewController extends BaseView {

    @FXML
    AnchorPane anchorPane;
    @FXML
    Button send, quit;
    @FXML
    TextArea chatBox;
    @FXML
    TextField chatInput, win;
    @FXML
    Text turn;

    @FXML
    Button  A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,
            B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,
            C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,
            D1,D2,D3,D4,D5,D6,D7,D8,D9,D10,
            E1,E2,E3,E4,E5,E6,E7,E8,E9,E10,
            F1,F2,F3,F4,F5,F6,F7,F8,F9,F10,
            G1,G2,G3,G4,G5,G6,G7,G8,G9,G10,
            H1,H2,H3,H4,H5,H6,H7,H8,H9,H10,
            I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,
            J1,J2,J3,J4,J5,J6,J7,J8,J9,J10;

    @FXML
    Button  A11,A21,A31,A41,A51,A61,A71,A81,A91,A101,
            B11,B21,B31,B41,B51,B61,B71,B81,B91,B101,
            C11,C21,C31,C41,C51,C61,C71,C81,C91,C101,
            D11,D21,D31,D41,D51,D61,D71,D81,D91,D101,
            E11,E21,E31,E41,E51,E61,E71,E81,E91,E101,
            F11,F21,F31,F41,F51,F61,F71,F81,F91,F101,
            G11,G21,G31,G41,G51,G61,G71,G81,G91,G101,
            H11,H21,H31,H41,H51,H61,H71,H81,H91,H101,
            I11,I21,I31,I41,I51,I61,I71,I81,I91,I101,
            J11,J21,J31,J41,J51,J61,J71,J81,J91,J101;

    String[][] myField =    {{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};


    String[][] enemyField = {{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
                            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}};

    WaitingController waiting = new WaitingController();

    private MainApplication mainApp = BaseView.getMainApp();

    private Scene backToMenu;

    /**
     * Sets the new scene to ConfigView.
     * @param scene
     */
    public void setMenu(Scene scene) {
        backToMenu = scene;
    }

    private int numberOfOwnHits = 0;
    private int numberOfEnemyHits = 0;
    private int gamePriority = 0;

    /**
     * When the send button is clicked the input is sent
     * to the server and appended to the chat box.
     *
     *
     * @throws Exception
     */
    public void handleSend() throws Exception{
            String User = mainApp.getUserCfg().getUsername();
            String message = chatInput.getText();
            mainApp.getChatClient().sendMessage("chat;" + User + ": " + message + "\n");
            chatBox.appendText("You" + ": " + message + "\n");
            chatInput.clear();
            chatInput.requestFocus();

    }

    /**
     * Calls handleSend when enter is pressed.
     * @param e key pressed
     * @throws Exception
     */
    public void enterPressed(KeyEvent e) throws Exception{
        if (e.getCode().equals(KeyCode.ENTER)) {
            handleSend();
        }
    }

    /**
     * Sends the hit to the server.
     * @param e
     * @throws Exception
     */
    public void hitEnemyField(ActionEvent e)throws Exception{
        Button save = (Button) e.getSource();
        save.setText("X");
        String temp = save.getId();

        int x = charToInt(temp.charAt(0));
        String y = "" + temp.charAt(1);
        if(temp.length() == 3) y = y + temp.charAt(2);

        hitCheck(x,Integer.parseInt(y));
        turn.setVisible(true);

        mainApp.getChatClient().sendMessage("hit;" + x + ";" + y + "\n");

        //win
        if(numberOfOwnHits == 31){
            disableEnemyButtons(true);
            chatBox.setVisible(false);
            chatInput.setVisible(false);
            send.setVisible(false);
            turn.setVisible(false);

            //win.setVisible(true);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Congratulations, you've won the game!", ButtonType.OK);
            alert.setTitle("Winner");
            alert.setHeaderText("You are the winner.");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.FINISH) {
                alert.close();
            }
            quit.setVisible(true);
        }
    }

    /**
     * Converts the letter of the coordinate to a number form 1 to 10.
     *
     * @param x char to convert
     * @return
     */
    private int charToInt(char x) {
        switch (x) {
            case 'A':
                return 1;
            case 'B':
                return 2;
            case 'C':
                return 3;
            case 'D':
                return 4;
            case 'E':
                return 5;
            case 'F':
                return 6;
            case 'G':
                return 7;
            case 'H':
                return 8;
            case 'I':
                return 9;
            case 'J':
                return 10;
        }
        return 0;
    }

    /**
     * Checks if the field is a boat of the enemy.
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void hitCheck(int x, int y){
        //AudioClip hit = new AudioClip(Paths.get("watersplash.mp3").toUri().toString());
        //System.out.println(Paths.get("watersplash.mp3").toUri().toString());
        //String path = new File("watersplash.mp3").getAbsolutePath();
        //Media sound = new Media(new File(path).toURI().toString());
        //MediaPlayer mediaPlayer = new MediaPlayer(sound);
        //hit.play();

        if(enemyField[x - 1][y - 1].equals("0")){
            getEnemyButton(x - 1,y - 1).setStyle("-fx-background-color: #00c4ff; ");
            disableEnemyButtons(true);
        }else{
            getEnemyButton(x - 1,y - 1).setStyle("-fx-background-color: #ff0000; ");
            getEnemyButton(x - 1,y - 1).setDisable(true);
            numberOfOwnHits++;
        }
    }


    /**
     * Checks if the buttons was already used .
     */
    public void checkForHits(){
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                int finalI = i;
                int finalJ = j;

                Platform.runLater(
                        () -> {
                            if(getEnemyButton(finalI,finalJ).getText().equals("X")){
                                getEnemyButton(finalI,finalJ).setDisable(true);
                            }
                        }
                );
            }
        }
    }

    /**
     * Checks which client must be first
     * @param priority priority of clients.
     */

    public void checkPriority(String priority){
        int var = Integer.parseInt(priority);
        var = var % 2;
        if(var == 1){
            disableEnemyButtons(true);
        }else{
            disableEnemyButtons(false);
        }
    }
    /**
     * Is called when a new message arrives and appends it to the chat box.
     * @param message
     * @throws Exception
     */
    public void appendMessage(String message) throws Exception{
        chatBox.appendText(message);
    }


    /**
     * Edits the field depending on the action.
     *
     * @param info
     * @throws Exception
     */
    public void appendToGame(String info) throws Exception{
        String[] separate = info.split(";");
        if(separate[0].equals("sendtome")) appendToMyBoard(separate[1]);
        if(separate[0].equals("sendtoenemy")) setEnemyField(separate[1]);
        if(separate[0].equals("hit")) appendHit(info);
        if(separate[0].equals("getpriority")) checkPriority(separate[1]);
    }


    /**
     * Changes the enemy field.
     * @param tempEnemyField
     */
    public void setEnemyField(String tempEnemyField){
        this.enemyField = waiting.to2DStringArray(tempEnemyField);
    }

    /**
     * Appends the enemy hit to the board.
     * @param hit
     * @throws Exception
     */
    public void appendHit(String hit)throws Exception{
        String[] separate = hit.split(";");
        int x = Integer.parseInt(separate[1]);
        int y = Integer.parseInt(separate[2]);
        if(myField[x - 1][y - 1].equals("0")){
            disableEnemyButtons(false);
        }else{
            numberOfEnemyHits++;
        }
        checkForHits();
        turn.setVisible(false);

        try {
            int finalI = x - 1;
            int finalJ = y - 1;
            Platform.runLater(
                    () -> {
                        getMyButton(finalI, finalJ).setText("X");
                        getMyButton(finalI, finalJ).setStyle("-fx-background-color: #ff0000; ");
                    }
            );

        }
        catch (NumberFormatException ex) {
            System.out.println("exception");
        }



            Platform.runLater(
                    () -> {
                        if (numberOfEnemyHits == 31) {
                            disableEnemyButtons(true);
                            chatBox.setVisible(false);
                            chatInput.setVisible(false);
                            send.setVisible(false);
                            turn.setVisible(false);


                            Alert alertLost = new Alert(Alert.AlertType.INFORMATION, "You've lost the game!", ButtonType.OK);
                            alertLost.setTitle("Loser");
                            alertLost.setHeaderText("You lost.");
                            alertLost.showAndWait();

                            if (alertLost.getResult() == ButtonType.FINISH) {
                                alertLost.close();
                            }
                            quit.setVisible(true);
                        }
                    }
            );

    }

    /**
     * Disables all enemy buttons.
     * @param bool true disables, false enables
     */
    public void disableEnemyButtons(boolean bool){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10 ; j++){
                int finalI = i;
                int finalJ = j;
                Platform.runLater(
                        () -> {
                            getEnemyButton(finalJ, finalI).setDisable(bool);
                        }
                );
            }
        }
    }


    /**
     * Displays the own field.
     * @param field
     * @throws Exception
     */
    public void appendToMyBoard(String field) throws Exception{
        myField = waiting.to2DStringArray(field);

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10 ; j++){
                try {
                    if (Integer.parseInt(myField[j][i]) == 0) {
                        int finalI = i;
                        int finalJ = j;
                        Platform.runLater(
                                () -> {
                                    getMyButton(finalJ, finalI).setStyle("-fx-background-color: #0037ff; ");
                                }
                        );
                    } else {
                        int finalI = i;
                        int finalJ = j;
                        Platform.runLater(
                                () -> {
                                    getMyButton(finalJ, finalI).setStyle("-fx-background-color: #ff8c00; ");
                                }
                        );
                    }
                }
                catch (NumberFormatException ex) {
                    System.out.println("Exception");
                }
            }
        }
    }

    /**
     * Return to the menu after lose/win.
     */
    public void handleQuit() {
        Stage primaryStage = (Stage) quit.getScene().getWindow();
        primaryStage.setScene(backToMenu);
    }


    /**
     * Gives the button what corresponds to x-,y-coordinate back.
     * @param x x-coordinate of the Button
     * @param y y-coordinate of the Button
     * @return the Button on the
     */
    public Button getMyButton(int x, int y){
        if(x == 0 && y == 0 ) return A11;
        if(x == 0 && y == 1 )return A21;
        if(x == 0 && y == 2 )return A31;
        if(x == 0 && y == 3 )return A41;
        if(x == 0 && y == 4 )return A51;
        if(x == 0 && y == 5 )return A61;
        if(x == 0 && y == 6 )return A71;
        if(x == 0 && y == 7 )return A81;
        if(x == 0 && y == 8 )return A91;
        if(x == 0 && y == 9 )return A101;
        if(x == 1 && y == 0 )return B11;
        if(x == 1 && y == 1 )return B21;
        if(x == 1 && y == 2 )return B31;
        if(x == 1 && y == 3 )return B41;
        if(x == 1 && y == 4 )return B51;
        if(x == 1 && y == 5 )return B61;
        if(x == 1 && y == 6 )return B71;
        if(x == 1 && y == 7 )return B81;
        if(x == 1 && y == 8 )return B91;
        if(x == 1 && y == 9 )return B101;
        if(x == 2 && y == 0 )return C11;
        if(x == 2 && y == 1 )return C21;
        if(x == 2 && y == 2 )return C31;
        if(x == 2 && y == 3 )return C41;
        if(x == 2 && y == 4 )return C51;
        if(x == 2 && y == 5 )return C61;
        if(x == 2 && y == 6 )return C71;
        if(x == 2 && y == 7 )return C81;
        if(x == 2 && y == 8 )return C91;
        if(x == 2 && y == 9 )return C101;
        if(x == 3 && y == 0 )return D11;
        if(x == 3 && y == 1 )return D21;
        if(x == 3 && y == 2 )return D31;
        if(x == 3 && y == 3 )return D41;
        if(x == 3 && y == 4 )return D51;
        if(x == 3 && y == 5 )return D61;
        if(x == 3 && y == 6 )return D71;
        if(x == 3 && y == 7 )return D81;
        if(x == 3 && y == 8 )return D91;
        if(x == 3 && y == 9 )return D101;
        if(x == 4 && y == 0 )return E11;
        if(x == 4 && y == 1 )return E21;
        if(x == 4 && y == 2 )return E31;
        if(x == 4 && y == 3 )return E41;
        if(x == 4 && y == 4 )return E51;
        if(x == 4 && y == 5 )return E61;
        if(x == 4 && y == 6 )return E71;
        if(x == 4 && y == 7 )return E81;
        if(x == 4 && y == 8 )return E91;
        if(x == 4 && y == 9 )return E101;
        if(x == 5 && y == 0 )return F11;
        if(x == 5 && y == 1 )return F21;
        if(x == 5 && y == 2 )return F31;
        if(x == 5 && y == 3 )return F41;
        if(x == 5 && y == 4 )return F51;
        if(x == 5 && y == 5 )return F61;
        if(x == 5 && y == 6 )return F71;
        if(x == 5 && y == 7 )return F81;
        if(x == 5 && y == 8 )return F91;
        if(x == 5 && y == 9 )return F101;
        if(x == 6 && y == 0 )return G11;
        if(x == 6 && y == 1 )return G21;
        if(x == 6 && y == 2 )return G31;
        if(x == 6 && y == 3 )return G41;
        if(x == 6 && y == 4 )return G51;
        if(x == 6 && y == 5 )return G61;
        if(x == 6 && y == 6 )return G71;
        if(x == 6 && y == 7 )return G81;
        if(x == 6 && y == 8 )return G91;
        if(x == 6 && y == 9 )return G101;
        if(x == 7 && y == 0 )return H11;
        if(x == 7 && y == 1 )return H21;
        if(x == 7 && y == 2 )return H31;
        if(x == 7 && y == 3 )return H41;
        if(x == 7 && y == 4 )return H51;
        if(x == 7 && y == 5 )return H61;
        if(x == 7 && y == 6 )return H71;
        if(x == 7 && y == 7 )return H81;
        if(x == 7 && y == 8 )return H91;
        if(x == 7 && y == 9 )return H101;
        if(x == 8 && y == 0 )return I11;
        if(x == 8 && y == 1 )return I21;
        if(x == 8 && y == 2 )return I31;
        if(x == 8 && y == 3 )return I41;
        if(x == 8 && y == 4 )return I51;
        if(x == 8 && y == 5 )return I61;
        if(x == 8 && y == 6 )return I71;
        if(x == 8 && y == 7 )return I81;
        if(x == 8 && y == 8 )return I91;
        if(x == 8 && y == 9 )return I101;
        if(x == 9 && y == 0 )return J11;
        if(x == 9 && y == 1 )return J21;
        if(x == 9 && y == 2 )return J31;
        if(x == 9 && y == 3 )return J41;
        if(x == 9 && y == 4 )return J51;
        if(x == 9 && y == 5 )return J61;
        if(x == 9 && y == 6 )return J71;
        if(x == 9 && y == 7 )return J81;
        if(x == 9 && y == 8 )return J91;
        return J101;
    }

    /**
     * Gives the button what corresponds to x-,y-coordinate back.
     * @param x x-coordinate of the Button
     * @param y y-coordinate of the Button
     * @return the Button on the
     */
    public Button getEnemyButton(int x, int y){
        if(x == 0 && y == 0 )return A1;
        if(x == 0 && y == 1 )return A2;
        if(x == 0 && y == 2 )return A3;
        if(x == 0 && y == 3 )return A4;
        if(x == 0 && y == 4 )return A5;
        if(x == 0 && y == 5 )return A6;
        if(x == 0 && y == 6 )return A7;
        if(x == 0 && y == 7 )return A8;
        if(x == 0 && y == 8 )return A9;
        if(x == 0 && y == 9 )return A10;
        if(x == 1 && y == 0 )return B1;
        if(x == 1 && y == 1 )return B2;
        if(x == 1 && y == 2 )return B3;
        if(x == 1 && y == 3 )return B4;
        if(x == 1 && y == 4 )return B5;
        if(x == 1 && y == 5 )return B6;
        if(x == 1 && y == 6 )return B7;
        if(x == 1 && y == 7 )return B8;
        if(x == 1 && y == 8 )return B9;
        if(x == 1 && y == 9 )return B10;
        if(x == 2 && y == 0 )return C1;
        if(x == 2 && y == 1 )return C2;
        if(x == 2 && y == 2 )return C3;
        if(x == 2 && y == 3 )return C4;
        if(x == 2 && y == 4 )return C5;
        if(x == 2 && y == 5 )return C6;
        if(x == 2 && y == 6 )return C7;
        if(x == 2 && y == 7 )return C8;
        if(x == 2 && y == 8 )return C9;
        if(x == 2 && y == 9 )return C10;
        if(x == 3 && y == 0 )return D1;
        if(x == 3 && y == 1 )return D2;
        if(x == 3 && y == 2 )return D3;
        if(x == 3 && y == 3 )return D4;
        if(x == 3 && y == 4 )return D5;
        if(x == 3 && y == 5 )return D6;
        if(x == 3 && y == 6 )return D7;
        if(x == 3 && y == 7 )return D8;
        if(x == 3 && y == 8 )return D9;
        if(x == 3 && y == 9 )return D10;
        if(x == 4 && y == 0 )return E1;
        if(x == 4 && y == 1 )return E2;
        if(x == 4 && y == 2 )return E3;
        if(x == 4 && y == 3 )return E4;
        if(x == 4 && y == 4 )return E5;
        if(x == 4 && y == 5 )return E6;
        if(x == 4 && y == 6 )return E7;
        if(x == 4 && y == 7 )return E8;
        if(x == 4 && y == 8 )return E9;
        if(x == 4 && y == 9 )return E10;
        if(x == 5 && y == 0 )return F1;
        if(x == 5 && y == 1 )return F2;
        if(x == 5 && y == 2 )return F3;
        if(x == 5 && y == 3 )return F4;
        if(x == 5 && y == 4 )return F5;
        if(x == 5 && y == 5 )return F6;
        if(x == 5 && y == 6 )return F7;
        if(x == 5 && y == 7 )return F8;
        if(x == 5 && y == 8 )return F9;
        if(x == 5 && y == 9 )return F10;
        if(x == 6 && y == 0 )return G1;
        if(x == 6 && y == 1 )return G2;
        if(x == 6 && y == 2 )return G3;
        if(x == 6 && y == 3 )return G4;
        if(x == 6 && y == 4 )return G5;
        if(x == 6 && y == 5 )return G6;
        if(x == 6 && y == 6 )return G7;
        if(x == 6 && y == 7 )return G8;
        if(x == 6 && y == 8 )return G9;
        if(x == 6 && y == 9 )return G10;
        if(x == 7 && y == 0 )return H1;
        if(x == 7 && y == 1 )return H2;
        if(x == 7 && y == 2 )return H3;
        if(x == 7 && y == 3 )return H4;
        if(x == 7 && y == 4 )return H5;
        if(x == 7 && y == 5 )return H6;
        if(x == 7 && y == 6 )return H7;
        if(x == 7 && y == 7 )return H8;
        if(x == 7 && y == 8 )return H9;
        if(x == 7 && y == 9 )return H10;
        if(x == 8 && y == 0 )return I1;
        if(x == 8 && y == 1 )return I2;
        if(x == 8 && y == 2 )return I3;
        if(x == 8 && y == 3 )return I4;
        if(x == 8 && y == 4 )return I5;
        if(x == 8 && y == 5 )return I6;
        if(x == 8 && y == 6 )return I7;
        if(x == 8 && y == 7 )return I8;
        if(x == 8 && y == 8 )return I9;
        if(x == 8 && y == 9 )return I10;
        if(x == 9 && y == 0 )return J1;
        if(x == 9 && y == 1 )return J2;
        if(x == 9 && y == 2 )return J3;
        if(x == 9 && y == 3 )return J4;
        if(x == 9 && y == 4 )return J5;
        if(x == 9 && y == 5 )return J6;
        if(x == 9 && y == 6 )return J7;
        if(x == 9 && y == 7 )return J8;
        if(x == 9 && y == 8 )return J9;
        return J10;
    }
}

