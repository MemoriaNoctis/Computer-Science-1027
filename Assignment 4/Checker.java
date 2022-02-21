/**
 * Interface that defines the important features of Checkers
 * @author Rose Gao
 *
 */
public interface Checker {
	
	/**
	 * Used to process single char c
	 * @param c character to be processed
	 * @return whether process succeeds or fails
	 */
	public boolean process(char c);
	
	/**
	 * Used for seeing if the checker needs to continue processing
	 * @return whether checker is finished processing
	 */
	public boolean finished();
	
	/**
	 * Used to create a new Checker with the same attributes but restarting at given position in the DNA sequence
	 * @param pos position in the DNA sequence
	 * @return new Checker with same attributes starting at given position
	 */
	public Checker cloneHere(int pos);


}
