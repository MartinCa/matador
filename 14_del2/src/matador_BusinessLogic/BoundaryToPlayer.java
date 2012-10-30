package matador_BusinessLogic;

import java.util.Scanner;

/**
 * Provides a boundary for communicating with the physical player.
 * @author Martin Caspersen
 * @see GameController
 *
 */
public class BoundaryToPlayer {
	private static Scanner input = new Scanner(System.in);

	/**
	 * Not used for this class.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		
	}
	
	/**
	 * Asks the physical player to enter a specific int. Checks whether the input matches the given int.
	 * Keeps trying until the physical player enters the correct int.
	 * Only accepts ints will throw an exception if anything but an int is entered.
	 * @param activePlayer the activer Player instances index in the Array.
	 * @return the int entered by the physical player as an int.
	 */
	public static boolean getPlayerAccept(int activePlayer) {
		int inputInt;
		activePlayer++; // Increment by one to match Player name.
		
		do {
			input.reset();
			showString("Det er spiller " + activePlayer + "'s tur. Tast " + activePlayer + " for at sl�");
			inputInt = input.nextInt();
		} while (inputInt != activePlayer);
		return inputInt == activePlayer;
	}
	
	/**
	 * Prints a given String to the console.
	 * @param output String to print to the console.
	 */
	public static void showString(String output) {
		System.out.println(output);
	}
	
	/**
	 * Closes the Scanner used to get input from the physical player.
	 */
	public static void closeScanner() {
		input.close();
	}
	
	/**
	 * Outputs the status of the Game to the physical player in the console.
	 * The format of the output is:
	 * Terning <num>: <facevalue>, . . .
	 * Spiller <num>: <points>, . . .
	 * @param facevalues Array of ints containing the facevalue of all the Die instances in the Game.
	 * @param playerPoints Array of ints containing the points of all the Player instances in the Game.
	 */
	public static void showStatus(MatadorRafleBaeger baeger, Player[] players) {
		int i = 1;
		String toShow = "\nStatus\n";
		int[] facevalues = baeger.getFacevalues();
		int[] playerBalances = getPlayerBalances(players);
		
		for (int facevalue : facevalues) {
			toShow += "Terning " + i + ": " + facevalue;
			if (i < facevalues.length) {
				toShow += ", ";
			}
			i++;
		}
		
		i = 1;
		toShow += "\n";
		for (int playerBalance : playerBalances) {
			toShow += "Spiller " + i + ": " + playerBalance;
			if (i < playerBalances.length) {
				toShow += ", ";
			}
			i++;
		}
		System.out.println(toShow);
	}
	
	private static int[] getPlayerBalances(Player[] players) {
		int[] returnArray = new int[players.length];
		int i = 0;
				
		for (Player player : players) {
			returnArray[i] = player.getKonto().getBalance();
			i++;
		}
		return returnArray;
	}
}
