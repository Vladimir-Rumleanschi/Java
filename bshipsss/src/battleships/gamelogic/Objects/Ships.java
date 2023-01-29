package battleships.gamelogic.Objects;

public enum Ships {
	//5 ship types
	CARRIER (5, "Carrier"),
	BATTLESHIP (4, "Battleship 1"),
	BATTLESHIP_2 (4, "Battleship 2"),
	CRUISER (3, "Cruiser 1"),
	CRUISER_2 (3, "Cruiser 2"),
	SUBMARINE (3, "Submarine 1"),
	SUBMARINE_2 (3, "Submarine 2"),
	DESTROYER (2, "Destroyer 1"),
	DESTROYER_2 (2, "Destroyer 2"),
	DESTROYER_3 (2, "Destroyer 3");
	
	private int size;
	private String name;
	
	Ships(int size, String name) {
		this.size = size;
		this.name = name;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public String getName() {
		return this.name;
	}
}
