package matador.board;

import matador.business_logic.Player;

/**
 * Represents the Refuge fields from Matador.
 * Can pay out a bonus for landing on the field. Can also represent bonus fields that do not payout any bonus.
 * @author Martin Caspersen
 *
 */
public class Refuge extends Field {
	private int bonus;

	/**
	 * Constructor that sets name and fieldNum and bonus.
	 * @param name {@link java.lang.String} field name.
	 * @param fieldNum {@link java.lang.int} number represent the ID in the provided GUI.
	 * @param bonus {@link java.lang.int} bonus for landing on the field.
	 */
	public Refuge(String name, int fieldNum, int bonus) {
		super(name, fieldNum);
		this.bonus = bonus;
	}
	
	/* (non-Javadoc)
	 * @see matador.board.Field#landOnField(matador.business_logic.Player)
	 */
	@Override
	public void landOnField(Player player) {
		player.getKonto().deposit(bonus);
	}

	/* (non-Javadoc)
	 * @see matador.board.Field#toString()
	 */
	@Override
	public String toString() {
		return "Refuge [bonus=" + bonus + ", name=" + name + ", fieldNum="
				+ fieldNum + "]";
	}
}
