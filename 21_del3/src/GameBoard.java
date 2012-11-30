import matador.board.*;

/**
 * Creates five different fields and prints the fields.
 * @author Martin Caspersen
 *
 */
public class GameBoard {
	private static Field[] boardFields;

	/**
	 * Used to start the initialization of the board and printing.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initBoard();
		printBoard();
	}
	
	/**
	 * Creates the five fields in boardFields.
	 */
	private static void initBoard() {
		int numFields = 5;
		boardFields = new Field[numFields]; // sets array length to numFields

		boardFields[0] = new Refuge("Start", 1, 200);
		boardFields[1] = new Street("Rødovervej", 2, 200, 60);
		boardFields[2] = new Taxes("Ekstraordinær statsskat", 39, 100);
		boardFields[3] = new Brewery("Carlsberg", 4, 20);
		boardFields[4] = new Shipping("D.F.D.S.", 16, 200);
	}
	
	/**
	 * Prints all the fields in boardFields.
	 */
	private static void printBoard() {
		for (Field field : boardFields) {
			System.out.println(field);
		}
	}
}
