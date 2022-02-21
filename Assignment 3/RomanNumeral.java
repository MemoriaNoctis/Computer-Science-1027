/**
 * The RomanNumeral class customizes the comparison between two Roman numerals.
 * @author Rose Gao
 * 
 */
public class RomanNumeral implements Comparable<RomanNumeral>{
	
	/**
	 * Roman numeral in form of a String
	 */
	private String numeral;
	
	/**
	 * Constructor to initialize the instance variable with given parameter
	 * @param numeral Roman Numeral to be compared
	 */
	public RomanNumeral (String numeral) {
		this.numeral = numeral;
	}
	
	/**
	 * Returns numeral value
	 */
	public String toString() {
		return numeral;		
	}
	
	/**
	 * Compares the Arabic conversion of the two Roman numerals
	 */
	public int compareTo (RomanNumeral compareNumeral) {
		
		/**
		 * Return -1 if this.numeral is smaller
		 */
		if (Roman2Arabic.convertWholeNumeral(numeral) < Roman2Arabic.convertWholeNumeral(compareNumeral.toString())) {
			return -1;			
		}
		
		/**
		 * Return 1 if this.numeral is larger
		 */
		else if (Roman2Arabic.convertWholeNumeral(numeral) > Roman2Arabic.convertWholeNumeral(compareNumeral.toString())) {
			return 1;			
		}
		
		/**
		 * Return 0 if both are equal
		 */
		else {
			return 0;
		}
	}

}
