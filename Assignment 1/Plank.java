/**
 * The Plank class is a subclass of Flooring, meant to represent a type of material that covers the floor in planks.
 * @author Rose Gao
 */

public class Plank extends Flooring {
	
	/**
	 * Length of plank in inches
	 */
	private int plankLengthInch;
	
	/**
	 * Width of plank in inches
	 */
	private int plankWidthInch;
	
	/**
	 * Price per plank
	 */
	private double plankPrice;
	
	/**
	 * Constructor creates a Plank object with given material, 
	 * length of plank in inches, width of plank in inches, and price per plank 
	 * @param material material name of plank
	 * @param plankLengthInch plank length in inches
	 * @param plankWidthInch plank width in inches
	 * @param plankPrice price per plank
	 */
	public Plank (String material, int plankLengthInch, int plankWidthInch, double plankPrice) {
		/** 
		 * Evoking the superclass, with parameters material and price per square inch (calculated from given Plank parameters)
		 */

		super(material, plankPrice/(plankLengthInch*plankWidthInch));
		super.setType("plank");
		this.plankLengthInch = plankLengthInch;
		this.plankWidthInch = plankWidthInch;
		this.plankPrice = plankPrice;
		
	}
	
	/**
	 * Method to calculate amount of material needed to cover the floor
	 * @param lengthInches length of the floor in inches
	 * @param widthInches width of the floor in inches
	 * @param plankLengthToFloorLength obtains the amount of material needed 
	 * to cover the floor if the plank length is laid out parallel to the floor length
	 * @param plankLengthToFloorWidth obtains the amount of material needed 
	 * to cover the floor if the plank length is laid parallel to floor width
	 * @return least amount of material required to cover the floor
	 */
	@Override
	public int amountOfMaterial (int lengthInches, int widthInches) {
		double plankLengthToFloorLength = 0;
		double plankLengthToFloorWidth = 0;
		
		/**
		 * Calculating plankLengthToFloorLength
		 * @param totalPlankLength1 calculates the least number of planks (by length) required to cover the the length of the room
		 * @param totalPlankWidth1 calculates the least number of planks (by width) required to cover the width of the room
		 */
		double totalPlankLength1 = plankLengthInch*(Math.ceil((double)lengthInches/(double)plankLengthInch));
		double totalPlankWidth1 = plankWidthInch*(Math.ceil((double)widthInches/(double)plankWidthInch));
		plankLengthToFloorLength = Math.ceil(totalPlankLength1*totalPlankWidth1);
		
		/**
		 * Calculating plankLengthToFloorWidth
		 * @param totalPlankLength2 calculates the least number of planks (by length) required to cover the the width of the room
		 * @param totalPlankWidth2 calculates the least number of planks (by width) required to cover the length of the room
		 */
		double totalPlankLength2 = plankLengthInch*(Math.ceil((double)widthInches/(double)plankLengthInch));
		double totalPlankWidth2 = plankWidthInch*(Math.ceil((double)lengthInches/(double)plankWidthInch));
		plankLengthToFloorWidth = Math.ceil(totalPlankLength2*totalPlankWidth2);
		
		if (plankLengthToFloorLength < plankLengthToFloorWidth) {
			return (int) plankLengthToFloorLength;
		
		}
		
		else {
			return (int) plankLengthToFloorWidth;
		}

		
	}
	
	/**
	 * Method that returns the amount of unused material
	 * @param lengthInch length of floor in inches 
	 * @param widthInch width of floor in inches
	 * @return amount of unused material
	 */
	@Override
	public int unusedMaterial(int lengthInches, int widthInches) {
		return amountOfMaterial(lengthInches, widthInches) - super.amountOfMaterial(lengthInches, widthInches);
	}
	
	/**
	 * Method to return a string representation of a Plank
	 */
	@Override
	public String toString() {
		String plankWidth = super.toFeet(plankWidthInch);
		String plankLength = super.toFeet(plankLengthInch);
		return ("Flooring-" + super.getType() + " " + super.getMaterial() + " @" + plankPrice + " per " + plankLength + " by " + plankWidth);		
	}

}
