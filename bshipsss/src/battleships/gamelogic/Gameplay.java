package battleships.gamelogic;
import java.util.Scanner;

import battleships.gamelogic.Objects.*;

//
public class Gameplay {
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
	private Field playerField = new Field(field);
	private Field enemyField = new Field(field);
	private Ships[] fleet = {//Ships.CARRIER,
			Ships.BATTLESHIP, Ships.BATTLESHIP_2, Ships.CRUISER, Ships.CRUISER_2,
			Ships.SUBMARINE, Ships.SUBMARINE_2, Ships.DESTROYER, Ships.DESTROYER_2, Ships.DESTROYER_3
			};
	private String[] latitude = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	private int[] playerFleetHP = new int[fleet.length];
	private int[] enemyFleetHP = new int[fleet.length];
	Scanner sc = new Scanner(System.in);
	private Bot bot1 = new Bot();
	public int x, y, fleetIndex;
	public boolean horizontal;
	
	public Gameplay() {
		for (int i = 0; i < this.fleet.length; i++) {
			playerFleetHP[i] = this.fleet[i].getSize();
			enemyFleetHP[i] = this.fleet[i].getSize();
		}
		this.x = 0;
		this.y = 0;
		this.fleetIndex = 0;
	}

	public void setCoordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void SetUp(Field inputField, int x, int y, boolean horizontal, Ships ship) {
		boolean shipPlaced = false;
		System.out.printf("Place %s on the field.\n", this.fleet[this.fleetIndex].getName());
		int a = 0;
		//while (!shipPlaced) {
			a++;
			/*
				System.out.println("Select latitude:");
				String lat = ConsoleInput.getChoice(this.latitude, "Select latitude (only uppercase letter from A to J available): ");
				int x = inputField.rowConvert(lat);
				System.out.println("Select longitude:");
				int y = this.sc.nextInt() - 1;				
				String placement = ConsoleInput.getChoice(hv, "Place ship horizonally or vertically? Choose h or v");
				if (placement.equals("h")) horizontal = true;

			if (a > 2) {
				System.out.println("Break while loop");
				break;
			}
			*/
			if (this.fleetIndex > 9) {
				System.out.println("Cannot place more.");
				//break;
			}
			if (inputField.placeable(x, y, ship, horizontal)) {
				inputField.placeShip(x, y, ship, horizontal);
				System.out.printf("%s has been deployed on the field.\n", ship.getName());
				//System.out.println("Else reached");
				//this.fleetIndex++;
				//shipPlaced = true;
				//break;
			}
			/*
			else {
				System.out.println("Invalid coordinate, please try again.");
				continue;
			}
			*/
		//}
		inputField.printField();
		System.out.printf("x: %d, y:%d \n", x, y);
	}

	public void setUp2(Field inputField, int x, int y, int shipLength, boolean horizontal) {
		if (playerField.placeable(x, y, this.fleet[shipLength], horizontal)) {
			playerField.placeShip(x, y, this.fleet[shipLength], horizontal);
		}
		else {
			System.out.println("Invalid coordinate, please try again.");
		}
	}
	
	private void playTurn(Field inputField, int[] fleetHP) {
		boolean attackFinished = false;
		while (!attackFinished) {
			System.out.println("Select latitude to attack:");
			String lat = ConsoleInput.getChoice(latitude, "Select latitude (only uppercase letter from A to J available): ");
			int x = inputField.rowConvert(lat);
			System.out.println("Select longitude to attack:");
			int y = this.sc.nextInt() - 1;
			if (x > 9 || y > 9) {
				System.out.println("Invalid coordinate, please try again.");
				continue;
			}
			if (inputField.getValue(x, y) == 1 || inputField.getValue(x, y) == 2) {
				System.out.println("This coordinate has already been fired upon.");
				continue;
			}
			else if (inputField.getValue(x, y) == 0) {
				System.out.println("You missed enemy ships.");
				inputField.setValue(x, y, 1);
				attackFinished = true;
			}
			else {
				System.out.println("You hit the enemy ships!");
				fleetHP[inputField.getValue(x, y) - 3]--;
				inputField.setValue(x, y, 2);
				attackFinished = true;
			}
		}
	}
	
	private void endTurn() {
		System.out.println("Player field:");
		playerField.printField();
		System.out.println("Enemy field:");
		enemyField.printEnemyField();
		int playerHP = 0;
		int enemyHP = 0;
		for (int i = 0; i < fleet.length; i++) {
			playerHP += playerFleetHP[i];
			enemyHP += enemyFleetHP[i];
		}
		if (playerHP < 1) {
			System.out.println("You have lost the battle.");
			System.exit(0);
		}
		else if (enemyHP < 1) {
			System.out.println("You have achieved victory.");
			System.exit(0);
		}
	}
	
	public void Play() {
		//SetUp(playerField);
		//SetUp(enemyField);
		while(true) {
			playTurn(enemyField, this.enemyFleetHP);
			endTurn();
			playTurn(playerField, this.playerFleetHP);
			endTurn();
		}
	}
	
	public void SinglePlay() {
		//SetUp(this.playerField);
		bot1.SetUp(enemyField);
		while(true) {
			playTurn(enemyField, this.enemyFleetHP);
			bot1.playTurn(playerField, playerFleetHP);
			endTurn();
		}
	}
	
	public void BotVsBot () {
		long time = System.currentTimeMillis();
		Field botField1 = new Field(this.field);
		Field botField2 = new Field(this.field);
		Bot bot1 = new Bot();
		Bot bot2 = new Bot();
		int[] fleetHP1 = new int[bot1.fleet.length];
		int[] fleetHP2 = new int[bot2.fleet.length];
		for (int i = 0; i < bot1.fleet.length; i++) {
			fleetHP1[i] = bot1.fleet[i].getSize();
			fleetHP2[i] = bot2.fleet[i].getSize();
		}	
		bot1.SetUp(botField1);
		botField1.printField();
		bot2.SetUp(botField2);
		botField2.printField();
		System.out.println("Game starting....");
		while (true) {
			while(System.currentTimeMillis() < time){
				     //Empty Loop   
			}
			time += 500;
			int botHP1 = 0;
			int botHP2 = 0;
			for (int i = 0; i < fleetHP1.length; i++) {
				botHP1 += fleetHP1[i];
				botHP2 += fleetHP2[i];
			}
			if (botHP1 < 1 || botHP2 < 1) {
				System.out.println("Game finised.");
				botField1.printField();
				botField2.printField();
				if (botHP2 < 1) System.out.println("Bot 1 won");
				else System.out.println("Bot 2 won");
				break;
			}
			else {
				System.out.println("Bot 1 turn:");
				bot1.playTurn(botField2, fleetHP2);
				botField2.printField();
				System.out.printf("Bot 2 HP: %d\n\n", botHP2);
				System.out.println("Bot 2 turn:");
				bot2.playTurn(botField1, fleetHP1);
				botField1.printField();
				System.out.printf("Bot 1 HP: %d\n\n", botHP1);
				System.out.printf("\n\n\n");
			}
		}
	}
}
