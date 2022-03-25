package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CardGame cardGame = new CardGame("poker");
        System.out.println(cardGame.getDeck());
        cardGame.shuffleDeck();
        System.out.println(cardGame.getDeck());
        System.out.println(cardGame.dealCard());
        cardGame.sortDeckIntoSuits();
        System.out.println(cardGame.getDeck());
        cardGame.sortDeckInNumberOrder();
        System.out.println(cardGame.getDeck());
//        ArrayList<Card> deck = cardGame.getDeck();
//        for (Card card : deck){
//            System.out.println(card.toString());
//        };
    }
}

//        Log all cards
//        System.out.println(cardGame.getDeck());

