package matador.business_logic;

import matador.board.*;
import matador.ui.*;

/**
 * Controller for the game that is responsible for running the game using the other classes in the project.
 * @author Martin Caspersen
 * @see Player
 * @see MatadorRafleBaeger
 * @see Die
 * @see Board
 *
 */
public class Game {
	private int activePlayer;
	private int winpoint;
	private MatadorRafleBaeger baeger;
	private Player[] players;
	private Board board;
	private static Game game = new Game();

	/**
	 * Constructor that starts the game, 2 Die and 2 Player instances are created. Creates the baeger using MatadorRafleBaeger and two players of type Player.
	 * "Spiller 1" will start the game.
	 * @see MatadorRafleBaeger
	 * @see Player
	 * @see Board
	 */
	private Game() {
		baeger = new MatadorRafleBaeger();
		players = new Player[2]; // This game will be played with two players
		winpoint = 30000; // Winner at balance of 30000
		activePlayer = 0; // Player one starts
		int initBalance = 10000; // Initial balance
		board = new Board();

		createPlayers(initBalance);
	}
	
	/**
	 * Returns an instance of Game, if one does not exist it makes one.
	 * Used to implement the Singleton pattern.
	 * @return instance of {@link Game}.
	 */
	public static Game getGame() {
		if (game == null) {
			game = new Game();
		}
		return game ;
	}

	/**
	 * Helper method to create the right amount of Player instances in the players Array. Also tells GameController to add the Player instances if a GUI is used.
	 * @see BoundaryToGUI
	 */
	private void createPlayers(int balance) {
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player("Spiller " + (i+1), i, balance);
			BoundaryToGUI.addPlayer(players[i]);
		}
	}

	/**
	 * Starts the game.
	 */
	public void startGame() {
		BoundaryToPlayer.showString("Spillet starter");
		oneRound();
	}

	/**
	 * Used to run one round of the game.
	 * Uses private helper method {@link #ShowStatus(Field)} to print the status of the game to console and GUI.
	 * Uses private helper method {@link #endRoundChecks()} to perform checks after the round have played.
	 * @see MatadorRafleBaeger
	 * @see Player
	 * @see BoundaryToPlayer
	 */
	private void oneRound() {
		Player actPlayer = players[activePlayer];
		Field actField;

		BoundaryToPlayer.showString("\n" + actPlayer.getName() + " har turen.");
		BoundaryToPlayer.getPlayerAccept(actPlayer);
		baeger.rollDice();
		actField = board.getField(baeger.getSum() - 2);
		actField.landOnField(actPlayer);

		optToBuy(actField, actPlayer);

		ShowStatus(actField);

		endRoundChecks();
	}

	/**
	 * Checks if player can and will buy field he landed on. 
	 * 
	 * @param actField
	 * @param actPlayer
	 */
	private void optToBuy(Field actField, Player actPlayer) {
		Ownable actOwnable; 
		if (Ownable.class.isInstance(actField)) {
			actOwnable = (Ownable) actField ;
			if (actOwnable.getOwner() == null) {	//If nobody owns the field
				if (actPlayer.getKonto().getBalance() >= actOwnable.getPrice()) {	//If player has enough money
					if (BoundaryToPlayer.optToBuy(actOwnable)) {					//If player wants to buy
						actPlayer.buyField(actOwnable);//Actually buy the field
						actOwnable.setOwner(actPlayer);
					}
				}
			}
		} 
	}

	/**
	 * Checks conditions at the end of the round to decide if there is a winner.
	 * Also calls {@link #nextPlayer()} if needed to advance the turn to the next Player.
	 * Uses {@link #checkWinner()} to check if there is a winner by balance.
	 * @see MatadorRafleBaeger
	 * @see Player
	 */
	private void endRoundChecks() {
		nextPlayer();
		if (checkWinner()) {
			BoundaryToPlayer.showString("" + players[activePlayer].getName() + " vandt spillet.");
			gameEnd();
		} else {
			oneRound();
		}
	}

	/**
	 * Prints the status of the game to the console and updates the provided GUI.
	 * @param baeger MatadorRafleBaeger with the dice used in the game.
	 * @param players Player[] with the players used in the game.
	 * @param field Field that the active player landed on.
	 */
	private void ShowStatus(Field field) {
		BoundaryToGUI.setCar(field, players[activePlayer]);
		BoundaryToGUI.setDice(baeger);
		BoundaryToGUI.setBalance(players);
		BoundaryToPlayer.showStatus(baeger, players);
		BoundaryToPlayer.landOnField(field);
	}

	/**
	 * Checks to see if there is a winner.
	 * Checks to see if there is a winner by balance.
	 * Checks to see if there is a winner by all the other players having lost.
	 */
	private boolean checkWinner() {
		int numPlayers = players.length;
		int numLosers = 0;
		int indexPlayer = 0;
		
		for (Player player : players) {
			if (player.isLoser()) {
				numLosers++;
			} else if (player.getKonto().getBalance() >= winpoint) {
				activePlayer = indexPlayer;
				return true;
			}
			indexPlayer++;
		}
		return numLosers == numPlayers - 1;
	}

	/**
	 * Closes the Scanner in BoundaryToPlayer
	 * @see BoundaryToPlayer
	 */
	private void gameEnd() {
		BoundaryToPlayer.closeScanner();
	}



	/**
	 * Sets the next activePlayer in the game.
	 */
	private void nextPlayer() {
		if (++activePlayer >= players.length) {
			activePlayer = 0;
		}
		if (players[activePlayer].isLoser()) {
			nextPlayer();
		}
	}
	
	/**
	 * Returns the {@link MatadorRafleBaeger} being used.
	 * @return {@link MatadorRafleBaeger} being used.
	 */
	public MatadorRafleBaeger getBaeger() {
		return baeger;
	}

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
