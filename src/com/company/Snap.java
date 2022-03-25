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

        while (!gameStarted) {
            System.out.println("Press enter to begin");
            String input = scanner.nextLine();
            if (input.length() == 0) {
                gameStarted = true;
            }
        }

        boolean winner = false;
        Card previousCard = new Card("",-1);

        while (getDeck().size() > 0 && !winner){
            System.out.println("Press enter to flip the next card");
            String input = scanner.nextLine();
            if (input.length() == 0) {
                Card newCard = dealCard();
                System.out.println(newCard);;
                if (newCard.getSuit() == previousCard.getSuit()) {
                    winner = true;
                }
                previousCard = newCard;
            }
        }

        String endMessage = winner ? "You win!" : "You lose!";
        System.out.println(endMessage);
    }
}
