package battleships.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import battleships.MainApplication;

/**
 * This class connects to the server allows exchanging messages.
 *
 * @author Ray, Vlad
 */
public class Client {

    private MainApplication mainApp;

    private Socket clientSocket;
    private ClientThread clientThread;

    /**
     * Constructor.
     * 
     * @param mainApp Reference to the main.
     */
    public Client(MainApplication mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Creates a new thread which listens for new messages of the server to show them in the chat.
     * 
     * @throws IOException
     */
    public void start() throws IOException {
        String host = mainApp.getUserCfg().getHost();
        int port = Integer.valueOf(mainApp.getUserCfg().getPort());
        clientSocket = new Socket(host, port);

        //Get streams
        BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"));
        //outStream.flush()
        BufferedReader inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
        //Create a new thread
        clientThread = new ClientThread(this, outStream, inStream);
        
        Thread thread = new Thread(clientThread);
        thread.start();
    }


    /**
     * Sends a message to the server.
     * 
     * @param message Message
     */
    public void sendMessage(String message) {
        try {
            clientThread.getWriter().write(message);
            clientThread.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected MainApplication getMainApp() {
        return mainApp;
    }

}
