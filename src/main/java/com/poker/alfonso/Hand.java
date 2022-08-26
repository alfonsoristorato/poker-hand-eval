package com.poker.alfonso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    private boolean royalFlush() {
        if (hand.stream().allMatch((card) -> card.getSuit() == hand.get(0).getSuit())) {
            Integer[] royalFlush = { 0, 9, 10, 11, 12 };
            Integer[] suitsFromHand = hand.stream().map(Card::getRank).collect(Collectors.toList())
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
