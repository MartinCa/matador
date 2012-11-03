package matador.board;

/**
 * Represents tax field from Matador.
 * @author Martin Caspersen.
 *
 */
public class Taxes extends Field{

	/**
	 * Constructor that sets name and changeBalance.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 */
	public Taxes(String name, int changeBalance){
		super(name, changeBalance);
	}

	/**
	 * Constructor that sets name, changeBalance and fieldNum.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 * @param fieldNum int representing the fields id in the provided GUI.
	 */
	public Taxes(String name, int changeBalance, int fieldNum) {
		super(name, changeBalance, fieldNum);
	}
}
