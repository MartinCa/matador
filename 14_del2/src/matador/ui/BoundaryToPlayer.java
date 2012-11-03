package matador.ui;

import java.util.Scanner;

import matador.business_logic.MatadorRafleBaeger;
import matador.business_logic.Player;
import matador.board.*;

/**
 * Provides a boundary for communicating with the physical player.
 * @author Martin Caspersen
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
	 * @param activePlayer the active Player.
	 * @return True if the player entered the correct int, cannot return false.
	 */
	public static boolean getPlayerAccept(Player activePlayer) {
		int inputInt;
		int playerInt = activePlayer.getCarColor() + 1;
		
		do {
			showString("Det er spiller " + playerInt + "'s tur. Tast " + playerInt + " for at slå:");
			inputInt = getPlayerInt(input);
		} while (inputInt != playerInt);
		return inputInt == playerInt;
	}
	
	/**
	 * Gets the actual input from the physical player.
	 * Catches exceptions and tries again until the player enters a valid integet.
	 * @param in Scanner to be used to get input from the physical player.
	 * @return [int] that the physical player entered.
	 */
	private static int getPlayerInt(Scanner in) {
		int inputInt;
		
		try  {
			inputInt = in.nextInt();
		} catch (Exception e) {
			showString("Kun integers er tilladt.");
			in.nextLine();
			inputInt = getPlayerInt(in);
		}
		return inputInt;
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
	 * Prints what field the player landed on and what effect that has on the balance.
	 * @param field the player landed on.
	 */
	public static void landOnField(Field field) {
		String fieldName = field.getName();
		String result = "Det ";
		
		showString("Du landede på: " + fieldName + ".");
		result += (field.getChangeBalance() >= 0) ? "giver " + field.getChangeBalance(): "koster " + (-field.getChangeBalance());
		result += ".";
		showString(result);
	}
	
	
	/**
	 * Outputs the status of the Game to the physical player in the console.
	 * The format of the output is:
	 * Terning <num>: <facevalue>, . . .
	 * Spiller <num>: <balance>, . . .
	 * @param baeger containing the dice used in the game
	 * @param players array containing the players in the game.
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
	
	/**
	 * Helper method to get the players balance from the array of players.
	 * @param players array containing the players.
	 * @return array of int with the players balances.
	 */
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
