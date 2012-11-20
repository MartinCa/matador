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
	 * Constructor that sets name and changeBalance.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 */
	public Ownable(String name, int fieldNum, int price) {
		super(name, fieldNum);
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	protected abstract int rent();

	@Override
	public String toString() {
		return "Ownable [price=" + price + ", name=" + name + ", fieldNum="
				+ fieldNum + ", owner=" + owner.getName() + "]";
	}
}
