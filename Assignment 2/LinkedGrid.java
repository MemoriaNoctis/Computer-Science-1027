/**
 * The LinkedGrid class represents a 2D grid created as an array of singly linked lists, meant to work with any generic type T.
 * @author Rose Gao
 *
 * @param <T> generic type T
 */
public class LinkedGrid<T> {
	
	/**
	 * width of grid
	 */
	private int width;
	
	/**
	 * height of grid
	 */
	private int height;
	
	/**
	 * LinearNode array of generic type T
	 */
	private LinearNode<T>[] grid;
	
	/**
	 * Constructor creates a 2D grid of a given width and height
	 * @param width width of grid (column)
	 * @param height height of grid (row)
	 */
	public LinkedGrid (int width, int height) {
		this.width = width;
		this.height = height;
		
		grid = (LinearNode<T>[])(new LinearNode[width]);

		
		/**
		 * for loop to initialize grid
		 */
		for (int i = 0; i < width; i++) {
			 LinearNode<T> current = new LinearNode<T> ();

			 grid[i] = current;
			 
			 for (int j = 0; j < height - 1; j++) {
				 current.setNext(new LinearNode<T>());
				 current = current.getNext();
				 
			 }
			 
		 }
		
	}
	
	/**
	 * Setter method to set data of generic type T into given column and row
	 * @param col grid column 
	 * @param row grid row
	 * @param data data of generic type T
	 */
	public void setElement (int col, int row, T data) {
		getElement(col, row).setElement(data);	
	}
	
	/**
	 * Accessor method to get the element stored in given column and row
	 * @param col grid column
	 * @param row grid row
	 * @return element stored in given column and row
	 */
	public LinearNode <T> getElement(int col, int row) {
		LinearNode<T> currNode = new LinearNode<T> ();
		
		/**
		 * Throw LinkedListException if column and/or row are out of bounds
		 */
		if (col < 0 || row < 0) {
			throw new LinkedListException("LinkedListException");
		}
		if (col >= width || row >= height ) {
			throw new LinkedListException("LinkedListException");
		}

		currNode = grid[col];
		for (int i = 0; i < row; i++) {
			currNode = currNode.getNext();
		}
		
		return currNode;

	}
	
	/**
	 * Accessor method to get width of grid
	 * @return width of grid
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Accessor method to get height of grid
	 * @return height of grid
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Method to return a string representation of the grid created by this class and the elements stored within it
	 */
	public String toString() {
		String strGrid = "";
		for (int i = 0; i < height; i++) { //row
			for (int j = 0; j < width; j++) { //column
				strGrid += getElement(j, i).getElement() + "  ";
			}
			strGrid += "\n";
		}
	
		return strGrid;
	}

	
}