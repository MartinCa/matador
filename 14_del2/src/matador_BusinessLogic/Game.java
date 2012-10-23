package matador_BusinessLogic;

/**
 * Plays a game using two six-sided dice. The rules of the game can be modified in the constructor, the basic rules are as follows:
 * Two Player will take turns to roll two dice. The value of the two dice will be added to the Players running total.
 * The first Player to 52 points and who rolls two dice with the same facevalues in the same round wins the game.
 * By rolling two dice with the same facevalue in the same round the Player will get another turn.
 * By rolling two dice with the facevalue one in the same round the Player will get their points set to 0.
 * By rolling two dice with the facevalue six in two consecutive rounds the Player will win the game.
 * The rules can be modified by the use of one of the Game constructors.
 * @author Martin Caspersen
 * @see Player
 * @see MatadorRafleBaeger
 * @see Die
 *
 */
public class Game {
	private int activePlayer;
	private int winpoint;
	private MatadorRafleBaeger baeger;
	private Player[] players;
	
	/**
	 * Constructor that starts the game, 2 Die and 2 Player instances are created. Creates the baeger using MatadorRafleBaeger and two players of type Player.
	 * With this constructor all the extra conditions will be on and "Spiller 1" will start the game.
	 * @see MatadorRafleBaeger
	 * @see Player
	 */
	public Game() {
		baeger = new MatadorRafleBaeger();
		players = new Player[2];
		winpoint = 52;
		activePlayer = 0;
		int balance = 10000;
		
		createPlayers(balance);
	}
	
	/**
	 * Helper method to create the right amount of Player instances in the players Array. Also tells GameController to add the Player instances if a GUI is used.
	 * @see GameController
	 */
	private void createPlayers(int balance) {
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player("Spiller " + (i+1), i, balance);
			GameController.addPlayer("Spiller " + (i+1), 100, i); // CHANGE: Should we even have GameController or is Game the Controller?
		}
	}
	
	/**
	 * Starts the game. The game will have the options set by the constructor.
	 */
	public void startGame() {
		oneRound();
	}
	
	/**
	 * Used to run one round of the game. As soon as the Dice have been rolled, GameController will be asked to print the Dice to the GUI (if gui is turned on).
	 * @see GameController
	 * @see MatadorRafleBaeger
	 * @see Player
	 */
	private void oneRound() {

	}
	
	/**
	 * Checks conditions at the end of the round to decide if there is a winner or if the Player gets an extra turn.
	 * Also calls nextPlayer if needed to advance the turn to the next Player.
	 * This adheres to the selected rules in the constructor.
	 * @see GameController
	 * @see MatadorRafleBaeger
	 * @see Player
	 */
	private void endRoundChecks() {

	}
	
	/**
	 * 
	 */
	private void checkWinner() {

	}
	
	/**
	 * 
	 */
	private void gameEnd() {

	}
	


	/**
	 * Sets the next activePlayer in the game.
	 */
	private void nextPlayer() {
		if (++activePlayer >= players.length) {
			activePlayer = 0;
		}
	}

//	/**
//	 * Returns an Array of ints containing alle the Player instances points.
//	 * @return Array of ints with all the Player instances points.
//	 */
//	private int[] getPlayerPoints() {
//		int[] returnArray = new int[players.length];
//		int i = 0;
//				
//		for (Player player : players) {
//			returnArray[i] = player.getPoint();
//			i++;
//		}
//		return returnArray;
//	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String retString = "";
		int i = 1;
		
		retString += baeger + "\n";
		for (Player player : players) {
			retString += player;
			if (i < players.length) {
				retString += ", ";
			}
			i++;
		}
		return retString;
	}
}
