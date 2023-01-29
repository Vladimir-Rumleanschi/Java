package battleships.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class represents the server for every chat client.
 *
 * It creates a new thread for every new
 * client that connects on the same port.
 *
 * @author Ray, Vlad
 */
public class Server {

	final private int PORT = 1234;
	final private List<ClientThread> clientList = new ArrayList<ClientThread>();

	final private Logger LOG = Logger.getLogger(Server.class.getName());

	private int playersPriority = 1;

	/**
	 * Starts the server.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}

	/**
	 * This method opens a ServerSocket and starts a loop
	 * while it's waiting for new clients.
	 *
	 * Whenever a client connects a new thread is assigned and stored
	 * into the clientList.
	 */
	public void start() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			LOG.info("Server has started and is listening for clients.");


			// Go into an infinite loop and listen for connection requests
			while (true) {


				Socket clientSocket = serverSocket.accept();
				LOG.info("A client has connected.");

				// Get streams
				BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"));
				outStream.flush();
				BufferedReader inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));


				// Create a new thread
				ClientThread clientThread = new ClientThread(this, outStream, inStream);
				clientList.add(clientThread);

				Thread thread = new Thread(clientThread);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Removes a client from the clientList if the server disconnects.
	 *
	 * @param client Client to be removed.
	 */
	protected void removeClient(ClientThread client) {
		clientList.remove(clientList.indexOf(client));
	}

	/**
	 * Sends a message from a client to all other connected clients depending on the executed action.
	 * 
	 * @param message Message to be send
	 * @param sender The client that sent the message
	 */
	protected void sendToClients(String message, ClientThread sender) {
		for (ClientThread clientThread : clientList) {
			String[] separate = message.split(";");
			//Don't send messages to yourself
			if (clientThread == sender) {
				if (separate[0].equals(("chat")) || separate[0].equals(("hit")) || separate[0].equals(("sendtoenemy")) ) {
					continue;
				}
			}
			//if player sets the ships, separate strings.
			if (clientThread != sender){
				if (separate[0].equals("set") || separate[0].equals("sendtome") || separate[0].equals("getpriority")) {
					continue;
				}
			}

			if (clientThread == sender) {
				if (separate[0].equals(("getpriority"))) {
					message = message + playersPriority;
					playersPriority++;
				}
			}


			try {
				clientThread.getWriter().write(message + "\n");
				clientThread.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
