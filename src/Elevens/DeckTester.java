package Elevens;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		boolean isEmpty = false;
		boolean boardEmpty = false;
		String[] ranks = {"king","queen","Jack","Ace"};
		String[] suits =  {"hearts","diamonds","clubs","spades"};
		int[] values = {1,2,3,4,5,6,7,8,9};
		Deck gameDeck = new Deck(ranks,suits,values);

		Card[][] gameBoard = new Card[3][3];

		gameDeck.realShuffle();

		//start game
		while(!isEmpty || !boardEmpty){



			isEmpty = gameDeck.isEmpty();



			//deal and display
			int rowCount = 0;
			int columnCount = 0;

			for (Card[] row:gameBoard){
				for (Card column:row){
					gameBoard[rowCount][columnCount] = gameDeck.deal();

					///System.out.println(gameBoard[rowCount][columnCount].toString());

					columnCount++;

				}
				columnCount = 0;
				rowCount++;
			}




			List boardList = Arrays.asList(gameBoard);
			boardEmpty = boardList.isEmpty();




		}
	}
}
