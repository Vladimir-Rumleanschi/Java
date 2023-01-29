package battleships.gamelogic.Objects;

//Initialize the play field with values according to objects
public class Field {
	private int row;
	private int col;
	public int[][]field;
	/* Status value:
	 * 0: Empty water, no ship, no hit (~)
	 * 1: Empty water, no ship, has been fired upon (#)
	 * 2: Empty water, has ship, has been fired upon (X)
	 * 3: Carrier
	 * 4: Battleship 1
	 * 5: Battleship 2
	 * 6: Cruiser 1
	 * 7: Cruiser 2
	 * 8: Submarine 1
	 * 9: Submarine 2
	 * 10: Destroyer 1
	 * 11: Destroyer 2
	 * 12: Destroyer 3
	 * */
	
	public Field(int[][] intfield) {
		this.row = 10;
		this.col = 10;
		this.field = intfield;
	}

	//For player field
	public void printField() {
		char water = '~';
		char ship = 'O';
		char hit = 'X';
		char miss = '#';
		char c = 'A';
		for (int i = 0; i < field[0].length; i++) {
			System.out.printf("%3d", i + 1);
		}
		System.out.println();
		for (int i = 0; i < this.field.length; i++) {
			System.out.print(c + " ");
			for (int j = 0; j < this.field[0].length; j++) {
				switch(field[i][j]) {
				case 0:
					System.out.print(water + "  ");
					break;
				case 1:
					System.out.print(miss + "  ");
					break;
				case 2:
					System.out.print(hit + "  ");
					break;
				default:
					System.out.print(ship + "  ");
					break;
				}
			}
			c++;
			System.out.println();
		}
	}

	public void printFieldTest() {
		char c = 'A';
		for (int i = 0; i < field[0].length; i++) {
			System.out.printf("%3d", i + 1);
		}
		System.out.println();
		for (int i = 0; i < this.field.length; i++) {
			System.out.print(c + " ");
			for (int j = 0; j < this.field[0].length; j++) {
				System.out.printf("%d  ", this.field[i][j]);
			}
			c++;
			System.out.println();
		}
	}

	//For enemy field
	public void printEnemyField() {
		char water = '~';
		char hit = 'X';
		char miss = '#';		
		char c = 'A';
		for (int i = 0; i < field[0].length; i++) {
			System.out.printf("%3d", i + 1);
		}
		System.out.println();
		for (int i = 0; i < this.field.length; i++) {
			System.out.print(c + " ");
			for (int j = 0; j < this.field[0].length; j++) {
				switch(field[i][j]) {
				case 0:
					System.out.print(water + "  ");
					break;
				case 1:
					System.out.print(miss + "  ");
					break;
				case 2:
					System.out.print(hit + "  ");
					break;
				default:
					System.out.print(water + "  ");
					break;
				}
			}
			c++;
			System.out.println();
		}
	}
	
	public int getValue(int x, int y) {
		return this.field[x][y];
	}
	
	public void setValue(int x, int y, int status) {
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.col; j++) {
				if (i == x && j == y) this.field[i][j] = status;
			}
		}
	}
	
	public int rowConvert(String c) {
		int i = 0;
		switch(c) {
		case "A":
			i = 0;
			break;
		case "B":
			i = 1;
			break;
		case "C":
			i = 2;
			break;
		case "D":
			i = 3;
			break;
		case "E":
			i = 4;
			break;
		case "F":
			i = 5;
			break;
		case "G":
			i = 6;
			break;
		case "H":
			i = 7;
			break;
		case "I":
			i = 8;
			break;
		case "J":
			i = 9;
			break;
		default:
			i = 0;
			break;
		}
		return i;
	}
	
	public boolean placeable(int x, int y, Ships ship, boolean horizontal) {
		boolean free = false;
		switch(ship.getSize()) {
		case 5:
			if(horizontal) {
				if (y < 2 || y > 7) break;
				if (this.field[x][y] == 0 &&
						this.field[x][y - 1] == 0 && this.field[x][y - 2] == 0 &&
						this.field[x][y + 1] == 0 && this.field[x][y + 2] == 0) free = true;
				else free = false;
			} else {
				if (x < 2 || x > 7) break;
				if (this.field[x][y] == 0 &&
						this.field[x - 1][y] == 0 && this.field[x - 2][y] == 0 &&
						this.field[x + 1][y] == 0 && this.field[x + 2][y] == 0) free = true;
				else free = false;
			}
			break;
		case 4:
			if(horizontal) {
				if (y < 1 || y > 7) break;
				if (this.field[x][y] == 0 &&
						this.field[x][y - 1] == 0 &&
						this.field[x][y + 1] == 0 && this.field[x][y + 2] == 0) free = true;
				else free = false;
			} else {
				if (x < 1 || x > 7) break;
				if (this.field[x][y] == 0 &&
						this.field[x - 1][y] == 0 &&
						this.field[x + 1][y] == 0 && this.field[x + 2][y] == 0) free = true;
				else free = false;
			}
			break;
		case 3:
			if(horizontal) {
				if (y < 1 || y > 8) break;
				if (this.field[x][y] == 0 &&
						this.field[x][y - 1] == 0 &&
						this.field[x][y + 1] == 0) free = true;
				else free = false;
			} else {
				if (x < 1 || x > 8) break;
				if (this.field[x][y] == 0 &&
						this.field[x - 1][y] == 0 &&
						this.field[x + 1][y] == 0) free = true;
				else free = false;
			}
			break;
		case 2:
			if(horizontal) {
				if (y > 8) break;
				if (this.field[x][y] == 0 &&
						this.field[x][y + 1] == 0) free = true;
				else free = false;
			} else {
				if (x > 8) break;
				if (this.field[x][y] == 0 &&
						this.field[x + 1][y] == 0) free = true;
				else free = false;
			}
			break;
		default:
			break;	
		}
		return free;
	}
	
	public boolean surrounded(int x, int y) {
		boolean surround = false;
		boolean vertical = false;
		boolean horizontal = false;
		if (x == 0) {
			if (this.field[x + 1][y] == 1 || this.field[x + 1][y] == 2) vertical = true;
		}
		else if (x == 9) {
			if (this.field[x - 1][y] == 1 || this.field[x - 1][y] == 2) vertical = true;
		}
		else {
			if ((this.field[x + 1][y] == 1 || this.field[x + 1][y] == 2) &&
					(this.field[x - 1][y] == 1 || this.field[x - 1][y] == 2)) vertical = true;
		}
		if (y == 0) {
			if (this.field[x][y + 1] == 1 || this.field[x][y + 1] == 2) horizontal = true;
		}
		else if (y == 9) {
			if (this.field[x][y - 1] == 1 || this.field[x][y - 1] == 2) horizontal = true;
		}
		else {
			if ((this.field[x][y + 1] == 1 || this.field[x][y + 1] == 2) &&
					(this.field[x][y - 1] == 1 || this.field[x][y - 1] == 2)) horizontal = true;
		}
		if (vertical && horizontal) surround = true;
		return surround;
	}
	
	public void placeShip(int x, int y, Ships ship, boolean horizontal) {
		switch(ship) {
		case CARRIER:
			if(horizontal) {
				this.setValue(x, y, 3);
				this.setValue(x, y - 1, 3);
				this.setValue(x, y - 2, 3);
				this.setValue(x, y + 1, 3);
				this.setValue(x, y + 2, 3);
			} else {
				this.setValue(x, y, 3);
				this.setValue(x - 1, y, 3);
				this.setValue(x - 2, y, 3);
				this.setValue(x + 1, y, 3);
				this.setValue(x + 2, y, 3);
			}
			break;
		case BATTLESHIP:
			if(horizontal) {
				this.setValue(x, y, 4);
				this.setValue(x, y - 1, 4);
				this.setValue(x, y + 1, 4);
				this.setValue(x, y + 2, 4);
			} else {
				this.setValue(x, y, 4);
				this.setValue(x - 1, y, 4);
				this.setValue(x + 1, y, 4);
				this.setValue(x + 2, y, 4);
			}
			break;
		case BATTLESHIP_2:
			if(horizontal) {
				this.setValue(x, y, 5);
				this.setValue(x, y - 1, 5);
				this.setValue(x, y + 1, 5);
				this.setValue(x, y + 2, 5);
			} else {
				this.setValue(x, y, 5);
				this.setValue(x - 1, y, 5);
				this.setValue(x + 1, y, 5);
				this.setValue(x + 2, y, 5);
			}
			break;
		case CRUISER:
			if(horizontal) {
				this.setValue(x, y, 6);
				this.setValue(x, y - 1, 6);
				this.setValue(x, y + 1, 6);
			} else {
				this.setValue(x, y, 6);
				this.setValue(x - 1, y, 6);
				this.setValue(x + 1, y, 6);
			}
			break;
		case CRUISER_2:
			if(horizontal) {
				this.setValue(x, y, 7);
				this.setValue(x, y - 1, 7);
				this.setValue(x, y + 1, 7);
			} else {
				this.setValue(x, y, 7);
				this.setValue(x - 1, y, 7);
				this.setValue(x + 1, y, 7);
			}
			break;
		case SUBMARINE:
			if(horizontal) {
				this.setValue(x, y, 8);
				this.setValue(x, y - 1, 8);
				this.setValue(x, y + 1, 8);
			} else {
				this.setValue(x, y, 8);
				this.setValue(x - 1, y, 8);
				this.setValue(x + 1, y, 8);
			}
			break;
		case SUBMARINE_2:
			if(horizontal) {
				this.setValue(x, y, 9);
				this.setValue(x, y - 1, 9);
				this.setValue(x, y + 1, 9);
			} else {
				this.setValue(x, y, 9);
				this.setValue(x - 1, y, 9);
				this.setValue(x + 1, y, 9);
			}
			break;
		case DESTROYER:
			if(horizontal) {
				this.setValue(x, y, 10);
				this.setValue(x, y + 1, 10);
			} else {
				this.setValue(x, y, 10);
				this.setValue(x + 1, y, 10);
			}
			break;
		case DESTROYER_2:
			if(horizontal) {
				this.setValue(x, y, 11);
				this.setValue(x, y + 1, 11);
			} else {
				this.setValue(x, y, 11);
				this.setValue(x + 1, y, 11);
			}
			break;
		case DESTROYER_3:
			if(horizontal) {
				this.setValue(x, y, 12);
				this.setValue(x, y + 1, 12);
			} else {
				this.setValue(x, y, 12);
				this.setValue(x + 1, y, 12);
			}
			break;
		default:
			break;	
		}
	}
	
}
