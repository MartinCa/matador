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
	private boolean winner = false;
	private boolean twoOnes = true;
	private boolean twoSame = true;
	private boolean twoSixes = true;
	private boolean win52 = true;
	
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
		
		createPlayers();
	}
	
	/**
	 * Constructor that starts the game, the number of Die and Player instances can be chosen. Will create the baeger using MatadorRafleBaeger with numDice amount of Die instances.
	 * Game will create numPlayers amount of Player instances for use in the game. The Player who is to start the game can be chosen with activePlayer.
	 * Extra conditions can be toggled of.
	 * @param numPlayers int amount of Player instances to be created for the game.
	 * @param numDice int amount of Die instances to be created in the baeger.
	 * @param activePlayer int the Player to start. [0:numPlayers-1]
	 * @param twoOnes if set to false a Player will not lose all his points by rolling two ones.
	 * @param twoSame if set to false a Player till not get an extra turn by rolling two of the sam facevalues.
	 * @param twoSixes if set to false a Player will not win by rolling two sixes in two consecutive rounds.
	 * @param win52 if set to false winning will require 25 points and getting two of the same facevalue in one is not required.
	 */
	public Game(int numPlayers, int numDice, int activePlayer, boolean twoOnes, boolean twoSame, boolean twoSixes, boolean win52) {
		baeger = new MatadorRafleBaeger(numDice);
		players = new Player[numPlayers];
		if (win52) {
			this.winpoint = 52;
		} else {
			winpoint = 25;
		}
		this.activePlayer = activePlayer;
		this.twoOnes = twoOnes;
		this.twoSame = twoSame;
		this.twoSixes = twoSixes;
		this.win52 = win52;
		
		createPlayers();
	}
	
	/**
	 * Helper method to create the right amount of Player instances in the players Array. Also tells GameController to add the Player instances if a GUI is used.
	 * @see GameController
	 */
	private void createPlayers() {
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player("Spiller " + (i+1), i, 100);
			GameController.addPlayer("Spiller " + (i+1), 100, i);
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
		if (GameController.getPlayerAccept(activePlayer)) {
			baeger.rollDice();
			GameController.setDice(baeger.getFacevalues());
			players[activePlayer].addPoint(baeger.getSum());
			endRoundChecks();
		} 
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
		int playerInt = activePlayer + 1;
		
		if (baeger.getSum() == 12 && twoSixes) {
			if (players[activePlayer].getTwelveLastTime()) {
				winner = true;
			}
			players[activePlayer].setTwelveLastTime(true);
		} else {
			players[activePlayer].setTwelveLastTime(false);
		}
		
		if (baeger.getSum() == 2 && twoOnes) {
			players[activePlayer].setPoint(0);
			GameController.showString("Desværre du slog to enere, spiller " + playerInt + " har nu 0 point");
		}
		
		checkWinner();
		GameController.showStatus(baeger.getFacevalues(), getPlayerPoints()); 
		
		GameController.setCar(players[activePlayer].getPoint(), players[activePlayer].getCarColor());
		
		if (winner) {
			gameEnd();
			return;
		}
		
		if (baeger.getEns() && twoSame) {
			GameController.showString("Spiller " + playerInt + " slog to ens, spiller " + playerInt + " får en tur mere.");
		} else {
			nextPlayer();
		}
		oneRound();
	}
	
	/**
	 * Checks whether there is a winner. If there is a winner, winner will be set to true.
	 * @see MatadorRafleBaeger
	 * @see Player
	 */
	private void checkWinner() {
		if (win52) {
			if (!baeger.getEns()) {
				return;
			}
		}
		if (players[activePlayer].getPoint() >= winpoint) {
			winner = true;
		}
	}
	
	/**
	 * Ends the game by printing the winner. Calls endGame() in GameController so it can carry out any necessary actions.
	 * @see GameController
	 */
	private void gameEnd() {
		GameController.showString("Spiller " + (activePlayer + 1) + " har vundet!");
		GameController.endGame();
	}
	


	/**
	 * Sets the next activePlayer in the game.
	 */
	private void nextPlayer() {
		if (++activePlayer >= players.length) {
			activePlayer = 0;
		}
	}

	/**
	 * Returns an Array of ints containing alle the Player instances points.
	 * @return Array of ints with all the Player instances points.
	 */
	private int[] getPlayerPoints() {
		int[] returnArray = new int[players.length];
		int i = 0;
				
		for (Player player : players) {
			returnArray[i] = player.getPoint();
			i++;
		}
		return returnArray;
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
