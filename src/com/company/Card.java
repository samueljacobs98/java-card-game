package com.company;

public class Card {
    private String suit;
    private String symbol;

    private int value;

    public Card(String suit,  int value) {
        this.suit = suit;
        this.value = value;
        this.symbol = returnSymbol();
    }

    public String toString() {
        return symbol + suit;
    }

    private String returnSymbol() {
        if (value < 11) return String.format("%s",value);
        switch (value) {
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "A";
        }
        return "-1";
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }
}
