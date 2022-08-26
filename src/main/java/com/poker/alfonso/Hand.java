package com.poker.alfonso;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {
    Card[] hand;
    StringBuilder stringifiedHand = new StringBuilder();

    Hand(Deck deck) {
        hand = deck.deck.subList(0, 5).toArray(new Card[0]);
        deck.deck.subList(0, 5).forEach((card) -> {
            stringifiedHand.append(card.stringify(card) + "; ");
        });
        deck.deck.subList(0, 5).clear();

    }

    public Card[] getHand() {
        return hand;
    }

    public String evaluate() {
        if (this.royalFlush() == true) {
            return "Royal Flush";
        // } else if (this.royalFlush() == false && this.flush() == true && this.straight() == true) {
        //     return "Straight Flush";
        // } else if (this.royalFlush() == false && this.flush() == false && this.straight() == true) {
        //     return "Straight";
        // } else if (this.royalFlush() == false && this.flush() == true && this.straight() == false) {
        //     return "Flush";
        // } else if (this.fourOfAKind() == true) {
        //     return "Four of a Kind";
        // } else if (this.threeOfAKind() == true) {
        //     return "Three of a Kind";
        } else {
            return "None";
        }
    }

    private boolean royalFlush() {
        if (Arrays.stream(hand).allMatch((card) -> card.getSuit() == hand[0].getSuit())) {
            Integer[] royalFlush = { 0, 9, 10, 11, 12 };
            Integer[] suitsFromHand = Arrays.stream(hand).map(Card::getRank).collect(Collectors.toList())
                    .toArray(new Integer[0]);

            if (royalFlush.equals(suitsFromHand)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
