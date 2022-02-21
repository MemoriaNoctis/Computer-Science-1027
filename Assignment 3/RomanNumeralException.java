/**
 * Custom exception classed used in the Roman2Arabic class
 * @author Rose Gao
 *
 */
public class RomanNumeralException extends RuntimeException {
	
	public RomanNumeralException (String exc) {
		super("Error: " + exc);
	}

}
