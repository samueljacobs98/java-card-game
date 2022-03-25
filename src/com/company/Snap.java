package com.company;

import java.util.Scanner;

public class Snap extends CardGame{

    public Snap(String name) {
        super(name);
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        shuffleDeck();

        boolean gameStarted = false;
        Player player1 = new Player("");
        Player player2 = new Player("");

        while (!gameStarted) {
            System.out.println("Player 1: Enter your name");
            player1.setName(scanner.nextLine());

            System.out.println("Player 2: Enter your name");
            player2.setName(scanner.nextLine());

            System.out.println("Hello " + player1.getName() + " and " + player2.getName() + ".");
            System.out.println("Press enter to begin");
            String input = scanner.nextLine();

            if (input.length() == 0) gameStarted = true;
        }

        boolean winner = false;
        Card previousCard = new Card("",-1);

        boolean player1Turn = true;
        Player currentPlayer = player1;

        while (getDeck().size() > 0 && !winner){
            currentPlayer = player1Turn ? player1 : player2;
            System.out.println(currentPlayer.getName() + ": Press enter to flip the next card");
            String input = scanner.nextLine();
            if (input.length() == 0) {
                Card newCard = dealCard();
                System.out.println(newCard);;
                if (newCard.getSuit() == previousCard.getSuit()) {
                    winner = true;
                }
                previousCard = newCard;
            }
            player1Turn = !player1Turn;
        }

        String endMessage = winner ? "Snap! " + currentPlayer.getName() + " wins!" : "You both lose!";
        System.out.println(endMessage);
    }
}
