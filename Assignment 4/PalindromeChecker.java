/**
 * Class used for checking if a sequence of chars passed to its process method is a palindrome of a certain length
 * @author Rose Gao
 *
 */
public class PalindromeChecker implements Checker {
	
	/**
	 * Stores sought after length
	 */
	final int seqLength;
	
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
	 * Stores the initial chars that must later be checked against the later chars to determine if this sequence is a palindrome
	 */
	StackADT <Character> previous;
	
	/**
	 * Constructor that creates a new Checker for palindromes 
	 * @param seqLength the sought after palindrome length
	 */
	public PalindromeChecker(int seqLength) {
		this.seqLength = seqLength;
		position = 0;
		fail = false;
		patternSoFar = "";
		previous = new ArrayStack<Character>();
	}
	
	/**
	 * Constructor that creates a new Checker for palindromes, this time with position specified
	 * @param seqLength the sought after palindrome length
	 * @param position start position in the DNA sequence form which to begin checking
	 */
	private PalindromeChecker(int seqLength, int position) {
		this.seqLength = seqLength;
		this.position = position;
		fail = false;
		patternSoFar = "";
		previous = new ArrayStack<Character>();
	}
	
	/**
	 * Method that checks whether the sequence passed into it is a palindrome
	 * @return whether the sequence is a palindrome or not
	 */
	@Override
	public boolean process(char c) {
		patternSoFar += c;
		
		/**
		 * If the palindrome has an even length
		 */
		if (seqLength % 2 == 0) {
			if (patternSoFar.length() <= seqLength/2) {
				previous.push(c);				
			}
			else {
				 if (c != previous.pop()) {
					 fail = true;					 
				 }
			}
		}
		
		/**
		 * If the palindrome has an odd length
		 */
		else {
			if (patternSoFar.length() <= seqLength/2) {
				previous.push(c);				
			}
			
			else if(patternSoFar.length() >= seqLength/2 + 2) {
				if (c!= previous.pop()) {
					fail = true;
				}
			}
		}
		
		if (patternSoFar.length() == seqLength && fail == false) {
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
		return new PalindromeChecker(seqLength, pos);
	}
	
	/**
	 * Returns String representation of this checker
	 */
	public String toString() {
		return ("Palindrome(" + seqLength + ") - " + position + "{" + patternSoFar + "}"); 
	}

}
