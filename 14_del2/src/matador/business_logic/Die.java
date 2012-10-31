package matador.business_logic;
import java.util.Random;

/**
 * Provides a pseudo random die. The number of sides the Die has can be set using one of the constructors.
 * Rolling the Die is done using the nextInt method provided by java.util.Random.
 * @author Martin Caspersen
 * @see MatadorRafleBaeger
 * @see java.util.Random
 *
 */
public class Die {
	private int facevalue;
	private int sides;
	
	/**
	 * Constructs a Die with 6 sides and gives it a random value.
	 */
	public Die() {
		this.sides = 6;
		this.rollDie();
	}
	
	/**
	 * Constructs the Die with the given number of sides and gives the Die a random value.
	 * @param sides int number of sides for the Die.
	 */
	public Die(int sides) {
		this.sides = sides;
		this.rollDie();
	}
	
	/**
	 * Rolls the Die using the nextInt method provided by java.util.Random.
	 */
	public void rollDie() {
		Random rand = new Random();
		
		facevalue = rand.nextInt(sides) + 1;
	}
	
	/**
	 * Returns the facevalue of the Die
	 * @return int with facevalue of the Die
	 */
	public int getFacevalue() {
		return facevalue;
	}
	
	@Override
	public String toString() {
		return "Die : " + facevalue;
	}
}
