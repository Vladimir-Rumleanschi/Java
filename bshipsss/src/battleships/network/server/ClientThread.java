package battleships.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Logger;

import battleships.gamelogic.*;
import battleships.gamelogic.Objects.*;

/**
 * This class is responsible for receiving input from the client and sending it
 * to the other clients.
 *
 * When a client disconnects it will be removed from the
 * clientList.
 * @author Ray, Vlad
 */
public class ClientThread implements Runnable {

	private BufferedWriter outStream;
	private BufferedReader inStream;
	private Server server;
	private boolean horizontal;
	private int x, y, length;
	private int[][] intField = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	private Field field1;
	private Ships[] fleet = {Ships.CARRIER,
			Ships.BATTLESHIP, Ships.BATTLESHIP_2, Ships.CRUISER, Ships.CRUISER_2,
			Ships.SUBMARINE, Ships.SUBMARINE_2, Ships.DESTROYER, Ships.DESTROYER_2, Ships.DESTROYER_3
			};
	private int fleetIndex;

	final private Logger LOG = Logger.getLogger(ClientThread.class.getName());

	/**
	 * Constructor.
	 * 
	 * @param server A reference back to the ChatServer that owns this thread.
	 * @param outStream A reference to the output stream for this client.
	 * @param inStream A reference to the input stream for this client.
	 */
	public ClientThread(Server server, BufferedWriter outStream, BufferedReader inStream) {
		this.server = server;
		this.outStream = outStream;
		this.inStream = inStream;
		this.field1 = new Field(this.intField);
		this.fleetIndex = 0;
		this.horizontal = false;
	}

	/**
	 * This method will start a loop and listen for input from
	 * its client.
	 *
	 * When input is received it sends it back to the server which sends it to all connected clients.
	 */
	@Override
	public void run() {
		try {
			while (true) {

				String message = inStream.readLine();
				String[] separate = message.split(";");
				if (separate[0].equals(("chat"))) {
					server.sendToClients(message, this);
				}
				//if player sets the ships, separate strings.
				if (separate[0].equals("set")) {
					Gameplay play = new Gameplay();
					String sfield = separate[1];
					String direction = separate[2];
					if (direction.equals(("h"))) this.horizontal = true;
					else this.horizontal = false;
					int xcord = Integer. valueOf(separate[3]);
					System.out.println(xcord);
					int ycord =  Integer. valueOf(separate[4]);
					int shipsize = Integer.valueOf(separate[5]);
					this.x = xcord - 1;
					this.y = ycord - 1;
					this.length = shipsize;
					this.field1 = new Field(to2DStringArray(sfield));
					if (field1.placeable(this.x, this.y, this.fleet[fleetIndex], this.horizontal)) {
						play.SetUp(field1, this.x, this.y, this.horizontal, this.fleet[this.fleetIndex]);
						this.fleetIndex++;
					}
					else play.SetUp(field1, this.x, this.y, this.horizontal, this.fleet[this.fleetIndex]);
					field1.printFieldTest();

					server.sendToClients("set;" + toString(field1.field), this);
				}
				if (separate[0].equals("sendtome")){
					server.sendToClients(message,this);
				}
				if (separate[0].equals("sendtoenemy")){
					server.sendToClients(message,this);
				}
				if (separate[0].equals("hit")){
					server.sendToClients(message,this);
				}
				if (separate[0].equals("getpriority")){
					server.sendToClients(message,this);
				}
			}
		} catch (SocketException e) {
			// If we end up in here, the client has lost the connection
			server.removeClient(this);
			LOG.info("Client was lost.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//TODO: JavaDoc
	/**
	 * Converts the given string to a two-dimensional field array.
	 * @param s String
	 * @return two-dimensional integer array
	 */
	public int[][] to2DStringArray(String s){
		String[] stringFill = s.split("/");
		int[][] field = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

		for(int i = 0; i < 10; i++){
			String[] cals = stringFill[i].split("_");
			for(int j = 0; j < 10 ; j++){
				field[i][j] = Integer.valueOf(cals[j]);
			}
		}
		return field;
	}


	/**
	 * Converts the two-dimensional integer to a string.
	 * @param arr two-dimensional integer
	 * @return String
	 */
	public String toString(int[][] arr){
		String s = "";
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10 ; j++){
				if(j == 9){
					String var = String.valueOf(arr[i][j]);
					s = s + var ;
				}else {
					String var = String.valueOf(arr[i][j]);
					s = s + var  + "_";
				}
			}
			if(i != 9){
				s = s + "/";
			}
		}
		return s;
	}

	public BufferedWriter getWriter() {
		return this.outStream;
	}
}
