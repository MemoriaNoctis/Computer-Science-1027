/**
 * Class used to check if a sequence of chars passed to its process method is a sequence of a certain length repeated a certain number of times
 * @author Rose Gao
 *
 */
public class RepeatChecker implements Checker{
	
	/**
	 * Stores sought after length to be repeated
	 */
	final int seqLength;
	
	/**
	 * Holds the sought after amount of repeats
	 */
	final int repeatNumber;
	
	/**
	 * Stores start position in the DNA sequence for tag reference
	 */
	final int position;
	
	/**
	 * Stores whether the processed sequence so far could not be the palindrome
	 */
	boolean fail;
	
	/**
	 * Stores accumulated chars so far passed to this checker
	 */
	String patternSoFar;
	
	/**
	 * Stores initial chars that must later be checked against the later chars to determine if the sequence is repeated repeatNumber times
	 */
	QueueADT <Character> previous;
	
	/**
	 * Constructor that creates a new Checker for a sequence repeated a certain number of times 
	 * @param seqLength the sought after sequence length to be repeated
	 * @param repeatNumber the sought after number of repeats
	 */
	public RepeatChecker(int seqLength, int repeatNumber) {
		this.seqLength = seqLength;
		this.repeatNumber = repeatNumber;
		position = 0;
		fail = false;
		patternSoFar = "";
		previous = new LinkedQueue<Character> ();
	}
	
	/**
	 * Constructor that creates a new Checker for a sequence repeated a certain number of times, this time with position specified
	 * @param seqLength the sought after sequence length to be repeated
	 * @param repeatNumber the sought after number of repeats
	 * @param position start position in the DNA sequence form which to begin checking
	 */
	private RepeatChecker(int seqLength, int repeatNumber, int position) {
		this.seqLength = seqLength;
		this.repeatNumber = repeatNumber;
		this.position = position;
		fail = false;
		patternSoFar = "";
		previous = new LinkedQueue<Character> ();
	}
	
	/**
	 * Method that checks whether the sequence passed into it repeats a length of chars a certain number of times
	 * @return whether the sequence repeats a certain length of chars a certain number of times
	*/
	@Override
	public boolean process(char c) {
		patternSoFar += c;
		
		if (patternSoFar.length() <= seqLength) {
			previous.enqueue(c);
		}
		
		else {
			if (c == previous.first()) {
				previous.dequeue();
				previous.enqueue(c);
			}
			
			else {
				fail = true;
			}
		}
		
		if ((patternSoFar.length() == seqLength * repeatNumber) && fail == false) {
			return true;
		}
		
		else {
			return false;
		}
	}

	/**
	 * Used for seeing if the checker needs to continue processing
	 * @return whether checker is finished processing
	 */
	@Override
	public boolean finished() {
		return fail;
	}

	/**
	 * Used to create a new Checker with the same attributes but restarting at given position in the DNA sequence
	 * @param pos position in the DNA sequence
	 * @return new Checker with same attributes starting at given position
	 */
	@Override
	public Checker cloneHere(int pos) {
		return new RepeatChecker (seqLength, repeatNumber, pos);
	}
	
	/**
	 * Returns String representation of this checker
	 */
	public String toString() {
		return ("Repeat(" + seqLength + "," + repeatNumber + ") - " + position + "{" + patternSoFar + "}"); 
	}

}
