package matador.board;

public class Taxes extends Field{
	//private int tax;

	public Taxes(String name, int tax){
		super(name, tax);
		//setTax(tax);
	}

	public Taxes(String name, int tax, int fieldNum) {
		super(name, tax, fieldNum);
	}

//	private void setTax(int tax) {
//		this.tax = tax;		
//	}

	//	public boolean landOnField() {
	//		// TODO Auto-generated method stub
	//		return false;
	//	}

}
