/**
 * The Grink class is a subclass of Monster. It represents a green monster that dances north, south, east, or west in a sequence of steps
 * @author Rose Gao
 *
 */
public class Grink extends Monster {
	
	/**
	 * Stores the front node of the linked list dance sequence
	 */
	LinearNode <String> actions;
	
	/**
	 * The current action Grink is undertaking
	 */
	LinearNode <String> currAction;
	
	/**
	 * Constructor that creates a Grink monster on the given column and row of the grid
	 * @param col column of grid
	 * @param row row of grid
	 * @param danceActions array storing actions of Grink
	 */
	public Grink (int col, int row, String[] danceActions) {
		/** 
		 * Evoking the superclass, with parameters column and row
		 */
		super(col, row);
		
		if (danceActions != null) {
			createActionList(danceActions);
			currAction = actions;
		}
	}
	
	/**
	 * Private helper method that creates a linked list with the actions from the array 
	 * @param actionList array storing actions of Grink
	 */
	private void createActionList(String[] actionList) {
		LinearNode<String> curr = new LinearNode<String>();
		
		curr.setElement(actionList[0]);
		actions = curr;
		for (int i = 1; i < actionList.length; i++) {
			curr.setNext(new LinearNode<String>());
			curr = curr.getNext();
			curr.setElement(actionList[i]);
	
		}
		
	}
	
	/**
	 * Accessor method that returns the linked list
	 * @return actions linked list 
	 */
	public LinearNode<String> getActions() {
		return actions;
	}
	
	/**
	 * Method that moves Grink in a sequence of movements defined by the linked list 
	 * @param col column where Grink begins 
	 * @param row row where Grink begins
	 * @size dimension of grid (height/width)
	 */

	@Override
	public void dance (MonsterMash grink) {
		int col = getCol();
		int row = getRow();
		int size = grink.getSize();
		
		if (currAction != null) {
		
			if (currAction.getElement() == "north") {
				if (getRow() > 0) {
					setRow(row - 1);
					currAction = currAction.getNext();
				}
				else {
					currAction = currAction.getNext();
					dance(grink);
					}
				}
			
			else if (currAction.getElement() == "south") {
				if (getRow() < size - 1) {
					setRow(row + 1);
					currAction = currAction.getNext();
				}
				else {
					currAction = currAction.getNext();
					dance(grink);
				}
			}
			
			else if (currAction.getElement() == "east") {
				if (getCol() < size - 1) {
					setCol(col + 1);
					currAction = currAction.getNext();
				}
				else {
					currAction = currAction.getNext();
					dance(grink);

				}
			}
			
			else if (currAction.getElement() == "west") {
				if (getCol() > 0) {
					setCol(col - 1);
					currAction = currAction.getNext();
				}
				else {
					currAction = currAction.getNext();
					dance(grink);
				}
			}
			
			else if (currAction.getElement() == "repeat"){
				currAction = actions;
				dance(grink);

			}
		}
	}

}
