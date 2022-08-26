package com.poker.alfonso;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Card> hand;
    StringBuilder stringifiedHand = new StringBuilder();

    Hand(Deck deck) {
        hand = deck.deck.subList(0, 5);
        deck.deck.subList(0, 5).forEach((card) -> {
            stringifiedHand.append(card.stringify(card) + "; ");
        });
        deck.deck.subList(0, 5).clear();
        
    }

    public List<Card> getHand() {
        return hand;
    }

   

}
