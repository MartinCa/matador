package matador.board;

/**
 * Reprensents the breweries in Matador, subclass of Field and Ownable.
 * @author Martin Caspersen
 * @see Ownable
 * @see Field
 */
public class Brewery extends Ownable {

	/**
	 * Constructor that sets name and changeBalance.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 */
	public Brewery(String name, int changeBalance) {
		super(name, changeBalance);
	}
	
	/**
	 * Constructor that sets name, changeBalance and fieldNum.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 * @param fieldNum int representing the fields id in the provided GUI.
	 */
	public Brewery(String name, int changeBalance, int fieldNum) {
		super(name, changeBalance, fieldNum);
	}
}
