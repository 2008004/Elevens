package Elevens;

import java.util.Arrays;
import java.util.Collections;

public class Deck {

    //ace cards are = 1
    int Ace = 1;
    int[] values = {Ace,2,3,4,5,6,7,8,9,10,};
    String[] suits = {"Hearts","Diamonds","Spades","Clubs"};
    String[] special = {"King","Queen","Jack"};
    String[] Deck;
    int index = 0;
    int cardsDealt = 0;

    public void getDeck() {
        for (String val:Deck){
            System.out.println(val);
        }
    }
    public String getDeckItem(int i){
        return Deck[i];
    }

    public int getCardsDealt() {
        return cardsDealt;
    }

    public Deck(){
        this.index = 0;
        this.Deck = new String[52];
        this.cardsDealt = 0;
        //add vals for each suit

        for (int val:values){
            for (String suit:suits){
                Deck[index] = suit+":"+val;
//                System.out.println(Deck[index]);
                index++;
            }
        }

        for (String special:special){
            for(String suit:suits){
                Deck[index] = suit+":"+special;
//                System.out.println(Deck[index]);
                index++;
            }
        }

        //shuffle
        Collections.shuffle(Arrays.asList(Deck));

    }

    public void dealNineCards(){
        int rowCount = 0;
        for (int i = cardsDealt+9; cardsDealt < i; cardsDealt++){
//            System.out.println(cardsDealt);
            try{

                if ((rowCount+1) % 3 == 0 && rowCount != 0){
                    System.out.println("|"+this.Deck[cardsDealt]+"|");
                }else{
                    System.out.print("|"+this.Deck[cardsDealt]+"|");
                }

            }catch (Exception e){
                break;
            }
            rowCount++;
        }
    }



}
