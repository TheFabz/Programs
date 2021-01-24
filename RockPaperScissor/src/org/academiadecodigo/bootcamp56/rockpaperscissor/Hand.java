package org.academiadecodigo.bootcamp56.rockpaperscissor;

public enum Hand {

    ROCK,
    PAPER,
    SCISSOR;

    public static Hand getRandomHand(){

     int randomNum = (int) ((Math.random() * 3));

     return fromIntToHand(randomNum);
    }

    public static Hand fromIntToHand(int num){

        return Hand.values()[num];
    }

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
