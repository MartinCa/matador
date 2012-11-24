package matador.board;

/**
 * Represents the gameboard used in Matador, contains all the fields used in the game.
 * @author Martin Caspersen
 * @see Field
 */
public class Board {
	private Field[] boardFields;	// array containing each field on the board 

	/**
	 * Constructor for creating the game board.
	 * Calls {@link #initBoard} to actually create the array and fields.
	 * 
	 */
	public Board() {
		initBoard();
	}

	/**
	 * Main architect method of board creation.
	 * Sets length of array boardFields to 11. boardFields contains all fields 
	 * for matador game board. 
	 */
	private void initBoard() {
		int numFields = 11; // assignment description demands 11 specific instances
		boardFields = new Field[numFields]; // sets array length to numFields

		boardFields[0] = new Refuge("Start", 1, 200); //Okay
		boardFields[1] = new Street("Rødovervej", 2, 200, 60); //Needs price
		boardFields[2] = new Taxes("Ekstraordinær statsskat", 39, 100); //Needs price
		boardFields[3] = new Street("Hvidovrevej", 4, 20, 60); //Needs price
		boardFields[4] = new Shipping("D.F.D.S.", 16, 200); //Needs price
		boardFields[5] = new Refuge("Prøv lykken", 3, 0); //Okay
		boardFields[6] = new Taxes("Fængsel", 11, 500); //Okay
		boardFields[7] = new Street("Strandvejen", 20, 60, 180); //Needs price
		boardFields[8] = new Street("Grønningen", 25, 80, 240); //Needs price
		boardFields[9] = new Street("Rådhuspladsen", 40, 150, 400);
		boardFields[10] = new Refuge("Helle", 21, 20000); //Okay
	}
	
	/**
	 * Returns the {@link Field} with given index in boardFields.
	 * @param index [int] 0-10, index of Field to get.
	 * @return Field requested.
	 * @see Field
	 */
	public Field getField(int index) {
		return boardFields[index];
	}
}

