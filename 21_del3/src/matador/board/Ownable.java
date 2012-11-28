package matador.board;

import matador.business_logic.Player;

/**
 * Abstract class that all the ownable fields used in Matador inherits from.
 * @author Martin Caspersen
 *
 */
public abstract class Ownable extends Field {
	protected int price;
	protected Player owner;

	/**
	 * Constructor that sets name, field number and price.
	 * @param name {@link java.lang.String} with field name.
	 * @param fieldNum {@link java.lang.int} with the id 
	 */
	public Ownable(String name, int fieldNum, int price) {
		super(name, fieldNum);
		this.price = price;
	}
	
	/**
	 * Return the price of the field.
	 * @return {@link java.lang.int} price of the field.
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Returns the owner of the field.
	 * @return {@link matador.business_logic.Player} owner of the field.
	 */
	public Player getOwner() {
		return owner;
	}
	
	/**
	 * Sets the owner of the field to the provided {@link matador.business_logic.Player}.
	 * @param owner {@link matador.business_logic.Player} to set as owner.
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	/* (non-Javadoc)
	 * @see matador.board.Field#landOnField(matador.business_logic.Player)
	 */
	@Override
	public void landOnField(Player player) {
		if (owner != player) {
			int currentRent = rent();
			if (player.getKonto().withdraw(currentRent)) {
				if (owner != null) {
					owner.getKonto().deposit(currentRent);
				}
			} else {
				player.setLoser();
			}
		}
	}
	
	/**
	 * Used to calculate the rent for landing on the field.
	 * @return {@link java.lang.int} rent to pay for landing on the field.
	 */
	protected abstract int rent();

	/* (non-Javadoc)
	 * @see matador.board.Field#toString()
	 */
	@Override
	public String toString() {
		return "Ownable [price=" + price + ", name=" + name + ", fieldNum="
				+ fieldNum + ", owner=" + owner.getName() + "]";
	}
}
