package matador.board;

public abstract class Ownable extends Field {

	public Ownable(String name, int rent) {
		super(name, rent);
	}

	public Ownable(String name, int rent, int fieldNum) {
		super(name, rent, fieldNum);
	}

}
