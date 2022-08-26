package com.poker.alfonso;

//  properties = <exec.mainClass>com.poker.alfonso.App</exec.mainClass>
//  mvn exec:java
public class App 
{
    public static void main( String[] args )
    {
        Deck deck = new Deck();
        System.out.println( deck.deck.get(0).stringify(deck.deck.get(0)) );
        
        deck.shuffle(deck);
        System.out.println( deck.deck.get(0).stringify(deck.deck.get(0)) );
    }
}
