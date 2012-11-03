package matador.board;

public abstract class Field {
	protected String name;
	protected int changeBalance;
	protected int fieldNum;

	public Field(String name, int changeBalance) {
		this.name = name;
		this.changeBalance = changeBalance; // Added to simplify part 2.
	}
	
	public Field(String name, int changeBalance, int fieldNum) {
		this.name = name;
		this.changeBalance = changeBalance; // Added to simplify part 2.
		this.fieldNum = fieldNum;
	}
	
	
	public int getChangeBalance() {
		return changeBalance;
	}
	
	public String getName() {
		return name;
	}
	
	public int getFieldNum() {
		return fieldNum;
	}
}
