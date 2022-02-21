/**
 * This class encapsulates all the data and methods used in creating table of quotes for
 * a contractor to show clients.
 * @author Rose Gao
 */

public class QuoteTable {
	
	/**
	 * Array of flooring options
	 */
	private Flooring[] option;
	
	/**
	 * Length of floor in inches
	 */
	private int lengthInch;
	
	/**
	 * Width of floor in inches
	 */
	private int widthInch;
	
	/**
	 * Contractor markup commission
	 */
	private double markup;
	
	/**
	 * Constructor to create a quote table; takes an array of Flooring, length of floor in inches
	 * width of floor in inches, and the contractor's markup
	 * @param option
	 * @param lengthInch
	 * @param widthInch
	 * @param markup
	 */
	public QuoteTable(Flooring[] option, int lengthInch, int widthInch, double markup) {
		this.option = option;
		this.lengthInch = lengthInch;
		this.widthInch = widthInch;
		this.markup = markup;		
	}
	
	/**
	 * Setter method for option
	 * @param newOption new option to replace the old option
	 */
	public void setOptions(Flooring[] newOption) {
		option = newOption;
		
	}
	
	/**
	 * Setter method to set length of the floor in inches
	 * @param newLengthInch new length of floor in inches to replace the old length
	 */
	public void setLength(int newLengthInch) {
		lengthInch = newLengthInch;
	}
	
	/**
	 * Setter method to set width of the floor in inches
	 * @param newWidthInch new width of floor in inches to replace the old width
	 */
	public void setWidth(int newWidthInch) {
		widthInch = newWidthInch;
	}
	
	/**
	 * 
	 * Setter method to set length of the floor in inches
	 * @param newMarkup new markup rate of contractor to replace the old markup
	 */
	
	public void setMarkup(double newMarkup) {
		markup = newMarkup;
	}
	
	/**
	 * Method that iterates through the options array to obtain the cheapest possible price of covering a floor
	 * @return cheapest cost to cover floor
	 */
	public int getCheapestValue() {
		int i;
		double cheapestValue = option[0].quoteCents(lengthInch, widthInch, markup);
		for (i = 0; i < option.length; ++i) {
			if(cheapestValue > option[i].quoteCents(lengthInch, widthInch, markup)) {
				cheapestValue = option[i].quoteCents(lengthInch, widthInch, markup);
				
			}
		}
		
		return (int) Math.ceil(cheapestValue);
	}
	
	/**
	 * Method that iterates through the options array to obtain the option with the lowest waste ratio
	 * @return
	 */
	public double getCleanestValue() {
		int i;
		double cleanestValue = option[0].wasteRatio(lengthInch, widthInch);
		
		for (i = 0; i < option.length; ++i) {
			if(cleanestValue > option[i].wasteRatio(lengthInch, widthInch)) {
				cleanestValue = option[i].wasteRatio(lengthInch, widthInch);
			}
		}
		
		return cleanestValue;
	}
	
	private static String displayHundredths(int hundredths) {
		return hundredths / 100 + "." + (hundredths / 10 % 10) + "" + hundredths % 10;
	}
	
	public String display() {
		String out = "For a floor " + Flooring.toFeet(lengthInch) + " by " + Flooring.toFeet(widthInch) + "\n\n";
        
        int cheapestValue = getCheapestValue();
        double cleanestValue = getCleanestValue();
		
		out += "Material\tWaste\tCost\n";
		out += "--------\t-----\t----\n";
		for (int i = 0; i < option.length; i++) {
			double waste = option[i].wasteRatio(lengthInch, widthInch);
			int cost = option[i].quoteCents(lengthInch, widthInch, markup);

			out += option[i].getType() + "-";
			out += option[i].getMaterial() + "\t";
			out += displayHundredths((int) (10000 * waste)) + "%\t";
			out += "$" + displayHundredths(cost);
			if (waste == cleanestValue)
				out += " Eco";
			if (cost == cheapestValue)
				out += " $$";
			out += "\n";
		}
		return out;
	}
}