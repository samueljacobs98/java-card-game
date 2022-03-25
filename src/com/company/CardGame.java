package com.company;

import java.util.ArrayList;

public class CardGame {
    private ArrayList<Card> deckOfCards = new ArrayList<Card>(0);
    private String name;

    public CardGame(String name) {
        initialiseDeck();
        this.name = name;
    }

    public ArrayList<Card> getDeck() {
        return deckOfCards;
    }

    private void initialiseDeck() {
        for (int suitNum = 0; suitNum < 4; suitNum++ ) {
            String suit;
            switch (suitNum) {
                case 0:
                    suit = "♥";
                    break;
                case 1:
                    suit = "♦";
                    break;
                case 2:
                    suit = "♠";
                    break;
                case 3:
                    suit = "♣";
                    break;
                default:
                    suit = "-1";
                    break;
                // Change to throw exception rather than default
            }
            for (int value = 2; value < 15; value++) {
                deckOfCards.add(new Card(suit, value));
            }
        }
    }


}
