package matador.business_logic;

import boundaryToMatador.GUI;

/**
 * Provides a boundary for communicating with the provided GUI.
 * As this is basically a one to one mapping to boundaryToMatador the javadoc is taken from boundaryToMatador.
 * @author Martin Caspersen
 * @see GameController
 *
 */
public class BoundaryToGUI {

	/**
	 * Not used for this class.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		
	}
	
	/**
	 * Shows two dice on the board, the facevalues for the dice are provided in an Array of ints.
	 * Only shows the dice if the Array has a length of 2. 
	 * @param facevalues Array of ints of the length 2.
	 */
	public static void setDice(MatadorRafleBaeger baeger) {
		int[] facevalues = baeger.getFacevalues();
		if (facevalues.length == 2) {
			GUI.setDice(facevalues[0], facevalues[1]);
		}
	}
	
	/**
	 * Adds a Player to the board. A new Player with the same color will replace the old. Max. 6 players.
	 * @param playerName name of the Player as a String. Mind the length!
	 * @param balance balance of the Player as an int.
	 * @param carColor color of the Players car as an int [0:5].
	 */
	public static void addPlayer(Player player) {
		String playerName = player.getName();
		int balance = player.getKonto().getBalance();
		int carColor = player.getCarColor();
		
		GUI.addPlayer(playerName, balance, carColor);
	}
	
	/**
	 * Sets the balance of the Player with the provided carColor to newBalance. The Player must have been added first.
	 * @param carColor Player represented by this color will get the balance changed.	
	 * @param newBalance newBalance to set the Players balance to.
	 */
	public static void setBalance(Player[] players) {
		for (Player player : players) {
		GUI.setBalance(player.getCarColor(), player.getKonto().getBalance());
		}
	}
	
	/**
	 * Places a car on the field. All cars can be placed on the same field.
	 * A car can only be placed if the corresponding player has been added. If a car is placed on the same field multiple times, nothing more happens. 
	 * A car can not be placed on multiple fields simultaneously.
	 * @param fieldNumber int [1:40]
	 * @param carColor int used to reprensent the Player and the color of his car [0:5].
	 */
	public static void setCar(int fieldNum, Player player) {
		GUI.setCar(fieldNum, player.getCarColor());
	}
}
