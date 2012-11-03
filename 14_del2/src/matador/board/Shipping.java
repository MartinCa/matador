package matador.board;

public class Shipping extends Ownable {

	public Shipping(String name, int changeBalance) {
		super(name, changeBalance);
	}

	public Shipping(String name, int changeBalance, int fieldNum) {
		super(name, changeBalance, fieldNum);
	}

}
