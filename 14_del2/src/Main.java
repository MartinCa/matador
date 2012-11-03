

import matador.business_logic.Game;

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
		Game game = new Game();
		
		game.startGame();
	}
}
