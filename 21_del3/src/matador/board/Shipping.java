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
	 * Constructor that sets name, changeBalance and fieldNum.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 * @param fieldNum int representing the fields id in the provided GUI.
	 */
	public Shipping(String name, int fieldNum, int price) {
		super(name, fieldNum, price);
	}
	
	protected int rent() {
		if (owner != null && owner.getOwnedFields() != null) {
			ArrayList<Ownable> ownedFields = owner.getOwnedFields();
			int numFields = 0;
			System.out.println(ownedFields.get(0));
			Iterator<Ownable> ownIter = ownedFields.iterator();

			while (ownIter.hasNext()) {
				if (Shipping.class.isInstance(ownIter.next())) {
					numFields++;
				}
			System.out.println(numFields);
			}

			return (int)(basisFare * Math.pow(2, numFields - 1));
		} else {
			return 0;
		}
	}
	
	public void landOnField(Player player) {
		int currentFare = rent();
		if (player.getKonto().withdraw(currentFare)) {
			if (owner != null) {
				owner.getKonto().deposit(currentFare);
			}
		} else {
			// NEED LOSER THING HERE
		}
	}
}
