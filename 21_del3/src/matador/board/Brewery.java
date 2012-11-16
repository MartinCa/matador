package matador.board;

import matador.business_logic.*;

/**
 * Reprensents the breweries in Matador, subclass of Field and Ownable.
 * @author Martin Caspersen
 * @see Ownable
 * @see Field
 */
public class Brewery extends Ownable {

	
	/**
	 * Constructor that sets name, changeBalance and fieldNum.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 * @param fieldNum int representing the fields id in the provided GUI.
	 */
	public Brewery(String name, int fieldNum, int price) {
		super(name, fieldNum, price);
	}
	
	protected int rent() {
		Field[] ownedFields = owner.getFields();
		int numFields = 0;
		
		for (Field field : ownedFields) {
			if (Refuge.class.isInstance(field)) {
				numFields++;
			}
		}
		
		return numFields * 100 * diceSum; // This class cannot get the dice values at the moment, this needs to be fixed.
	}
	
	public void landOnField(Player player) {
		int currentRent = rent();
		if (player.getKonto().withdraw(currentRent)) {
			owner.getKonto().deposit(currentRent);
		} else {
			// NEED LOSER THING HERE
		}
		
	}
}
