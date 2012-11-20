package matador.board;

import matador.business_logic.Player;

/**
 * Represents the streets from Matador.
 * @author Martin Caspersen
 *
 */
public class Street extends Ownable{
	private int rent;
	
	/**
	 * Constructor that sets name and changeBalance.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 */
	public Street(String name, int fieldNum, int rent, int price) {
		super(name, fieldNum, price);
		this.rent = rent;
	}

	public void landOnField(Player player) {
		int currentRent = rent();
		if (owner != player) {
			if (player.getKonto().withdraw(currentRent)) {
				if (owner != null) {
					owner.getKonto().deposit(currentRent);
				}
			} else {
				player.setLoser();
			}
		}
	}
	
	protected int rent() {
		return rent;
	}

	@Override
	public String toString() {
		return "Street [rent=" + rent + ", price=" + price + ", owner=" + owner
				+ ", name=" + name + ", fieldNum=" + fieldNum + "]";
	}


}
