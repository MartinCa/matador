package matador.business_logic;

import java.text.NumberFormat;

/**
 * Tests MatadorRafleBaeger to see if it is random. Performs 100000 rolls using rollDice provided by MatadorRafleBaeger.
 * Prints the percentage distribution of all the dice rolls sum.
 * <p>
 * Calculates the percentage of each sum out of all the rolls. Prints some text that can be used to rationalize whether or not it is random.
 * @author Martin Caspersen
 * @see MatadorRafleBaeger
 *
 */
public class TestMatadorRafleBaeger {

	/**
	 * Starts the test.
	 * @param args
	 */
	public static void main(String[] args) {
		/*Initializtion of variables*/
		int[] dicevalues = new int[11]; // Initialize the Array to hold Die facevalues.
		MatadorRafleBaeger baeger = new MatadorRafleBaeger(2); // Initialize the MatadorRafleBaeger to be used for the test.
		final int MAXCOUNT = 100000; // Set the amount of rolls to be tested.
		int sameCount = 0;
		
		/*Numberformats are defined*/
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMinimumIntegerDigits(2);
		NumberFormat nfpercent = NumberFormat.getPercentInstance();
		nfpercent.setMaximumFractionDigits(2);
		nfpercent.setMinimumFractionDigits(2);
		nfpercent.setMinimumIntegerDigits(2);
		
		/*Rolling MAXCOUNT times*/
		for (int currCount = 1; currCount <= MAXCOUNT; currCount++) {
			baeger.rollDice();
			dicevalues[baeger.getSum() - 2] += 1;
			if (baeger.getEns()) {
				sameCount++;
			}
		}
		
		/*Printing various information about the rolls*/
		System.out.println("Procentfordeling af slag:");
		for (int i = 0; i < 11; i++) {
			System.out.println(nf.format(i + 2) + ": " + nfpercent.format((float) dicevalues[i] / MAXCOUNT));
		}
		
		System.out.println("\nDer blev slået to ens: " + sameCount + " gange.\nDet svarer til " + nfpercent.format((float) sameCount / MAXCOUNT));
		
		System.out.println("\nI alt er der med 2 terninger 36 forskellige muligheder (6*6).\n" +
				"Der er 1 af de muligheder der giver 2, 2 der giver 3, 3 der giver 4, osv. op til 6 der giver 7. \n" +
				"Fra 7 og opefter går det nedaf igen så det ender med at der er 1 mulighed der giver 12.\n");
		System.out.println("Én mulighed svarer til " + nfpercent.format((float) 1 / 36) + "\n" +
				"Det er altså den procent som 2 og 12 ca skal ligge på, hvorimod syv skal ligge på ca. " + nfpercent.format((float) 6 / 36) + ".");
		System.out.println("\nDer er samme sandsynlighed for at værdien af de to terninger er ens som der er for at slå summen syv 6 muligheder ud af 36.\nDerfor skal der helst være omkring " +
				nfpercent.format((float) 6 / 36) + " af slagene hvor de to terninger har samme værdi.");
	}
}
