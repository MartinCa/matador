package matador.business_logic;

public class Konto {
	private int balance;
	
	public Konto() {
		balance = 10000; // Balance initially set to 10000 if no parameters are passed to the constructor.
	}
	
	public Konto(int balance) {
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		balance += amount;
	}
	
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
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
