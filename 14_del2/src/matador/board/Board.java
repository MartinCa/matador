package matador.board;

/**
 * Represents the gameboard used in Matador, contains all the fields used in the game.
 * @author Martin Caspersen
 * @see Field
 */
public class Board {
	private Field[] boardFields;	// array containing each field on the board 

	/**
	 * Constructor for creating the game board, makes the board with 11 fields. Calls initBoard to actually create the array and fields.
	 * 
	 */
	public Board() {
		int numFields = 11; // assignment description demands 11 specific instances
		
		initBoard(numFields);
	}

	/**
	 * Main architect method of board creation.
	 * Sets length of array boardFields to numFields. boardFields contains all fields 
	 * for matador game board. 
	 * 
	 * @param numFields [int] amount of fields to be created. Must be set to 11 or higher for this game.
	 */
	private void initBoard(int numFields) {
		boardFields = new Field[numFields]; // sets array length to numFields

		boardFields[0] = new Refuge("Start", 200, 1);
		boardFields[1] = new Street("Rødovervej", -200, 2);
		boardFields[2] = new Taxes("Ekstraordinær statsskat", -100, 39);
		boardFields[3] = new Street("Hvidovrevej", -20, 4);
		boardFields[4] = new Shipping("D.F.D.S.", -75, 16);
		boardFields[5] = new Refuge("Prøv lykken", 0, 3);
		boardFields[6] = new Taxes("Fængsel", -500, 11);
		boardFields[7] = new Street("Strandvejen", -60, 20);
		boardFields[8] = new Street("Grønningen", -80, 25);
		boardFields[9] = new Street("Rådhuspladsen", -150, 40);
		boardFields[10] = new Refuge("Helle", 20000, 21);
	}
	
	/**
	 * Retunds the Field with given index in boardFields.
	 * @param index [int] 0-10, index of Field to get.
	 * @return Field requested.
	 * @see Field
	 */
	public Field getField(int index) {
		return boardFields[index];
	}
}

