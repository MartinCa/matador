package matador_board;

public class Taxes extends Field{
	private int tax;

	public Taxes(String name, int tax){
		super(name);
		setTax(tax);
	}

	private void setTax(int tax) {
		this.tax = tax;		
	}

	//	public boolean landOnField() {
	//		// TODO Auto-generated method stub
	//		return false;
	//	}

}
