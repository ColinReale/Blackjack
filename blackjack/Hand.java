package com.blackjack;
import java.util.ArrayList;
public class Hand {

//    a method that lets me use .add() to add a card from a deck to this hand
    public void takeCardFromDeck(Deck deck){
        hand.add(deck.takeCard());
    }
    private ArrayList<Card> hand;

//    a constructor that instantiate's an arraylist of Cards, though instead of a full deck, this arraylist is simply a 2 card hand
    public Hand(){
        hand = new ArrayList<Card>();
    }
//let's me print a player or dealer's hand
    public String toString(){
        String output = "";
        for(Card card: hand){
            output += card + " - ";
        }
        return output;
    }

//    this is a complicated method. What it does is calculate the value of a hand, accounting for aces being 1 or 11.
    public int calculatedValue(){

        //variable to count number of aces, and current total value
        int value = 0;
        int aceCount = 0;

        //For each card in this hand
        for(Card card: hand){
            //Add the value of the card to the hand
            value += card.getValue();
            //Count how many aces have been added. We have to keep track of the aces because their value can change, which gets tricky.
            if (card.getValue() == 11){
                aceCount ++;
            }
        }
        //if we have a scenario where we have multiple aces, as may be the case of drawing 10, followed by two or more aces, (10+11+1 > 21)
        //go back and set each ace to 1 until get back under 21, if possible
        if (value > 21 && aceCount > 0){
            while(aceCount > 0 && value > 21){
                aceCount --;
                value -= 10;
            }
        }
        return value;

    }
//a way to get one specific card, so that we can target one of the Dealer's cards
    public Card getCard(int index){
        return hand.get(index);
    }


//     discards a Hand to a Deck
    public void discardHandToDeck(Deck discardDeck){

        //copy cards from hand to discardDeck
        discardDeck.addCards(hand);

        //clear the hand
        hand.clear();

    }
}