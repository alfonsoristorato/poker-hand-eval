package com.poker.alfonso;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

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
        } else if (this.nOfAKind() > 1) {
            if (this.nOfAKind() == 2) {
                return "Two of a Kind";
            } else if (this.nOfAKind() == 3) {
                return "Three of a Kind";
            } else if (this.nOfAKind() == 4) {
                return "Four of a Kind";
            }
            else{
                return "None";
            }
        } else {
            return "High Card";
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

    private int nOfAKind() {
        int temp = hand[0].getRank();
        int iter = 1;
        int dupes = 1;
        while (iter < 5) {
            if (hand[iter].getRank() == temp) {
                dupes++;
            } else {
                temp = hand[iter].getRank();
            }
            iter++;
        }
        return dupes;
    }

}
