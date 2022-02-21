
public class Storage {
	

public class LinkedGrid<T> {
	private int width;
	private int height;
	private LinearNode<T>[] grid;
	
	public LinkedGrid (int width, int height) {
		this.width = width;
		this.height = height;
		
		grid = new LinearNode [width];
		 
		 for (int i = 0; i < width; i++) {
			 LinearNode<T> current = new LinearNode<T> ();

			 grid[i] = current;
			 
			 for (int j = 0; j < height - 1; j++) {
				 LinearNode<T> successor = new LinearNode<T> ();
				 current.setNext(successor);
				 current = current.getNext();
				 
			 }
			 
		 }
		
	}
	
	public void setElement (int col, int row, T data) {
		
		try {
			if (col < 0 || row < 0) {
				throw new LinkedListException("LinkedListException");
			}
			if (col >= height || row >= width ) {
				throw new LinkedListException("LinkedListException");
			}

			getElement(col, row).setElement(data);
		}
		
		catch (LinkedListException e) {	 
		}


		
	}
	
	public LinearNode <T> getElement(int col, int row) {
		LinearNode<T> currNode = new LinearNode<T> ();

		try {
			if (col < 0 || row < 0) {
				throw new LinkedListException("LinkedListException");
			}
			if (col >= height || row >= width ) {
				throw new LinkedListException("LinkedListException");
			}

			currNode = grid[col];
			for (int i = 0; i < row; i++) {
				currNode = currNode.getNext();
			}
			
		}
		
		catch (LinkedListException e) {	 
		}
		
		return currNode;

	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public String toString() {
		String strGrid = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				strGrid += getElement(j, i).getElement() + "  ";
			}
			strGrid += "\n";
		}
		
		return strGrid;
	}

	
}

}



public class LinkedGrid<T> {
	private int width;
	private int height;
	private LinearNode<T>[] grid;
	
	public LinkedGrid (int width, int height) {
		this.width = width;
		this.height = height;
		
		grid = (LinearNode<T>[])(new LinearNode[width]);

		 
		 for (int i = 0; i < width; i++) {
			 LinearNode<T> current = new LinearNode<T> ();

			 grid[i] = current;
			 
			 for (int j = 0; j < height - 1; j++) {
				 LinearNode<T> successor = new LinearNode<T> ();
				 current.setNext(successor);
				 current = current.getNext();
				 
			 }
			 
		 }
		
	}
	
	public void setElement (int col, int row, T data) {
		LinearNode<T> currNode = new LinearNode<T> ();
		currNode = grid[col];
		for (int i = 0; i < row; i++) {
			currNode = currNode.getNext(); 
		}
		currNode.setElement(data);
	}


	
	public LinearNode <T> getElement(int col, int row) {
		LinearNode<T> currNode = new LinearNode<T> ();

		try {
			if (col < 0 || row < 0) {
				throw new LinkedListException("LinkedListException");
			}
			if (col >= height || row >= width ) {
				throw new LinkedListException("LinkedListException");
			}
			
			currNode = grid[col];
			for (int i = 0; i < row; i++) {
				currNode = currNode.getNext(); 
			}
		
		}
		
		catch (LinkedListException e) {	 
		}
		
		return currNode;

	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public String toString() {
		String strGrid = "";
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				strGrid += getElement(j, i).getElement() + "  ";
			}
			strGrid += "\n";
		}

/*		LinearNode <T> currNode = null;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				currNode = grid[i];
				for (int k = 0; k < i; k++) {
					currNode = currNode.getNext();
					strGrid += currNode.getElement() + "  ";
				}
				
			}
			strGrid += "\n";
		}
*/		
		return strGrid;
	}

	
}