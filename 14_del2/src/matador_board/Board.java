package matador_board;

public class Board {
	private Field[] boardFields;	// array containing each field on the board 

	/**
	 * Constructor, calls method for creating game board
	 * 
	 * @see initBoard
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
	 * @param numFields
	 */
	public void initBoard(int numFields) {
		boardFields = new Field[numFields]; // sets array length to numFields

		boardFields[0] = new Refuge("Start", 200);
		boardFields[1] = new Street("Rødovervej", 200);
		boardFields[2] = new Taxes("Ekstraordinær statsskat", 100);
		boardFields[3] = new Street("Hvidovrevej", 20);
		boardFields[4] = new Shipping("D.F.D.S.", 75);
		boardFields[5] = new Refuge("Prøv lykken", 0);
		boardFields[6] = new Taxes("Fængsel", 500);
		boardFields[7] = new Street("Strandvejen", 60);
		boardFields[8] = new Street("Grønningen", 80);
		boardFields[9] = new Street("Rådhuspladsen", 150);
		boardFields[10] = new Refuge("Helle", 20000);
	}
}

