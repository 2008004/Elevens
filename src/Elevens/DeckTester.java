package Elevens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *
     * @param args is not used.
     */
    public static void main(String[] args) {
        boolean isEmpty = false;
        boolean boardEmpty = false;
        String[] ranks = {"K", "Q", "J", "A"};
        String[] suits = {"H", "D", "C", "S"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9};
        Deck gameDeck = new Deck(ranks, suits, values);

        Card[][] gameBoard = new Card[3][3];
        for (Card[] row : gameBoard) {
            for (Card column : row) {
                column = null;
            }
        }


        JFrame frame = new JFrame("Elevens");
        GridLayout gridLayout = new GridLayout(3, 4, 50, 50);
        frame.setLayout(gridLayout);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        int rowCount = 0;
        int colCount = 0;


        List<JButton> btnList = new ArrayList<JButton>();

        gameDeck.realShuffle();
        while (!isEmpty) {
            for (Card[] row : gameBoard) {
                for (Card column : row) {
                    if (column == null) {
                        gameBoard[rowCount][colCount] = gameDeck.deal();
                    }
                    colCount++;
//                    System.out.println(column);
                }
                rowCount++;
                colCount = 0;
            }


            for (Card[] row : gameBoard) {
                for (Card column : row) {
                    System.out.println(column);

                    if (column.pointValue() != 0){
                        ImageIcon cardImage = new ImageIcon("images/"+column.pointValue()+column.suit()+".jpg");
                        JButton a = new JButton("",cardImage);
                        a.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (a.getBackground() == Color.RED){
                                    a.setBackground(Color.WHITE);
                                    a.setName("notSelected");
                                    btnList.remove(a);
                                    System.out.println(btnList);
                                }else{
                                    a.setBackground(Color.RED);
                                    a.setName("selected");
                                    btnList.add(a);
                                    System.out.println(btnList);
                                }
                            }
                        });
                        frame.add(a);
                    }else{
                        ImageIcon cardImage = new ImageIcon("images/"+column.rank()+column.suit()+".jpg");
                        JButton a = new JButton("",cardImage);
                        a.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (a.getBackground() == Color.RED){
                                    a.setBackground(Color.WHITE);
                                    a.setName("notSelected");
                                    btnList.remove(a);
                                    System.out.println(btnList);
                                }else{
                                    a.setBackground(Color.RED);
                                    a.setName("selected");
                                    btnList.add(a);
                                    System.out.println(btnList);
                                }
                            }
                        });
                        frame.add(a);
                    }


                }
            }




            frame.pack();
            frame.setVisible(true);


            isEmpty = gameDeck.isEmpty();






            //for debug
            isEmpty = true;
        }
    }
}

