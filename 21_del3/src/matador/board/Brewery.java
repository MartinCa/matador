package matador.board;

import matador.business_logic.*;
import java.util.*;

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
			
			return numFields * 100 * Game.getGame().getBaeger().getSum(); // This class cannot get the dice values at the moment, this needs to be fixed.
		} else {
			return 0;
		}
		
		
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
