package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CardGame {
    private ArrayList<Card> deckOfCards = new ArrayList<Card>(0);
    private String name;
    protected Scanner scanner;

    public CardGame(String name, Scanner scanner) {
        deckOfCards = initialiseDeck();
        this.name = name;
        this.scanner = scanner;
    }

    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
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

    private ArrayList<Card> initialiseDeck() {
        ArrayList<Card> temporaryDeck = new ArrayList<Card>(0);
        for (int value = 2; value < 15; value++) {
            for (int suitNum = 0; suitNum < 4; suitNum++ ) {
            String suit = getSuitFromSuitNum(suitNum);
                temporaryDeck.add(new Card(suit, value));
            }
        }
        return temporaryDeck;
    }

    public Card dealCard() {
        Card temporaryCard = deckOfCards.get(0);
        deckOfCards.remove(0);
        return temporaryCard;
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
