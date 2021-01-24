package org.academiadecodigo.bootcamp56.rockpaperscissor;

import java.util.Scanner;

public class Player {

    private int chosenHand;
    Scanner userInput;

    public Player() {
        this.chosenHand = -1;
        userInput = new Scanner(System.in);
    }

    public Hand chooseHand() {

        while (true) {

            System.out.println("\nChoose one of the following:\n0) Rock\n1) Paper\n2) Scissors");

            this.chosenHand = userInput.nextInt();

            if (chosenHand == 0) {
                break;
            } else if (chosenHand == 1) {
                break;
            } else if (chosenHand == 2) {
                break;
            } else {
                System.out.println("invalid choice, try again.");
            }
        }
        return Hand.fromIntToHand(chosenHand);
    }
}

