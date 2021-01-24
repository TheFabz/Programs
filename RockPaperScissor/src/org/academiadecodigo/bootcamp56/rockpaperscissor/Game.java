package org.academiadecodigo.bootcamp56.rockpaperscissor;

import java.util.Scanner;

public class Game {

    String gameMode;
    String players_hand;
    String cpu_hand;
    int p1Wins;
    int p2Wins;
    private int gamesCount = 0;
    boolean isGameModeSelected = false;

    Scanner menuSelectionInput = new Scanner(System.in);

    Player player1 = new Player();

    public void startGame(){
        defineGameType();
    }

    public void defineGameType() {

        while (!isGameModeSelected) {

            System.out.println("Please choose a game type or quit:\n\n1) Player VS CPU \n2) CPU VS CPU \nQ) Quit\n");

            gameMode = menuSelectionInput.nextLine();

            if (gameMode.equals("1")){
                System.out.println("\nYou've chosen player VS CPU.");
                isGameModeSelected = true;
                gameSet(gameMode);
            } if (gameMode.equals("2")){
                System.out.println("\nYou've chosen CPU VS CPU.");
                isGameModeSelected = true;
                gameSet(gameMode);
            } if (gameMode.equals("q") || gameMode.equals("Q")){
                System.out.println("\nSee you next time!");
                isGameModeSelected = true;
            } else{
                startGame();
            }
        }
    }

    public void gameSet(String gameMode){

        while(gamesCount != 3) {

            gamesCount++;

            if (gameMode.equals("1")) {
                players_hand = player1.defineHand();
                cpu_hand = Random.cpuHand();
                gameRules();
            }

            if(gameMode.equals("2")) {
                players_hand = Random.cpuHand();
                cpu_hand = Random.cpuHand();
                gameRules();
            }

            System.out.println("\nPlayer 1: " + p1Wins + "\n" + "Player 2: " + p2Wins);
            System.out.println("\n______________________");

        }

        if (p1Wins < p2Wins){
            System.out.println("\nPlayer 2 is victorious!");
        }
        if(p1Wins > p2Wins){
            System.out.println("\nPlayer 1 is victorious!");
        }
        if(p1Wins == p2Wins){
            System.out.println("\nIt's a draw!");
        }

    }

    public void gameRules(){

        if (players_hand.equals("Rock") && cpu_hand.equals("Scissor")) {
            victoryMessage("Player1 Wins");
            p1Wins++;
        }

        if (players_hand.equals("Paper") && cpu_hand.equals("Rock")) {
            victoryMessage("Player1 Wins");
            p1Wins++;
        }

        if (players_hand.equals("Scissor") && cpu_hand.equals("Paper")) {
            victoryMessage("Player1 Wins");
            p1Wins++;
        }

        if (players_hand.equals("Rock") && cpu_hand.equals("Paper")) {
            victoryMessage("Player2 Wins");
            p2Wins++;
        }

        if (players_hand.equals("Paper") && cpu_hand.equals("Scissor")) {
            victoryMessage("Player2 Wins");
            p2Wins++;
        }

        if (players_hand.equals("Scissor") && cpu_hand.equals("Rock")) {
            victoryMessage("Player2 Wins");
            p2Wins++;
        }
        if (players_hand.equals(cpu_hand)) {
            victoryMessage("It's a draw");
        }
    }

    public void victoryMessage(String name){
        System.out.println("\n______________________");
        System.out.println("\n" + name);

    }
}
