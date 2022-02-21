/**
 * The Roll class is a subclass of Flooring, meant to represent a type of material that covers the floor in large rolls.
 * @author Rose Gao
 */

public class Roll extends Flooring {
	
	/**
	 * Width of Roll
	 */
	private int rollWidthInch;
	
	/**
	 * Price of Roll per inch
	 */
	private double rollPricePerInch;
	
	/**
	 * Constructor creates a Roll object with given material, width of roll, and price per inch
	 * @param material material type of roll
	 * @param rollWidthInch width of roll
	 * @param rollPricePerInch price per inch of roll
	 */
	public Roll(String material, int rollWidthInch, double rollPricePerInch) {
		/**
		 * Evoking the superclass, with parameters material and price per square inch (calculated from given Roll parameters)
		 */
		super(material, rollPricePerInch/rollWidthInch);
		this.rollPricePerInch = rollPricePerInch;
		this.rollWidthInch = rollWidthInch;
		super.setType("roll");		
	}
	
	/**
	 * Method to calculate amount of material needed to cover the floor
	 * @param lengthInches length of the floor in inches
	 * @param widthInches width of the floor in inches
	 * @param rollAreaByLength obtains the amount of material needed 
	 * to cover the floor if the roll is laid parallel to room length
	 * @param rollAreaByWidth obtains the amount of material needed 
	 * to cover the floor if the roll is laid parallel to room width
	 * @return least amount of material required to cover the floor
	 */
	@Override	
	public int amountOfMaterial (int lengthInches, int widthInches) {
		double rollAreaByLength = 0;
		double rollAreaByWidth = 0;
		
		
		rollAreaByLength = (rollWidthInch*lengthInches) * Math.ceil((double)widthInches/(double)rollWidthInch);
		
		rollAreaByWidth = (rollWidthInch*widthInches) * Math.ceil((double)lengthInches/(double)rollWidthInch);
		
		
		if (rollAreaByLength < rollAreaByWidth) {
			return (int) Math.ceil(rollAreaByLength);
		}
		
		else {
			return (int) Math.ceil(rollAreaByWidth);
		}
	}
	
	/**
	 * Method that returns the amount of unused material
	 * @param lengthInch length of floor in inches 
	 * @param widthInch width of floor in inches
	 * @return amount of unused material
	 */
	@Override
	public int unusedMaterial (int lengthInches, int widthInches) {
		return amountOfMaterial(lengthInches, widthInches) - super.amountOfMaterial(lengthInches, widthInches);	
	}
	
	/**
	 * Method to return a string representation of a Roll
	 */
	@Override
	public String toString() {
		String rollWidth = super.toFeet(rollWidthInch);
		return ("Flooring-" + super.getType() + " " + super.getMaterial() + " @" + rollPricePerInch + " per inch of a " + rollWidth + " roll");
		
	}

}
