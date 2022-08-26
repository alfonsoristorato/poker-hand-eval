package com.poker.alfonso;

//  properties = <exec.mainClass>com.poker.alfonso.App</exec.mainClass>
//  mvn exec:java
public class App {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("/////////////////////////////");
        System.out.println("First card in deck: " + deck.deck.get(0).stringify(deck.deck.get(0)));
        System.out.println("/////////////////////////////");

        deck.shuffle(deck);
        System.out.println("/////////////////////////////");
        System.out.println("First card in deck after shuffle: " + deck.deck.get(0).stringify(deck.deck.get(0)));
        System.out.println("/////////////////////////////");

        System.out.println("/////////////////////////////");
        System.out.println("Deck size: " + deck.deck.size());
        System.out.println("/////////////////////////////");
        Hand hand = new Hand(deck);
        System.out.println("/////////////////////////////");
        System.out.println("Deck size after creating hand: " + deck.deck.size());
        System.out.println("/////////////////////////////");
        System.out.println("/////////////////////////////");
        System.out.println("Hand elements: " + hand.stringifiedHand);
        System.out.println("/////////////////////////////");
    }
}
