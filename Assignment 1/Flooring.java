/**
 * This class encapsulates the data and methods associated with different flooring materials.
 * It is also the base class for Roll, Plank, and Tile.
 * @author Rose Gao
 *
 */
public class Flooring {
	/**
	 * Type of Flooring
	 */
	private String type;
	/**
	 * Name of material used
	 */
	private String materialName;
	/**
	 * Price per square inch of the flooring
	 */
	private double pricePerSqInch;
	
	/**
	 * Constructor creates a Flooring object with given material and price per square inch
	 * @param material material of flooring used
	 * @param pricePerSqInch price per square inch of the flooring
	 */
	public Flooring(String material, double pricePerSqInch) {
		type = "poured";
		this.materialName = material;
		this.pricePerSqInch = pricePerSqInch;		
	}
	
	/**
	 * Accessor method to obtain flooring type
	 * @return type of flooring
	 */
	public String getType() {
		return type;		
	}
	
	/**
	 * Setter method to set flooring type
	 * @param newType new type of flooring to replace the old type
	 */
	public void setType(String newType) {
		type = newType;		
	}
	
	/**
	 * Accessor method to obtain material name of the flooring
	 * @return material name of flooring
	 */
	public String getMaterial() {
		return materialName;		
	}
	
	/**
	 * Accessor method to obtain price per square inch of flooring
	 * @return price per square inch
	 */
	public double getPricePerSqInch() {
		return pricePerSqInch;
	}
	
	/**
	 * Method to calculate amount of material needed to cover the floor
	 * @param lengthInch length of the floor in inches
	 * @param widthInch width of the floor in inches
	 * @return area of floor that must be covered by material
	 */
	public int amountOfMaterial (int lengthInch, int widthInch) {
		double amountOfMaterial = lengthInch * widthInch;
		return (int)Math.ceil(amountOfMaterial);	
	}
	
	/**
	 * Method to calculate the estimated price of covering the floor
	 * @param lengthInch length of floor in inches
	 * @param widthInch width of floor in inches
	 * @param markup markup commission charged by the company
	 * @return cost in cents
	 */
	public int quoteCents(int lengthInch, int widthInch, double markupCom) {
        int fullArea = amountOfMaterial(lengthInch, widthInch);
        double quoteCalc = (((fullArea * getPricePerSqInch()) * (1 + markupCom)) * 100);
        quoteCalc = Math.ceil(quoteCalc);
        return (int) (quoteCalc);
    }	
	
	/**
	 * Method that converts inches to feet and inches
	 * @param numberOfInches input of number of inches to convert
	 * @return conversion of input to feet and inches
	 */
	public static String toFeet (int numberOfInches) {
		int FEET_CONVERSION_RATE = 12;
		int toFeet = numberOfInches / FEET_CONVERSION_RATE;
		int remainingInches = numberOfInches % FEET_CONVERSION_RATE;
		
		if (toFeet == 0) {
			return (remainingInches + "''");
		}
		
		else if (remainingInches == 0) {
			return (toFeet + "'");
		}
		
		else {
			return (toFeet + "'" + remainingInches + "''");				
		}
	}
	
	/**
	 * Method that returns the amount of unused material
	 * @param lengthInch length of floor in inches 
	 * @param widthInch width of floor in inches
	 * @return amount of unused material
	 */
	public int unusedMaterial (int lengthInch, int widthInch) {
		return 0;
	}
	
	/**
	 * Method that calculates the waste ratio of unused material to total material used
	 * @param lengthInch length of floor in inches
	 * @param widthInch width of floor in inches
	 * @return waste ratio
	 */
	public double wasteRatio (int lengthInch, int widthInch) {
		return unusedMaterial (lengthInch, widthInch) / (double)amountOfMaterial(lengthInch, widthInch);
	}
	
	/**
	 * Method to return a string representation of the selected flooring
	 */
	public String toString() {
		return ("Flooring-" + type + " " + materialName + " @" + pricePerSqInch + " sq. in");
	}

}
