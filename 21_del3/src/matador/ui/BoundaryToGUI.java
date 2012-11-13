package matador.ui;

import boundaryToMatador.GUI;
import matador.board.*;
import matador.business_logic.MatadorRafleBaeger;
import matador.business_logic.Player;

/**
 * Provides a boundary for communicating with the provided GUI.
 * As this is basically a one to one mapping to boundaryToMatador the javadoc is taken from boundaryToMatador.
 * @author Martin Caspersen
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
	 * @param baeger containing the dice used in the game.
	 */
	public static void setDice(MatadorRafleBaeger baeger) {
		int[] facevalues = baeger.getFacevalues();
		if (facevalues.length == 2) { // Only show dice if the game uses two dice.
			GUI.setDice(facevalues[0], facevalues[1]);
		}
	}
	
	/**
	 * Adds a Player to the board. A new Player with the same color will replace the old. Max. 6 players.
	 * @param player the player to be added to the GUI board.
	 */
	public static void addPlayer(Player player) {
		String playerName = player.getName();
		int balance = player.getKonto().getBalance();
		int carColor = player.getCarColor();
		
		GUI.addPlayer(playerName, balance, carColor);
	}
	
	/**
	 * Sets the balance of the Player with the provided carColor to newBalance. The Player must have been added first.
	 * @param players the players to update the balance of.
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
	 * @param field to place the car on.
	 * @param player owner of the car to be placed.
	 */
	public static void setCar(Field field, Player player) {
		GUI.setCar(field.getFieldNum(), player.getCarColor());
	}
}
