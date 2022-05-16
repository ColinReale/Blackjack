package com.blackjack;


public class Main {

    public static void main(String[] args) {
        //Say hi to the user
        System.out.println("Welcome to Blackjack");


        //Create and start the Game by creating a new Game object!
        Game blackjack = new Game();


        Dealer myDealer = new Dealer();
        System.out.println("The dealer's name is: " + myDealer.getName());
    }
}