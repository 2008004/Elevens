package Elevens;

import javax.swing.*;
import java.awt.*;
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
		String[] ranks = {"K","Q","J","A"};
		String[] suits =  {"H","D","C","S"};
		int[] values = {1,2,3,4,5,6,7,8,9};
		Deck gameDeck = new Deck(ranks,suits,values);

		Card[][] gameBoard = new Card[3][3];
		for (Card[] row:gameBoard){
			for (Card column:row){
				column = null;
			}
		}

		gameDeck.realShuffle();

		JFrame frame = new JFrame();



		}
	}

