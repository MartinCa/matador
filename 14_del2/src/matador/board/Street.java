package matador.board;

public class Street extends Ownable{
	
	public Street(String name, int changeBalance) {
		super(name, changeBalance);
	}

	public Street(String name, int changeBalance, int fieldNum) {
		super(name, changeBalance, fieldNum);
	}

}
