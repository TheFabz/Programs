package org.academiadecodigo.bootcamp56.rockpaperscissor;


public enum Hand {
    //Possible hands to play
    ROCK,
    PAPER,
    SCISSOR;

    //Allows CPU player to generate a hand by selecting one of the available index positions(0,1,2)
    public static Hand getRandomHand(){
     int randomNum = (int) ((Math.random() * 3));
     return fromIntToHand(randomNum);
    }

    //Turns int input to a hand, function will receive 0,1,2 as a valid parameter
    public static Hand fromIntToHand(int num){
        return Hand.values()[num];
    }

    //compares hands between players and decides winner. If P1 wins, return is 1, if P2 wins, return is -1 and it it's a tie, return is 0.
    public static int compare(Hand firstHand, Hand otherHand){
        if(firstHand.equals(otherHand)){
            return 0;
        }
        else if(firstHand.equals(ROCK) && otherHand.equals(SCISSOR)){
            return 1;
        }
        else if(firstHand.equals(PAPER) && otherHand.equals(ROCK)){
            return 1;
        }
        else if(firstHand.equals(SCISSOR) && otherHand.equals(PAPER)){
            return 1;
        }
        else{
            return -1;
        }
    }

}
