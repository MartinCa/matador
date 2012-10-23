package matador_BusinessLogic;

public class Konto {
	private int balance;
	private int iniCash;
	
	public Konto() {
		balance = iniCash;
	}
	
	public Konto(int balance) {
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public boolean withdraw(int amount) {
		if (amount > balance) {
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
