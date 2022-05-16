package com.blackjack;

//using extends, this class will be everything that is in the Person class, plus whatever else I add to it
public class Dealer extends Person{

    /**
     * Create a new Dealer
     */
    public Dealer(){

        //Naming the dealer using super(), which targets the "parent" class, in this case Person, to name it "Dealer"
        super.setName("Dealer");

    }

    /**
     * Uses a slightly different method to print the dealer's hand, because the dealer's hand only shows 1 card face up
     */
    public void printFirstHand(){
        System.out.println("Each hand, 5 chips will be bet!");
        System.out.println("The dealer's hand looks like this:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down.");
    }

}