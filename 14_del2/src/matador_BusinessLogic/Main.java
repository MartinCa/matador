package matador_BusinessLogic;

/**
 * The sole purpose of the class is to start the Game. This is where the extra conditions can be toggled.
 * @author Martin Caspersen
 * @see Game
 *
 */
public class Main {
	/**
	 * Starts the game.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		GameController game = new GameController(); // This runs a game with all the extra conditions on
		//GameController game = new GameController(2, 0, false, false, false, false, false); // This runs the basic game to 25 with no extra conditions and no GUI.
		
		game.startGame();
	}
}
