package matador.board;

public abstract class Ownable extends Field {
	//private int rent;

	public Ownable(String name, int rent) {
		super(name, rent);
		//setRent(rent);
	}

	public Ownable(String name, int rent, int fieldNum) {
		super(name, rent, fieldNum);
	}

//	private void setRent(int rent){
//		this.rent = rent;
//	}
}
