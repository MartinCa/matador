package matador.business_logic;
import java.util.Random;

/**
 * Provides a pseudo random die. The number of sides the Die has can be set using one of the constructors.
 * Also a constructor that takes a Random object can be called to provide the Random object used to generate random numbers.
 * Rolling the Die is done using the nextInt method provided by java.util.Random.
 * @author Martin Caspersen
 * @see MatadorRafleBaeger
 * @see java.util.Random
 *
 */
public class Die {
	private int facevalue;
	private int sides;
	private static Random rand = new Random();
	
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
	 * Constructs a Die with 6 sides and uses the provided Random object to generate random numbers.
	 * Does not roll the Die.
	 * @param rand Random object to be used for number generation.
	 */
	public Die(Random rand) {
		Die.rand = rand;
		this.sides = 6;
	}
	
	/**
	 * Rolls the Die using the nextInt method provided by java.util.Random.
	 */
	public void rollDie() {		
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
