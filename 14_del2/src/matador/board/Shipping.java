package matador.board;

/**
 * Represents the shipping companies from Matador.
 * @author Martin Caspersen
 *
 */
public class Shipping extends Ownable {

	/**
	 * Constructor that sets name and changeBalance.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 */
	public Shipping(String name, int changeBalance) {
		super(name, changeBalance);
	}

	/**
	 * Constructor that sets name, changeBalance and fieldNum.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 * @param fieldNum int representing the fields id in the provided GUI.
	 */
	public Shipping(String name, int changeBalance, int fieldNum) {
		super(name, changeBalance, fieldNum);
	}
}
