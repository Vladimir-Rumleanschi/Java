package battleships;

import java.io.File;
import java.io.IOException;

import battleships.gui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import battleships.network.client.Client;
import battleships.gamelogic.UserConfig;

/**
 * Main class for the Battleship game.
 *
 * This class is responsible for creating the JavaFX window and initializes all necessary
 * objects.
 *
 * @author Ray, Alaa, Vlad, Hoang
 */
public class MainApplication extends Application {

    public Stage primaryStage;
    private UserConfig userCfg;

    private Client client;

    private ConfigViewController configView;
    private WaitingController waiting;
    private GameViewController gameView;

    /**
     * Responsible for launching the whole application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the JavaFX application and configures the primary stage.
     *
     * Also gives BaseView a reference back to the main application and
     * instantiates all the other views that will be used.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        client = new Client(this); // Create a new instance of the chat client
        BaseView.setMainApp(this);


        // getting loader and a pane for the first scene so we can get the second controller
        FXMLLoader firstScreenLoader = new FXMLLoader(getClass().getResource("gui" + File.separator + "ConfigView.fxml"));
        Parent firstScreen = firstScreenLoader.load();
        Scene firstScene = new Scene(firstScreen, 601, 406);

        // getting loader and a pane for the second scene
        FXMLLoader secondScreenLoader = new FXMLLoader(getClass().getResource("gui" + File.separator + "Waiting.fxml"));
        Parent secondScreen = secondScreenLoader.load();
        Scene secondScene = new Scene(secondScreen, 600, 400);

        // getting loader and a pane for the third scene
        FXMLLoader thirdScreenLoader = new FXMLLoader(getClass().getResource("gui" + File.separator + "GameView.fxml"));
        Parent thirdScreen = thirdScreenLoader.load();
        Scene thirdScene = new Scene(thirdScreen, 921, 656);

        // injecting second scene into the controller of the first scene
        configView = firstScreenLoader.getController();
        configView.setSecondScene(secondScene);

        // injecting third scene into the controller of the second scene
        waiting = secondScreenLoader.getController();
        waiting.setThirdScene(thirdScene);

        gameView = thirdScreenLoader.getController();
        gameView.setMenu(firstScene);

        primaryStage.setTitle("Battleships");
        primaryStage.setScene(firstScene);
        primaryStage.show();
    }
    

    /**
     * Appends text to the chat in the GUI.
     * 
     * @param message The message to append.
     */
    public void appendToChat(String message) throws Exception{
        gameView.appendMessage(message);
    }

    /**
     * Appends the field as a string to the game board.
     * @param message
     */
    public void appendToBoard(String message) throws Exception{
        waiting.printField(message);
    }
//TODO
    /**
     * Appends text to the gui.
     *
     * @param field The field to append.
     */
    public void appendToGame(String field) throws Exception {
        gameView.appendToGame(field);
    }


    /**
     * Starts the chat client that connects to the server.
     * 
     * @throws IOException Throws an IOException if the server could not be reached.
     */
    public void startChatClient() throws IOException {
        getChatClient().start();
    }

    public UserConfig getUserCfg() {
        return userCfg;
    }

    public void setUserCfg(UserConfig userCfg) {
        this.userCfg = userCfg;
    }

    public Client getChatClient() {
        return client;
    }
}
