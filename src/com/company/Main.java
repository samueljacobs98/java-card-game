package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CardGame cardGame = new CardGame("poker");
        ArrayList<Card> deck = cardGame.getDeck();
//        for (Card card : deck){
//            System.out.println(card.toString());
//        };
    }
}
