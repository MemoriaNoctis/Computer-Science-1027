/**
 * The Orbin class is a subclass of Monster. It represents a orange monster that glides around the perimeter of the dance floor in a clockwise direction
 * @author Rose Gao
 *
 */
public class Orbin extends Monster {
	/**
	 * String representing the default direction of Orbin
	 */
	private String dir;
	
	/**
	 * Constructor that creates an Orbin monster on the given column and row of the grid
	 * @param col column of grid
	 * @param row row of grid
	 * @param dir default direction of Orbin (north, south, east, or west)
	 */
	public Orbin (int col, int row, String dir) {
		/** 
		 * Evoking the superclass, with parameters column and row
		 */
		super(col, row);
		
		this.dir = dir;
	}
	
	/**
	 * Method that moves Orbin in a clockwise direction along the perimeter of the dance floor 
	 * @param col column where Orbin begins 
	 * @param row row where Orbin begins
	 * @size dimension of grid (height/width)
	 */
	@Override
	public void dance (MonsterMash orbin) {
		int col = getCol();
		int row = getRow();
		int size = orbin.getSize();
		
		if (dir == "north") {
			if (getRow() > 0) {
				setRow(row - 1);
			}
			else {
				dir = "east";
				dance(orbin);
			}
		}
		
		else if (dir == "east" ) {
			if (getCol() < size - 1) {
				setCol (col + 1);
			}
			else {
				dir = "south";
				dance(orbin);

			}
		}
		
		else if (dir == "south") {
			if (getRow() < size - 1) {
				setRow(row + 1);
			}
			else {
				dir = "west";
				dance(orbin);

			}
		}
		
		else if (dir == "west") {
			if (getCol() > 0) {
				setCol(col - 1);
			}
			else {
				dir = "north";
				dance(orbin);

			}
		}
		
	}
}
