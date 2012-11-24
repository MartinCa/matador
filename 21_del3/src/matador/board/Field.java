package matador.board;

import matador.business_logic.Player;

/**
 * Abstract class that all the fields used in Matador inherits from.
 * Implements name and fieldNum which all fields in Matador have.
 * @author Martin Caspersen
 *
 */
public abstract class Field {
	protected String name;
	protected int fieldNum;

	/**
	 * Constructor taking a name and field number.
	 * @param name {@link java.lang.String} with the name of the field.
	 * @param fieldNum {@link java.lang.int} representing the field place in the provided GUI.
	 */
	public Field(String name, int fieldNum) {
		this.name = name;
		this.fieldNum = fieldNum;
	}

	/**
	 * Performs the necessary actions on the {@link matador.business_logic.Player} landing on the field.
	 * Gets the players Konto and calls {@link matador.business_logic.Konto#withdraw(int)} or {@link matador.business_logic.Konto#deposit(int)} as necessary.
	 * If the player does not have sufficient money to pay the cost of landing on the field he will be set as a loser with a call to {@link matador.business_logic.Player#setLoser()}
	 * 
	 * @param player {@link matador.business_logic.Player} landing on the field.
	 * @see matador.business_logic.Player
	 * @see matador.business_logic.Konto
	 */
	public abstract void landOnField(Player player);
	
	/**
	 * Returns the name of a field.
	 * @return {@link java.lang.String} name of field.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the field ID as used in the provided GUI.
	 * @return {@link java.lang.int} field ID for GUI.
	 */
	public int getFieldNum() {
		return fieldNum;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Field [name=" + name + ", fieldNum=" + fieldNum + "]";
	}
}
