package battleships.gamelogic.Objects;

import java.util.Random;

public class Bot {
	/* lastStatus:
	 * 0 = initial state or missed on last attack phase
	 * 1 = hit a part of a ship
	 * 2 = continue from 1 and hit another part of a ship
	 * 3 = continue from 1 and miss
	 * */
	public int lastStatus;
	/* atkDirection:
	 *     0
	 *     |
	 * 3 -- -- 1  
	 *     |
	 *     2
	 * */
	private int atkDirection;
	private int lastAtkDirection;
	private int reverseCount;
	private int lastX;
	private int lastY;
	public Ships[] fleet = {Ships.CARRIER, 
			Ships.BATTLESHIP, Ships.BATTLESHIP_2, Ships.CRUISER, Ships.CRUISER_2, 
			Ships.SUBMARINE, Ships.SUBMARINE_2, Ships.DESTROYER, Ships.DESTROYER_2, Ships.DESTROYER_3
			};
	private Random rand = new Random();
	
	public Bot() {
		this.lastStatus = 0;
		this.atkDirection = 0;
		this.lastAtkDirection = 0;
		this.reverseCount = 0;
		this.lastX = 0;
		this.lastY = 0;
	}
	
	private void reverseDirection() {
		switch(this.lastAtkDirection) {
		case 0:
			this.lastAtkDirection = 2;
			break;
		case 1:
			this.lastAtkDirection = 3;
			break;
		case 2:
			this.lastAtkDirection = 0;
			break;
		case 3:
			this.lastAtkDirection = 1;
			break;
		default:
			break;
		}
	}
	
	public void SetUp(Field inputField) {
		for (int i = 0; i < this.fleet.length; i++) {
			boolean shipPlaced = false;
			boolean horizontal = false;
			while (!shipPlaced) {
				int x = rand.nextInt(10);
				int y = rand.nextInt(10);		
				int placement = rand.nextInt(2);
				if (placement == 1) horizontal = true;
				if (inputField.placeable(x, y, this.fleet[i], horizontal)) {
					inputField.placeShip(x, y, this.fleet[i], horizontal);
					shipPlaced = true;
					break;
				}
				else {
					continue;
				}
			}
			System.out.printf("Bot is placing %s on the field....\n", this.fleet[i].getName());
			inputField.printField();
			System.out.println();
		}
	}
	
	public void playTurn(Field inputField, int[] fleetHP) {
		boolean attackFinished = false;
		int val = 0;
		atkPhase:
		while (!attackFinished) {
			//If this is the first attack or the last attack hit nothing
			if (this.lastStatus == 0) {
				int x = rand.nextInt(10);
				int y = rand.nextInt(10);
				if (inputField.getValue(x, y) == 1 || inputField.getValue(x, y) == 2) {
					continue;
				}
				else if (inputField.getValue(x, y) == 0) {
					inputField.setValue(x, y, 1);
					attackFinished = true;
				}
				else {
					fleetHP[inputField.getValue(x, y) - 3]--;
					this.lastStatus = 1;
					this.lastX = x;
					this.lastY = y;
					inputField.setValue(x, y, 2);
					attackFinished = true;
				}
			}
			//If the last attack hit a ship
			else if (this.lastStatus == 1) {
				if (inputField.surrounded(this.lastX, this.lastY)) {
					this.lastStatus = 0;
					continue atkPhase;
				}
				this.atkDirection = rand.nextInt(4);
				switch(this.atkDirection) {
				case 0:
					if (this.lastX == 0) continue atkPhase;
					else {
						if (inputField.getValue(this.lastX - 1, this.lastY) == 1 || inputField.getValue(this.lastX - 1, this.lastY) == 2) continue atkPhase;
						else if (inputField.getValue(this.lastX - 1, this.lastY) == 0) {
							inputField.setValue(this.lastX - 1, this.lastY, 1);
							//this.lastStatus = 3;
							attackFinished = true;
						}
						else {
							val = inputField.getValue(this.lastX - 1, this.lastY);
							fleetHP[val - 3]--;
							inputField.setValue(this.lastX - 1, this.lastY, 2);
							if (fleetHP[val - 3] < 1) this.lastStatus = 0;
							else {
								this.lastStatus = 2;
								this.lastAtkDirection = this.atkDirection;
								this.lastX -= 1;
							}
							attackFinished = true;
						}				
					}
					break;
				case 1:
					if (this.lastY == 9) continue atkPhase;
					else {
						if (inputField.getValue(this.lastX, this.lastY + 1) == 1 || inputField.getValue(this.lastX, this.lastY + 1) == 2) continue atkPhase;
						else if (inputField.getValue(this.lastX, this.lastY + 1) == 0) {
							inputField.setValue(this.lastX, this.lastY + 1, 1);
							//this.lastStatus = 3;
							attackFinished = true;
						}
						else {
							val = inputField.getValue(this.lastX, this.lastY + 1);
							fleetHP[val - 3]--;
							inputField.setValue(this.lastX, this.lastY + 1, 2);
							if (fleetHP[val - 3] < 1) this.lastStatus = 0;
							else {
								this.lastStatus = 2;
								this.lastAtkDirection = this.atkDirection;
								this.lastY += 1;
							}
							attackFinished = true;
						}				
					}
					break;
				case 2:
					if (this.lastX == 9) continue atkPhase;
					else {
						if (inputField.getValue(this.lastX + 1, this.lastY) == 1 || inputField.getValue(this.lastX + 1, this.lastY) == 2) continue atkPhase;
						else if (inputField.getValue(this.lastX + 1, this.lastY) == 0) {
							inputField.setValue(this.lastX + 1, this.lastY, 1);
							//this.lastStatus = 3;
							attackFinished = true;
						}
						else {
							val = inputField.getValue(this.lastX + 1, this.lastY);
							fleetHP[val - 3]--;
							inputField.setValue(this.lastX + 1, this.lastY, 2);
							if (fleetHP[val - 3] < 1) this.lastStatus = 0;
							else {
								this.lastStatus = 2;
								this.lastAtkDirection = this.atkDirection;
								this.lastX += 1;
							}
							attackFinished = true;
						}				
					}
					break;
				case 3:
					if (this.lastY == 0) continue atkPhase;
					else {
						if (inputField.getValue(this.lastX, this.lastY - 1) == 1 || inputField.getValue(this.lastX, this.lastY - 1) == 2) continue atkPhase;
						else if (inputField.getValue(this.lastX, this.lastY - 1) == 0) {
							inputField.setValue(this.lastX, this.lastY - 1, 1);
							//this.lastStatus = 3;
							attackFinished = true;
						}
						else {
							val = inputField.getValue(this.lastX, this.lastY - 1);
							fleetHP[val - 3]--;
							inputField.setValue(this.lastX, this.lastY - 1, 2);
							if (fleetHP[val - 3] < 1) this.lastStatus = 0;
							else {
								this.lastStatus = 2;
								this.lastAtkDirection = this.atkDirection;
								this.lastY -= 1;
							}
							attackFinished = true;
						}				
					}
					break;
				default:
					break;
				}
			}
			//If the last attack continued hitting a ship
			else {
				this.atkDirection = this.lastAtkDirection;
				switch(this.atkDirection) {
				case 0:
					if (this.lastX == 0) {
						if (this.reverseCount == 0) {
							reverseDirection();
							this.reverseCount++;
							continue atkPhase;
						}
						else {
							this.lastStatus = 0;
							this.reverseCount = 0;
							continue atkPhase;
						}
					}
					else {
						if (inputField.getValue(this.lastX - 1, this.lastY) == 1 || inputField.getValue(this.lastX - 1, this.lastY) == 2) {
							if (this.reverseCount == 0) {
								reverseDirection();
								this.reverseCount++;
								continue atkPhase;
							}
							else {
								this.lastStatus = 0;
								this.reverseCount = 0;
								continue atkPhase;
							}
						}
						else if (inputField.getValue(this.lastX - 1, this.lastY) == 0) {
							inputField.setValue(this.lastX - 1, this.lastY, 1);
							reverseDirection();
							this.lastStatus = 0;
							attackFinished = true;
						}
						else {
							val = inputField.getValue(this.lastX - 1, this.lastY);
							fleetHP[val - 3]--;
							inputField.setValue(this.lastX - 1, this.lastY, 2);
							if (fleetHP[val - 3] < 1) this.lastStatus = 0;
							else this.lastX -= 1;
							attackFinished = true;
						}				
					}
					break;
				case 1:
					if (this.lastY == 9) {
						if (this.reverseCount == 0) {
							reverseDirection();
							this.reverseCount++;
							continue atkPhase;
						}
						else {
							this.lastStatus = 0;
							this.reverseCount = 0;
							continue atkPhase;
						}
					}
					else {
						if (inputField.getValue(this.lastX, this.lastY + 1) == 1 || inputField.getValue(this.lastX, this.lastY + 1) == 2) {
							if (this.reverseCount == 0) {
								reverseDirection();
								this.reverseCount++;
								continue atkPhase;
							}
							else {
								this.lastStatus = 0;
								this.reverseCount = 0;
								continue atkPhase;
							}
						}
						else if (inputField.getValue(this.lastX, this.lastY + 1) == 0) {
							inputField.setValue(this.lastX, this.lastY + 1, 1);
							reverseDirection();
							this.lastStatus = 0;
							attackFinished = true;
						}
						else {
							val = inputField.getValue(this.lastX, this.lastY + 1);
							fleetHP[val - 3]--;
							inputField.setValue(this.lastX, this.lastY + 1, 2);
							if (fleetHP[val - 3] < 1) this.lastStatus = 0;
							else this.lastY += 1;
							attackFinished = true;
						}				
					}
					break;
				case 2:
					if (this.lastX == 9) {
						if (this.reverseCount == 0) {
							reverseDirection();
							this.reverseCount++;
							continue atkPhase;
						}
						else {
							this.lastStatus = 0;
							this.reverseCount = 0;
							continue atkPhase;
						}
					}
					else {
						if (inputField.getValue(this.lastX + 1, this.lastY) == 1 || inputField.getValue(this.lastX + 1, this.lastY) == 2) {
							if (this.reverseCount == 0) {
								reverseDirection();
								this.reverseCount++;
								continue atkPhase;
							}
							else {
								this.lastStatus = 0;
								this.reverseCount = 0;
								continue atkPhase;
							}
						}
						else if (inputField.getValue(this.lastX + 1, this.lastY) == 0) {
							inputField.setValue(this.lastX + 1, this.lastY, 1);
							reverseDirection();
							this.lastStatus = 0;
							attackFinished = true;
						}
						else {
							val = inputField.getValue(this.lastX + 1, this.lastY);
							fleetHP[val - 3]--;
							inputField.setValue(this.lastX + 1, this.lastY, 2);
							if (fleetHP[val - 3] < 1) this.lastStatus = 0;
							else this.lastX += 1;
							attackFinished = true;
						}				
					}
					break;
				case 3:
					if (this.lastY == 0) {
						if (this.reverseCount == 0) {
							reverseDirection();
							this.reverseCount++;
							continue atkPhase;
						}
						else {
							this.lastStatus = 0;
							this.reverseCount = 0;
							continue atkPhase;
						}
					}
					else {
						if (inputField.getValue(this.lastX, this.lastY - 1) == 1 || inputField.getValue(this.lastX, this.lastY - 1) == 2) {
							if (this.reverseCount == 0) {
								reverseDirection();
								this.reverseCount++;
								continue atkPhase;
							}
							else {
								this.lastStatus = 0;
								this.reverseCount = 0;
								continue atkPhase;
							}
						}
						else if (inputField.getValue(this.lastX, this.lastY - 1) == 0) {
							inputField.setValue(this.lastX, this.lastY - 1, 1);
							reverseDirection();
							this.lastStatus = 0;
							attackFinished = true;
						}
						else {
							val = inputField.getValue(this.lastX, this.lastY - 1);
							fleetHP[val - 3]--;
							inputField.setValue(this.lastX, this.lastY - 1, 2);
							if (fleetHP[val - 3] < 1) this.lastStatus = 0;
							else this.lastY -= 1;
							attackFinished = true;
						}				
					}
					break;
				default:
					break;
				}
			}
		}
		inputField.printField();
	}
}
