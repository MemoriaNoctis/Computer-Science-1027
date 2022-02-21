/**
 * The Blub class is a subclass of Monster. It represents a blue monster that slides back and forth between two adjacent cells
 * @author Rose Gao
 *
 */
public class Blub extends Monster{
	
	/**
	 * Axis on which Blub will move (horizontal/vertical)
	 */
	private String axis;
	
	/**
	 * Direction of movement (1/-1)
	 */
	private int dir;
	
	/**
	 * Constructor that creates a Blub monster on the given column and row of the grid
	 * @param col column of grid
	 * @param row row of grid
	 * @param axis axis on which Blub dances (horizontal/vertical)
	 */
	public Blub (int col, int row, String axis) {
		/** 
		 * Evoking the superclass, with parameters column and row
		 */
		super(col, row);
		
		this.axis = axis;
		dir = 1;
	}
	
	
	/**
	 * Method that moves Blub forwards and backwards on either a horizontal or vertical axis 
	 * @param col column where Blub begins 
	 * @param row row where Blub begins
	 * @size dimension of grid (height/width)
	 */
	@Override
	public void dance(MonsterMash blub) {
		int col = getCol();
		int row = getRow();
		int size = blub.getSize();
		
		if (axis == "horizontal") {
			if ((col < size - 1) && (dir == 1)) {
				setCol(col + dir);
				dir = -1;

			}
			else if (dir == -1) {
				setCol(col + dir);
				dir = 1;
			}
			
			
		}
			
		if (axis == "vertical") {
			if ((row < size - 1) && (dir == 1)) {
				setRow(row + dir);
				dir = -1;
			}
			else if (dir == -1) {
				setRow(row + dir);
				dir = 1;
			}
		}
						

						
	}

}
