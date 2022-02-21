/**
 * The Tile class is a subclass of Plank, meant to represent a type of material that covers the floor in square tiles.
 * @author Rose Gao
 */
public class Tile extends Plank{
	
	/**
	 * Constructor creates a Tile object with given material, 
	 * side length of the square tile in inches, and price per tile
	 * @param material material name of tile
	 * @param sideLength side length of tile in inches
	 * @param pricePerTile price per tile
	 */
	public Tile (String material, int sideLength, double pricePerTile) {
		/**
		 * Evoking the superclass, with parameters material, side length in inches 
		 * (corresponding to plank length and width), and price per tile
		 */
		super(material, sideLength, sideLength, pricePerTile);
		super.setType("tile");		
	}

}
