
public class Testing {
	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack<Character> romanStack = new ArrayStack<Character> ();
		String numeral = "XCIX";
		int total = 0;
		
		
		for (int i = 0; i < numeral.length(); i++) {
			char strChar = numeral.charAt(i);
			if ((strChar == 'I' || strChar == 'X' || strChar == 'C' || strChar == 'M') && ((i + 3) < numeral.length())) {
				if (strChar == numeral.charAt(i + 1) && strChar == numeral.charAt(i + 2) && strChar == numeral.charAt(i + 3)) {
					System.out.println("Error"); 
				}
			}
			
			if ((strChar == 'V' || strChar == 'L' || strChar == 'D') && ((i + 1) < numeral.length())) {
				if (strChar == numeral.charAt(i + 1)) {
					System.out.println("Error"); 
				}
			}
			
			if (romanStack.isEmpty()) {
				romanStack.push(strChar);
			}
			
			else {
				if (convertSingleNumeral(strChar) <= convertSingleNumeral(romanStack.peek())) {
					romanStack.push(strChar);
//					System.out.println("if " + strChar);
				}
				
				else {
					total += convertSingleNumeral(strChar) - convertSingleNumeral(romanStack.pop());
//					System.out.println("else " + total);

					
				}
			}
		}	
		while (!romanStack.isEmpty()) {
			total += convertSingleNumeral(romanStack.pop());
//			System.out.println("while " + total);
		}
		
		System.out.println(total);
		
	}
}
