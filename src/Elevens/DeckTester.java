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
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10};
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


        List<Card> btnList = new ArrayList<Card>();

        gameDeck.realShuffle();
        while (!isEmpty) {
            btnList.clear();
            rowCount = 0;
            colCount = 0;
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

                    if (column.pointValue() != 0) {
                        ImageIcon cardImage = new ImageIcon("images/" + column.pointValue() + column.suit() + ".jpg");
                        JButton a = new JButton("", cardImage);

                        a.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (a.getBackground() == Color.RED) {
                                    a.setBackground(Color.WHITE);
                                    btnList.remove(column);
                                    System.out.println(btnList);
                                } else {
                                    a.setBackground(Color.RED);
                                    btnList.add(column);
                                    System.out.println(btnList);
                                }
                            }
                        });
                        frame.add(a);
                    } else {
                        ImageIcon cardImage = new ImageIcon("images/" + column.rank() + column.suit() + ".jpg");
                        JButton a = new JButton("", cardImage);
                        a.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (a.getBackground() == Color.RED) {
                                    a.setBackground(Color.WHITE);

                                    btnList.remove(column);
                                    System.out.println(btnList);
                                } else {
                                    a.setBackground(Color.RED);
                                    btnList.add(column);
                                    System.out.println(btnList);
                                }
                            }
                        });
                        frame.add(a);
                    }


                }


            }

            frame.validate();
            frame.repaint();
            frame.pack();
            frame.setVisible(true);


            while (btnList.size() != 2) {
                //wait til two cards are selected to proceed
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }

            //System.out.println("test");
            //check values
            try {
                Card c1 = btnList.get(0);
                Card c2 = btnList.get(1);
                if (c1.rank() == "A") {
                    c1.setPointValue(1);
                }
                if (c2.rank() == "A") {
                    c2.setPointValue(1);
                }
                int val = c1.pointValue() + c2.pointValue();
                if (val == 11) {
                    System.out.println("true");
                    rowCount = 0;
                    colCount = 0;
                    for (Card[] row : gameBoard) {
                        for (Card column : row) {
                            if (column == c1 || column == c2) {
                                gameBoard[rowCount][colCount] = null;

                            }
                            colCount++;
                        }
                        colCount = 0;
                        rowCount++;
                    }
                } else {
                    //System.out.println("false");
                    while (btnList.size() != 3) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            //nothing
                        }
                    }

                    c1 = btnList.get(0);
                    c2 = btnList.get(1);
                    Card c3 = btnList.get(2);

                    List<String> rlist = new ArrayList<String>();

                    rlist.add(c1.rank());
                    rlist.add(c2.rank());
                    rlist.add(c3.rank());

                    if (rlist.contains("K")) {
                        if (rlist.contains("Q")) {
                            if (rlist.contains("J")) {
                                System.out.println("true");
                                rowCount = 0;
                                colCount = 0;
                                for (Card[] row:gameBoard){
                                    for (Card column:row){
                                        if (column == c1 || column == c2 || column == c3){
                                            gameBoard[rowCount][colCount] = null;
                                        }
                                        colCount++;
                                    }
                                    colCount = 0;
                                    rowCount++;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                //if fail then check for KQJ
                while (btnList.size() != 3) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        //nothing
                    }
                }

                Card c1 = btnList.get(0);
                Card c2 = btnList.get(1);
                Card c3 = btnList.get(2);

                List<String> rlist = new ArrayList<String>();

                rlist.add(c1.rank());
                rlist.add(c2.rank());
                rlist.add(c3.rank());

                if (rlist.contains("K")) {
                    if (rlist.contains("Q")) {
                        if (rlist.contains("J")) {
                            System.out.println("true");
                            rowCount = 0;
                            colCount = 0;
                            for (Card[] row:gameBoard){
                                for (Card column:row){
                                    if (column == c1 || column == c2 || column == c3){
                                        gameBoard[rowCount][colCount] = null;
                                    }
                                    colCount++;
                                }
                                colCount = 0;
                                rowCount++;
                            }
                        }
                    }
                }

            }


            frame.getContentPane().removeAll();


            isEmpty = gameDeck.isEmpty();


            //for debug
//             isEmpty = true;
//            isEmpty = false;
            System.out.println(gameDeck.getSize());
        }

        System.out.println("WIN");
        frame.getContentPane().removeAll();
        Label a = new Label("you win!");
        a.setFont(new Font("Serif", Font.PLAIN, 250));
        frame.add(a);
        frame.validate();
        frame.pack();

    }
}

