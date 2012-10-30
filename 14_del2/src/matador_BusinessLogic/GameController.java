package matador_BusinessLogic;

import matador.ui.BoundaryToPlayer;

/**
 * Starts the game and handles communication between Game and the boundaries.
 * The rules can be modified with a constructor, the extra options are:
 * <ul>
 * <li>twoOnes If true you will lose all you points by rolling the values 1 and 1 in the same turn.</li>
 * <li>twoSame If true you will gain an extra turn by rolling two of the same values in one turn.</li>
 * <li>toSixes If true you will win if you roll two sixes in two consecutive turns.</li>
 * <li>win52 If true winning required 52 points and then rolling two of the same values.</li>
 * <li>gui If true turns on the GUI.</li>
 * </ul>
 * <p>
 * As standard all these conditions are set to true, and the number of Die and Player instances is set to 2.
 * Using the non standard constructor these conditions and the number of players can be changed. For this particular game having anything but two number of Dice does not make sense so that cannot be changed.
 * @author Martin Caspersen
 * @see Game
 * @see BoundaryToPlayer
 * @see BoundaryToGUI
 *
 */
public class GameController { 
private Game activeGame;
private static boolean gui = true;
	
	/**
	 * Creates the game with 2 Die, 2 Player instances and a requirement of 52 points to win.
	 * All the extra conditions will be turned on when using this constructor.
	 * Spiller 1 will start the game when using this constructor.
	 * @see Game
	 */
	public GameController() {
		activeGame = new Game();
	}
	
	/**
	 * Starts the first round of the game.
	 */
	public void startGame() {
		activeGame.startGame();
	}
	
	/**
	 * Adds a Player to the GUI board with name, balance and carColor as provided.
	 * @param name name of the Player as a String.
	 * @param balance balance of the Player as an int.
	 * @param carColor color of the Players car as an int.
	 * @see BoundaryToGUI
	 */
	public static void addPlayer(Player player) {
		if (gui) {
			BoundaryToGUI.addPlayer(player);
		}
	}
	
	/**
	 * Sets the cars position on the GUI, if gui is true.
	 * @see BoundaryToGUI
	 */
	public static void setCar(int fieldNum, Player player) {
		if (gui) {
			BoundaryToGUI.setCar(fieldNum, player);
		}
	}
	
	/**
	 * Sends an int to the boundary, the physical player is to enter the same int to accept to roll.
	 * @param activePlayer int representing the active Player [0:numPlayers-1]
	 * @return true if the player accepts to roll.
	 * @see BoundaryToPlayer
	 */
	public static boolean getPlayerAccept(int activePlayer) {
		return BoundaryToPlayer.getPlayerAccept(activePlayer);
	}
	
//	/**
//	 * Will set the dice on the GUI to the facevalue of the Dies instances in the game if gui is true.
//	 * @param facevalues Array of ints containing the facevalue of all the Dice in the game.
//	 * @see BoundaryToGUI
//	 */
//	public static void setDice(MatadorRafleBaeger baeger) {
//		if (gui) {
//			BoundaryToGUI.setDice(baeger);
//		}
//	}
	
	/**
	 * Shows the status of the game. BoundaryToPlayer is responsible for formatting the two provided Array of ints.
	 * @param facevalues Array of ints containing the facevalues of all the Dice in the game.
	 * @param playerPoints Array of ints containg the points of all the Players in the game.
	 * @see BoundaryToPlayer
	 */
	public static void showStatus(MatadorRafleBaeger baeger, Player[] players) {
		BoundaryToGUI.setDice(baeger);
		BoundaryToPlayer.showStatus(baeger, players);
		BoundaryToGUI.setBalance(players);
	}
	
	/**
	 * Outputs the provided String to the physical player.
	 * @param toShow String to output.
	 * @see BoundaryToPlayer
	 */
	public static void showString(String toShow) {
		BoundaryToPlayer.showString(toShow);
	}
	
	/**
	 * Closes the Scanner used by BoundaryToPlayer to get input from the physical player.
	 * @see BoundaryToPlayer
	 */
	public static void endGame() {
		BoundaryToPlayer.closeScanner();
	}
}
