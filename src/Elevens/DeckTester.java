package Elevens;
/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"king","queen","Jack","Ace"};
		String[] suits =  {"hearts","diamonds","clubs","spades"};
		int[] values = {1,2,3,4,5,6,7,8,9};
		Deck gameDeck = new Deck(ranks,suits,values);
		gameDeck.toString();
	}
}
