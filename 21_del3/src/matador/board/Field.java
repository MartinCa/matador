package matador.board;

import board.codeBehind.Player;

/**
 * Abstract class that all the fields used in Matador inherits from.
 * In this current implementation all the fields have the same behviour and use the methods as implemented here.
 * @author Martin Caspersen
 *
 */
public abstract class Field {
	protected String name;
	protected int changeBalance;
	protected int fieldNum;
	private Player owner;

	/**
	 * Constructor that sets name and changeBalance.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 */
	public Field(String name, int changeBalance) {
		this.name = name;
		this.changeBalance = changeBalance; // Added to simplify part 2.
	}
	
	/**
	 * Constructor that sets name, changeBalance and fieldNum.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 * @param fieldNum int representing the fields id in the provided GUI.
	 */
	public Field(String name, int changeBalance, int fieldNum) {
		this.name = name;
		this.changeBalance = changeBalance; // Added to simplify part 2.
		this.fieldNum = fieldNum;
	}
	
	/**
	 * Returns changeBalance, which represents what should happen to a players balance upon landing on a given field.
	 * @return [int] representing the change to a players balance as a result of landing on the field.
	 */
	public int getChangeBalance() {
		return changeBalance;
	}
	
	/**
	 * Returns the name of a field.
	 * @return [String] name of field.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the fields ID as used in the provided GUI.
	 * @return [int] field ID for GUI.
	 */
	public int getFieldNum() {
		return fieldNum;
	}
}
