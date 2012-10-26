package matador_board;

public abstract class Ownable extends Field {
	private int rent;

	public Ownable(String name, int rent) {
		super(name);
		setRent(rent);
	}

	private void setRent(int rent){
		this.rent = rent;
	}
}
