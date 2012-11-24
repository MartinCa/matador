package matador.board;

import matador.business_logic.Player;

/**
 * Represents tax fields from Matador.
 * @author Martin Caspersen.
 *
 */
public class Taxes extends Field{
	private int tax;

	/**
	 * Constructor that sets name, fieldNum and .
	 * @param name String with field name.
	 * @param fieldNum int representing the fields id in the provided GUI.
	 */
	public Taxes(String name, int fieldNum, int tax) {
		super(name, fieldNum);
		this.tax = tax;
	}
	
	/* (non-Javadoc)
	 * @see matador.board.Field#landOnField(matador.business_logic.Player)
	 */
	@Override
	public void landOnField(Player player) {
		if (player.getKonto().withdraw(tax)) {
			
		} else {
			player.setLoser();
		}
	}

	/* (non-Javadoc)
	 * @see matador.board.Field#toString()
	 */
	@Override
	public String toString() {
		return "Taxes [tax=" + tax + ", name=" + name + ", fieldNum="
				+ fieldNum + "]";
	}
}
