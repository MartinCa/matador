package matador.board;

/**
 * Represents the streets from Matador.
 * @author Martin Caspersen
 *
 */
public class Street extends Ownable {
	private int rent;
	
	/**
	 * Constructor that sets the name, fieldNum, rent and price.
	 * @param name {@link java.lang.String} field name.
	 * @param fieldNum {@link java.lang.int} representing the field place in the provided GUI.
	 * @param rent {@link java.lang.int} basic rent for landing on the field.
	 * @param price {@link java.lang.int} price to buy the field.
	 */
	public Street(String name, int fieldNum, int rent, int price) {
		super(name, fieldNum, price);
		this.rent = rent;
	}

	/* (non-Javadoc)
	 * @see matador.board.Ownable#rent()
	 */
	@Override
	protected int rent() {
		return rent;
	}
	
	/* (non-Javadoc)
	 * @see matador.board.Ownable#toString()
	 */
	@Override
	public String toString() {
		return "Street [rent=" + rent + ", price=" + price + ", owner=" + owner
				+ ", name=" + name + ", fieldNum=" + fieldNum + "]";
	}
}