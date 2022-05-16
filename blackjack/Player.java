package com.blackjack;
import java.util.Scanner;

public class Player extends Person {

    //Creates a new Player, uses the exact same code as the Dealer class.
    Scanner input = new Scanner(System.in);

    //Create a new Player
    public Player() {
        super.setName("Desmond");

    }

    //Allow the player to make decisions
    public void makeDecision(Deck deck, Deck discard) {
        int  decision = 0;
        boolean getNum = true;

        //while were getting a number
        while(getNum){

            try{
                System.out.println("Would you like to: 1) Hit or 2) Stand");
                decision = input.nextInt();
                getNum = false;

            }
            catch(Exception e){
                System.out.println("Invalid");
                input.next();
            }
            //we don't close the scanner, because we will need it later.
        }
        //if the player hits (1)
        if (decision == 1) {
            //hit the deck using the deck and discard deck
            this.hit(deck, discard);
            //return (exit the method) if they have blackjack or busted
            if(this.getHand().calculatedValue()>20){
                return;
            }
            //if they didnt bust or get 21, player decides to hit or stand again by going back to the makeDecision method
            else{
                this.makeDecision(deck, discard);
            }

            //if they type any number other than 1, we'll assume they're standing
        } else {
            System.out.println("You stand.");
        }

    }

}