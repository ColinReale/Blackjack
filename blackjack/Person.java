package com.blackjack;

public abstract class Person {

    private Hand hand;
    private String name;

//  constructor that instantiates a new person- player or dealer and gives them an empty hand & empty name
    public Person(){
        this.hand = new Hand();
        this.name = "";
    }


//    getters and setters for a Person's hand and name
    public Hand getHand(){
        return this.hand;
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;

    }
//a class that uses calculatedValue() to determine if a player or dealer has blackjack
    public boolean hasBlackjack(){
        if(this.getHand().calculatedValue() == 21){
            return true;
        }
        else{
            return false;
        }
    }
//a method that allows the players to hit and receive another card
public void hit(Deck deck, Deck discard){

    //If there's no cards left in the deck
    if (!deck.hasCards()) {
        deck.reloadDeckFromDiscard(discard);
    }
    this.hand.takeCardFromDeck(deck);
    System.out.println(this.name + " gets a card");
    this.printHand();

}

    /**
     * This will print a Person's hand
     */
    public void printHand(){
        System.out.println(this.name + "'s hand is: ");
        System.out.println(this.hand + " Which adds up to: " + this.hand.calculatedValue());
    }

}
