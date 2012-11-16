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

		boardFields[0] = new Refuge("Start", 1, 200); //Okay
		boardFields[1] = new Street("Rødovervej", -200, 2); //Needs price
		boardFields[2] = new Taxes("Ekstraordinær statsskat", -100, 39); //Needs price
		boardFields[3] = new Street("Hvidovrevej", -20, 4); //Needs price
		boardFields[4] = new Shipping("D.F.D.S.", -75, 16); //Needs price
		boardFields[5] = new Refuge("Prøv lykken", 3, 0); //Okay
		boardFields[6] = new Taxes("Fængsel", 11, 500); //Okay
		boardFields[7] = new Street("Strandvejen", -60, 20); //Needs price
		boardFields[8] = new Street("Grønningen", -80, 25); //Needs price
		boardFields[9] = new Street("Rådhuspladsen", -150, 40);
		boardFields[10] = new Refuge("Helle", 21, 20000); //Okay
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

