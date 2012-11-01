package matador.business_logic;

import matador.board.*;
import matador.ui.BoundaryToGUI;
import matador.ui.BoundaryToPlayer;

/**
 * 
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
	private Board board;
	private boolean winner = false;
	
	/**
	 * Constructor that starts the game, 2 Die and 2 Player instances are created. Creates the baeger using MatadorRafleBaeger and two players of type Player.
	 * With this constructor all the extra conditions will be on and "Spiller 1" will start the game.
	 * @see MatadorRafleBaeger
	 * @see Player
	 */
	public Game() {
		baeger = new MatadorRafleBaeger();
		players = new Player[2]; // This game will be played with two players
		winpoint = 30000; // Winner at balance of 30000
		activePlayer = 0; // Player one starts
		int initBalance = 10000; // Initial
		board = new Board();
		
		createPlayers(initBalance);
	}
	
	/**
	 * Helper method to create the right amount of Player instances in the players Array. Also tells GameController to add the Player instances if a GUI is used.
	 * @see GameController
	 */
	private void createPlayers(int balance) {
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player("Spiller " + (i+1), i, balance);
			BoundaryToGUI.addPlayer(players[i]);
		}
	}
	
	/**
	 * Starts the game. The game will have the options set by the constructor.
	 */
	public void startGame() {
		BoundaryToPlayer.showString("Spillet starter");
		oneRound();
	}
	
	/**
	 * Used to run one round of the game. As soon as the Dice have been rolled, GameController will be asked to print the Dice to the GUI (if gui is turned on).
	 * @see GameController
	 * @see MatadorRafleBaeger
	 * @see Player
	 */
	private void oneRound() {
		int balanceChange;
		Player actPlayer = players[activePlayer];
		
		BoundaryToPlayer.showString("\n" + actPlayer.getName() + " har turen.");
		BoundaryToPlayer.getPlayerAccept(actPlayer);
		baeger.rollDice();
		balanceChange = board.getFieldAction(baeger.getSum() - 2);
		
		if (balanceChange >= 0) {
			actPlayer.getKonto().deposit(balanceChange);
		} else if (!actPlayer.getKonto().withdraw(-balanceChange)) {
			nextPlayer();
			winner = true;
		}
		ShowStatus(baeger, players, board.getField(baeger.getSum() - 2));
		
		endRoundChecks();
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
		checkWinner();
		if (winner) {
			BoundaryToPlayer.showString("" + players[activePlayer].getName() + " vandt spillet.");
			gameEnd();
		} else {
			nextPlayer();
			oneRound();
		}
	}
	
	private void ShowStatus(MatadorRafleBaeger baeger, Player[] players, Field field) {
		BoundaryToGUI.setCar(field, players[activePlayer]);
		BoundaryToGUI.setDice(baeger);
		BoundaryToGUI.setBalance(players);
		BoundaryToPlayer.showStatus(baeger, players);
		BoundaryToPlayer.landOnField(field);
	}
	
	/**
	 * 
	 */
	private void checkWinner() {
		if (players[activePlayer].getKonto().getBalance() >= winpoint) {
			winner = true;
		}
	}
	
	/**
	 * 
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
//			returnArray[i] = player.getKonto().getBalance();
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
