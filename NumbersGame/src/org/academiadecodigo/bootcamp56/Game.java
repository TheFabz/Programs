package org.academiadecodigo.bootcamp56;

public class Game {

    Player player1 = new Player();

    Player player2 = new Player();

    Random number = new Random();

    int round = 0;

public void start(){

    while (player1.playerRandomNumber(0,10) != number.gameRandomNumber(0,10) || player2.playerRandomNumber(0,10) != number.gameRandomNumber(0,10)){

        round++;

        System.out.println("\n" + "round " + round + "\n");



        number.gameRandomNumber(0,10);
        int computer_number = number.gameRandomNumber(0,10);

        player1.playerRandomNumber(0,10);
        int player1_number = player1.playerRandomNumber(0,10);

        player2.playerRandomNumber(0,10);
        int player2_number = player2.playerRandomNumber(0,10);


        System.out.println("Game's hidden number: " + computer_number);
        System.out.println("Player1's number: " + player1_number);
        System.out.println("Player2's number: " + player2_number);


        if (computer_number == player1_number){
            System.out.println("Player1 Wins!!" + "\n");
            break;
        }

        if (computer_number == player2_number){
            System.out.println("Player2 wins!!" + "\n");
            break;
        }

        else {
            System.out.println("losers..\n");
        }

    }

}

}
