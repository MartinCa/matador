import matador.board.*;


public class GameBoard {
	private static Field[] boardFields;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initBoard(5);
		printBoard();
	}
	
	private static void initBoard(int numFields) {
		boardFields = new Field[numFields]; // sets array length to numFields

		boardFields[0] = new Refuge("Start", 1, 200); //Okay
		boardFields[1] = new Street("Rødovervej", 2, 200, 60); //Needs price
		boardFields[2] = new Taxes("Ekstraordinær statsskat", 39, 100); //Needs price
		boardFields[3] = new Brewery("Carlsberg", 4, 20); //Needs price
		boardFields[4] = new Shipping("D.F.D.S.", 16, 200); //Needs price
	}
	
	private static void printBoard() {
		for (Field field : boardFields) {
			System.out.println(field);
		}
	}
}
