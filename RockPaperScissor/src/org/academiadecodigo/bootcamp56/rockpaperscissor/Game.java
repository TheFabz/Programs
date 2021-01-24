package org.academiadecodigo.bootcamp56.rockpaperscissor;

import java.util.Scanner;

public class Game {

    //Create CONSTRUCTOR;

    String gameMode;
    Hand players_hand;
    Hand cpu_hand;
    int p1Wins;
    int p2Wins;
    private int gamesCount = 0;
    boolean isGameModeSelected = false;

    Scanner menuSelectionInput = new Scanner(System.in);

    Player player1 = new Player();

    public void startGame() {

        while (!isGameModeSelected) {

            System.out.println("Please choose a game type or quit:\n\n1) Player VS CPU \n2) CPU VS CPU \nQ) Quit\n");

            gameMode = menuSelectionInput.nextLine();

            if (gameMode.equals("1")){
                System.out.println("\nYou've chosen player VS CPU.");
                isGameModeSelected = true;
                gameSet(gameMode);
            }
            else if (gameMode.equals("2")){
                System.out.println("\nYou've chosen CPU VS CPU.");
                isGameModeSelected = true;
                gameSet(gameMode);
            }
            else if (gameMode.equals("q") || gameMode.equals("Q")){
                System.out.println("\nSee you next time!");
                isGameModeSelected = true;
            }
            else{
                System.out.println("Invalid entry");

            }
        }

    }

    public void gameSet(String gameMode){

        while(gamesCount != 3) {

            gamesCount++;

            if (gameMode.equals("1")) {
                players_hand = player1.chooseHand();
                cpu_hand = Hand.getRandomHand();
                gameRules();
            }

            if(gameMode.equals("2")) {
                players_hand = Hand.getRandomHand();
                cpu_hand = Hand.getRandomHand();
                gameRules();
            }

            System.out.println("\nPlayer 1: " + p1Wins + "\n" + "Player 2: " + p2Wins);
            System.out.println("\n______________________");

        }

        if (p1Wins < p2Wins){
            System.out.println("\nPlayer 2 is victorious!");
            isGameModeSelected = false;
            startGame();
        }
        else if(p1Wins > p2Wins){
            System.out.println("\nPlayer 1 is victorious!");
            isGameModeSelected = false;
            startGame();
        }
        else{
            System.out.println("\nIt's a draw!");
            isGameModeSelected = false;
            startGame();
        }

    }

    public void gameRules(){

        if (Hand.compare(players_hand, cpu_hand) > 0){
            victoryMessage("Player1 Wins");
            p1Wins++;
        }
        else if(Hand.compare(players_hand,cpu_hand) < 0){
            victoryMessage("Player2 Wins");
            p2Wins++;
        }
        else{
            victoryMessage("It's a draw");
        }

    }

    public void victoryMessage(String name){
        System.out.println("\n______________________");
        System.out.println("\n" + name);
    }

}
