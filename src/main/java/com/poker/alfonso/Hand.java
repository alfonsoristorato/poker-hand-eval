package com.poker.alfonso;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hand {
    Card[] hand;
    StringBuilder stringifiedHand = new StringBuilder();

    Hand(Deck deck) {
        hand = deck.deck.subList(0, 5).toArray(new Card[0]);
        Arrays.sort(hand, Comparator.comparing(Card::getRank).reversed());
        Arrays.stream(hand).forEach((card) -> {
            stringifiedHand.append(card.stringify(card) + "; ");
        });
        for (Card card : hand) {
            deck.drawFromDeck();
        }

    }

    public Card[] getHand() {
        return hand;
    }

    public String evaluate() {
        if (this.royalFlush()) {
            return "Royal Flush";
        } else if (!this.royalFlush() && this.flush() &&
                this.straight()) {
            return "Straight Flush";
        } else if (!this.royalFlush() && !this.flush() &&
                this.straight()) {
            return "Straight";
        } else if (!this.royalFlush() && this.flush() &&
                !this.straight()) {
            return "Flush";
        } else if (this.fourOfAKind()) {
            return "Four of a Kind";
        } else if (this.threeOfAKind()) {
            return "Three of a Kind";
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

    private boolean flush() {
        if (Arrays.stream(hand).allMatch((card) -> card.getSuit() == hand[0].getSuit())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean straight() {
        boolean result = true;
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i].getRank() - hand[i + 1].getRank() != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean fourOfAKind() {
        // Long distinctCount = Arrays.stream(hand).distinct().count();
        // return hand.length != distinctCount;
        if (hand[0].getRank() == hand[1].getRank() && hand[0].getRank() == hand[2].getRank()
                && hand[0].getRank() == hand[3].getRank()
                || hand[4].getRank() == hand[1].getRank() && hand[4].getRank() == hand[2].getRank()
                        && hand[4].getRank() == hand[3].getRank()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean threeOfAKind() {
        if (hand[0].getRank() == hand[1].getRank() && hand[0].getRank() == hand[2].getRank()
                && hand[0].getRank() != hand[3].getRank() && hand[0].getRank() != hand[4].getRank()
                || hand[1].getRank() == hand[2].getRank() && hand[1].getRank() == hand[3].getRank()
                        && hand[1].getRank() != hand[0].getRank() && hand[1].getRank() != hand[4].getRank()
                || hand[4].getRank() == hand[2].getRank() && hand[4].getRank() == hand[3].getRank()
                        && hand[4].getRank() != hand[0].getRank() && hand[4].getRank() != hand[1].getRank()) {
            return true;
        } else {
            return false;
        }
    }

}
