package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

    private String getSuitFromSuitNum(int suitNum) {
        switch (suitNum) {
            case 0:
                return "♥";
            case 1:
                return "♦";
            case 2:
                return "♠";
            case 3:
                return "♣";
            default:
                return "-1";
            // Change to throw exception rather than default
        }
    }

    private void initialiseDeck() {
        for (int value = 2; value < 15; value++) {
            for (int suitNum = 0; suitNum < 4; suitNum++ ) {
            String suit = getSuitFromSuitNum(suitNum);
                deckOfCards.add(new Card(suit, value));
            }
        }
    }

    public Card dealCard() {
        return deckOfCards.get(0);
    }

    public void sortDeckInNumberOrder() {
        ArrayList<Card> temporaryDeck = new ArrayList<Card>(0);
        for (int value = 2; value < 15; value++) {
            for (Card card : deckOfCards) {
                if (card.getValue() == value) {
                    temporaryDeck.add(card);
                }
            }
        }
        deckOfCards = temporaryDeck;
    }

    public void sortDeckIntoSuits() {
        sortDeckInNumberOrder();
        ArrayList<Card> temporaryDeck = new ArrayList<Card>(0);
        String[] suitsArr = {"♥","♦","♠","♣"};
        for (String suit : suitsArr) {
            for (Card card : deckOfCards) {
                if (card.getSuit() == suit) {
                    temporaryDeck.add(card);
                }
            }
        }
        deckOfCards = temporaryDeck;
    }

    public void shuffleDeck() {
                Collections.shuffle(deckOfCards);
    }
}
