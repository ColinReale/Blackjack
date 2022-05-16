package com.blackjack;

import java.util.Random;

public class Card {

    private Suit suit;
    private Rank rank;


    //create a card given a suit and a rank
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

// A constructor that sets the rank and suit of a Card equal to that of another Card provided in the parameters.
    public Card(Card card) {
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }




    //these are getter methods we will use to figure out the rank, suit and value of the cards
    public int getValue(){
        return rank.rankValue;
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public String toString(){
        return ("["+rank+" of "+ suit + "] ("+this.getValue()+")");

    }
}