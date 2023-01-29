package battleships.gui;

import battleships.MainApplication;
import battleships.gamelogic.UserConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class represents a controller for ConfigView.fxml.
 *
 * @author Alaa
 */
public class ConfigViewController extends BaseView{

    @FXML
    AnchorPane anchorPane;
    @FXML
    Button multiplayer, singleplayer;
    @FXML
    TextField userName;
    @FXML
    Text note;


    private MainApplication mainApp = BaseView.getMainApp();

    private Scene secondScene;

    /**
     * Sets the new scene to Waiting
     * @param scene
     */
    public void setSecondScene(Scene scene) {
        secondScene = scene;
    }


    /**
     * When the multiplayer button is pressed the username is saved, the client starts and the new window opens
     * @throws IOException
     */
    public void handleMulti() throws IOException{

        UserConfig userCfg = new UserConfig();
        userCfg.setUsername(userName.getText());
        //save the username
        mainApp.setUserCfg(userCfg);

        try {
            mainApp.startChatClient();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Could not connect");
            alert.setHeaderText("Could not connect to the server.");
            alert.setContentText("Make sure you're using the correct IP and Port, or that\n"
                    + "the server you're trying to connect to is running.");

            alert.showAndWait();
        }
        Stage primaryStage = (Stage) ((Node)multiplayer).getScene().getWindow();
        primaryStage.setScene(secondScene);
        String css = ConfigViewController.class.getResource("waitingbg.css").toExternalForm();
        secondScene.getStylesheets().add(css);
    }

    public void handleSingle() {
        note.setVisible(true);
    }
}
