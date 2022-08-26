package com.poker.alfonso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Deck {
    ArrayList<Card> deck;


    ArrayList<Integer> deckPoistions = new ArrayList<Integer>();

    Deck() {
        for (int i = 0; i < 52; i++) {
            deckPoistions.add(i);
        }
        deck = new ArrayList<>();
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                Card temp = new Card(suit, rank, 0);
                deck.add(temp);
            }
        }

    }


    public Deck shuffle(Deck deck) {
        Collections.shuffle(deckPoistions);
        for (int i : deckPoistions) {
            deck.deck.get(i).setDeckPosition(deckPoistions.get(i));
        }
        deck.deck.sort(Comparator.comparing(Card::getDeckPosition));
       
        return deck;

    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Card drawFromDeck() {
        return deck.remove(0);
    }
}
