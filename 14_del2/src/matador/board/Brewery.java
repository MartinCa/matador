package matador.board;

public class Brewery extends Ownable {

	public Brewery(String name, int changeBalance) {
		super(name, changeBalance);
	}
	
	public Brewery(String name, int changeBalance, int fieldNum) {
		super(name, changeBalance, fieldNum);
	}

}
