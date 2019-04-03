package Elevens;

public class main {


    public static void main(String args[]) {
        Deck gameDeck = new Deck();

        //deal nine cards in a grid
        int cardCount = 0;


        gameDeck.dealNineCards();

        System.out.println(gameDeck.getCardsDealt());


    }
}