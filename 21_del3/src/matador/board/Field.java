package matador.board;

import matador.business_logic.Player;

/**
 * Abstract class that all the fields used in Matador inherits from.
 * In this current implementation all the fields have the same behviour and use the methods as implemented here.
 * @author Martin Caspersen
 *
 */
public abstract class Field {
	protected String name;
	protected int fieldNum;
	protected Player owner;

	/**
	 */
	public Field(String name, int fieldNum) {
		this.name = name;
		this.fieldNum = fieldNum;
	}

	public abstract void landOnField(Player player);
	
//	/**
//	 * Returns changeBalance, which represents what should happen to a players balance upon landing on a given field.
//	 * @return [int] representing the change to a players balance as a result of landing on the field.
//	 */
//	public int getChangeBalance() {
//		return changeBalance;
//	}
	
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

	@Override
	public String toString() {
		return "Field [name=" + name + ", fieldNum=" + fieldNum + ", owner="
				+ owner.getName() + "]";
	}
}
