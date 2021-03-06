package Elevens;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {


	List<Card> shuffled = new ArrayList<Card>();
	List<Card> halfDeck = new ArrayList<Card>();

	/**
	 * cards contains all the cards in the deck.
	 */
	private List<Card> cards = new ArrayList<Card>();

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size = 0;

	public int getSize() {
		return cards.size();
	}

	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
     * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */


	public Deck(String[] ranks, String[] suits, int[] values) {


		//face cards
	    for (String rank:ranks){
	        for (String suit:suits){
	            cards.add(new Card(rank,suit,0));
	            size++;
            }
        }

        //val cards
		for(String suit:suits){
			for(int val:values){
				cards.add(new Card("N/A",suit,val));
				size++;
			}
		}


	}


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		if (cards.isEmpty()){
			return true;
		}
		return false;
	}


	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int Getsize() {
		return size;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		int counter  = 0;

		System.out.println(cards);

		for (int i = 0; i <size/2; i++ ){
			halfDeck.add(cards.get(counter));
			cards.remove(counter);
//			System.out.println(cards);

		}
//		System.out.println(cards);

		for (int i = 0; i < size/2; i++){
			try{
				shuffled.add(cards.get(counter));
				shuffled.add(halfDeck.get(counter));

			}catch (Exception e){
				System.out.println(e);
			}
		}
//		System.out.println(shuffled.size());
//		System.out.println(halfDeck.size());
//		System.out.println(cards.size());
		System.out.println(cards);
		System.out.println(halfDeck);
		cards = shuffled;
		System.out.println(cards);
	}

	public void realShuffle(){
		Collections.shuffle(cards);


	}


	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {
		Card delt = cards.get(0);
		cards.remove(0);
		return delt;

	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}

	public void listCards(){
		for (Card card:cards){
			System.out.println(card);
		}
	}


}
