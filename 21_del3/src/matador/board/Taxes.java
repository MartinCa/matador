package matador.board;

import matador.business_logic.Player;

/**
 * Represents tax field from Matador.
 * @author Martin Caspersen.
 *
 */
public class Taxes extends Field{
	private int tax;

	/**
	 * Constructor that sets name, changeBalance and fieldNum.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 * @param fieldNum int representing the fields id in the provided GUI.
	 */
	public Taxes(String name, int fieldNum, int tax) {
		super(name, fieldNum);
		this.tax = tax;
	}
	
	public void landOnField(Player player) {
		if (player.getKonto().withdraw(tax)) {
			
		} else {
			// Need loser thing here
		}
	}
}
