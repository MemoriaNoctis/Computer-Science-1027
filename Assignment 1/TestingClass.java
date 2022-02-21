
public class TestingClass {
	
	public static void main(String[] args) {
		Flooring[] option = new Flooring[3];
		option[0] = new Plank("birch", 12 * 6, 4, 14.95);
		option[2] = new Roll("linoleum", 79, 3.92);
		option[1] = new Plank("oak", 12 * 7, 5, 23.07);
		
		int i;
		double cleanestValue = option[0].wasteRatio(750, 300);
					
		for (i = 0; i < option.length; ++i) {
			if(cleanestValue > option[i].wasteRatio(750, 300)) {
				cleanestValue = option[i].wasteRatio(750, 300);
				System.out.println(cleanestValue);
			}
				
				
		}
		
		System.out.println();
		System.out.println(option[0].wasteRatio(750, 300));
		System.out.println(option[1].wasteRatio(750, 300));
		System.out.println(option[2].wasteRatio(750, 300));
		
		System.out.println(cleanestValue);
	}


}
