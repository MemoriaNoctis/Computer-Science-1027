/**
 * The Roman2Arabic class is used to convert a Roman numeral to its Arabic value.
 * @author Rose Gao
 *
 */
public class Roman2Arabic {
	
	/**
	 * Returns the Arabic value of a given character if it is a valid Roman numeral. Otherwise throws RomanNumeralException.
	 * @param numeral Roman numeral to be converted to Arabic
	 * @return Arabic version of Roman Numeral
	 */
	public static int convertSingleNumeral(char numeral) {
		if (numeral == 'I') {
			return 1;			
		}
		
		else if (numeral == 'V') {
			return 5;
		}
		
		else if (numeral == 'X') {
			return 10;
		}
		
		else if (numeral == 'L') {
			return 50;
		}
		
		else if (numeral == 'C') {
			return 100;
		}
		
		else if (numeral == 'D') {
			return 500;
		}
		
		else if (numeral == 'M') {
			return 1000;
		}
		
		else {
			throw new RomanNumeralException("RomanNumeralException");
		}
	}
	
	/**
	 * Takes in a String representing Roman numeral and converts it to its Arabic value if valid.
	 * @param numeral Roman numeral to be coverted to Arabic
	 * @return Arabic version of Roman numeral
	 */
	public static int convertWholeNumeral(String numeral) {
		ArrayStack<Character> romanStack = new ArrayStack<Character> ();
		int total = 0;
		for (int i = 0; i < numeral.length(); i++) {
			char strChar = numeral.charAt(i);
			
			/**
			 * Checks if there are more than three repeats of I, X, C, or M in a row.
			 */
			if ((strChar == 'I' || strChar == 'X' || strChar == 'C' || strChar == 'M') && ((i + 3) < numeral.length())) {
				if (strChar == numeral.charAt(i + 1) && strChar == numeral.charAt(i + 2) && strChar == numeral.charAt(i + 3)) {
					throw new RomanNumeralException("RomanNumeralException");
				}
			}
			
			/**
			 * Checks if there are any repeats of V, L, or D in a row.
			 */
			if ((strChar == 'V' || strChar == 'L' || strChar == 'D') && ((i + 1) < numeral.length())) {
				if (strChar == numeral.charAt(i + 1)) {
					throw new RomanNumeralException("RomanNumeralException");
				}
			}
			
			if (romanStack.isEmpty()) {
				romanStack.push(strChar);
			}
			
			else {
				if (convertSingleNumeral(strChar) <= convertSingleNumeral(romanStack.peek())) {
					romanStack.push(strChar);
				}
				
				else {
					total += convertSingleNumeral(strChar) - convertSingleNumeral(romanStack.pop());

					
				}
			}
		}	
		while (!romanStack.isEmpty()) {
			total += convertSingleNumeral(romanStack.pop());
		}
		
		return total;
	}
}
