package matador_board;

public class Street extends Ownable{
	
	public Street(String name, int rent) {
		super(name, rent);
	}

	public Street(String name, int rent, int fieldNum) {
		super(name, rent, fieldNum);
	}

//	public boolean landOnField() {
//		// TODO Auto-generated method stub
//		return false;
//	}
}
