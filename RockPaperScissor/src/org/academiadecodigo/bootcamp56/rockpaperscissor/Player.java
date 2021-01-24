package org.academiadecodigo.bootcamp56.rockpaperscissor;

import java.util.Scanner;

public class Player {

    private String chosenHand;

    Scanner userInput = new Scanner(System.in);

    public String chooseHand(){

        while(chosenHand != "a" || chosenHand != "b" || chosenHand != "c" ) {

            System.out.println("\nChoose one of the following:\na)Rock\nb)Paper\nc)Scissors");

            this.chosenHand = userInput.nextLine();

            if (chosenHand.equals("a")) {
                break;
            }
            if (chosenHand.equals("b")) {
                break;
            }
            if (chosenHand.equals("c")) {
                break;
            } else {
                System.out.println("invalid choice, try again.");
            }

        }
    return chosenHand;
    }

    public String defineHand(){

        chooseHand();
        String playerHand;

        if (chosenHand.equals("a")){
             playerHand = "Rock";
            return playerHand;
        }
        else if (chosenHand.equals("b")){
            playerHand = "Paper";
            return playerHand;
        }
        else{
            playerHand = "Scissor";
            return playerHand;
        }

    }

}
