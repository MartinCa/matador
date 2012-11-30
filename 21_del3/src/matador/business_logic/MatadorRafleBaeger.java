package matador.business_logic;

/**
 * Provides a MatadorRafleBaeger containing either two or a custom number of pseudo random six-sided dice. Provides necessary methods to support the Game class.
 * @author Martin Caspersen
 * @see Die
 *
 */
public class MatadorRafleBaeger {
	private Die[] dice;
	
	/**
	 * Constructor that creates two Die instances.
	 */
	public MatadorRafleBaeger() {
		dice = new Die[2];
		
		createDice();
	}

	/**
	 * Creates a MatadorRafleBaeger with numDice Die instances.
	 * The Die instances will initially be given random values.
	 * @param numDice required number of Die instances as an int.
	 */
	public MatadorRafleBaeger(int numDice) {
		dice = new Die[numDice];
		
		createDice();
	}
	
	
	/**
	 * Helper class to initialize the Die instances in the arrays created by the class constructors.
	 */
	private void createDice() {
		for (int i = 0; i < dice.length; i++) {
			dice[i] = new Die();
		}
	}
	
	/**
	 * Returns whether or all the Die instances have the same facevalue.
	 * @return true if all the Die instances have the same facevalue.
	 */
	public boolean getEns() {
		int i = 0, lastFacevalue = dice[0].getFacevalue();
		boolean ens;
		
		do {
			ens = lastFacevalue == dice[i].getFacevalue();
			lastFacevalue = dice[i].getFacevalue();
			i++;
		} while (ens && i < dice.length);
		return ens;
	}
	
	/**
	 * Returns the sum of the facevalues of all the Die instances.
	 * @return int with the sum of all Die instances facevalues.
	 */
	public int getSum() {
		int sum = 0;
		
		for (Die die : dice) {
			sum += die.getFacevalue();
		}
		return sum;
	}

	/**
	 * Rolls all Die instances contained in this MatadorRafleBaeger.
	 */
	public void rollDice() {
		for (Die die : dice) {
			die.rollDie();
		}
	}
	
	/**
	 * Returns the facevalue of all the Die instances in the MatadorRafleBaeger contained in an Array of int. The facevalues are ordered the same way as the original Die instances in dice.
	 * @return Array of ints with the facevalue of all Die instances in the MatadorRafleBaeger.
	 */
	public int[] getFacevalues() {
		int[] facevalues = new int[dice.length];
		int i = 0;
		
		for (Die die : dice) {
			facevalues[i] = die.getFacevalue();
			i++;
		}
		return facevalues;
	}
	
	@Override
	public String toString() {
		String retString = "";
		int i = 1;
		
		for (Die die : dice) {
			retString += "terning " + i + ": " + die.getFacevalue();
			if (i < dice.length) {
				retString += ", ";
			}
			i++;
		}
		return retString;
	}
}