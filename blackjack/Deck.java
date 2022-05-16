package com.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }
    public Deck(boolean makeDeck){
        this.deck = new ArrayList<Card>();
        if(makeDeck){
            //Go through all the suits. Using the values() on an enum returns an array of all of the enums' values
            for(Suit suit : Suit.values()){
                //Go through all the ranks
                for(Rank rank : Rank.values()){
                    //add a new card containing each iterations suit and rank
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    //A method that shuffles the deck
    public void shuffle(){
        ArrayList<Card> shuffled = new ArrayList<Card>();
        //this will go through the entire size of the deck, so each card can be pulled at random, thus shuffling the deck
        while(deck.size()>0){
            //Select a random index to pull
            int cardToPull = (int)(Math.random()*(deck.size()-1));
            //Add this random card to the new shuffled deck
            shuffled.add(deck.get(cardToPull));
            //Remove the pulled card from the original deck
            deck.remove(cardToPull);
        }
        deck = shuffled;
    }



    public void createFullDeck() {
        // generate cards

    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    //a method that adds a card
    public void addCard(Card card){
        deck.add(card);
    }

    public String toString(){
        //A string to hold everything we're going to return
        String output = "";

        //for each Card "card" in the deck
        for(Card card: deck){
            //add the card and the escape character for a new line
            output += card;
            output += "\n";
        }
        return output;
    }

    public Card getCard(int i){
        return this.deck.get(i);
    }

    public void removeCard(int i){
        this.deck.remove(i);
    }


    // Get the size of the deck
    public int deckSize() {
        return this.deck.size();
    }

    // Draws from the deck
    public void draw(Deck comingFrom) {

    }

    // This will move cards back into the deck to continue playing
    public void moveAllToDeck(Deck moveTo) {

    }


    public Card takeCard(){

        //Take a copy of the first card from the deck
        Card cardToTake = new Card(deck.get(0));
        //Remove the card from the deck
        deck.remove(0);
        //Give the card back
        return cardToTake;

    }
//checks to see if there are cards in the deck
    public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Empties out this Deck
     */
    public void emptyDeck(){
        deck.clear();
    }

    /**
     *
     * @param cards an arraylist of cards to be added to this deck
     */
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }


    /**
     * Take all the cards from a discarded deck and place them in this deck, shuffled.
     * Clear the old deck
     * @param discard - the deck we're getting the cards from
     */
    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
    }
//    integer which returns the amount of cards left in a Deck.
    public int cardsLeft(){
        return deck.size();
    }

    public ArrayList<Card> getCards() {
        return deck;
    }
}