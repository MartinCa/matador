package matador_BusinessLogic;

/**
 * Provides a Player that is used in a dice game. The Player hold a name, points, carColor, balance and twelveLastTime.
 * Provides necessary functions used by the Game class.
 * @author Martin Caspersen
 * @see Game
 *
 */
public class Player {
	private int point;
	private int carColor;
	private int balance;
	private String name;
	private boolean twelveLastTime;
	private Konto konto;

	/**
	 * Constructs a Player with the provided name, carColor and balance.
	 * @param name name of the Player as a String.
	 * @param carColor int describing the color of this Players car [0:5].
	 * @param balance initial balance of the Player as an int.
	 */
	public Player(String name, int carColor, int balance) {
		this.name = name;
		this.carColor = carColor;
		this.balance = balance;
		point = 0;
		twelveLastTime = false;
		konto = new Konto();
	}
	
	/**
	 * Returns the Players points.
	 * @return Players current points as an int.
	 */
	public int getPoint() {
		return point;
	}
	
	/**
	 * Returns the name of the Player.
	 * @return Players name as a String.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns whether or not the Player rolled two sixes on Players last turn.
	 * @return true if the Player rolled two sixes on Players last turn.
	 */
	public boolean getTwelveLastTime() {
		return twelveLastTime;
	}
	
	/**
	 * Sets whether or not the Player rolled two sixes.
	 * @param twelveLastTime boolean, true if the Player rolled two sixes.
	 */
	public void setTwelveLastTime(boolean twelveLastTime) {
		this.twelveLastTime = twelveLastTime;
	}
	
	/**
	 * Adds the provided integer to Players current points.
	 * @param point int with points to be added to Players current points.
	 */
	public void addPoint(int point) {
		this.point += point;
	}
	
	/**
	 * Sets the Players current points to the provided value.
	 * @param point int to set the Players points to.
	 */
	public void setPoint(int point) {
		this.point = point;
	}
	
	/**
	 * Returns the carColor of the Player.
	 * @return carColor as an int.
	 */
	public int getCarColor() {
		return carColor;
	}

	/**
	 * Returns the balance of the Player.
	 * @return balance of the Player as an int.
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Sets the balance of the Player to balance.
	 * @param balance int to set the Players balance to.
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return name + ": " + point;
	}
}
