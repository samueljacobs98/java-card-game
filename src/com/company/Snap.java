package com.company;

import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;


public class Snap extends CardGame{
    // Initialise
    private Player currentPlayer;
    private boolean winner;
    private boolean gameStarted;
    private Player player1;
    private Player player2;
    private Card previousCard;

    // Constructor
    public Snap(String name) {
        super(name);
        this.player1 = new Player("");
        this.player2 = new Player("");
        this.previousCard = new Card("",-1);
    }
    // Getters and Setters
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean getWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean getGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public void setPreviousCard(Card previousCard) {
        this.previousCard = previousCard;
    }

    // Methods
    private void setupGame() {
        while (!getGameStarted()) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Player 1: Enter your name");
            player1.setName(scanner.nextLine());

            System.out.println("Player 2: Enter your name");
            player2.setName(scanner.nextLine());

            System.out.println("Hello " + player1.getName() + " and " + player2.getName() + ".");
            System.out.println("Press enter to begin");
            String input = scanner.nextLine();

            if (input.length() == 0) setGameStarted(true);
        }
    }

    private void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getCurrentPlayer().getName() + ": Press enter to flip the next card");
        String input = scanner.nextLine();
        if (input.length() == 0) {
            Card newCard = dealCard();
            System.out.println(newCard);
            if (Objects.equals(newCard.getSuit(), previousCard.getSuit())) {
                setWinner(responseInTime());
            }
            setPreviousCard(newCard);
        }
        if (!getWinner()) setCurrentPlayer(getCurrentPlayer() == player1 ? player2 : player1);
    }

    public void playGame() {
        shuffleDeck();
        setupGame();

        setCurrentPlayer(player1);

        while (getDeck().size() > 0 && !getWinner()){
            runGame();
        }

        String endMessage = winner ? "Snap! " + currentPlayer.getName() + " wins!" : "You both lose!";
        System.out.println(endMessage);
    }

    private boolean responseInTime() {
        TimeMeasure timer = new TimeMeasure(5, new Timer());
        Scanner snapScanner = new Scanner(System.in);
        timer.startTimer();
        String potentialSnap = snapScanner.nextLine().toLowerCase();
        timer.stopTimer();

        if (potentialSnap.equals("snap") && timer.getTimeLeft() != 0) {
            setWinner(true);
            return true;
        }
        return false;
    }
}
