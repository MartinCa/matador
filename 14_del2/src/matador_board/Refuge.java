package matador_board;

public class Refuge extends Field{
private String name;
private int bonus;

	public Refuge(String name, int bonus) {
		super(name);
		setBonus(bonus);
	}

	private void setBonus(int bonus) {
		this.bonus = bonus;		
	}

	
//	public boolean landOnField() {
//		// TODO Auto-generated method stub
//		return false;
//	}
}
