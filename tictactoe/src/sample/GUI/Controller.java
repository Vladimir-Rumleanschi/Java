package sample.GUI;

import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import sample.SpielLogik.Logik;


public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;
    int priority = 0;

    public Button a1,a2,a3,
                   b1,b2,b3,
                   c1,c2,c3;
    public Button quit,newgame,endtext;

    /**
     * Load new game scenes on game window
     *
     * @param event Game event
     * */
    public void switchToGameScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Gamescene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Check which player turn is currently available
     *
     * @param event Current game event
     * */
    public void checkMove(ActionEvent event)throws IOException{
        Button move = (Button) event.getSource();
        if(priority % 2 == 0){
            move.setText("X");
            move.setStyle("-fx-background-color: #ff0000; ");
            priority++;
        }else {
            move.setText("O");
            move.setStyle("-fx-background-color: #0048ff; ");
            priority++;
        }


        Logik bot = new Logik();
        int status = bot.checkForVictory(new String[]{a1.getText(),a2.getText(),a3.getText(),b1.getText(),b2.getText(),b3.getText(),c1.getText(),c2.getText(),c3.getText()});
        if(status == 1 && priority % 2 == 1){
            moveToScene("won",1);
            disableButtons(true);
        }else if(status == 1 && priority % 2 == 0){
            moveToScene("won",2);
            disableButtons(true);
        }else if(status == 0){
            moveToScene("draw",0);
            disableButtons(true);
        }


    }

    /**
     * */
    public void printField(String[] field){
        System.out.println("-----");
        for(int i = 0;i < field.length; i = i + 3){
            System.out.println(field[i] + " " + field[i+1] + " " + field[i+2]);
        }
    }

    /**
     * Disable button on the game UI
     *
     * @param tag   Tags defined for all buttons
     * */
    public void disableButtons( boolean tag){

            a1.setDisable(tag);
            a2.setDisable(tag);
            a3.setDisable(tag);
            b1.setDisable(tag);
            b2.setDisable(tag);
            b3.setDisable(tag);
            c1.setDisable(tag);
            c2.setDisable(tag);
            c3.setDisable(tag);
    }

    /**
     * Set status for each button
     *
     * @param position   Position as integer
     * */
    public void setButton(int position){
        if(position == 0) {
            a1.setText("O");
            a1.setStyle("-fx-background-color: #0088ff; ");
        }
        if(position == 1) {
            a2.setText("O");
            a2.setStyle("-fx-background-color: #0088ff; ");
        }
        if(position == 2) {
            a3.setText("O");
            a3.setStyle("-fx-background-color: #0088ff; ");
        }
        if(position == 3) {
            b1.setText("O");
            b1.setStyle("-fx-background-color: #0088ff; ");
        }
        if(position == 4) {
            b2.setText("O");
            b2.setStyle("-fx-background-color: #0088ff; ");
        }
        if(position == 5) {
            b3.setText("O");
            b3.setStyle("-fx-background-color: #0088ff; ");
        }
        if(position == 6) {
            c1.setText("O");
            c1.setStyle("-fx-background-color: #0088ff; ");
        }
        if(position == 7) {
            c2.setText("O");
            c2.setStyle("-fx-background-color: #0088ff; ");
        }
        if(position == 8) {
            c3.setText("O");
            c3.setStyle("-fx-background-color: #0088ff; ");
        }
    }

    /**
     * Checks if game has ended and give options to close the game or start a new game
     *
     * @param event Current game event
     * */
    public void endGame(ActionEvent event) throws IOException{
        Button bt = (Button) event.getSource();
        if(bt.getText().equals("Quit"))System.exit(0);;
        if(bt.getText().equals("New game")){
            disableButtons(false);
            resetButtons();
            priority = 0;
            quit.setVisible(false);
            newgame.setVisible(false);
            endtext.setVisible(false);
        }
    }

    /**
     * Reset status of all buttons
     * */
    public void resetButtons(){
        a1.setText("");
        a1.setStyle("-fx-background-color: #ffffff; ");
        a2.setText("");
        a2.setStyle("-fx-background-color: #ffffff; ");
        a3.setText("");
        a3.setStyle("-fx-background-color: #ffffff; ");
        b1.setText("");
        b1.setStyle("-fx-background-color: #ffffff; ");
        b2.setText("");
        b2.setStyle("-fx-background-color: #ffffff; ");
        b3.setText("");
        b3.setStyle("-fx-background-color: #ffffff; ");
        c1.setText("");
        c1.setStyle("-fx-background-color: #ffffff; ");
        c2.setText("");
        c2.setStyle("-fx-background-color: #ffffff; ");
        c3.setText("");
        c3.setStyle("-fx-background-color: #ffffff; ");

    }

    /**
     * Announces which player has won the game
     *
     * @param tag   Current status
     * @param player    Player number
     * */
    public void moveToScene(String tag, int player){
        if(tag.equals("won") && player == 1 ){
            quit.setVisible(true);
            newgame.setVisible(true);
            endtext.setText("Player 1 won");
            endtext.setStyle("-fx-background-color: #ff0000; ");
            endtext.setVisible(true);
        }else if(tag.equals("won") && player == 2){
            quit.setVisible(true);
            newgame.setVisible(true);
            endtext.setText("Player 2 won");
            endtext.setStyle("-fx-background-color: #0088ff; ");
            endtext.setVisible(true);
        }else{
            quit.setVisible(true);
            newgame.setVisible(true);
            endtext.setText("Draw");
            endtext.setStyle("-fx-background-color: #64c90b; ");
            endtext.setVisible(true);
        }

    }

}