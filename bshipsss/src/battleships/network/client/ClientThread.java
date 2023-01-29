package battleships.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.SocketException;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class receives input from the server and displays it.
 * 
 * It notifies the user if the server disconnects.
 * @author Ray, Vlad
 */
public class ClientThread implements Runnable {

    private Client client;
    private BufferedWriter outStream;
    private BufferedReader inStream;

    /**
     * Constructor.
     * 
     * @param client Reference back to the ChatClient that owns this thread.
     * @param outStream Reference to the OutputStream.
     * @param inStream Reference to the InputStream.
     */
    public ClientThread(Client client, BufferedWriter outStream,
            BufferedReader inStream) {
        this.client = client;
        this.outStream = outStream;
        this.inStream = inStream;
    }

    /**
     * This method starts a loop and listens for input.
     *
     * When input is received, it will call different methods depending on the given input.
     */
    @Override
    public void run() {
        try {
        	
            while (true) {
                String message = inStream.readLine();
                String[] separate = message.split(";");
                if(separate[0].equals("chat")){
                    client.getMainApp().appendToChat(message.substring(5) + "\n");
                }else if(separate[0].equals("set")) {
                    client.getMainApp().appendToBoard(message);
                }else if(separate[0].equals("sendtome")){
                    client.getMainApp().appendToGame(message);
                }else if (separate[0].equals("sendtoenemy")){
                    System.out.println(message);
                    client.getMainApp().appendToGame(message);
                }else if (separate[0].equals("hit")){
                    client.getMainApp().appendToGame(message);
                }else if (separate[0].equals("getpriority")){
                client.getMainApp().appendToGame(message);
            }

            }
        } catch (SocketException e) {
            //Client has lost the connection
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Connection Lost");
                    alert.setHeaderText("Lost the connection to the server.");
                    alert.setContentText("The connection to the server was lost.");
                    alert.showAndWait();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BufferedWriter getWriter() {
        return this.outStream;
    }

}
