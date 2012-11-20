package matador.board;

import matador.business_logic.Player;

/**
 * Represents the Refuge from Matador.
 * @author Martin Caspersen
 *
 */
public class Refuge extends Field{
	private int bonus;

	/**
	 * Constructor that sets name and changeBalance.
	 * @param name String with field name.
	 * @param changeBalance int representing what should happen with a players balance upon landing on the field.
	 */
	public Refuge(String name, int fieldNum, int bonus) {
		super(name, fieldNum);
		this.bonus = bonus;
	}
	
	public void landOnField(Player player) {
		player.getKonto().deposit(bonus);
	}

	@Override
	public String toString() {
		return "Refuge [bonus=" + bonus + ", name=" + name + ", fieldNum="
				+ fieldNum + "]";
	}
}
