package matador.board;

import java.util.ArrayList;

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
		ArrayList<Ownable> ownedFields = owner.getOwnedFields();
		int numFields = 0;
		
		for (Ownable field : ownedFields) {
			if (Refuge.class.isInstance(field)) {
				numFields++;
			}
		}
		return (int)(basisFare * Math.pow(basisFare, numFields));
	}
	
	public void landOnField(Player player) {
		int currentFare = rent();
		if (player.getKonto().withdraw(currentFare)) {
			owner.getKonto().deposit(currentFare);
		} else {
			// NEED LOSER THING HERE
		}
	}
}
