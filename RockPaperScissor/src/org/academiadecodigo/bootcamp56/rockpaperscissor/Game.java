package org.academiadecodigo.bootcamp56.rockpaperscissor;

import java.util.Scanner;

public class Game {

    //Create CONSTRUCTOR TO DO.

    String gameMode;
    private Hand players_hand;
    private Hand cpu_hand;
    private int p1Wins;
    private int p2Wins;
    private int gamesCount = 0;
    private boolean isGameModeSelected = false;

    Scanner menuSelectionInput = new Scanner(System.in);
    Player player1 = new Player();

    // Loops menu screen until valid option is selected
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

    //Takes user input and defines game type. Random V random or player V random. Also, prints winner message.
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
            resetGame();
        }
        else if(p1Wins > p2Wins){
            System.out.println("\nPlayer 1 is victorious!");
            resetGame();
        }
        else{
            System.out.println("\nIt's a draw!");
            resetGame();
        }

    }

    public void resetGame(){
        isGameModeSelected = false;
        p1Wins= 0;
        p2Wins =0;
        gamesCount = 0;
        startGame();
    }

    //runs user hands through a compare function in hand class to find out who won.
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
