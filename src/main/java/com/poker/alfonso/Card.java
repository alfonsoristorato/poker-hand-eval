package com.poker.alfonso;


public class Card {
    private int suit;
    private int rank;
    private int deckPosition;


    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private String[] suits = {"Hearts", "Spades", "Clubs", "Diamonds"};

    Card(int suit, int rank, int deckPosition){
        this.suit = suit;
        this.rank = rank;
       
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getDeckPosition(){
        return deckPosition;
    }

    public void setDeckPosition(int deckPosition) {
        this.deckPosition = deckPosition;
    }

    public String stringify(Card card) {
        return ranks[card.rank] + " of " + suits[card.suit] + ", deck position: " + card.deckPosition;
    }

  






}
