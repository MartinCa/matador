package matador.business_logic;

/**
 * Konto used to represent the balance of the Player.
 * @author Martin Caspersen
 * @see Player
 */
public class Konto {
	private int balance;
	
	/**
	 * Constructor that initially sets the balance to 10000.
	 */
	public Konto() {
		balance = 10000; // Balance initially set to 10000 if no parameters are passed to the constructor.
	}
	
	/**
	 * Constructor that sets the balance to the provided balance.
	 * @param balance [int] initial balance.
	 */
	public Konto(int balance) {
		this.balance = balance;
	}
	
	/**
	 * Adds the provided amount to the Konto balance.
	 * @param amount [int] to be added to balance.
	 */
	public void deposit(int amount) {
		balance += amount;
	}
	
	/**
	 * Subtracts the provided amount from Konto. Only subtracts if the resulting balance will not be negative, otherwise balance is set to zero..
	 * Returns True if the full amount could be subtracted.
	 * @param amount [int] to be subtracted.
	 * @return True if amount did not exceed balance.
	 */
	public boolean withdraw(int amount) {
		if (amount > balance) {
			balance = 0; // Balance set to zero instead of going to negative.
			return false;
		} else {
			balance -= amount;
			return true;
		}
	}

	/**
	 * Returns the balance.
	 * @return balance.
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Sets the balance to the provided balance.
	 * @param balance [int] to set the balance to.
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
