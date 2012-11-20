

import matador.business_logic.Game;

/**
 * The sole purpose of the class is to start the Game.
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
		Game game = Game.getGame();
		
		game.startGame();
	}
}
