package matador.board;

import java.util.*;

import matador.business_logic.Player;

/**
 * Represents the shipping companies from Matador.
 * @author Martin Caspersen
 *
 */
public class Shipping extends Ownable {
	private int basisFare = 500;

	/**
	 * Constructor that sets name, fieldNum and price.
	 * @param name {@link java.lang.String} with field name.
	 * @param fieldNum {@link java.lang.int} representing the fields ID in the provided GUI.
	 * @param price {@link java.lang.int} price of the field.
	 */
	public Shipping(String name, int fieldNum, int price) {
		super(name, fieldNum, price);
	}
	
	/* (non-Javadoc)
	 * @see matador.board.Ownable#rent()
	 */
	@Override
	protected int rent() {
		if (owner != null) {
			List<Ownable> ownedFields = owner.getOwnedFields();
			int numFields = 0;
			Iterator<Ownable> ownIter = ownedFields.iterator();

			while (ownIter.hasNext()) {
				if (ownIter.next() instanceof Shipping) {
					numFields++;
				}
			}

			return (int)(basisFare * Math.pow(2, numFields - 1));
		} else {
			return 0;
		}
	}
	
	/* (non-Javadoc)
	 * @see matador.board.Field#landOnField(matador.business_logic.Player)
	 */
	@Override
	public void landOnField(Player player) {
		int currentFare = rent();
		if (owner != player) {
			if (player.getKonto().withdraw(currentFare)) {
				if (owner != null) {
					owner.getKonto().deposit(currentFare);
				}
			} else {
				player.setLoser();
			}
		}
	}

	/* (non-Javadoc)
	 * @see matador.board.Ownable#toString()
	 */
	@Override
	public String toString() {
		return "Shipping [basisFare=" + basisFare + ", price=" + price
				+ ", owner=" + owner + ", name=" + name + ", fieldNum="
				+ fieldNum + "]";
	}
}
