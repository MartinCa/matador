package matador.business_logic;

/**
 * Provides a Player that is used in a dice game. The Player holds a name, carColor and a Konto.
 * Provides necessary functions used by the Game class.
 * @author Martin Caspersen
 * @see Game
 * @see Konto
 *
 */
public class Player {
	private int carColor;
	private String name;
	private Konto konto;

	/**
	 * Constructs a Player with the provided name, carColor and balance.
	 * @param name name of the Player as a String.
	 * @param carColor int describing the color of this Players car [0:5].
	 * @param balance initial balance of the Players Konto as an int.
	 */
	public Player(String name, int carColor, int balance) {
		this.name = name;
		this.carColor = carColor;
		konto = new Konto(balance);
	}
	
	/**
	 * Returns the name of the Player.
	 * @return Players name as a String.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the carColor of the Player.
	 * @return carColor as an int.
	 */
	public int getCarColor() {
		return carColor;
	}

	/**
	 * Returns the players Konto.
	 * @return Konto of the player.
	 * @see Konto
	 */
	public Konto getKonto() {
		return konto;
	}

	@Override
	public String toString() {
		return "Player [carColor=" + carColor + ", name=" + name + ", konto="
				+ konto + "]";
	}
}
