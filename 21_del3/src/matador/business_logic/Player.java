package matador.business_logic;

import java.util.*;

import matador.board.*;

/**
 * Provides a Player that is used in a dice game. The Player holds a name, carColorm, a Konto and a list of owned fields.
 * Provides necessary functions used by the Game class.
 * @author Martin Caspersen
 * @see Game
 * @see Konto
 *
 */
public class Player {
	private int carColor;
	private String name;
	private Konto konto;
	private List<Ownable> ownedFields = new ArrayList<Ownable>(); 	//Array af fields den enkelte spiller ejer.
	private boolean loser = false;

	/**
	 * Constructs a Player with the provided name, carColor and balance.
	 * @param name name of the Player as a String.
	 * @param carColor int describing the color of this Players car [0:5].
	 * @param balance initial balance of the Players Konto as an int.
	 */
	public Player(String name, int carColor, int balance) {
		this.name = name;
		this.carColor = carColor;
		konto = new Konto(balance);
	}
	
	/**
	 * Returns the name of the Player.
	 * @return {@link java.lang.String} Players name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the carColor of the Player.
	 * @return {@link java.lang.int} carColor.
	 */
	public int getCarColor() {
		return carColor;
	}

	/**
	 * Returns the players {@link Konto}.
	 * @return {@link Konto} of the player.
	 * @see Konto
	 */
	public Konto getKonto() {
		return konto;
	}
	
	/**
	 * Handles processes of buying a Field.
	 * Withdraws the price of the field from the players account.
	 * Adds bought field to arrayList of players owned fields.
	 * 
	 * @param field
	 */
	public void buyField(Ownable field){
		this.konto.withdraw(field.getPrice());	
		this.ownedFields.add(field);			
	}
	/**
	 * Returns the ownedFields ArrayList.
	 * This ArrayList holds references to all fields owned by the player.
	 *  
	 * @return ownedFields {@link java.util.ArrayList}
	 */
	public List<Ownable> getOwnedFields() {
		return ownedFields;		
	}
	
	/**
	 * Returns whether the player har lost the game.
	 * @return True if the player has lost the game.
	 */
	public boolean isLoser() {
		return loser;
	}

	/**
	 * Sets the Player as a loser in the game.
	 */
	public void setLoser() {
		this.loser = true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [carColor=" + carColor + ", name=" + name + ", konto="
				+ konto + "]";
	}

}
