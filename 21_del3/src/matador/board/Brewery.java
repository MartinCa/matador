package matador.board;

import matador.business_logic.*;
import java.util.*;

/**
 * Reprensents the breweries in Matador, subclass of {@link matador.board.Field} and {@link matador.board.Ownable}.
 * @author Martin Caspersen
 * @see Ownable
 * @see Field
 */
public class Brewery extends Ownable {

	
	/**
	 * Constructor that sets name, fieldNum and price.
	 * @param name String with field name.
	 * @param fieldNum int representing the fields id in the provided GUI.
	 * @param price int price to but the field.
	 */
	public Brewery(String name, int fieldNum, int price) {
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
				if (ownIter.next() instanceof Brewery) {
					numFields++;
				}
			}

			return numFields * 100 * Game.getGame().getBaeger().getSum(); // This class cannot get the dice values at the moment, this needs to be fixed.
		} else {
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see matador.board.Ownable#toString()
	 */
	@Override
	public String toString() {
		return "Brewery [price=" + price + ", owner=" + owner + ", name="
				+ name + ", fieldNum=" + fieldNum + "]";
	}
}
