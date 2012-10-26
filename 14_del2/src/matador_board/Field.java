package matador_board;

public abstract class Field {
	private String name;
	private int changeBalance;

//	public abstract boolean landOnField(); //to be implemented later

	public Field(String name, int changeBalance){
		this.name = name;
		this.changeBalance = changeBalance; // Added to simplify part 2.
	}
	
	public int getChangeBalance() {
		return changeBalance;
	}
	
	public String getname() {
		return name;
	}
}
