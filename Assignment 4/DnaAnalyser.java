import java.util.Iterator;

/**
 * Class that uses the checker to find patterns in DNA sequences
 * @author Rose Gao
 *
 */
public class DnaAnalyser {
	
	/**
	 * Stores all checkers for this analyzer
	 */
	LinkedQueue<Checker> checkers;
	
	/**
	 * Stores all the results for the most recently searched sequence
	 */
	LinkedQueue<String> results;
	
	/**
	 * Constructor that creates a new analyzer for a DNA sequence
	 * @param checkers all checkers for this analyzer
	 */
	public DnaAnalyser (LinkedQueue<Checker> checkers) {
		this.checkers = checkers;
		results = new LinkedQueue<String> ();
		
	}
	
	/**
	 * Method that iterates through a DNA sequence, finding all palindromic sequences and tandem repeats within it
	 * @param dnaSequence DNA sequence to be searched
	 * @return String of the full DNA sequence searched
	 */
	public String search(Iterator<Character> dnaSequence) {
		
		LinkedQueue<Checker> activeCheckers = new LinkedQueue<Checker> ();
		String fullSequence = "";
		int position = 0;
		
		while (!results.isEmpty()) {
			results.dequeue();
		}
		
		while (dnaSequence.hasNext()) {
			Character character = dnaSequence.next();
			fullSequence += character;
			position += 1;
			
			
			for (int i = 0; i < checkers.size(); i++) {
				Checker temp = checkers.dequeue();
				activeCheckers.enqueue(temp.cloneHere(position));
				checkers.enqueue(temp);
			}
			
			int size = activeCheckers.size();
			for (int j = 0; j < size; j++) {
				Checker tempActive = activeCheckers.dequeue();
				boolean status = tempActive.process(character);
				
				if (status == true) {
					results.enqueue(tempActive.toString());
				}
				
				else if (!tempActive.finished()) {
					activeCheckers.enqueue(tempActive);
				}
			}
			
		}
		
		
		return fullSequence;
		
	}
	
	/**
	 * Prints out the results queue followed by a formatted DNA sequence string to visually confirm the results
	 * @param dnaSequence DNA sequence to be displayed
	 * @return String of results queue with formatted DNA sequence following it
	 */
	public String displayAnalysis(String dnaSequence) {
		String resultsStr = "";
		for (int i = 0; i < results.size(); i++) {
			String tempResults = results.dequeue();
			resultsStr += tempResults;
			results.enqueue(tempResults);
		}
		
		return resultsStr + DNA.display(dnaSequence);
		
	}

}
