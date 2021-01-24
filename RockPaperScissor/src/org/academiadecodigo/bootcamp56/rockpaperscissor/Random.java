package org.academiadecodigo.bootcamp56.rockpaperscissor;

public class Random {

    private String cpuHand;

    public static int getRandomNum() {

        return (int) ((Math.random() * 3));
    }

    public static String cpuHand(){

        String cpuHand;
        int cpuNum = getRandomNum();

        if (cpuNum == 0){
            cpuHand = "Rock";
        }
        if (cpuNum == 1){
            cpuHand = "Paper";
        }
        else{
            cpuHand = "Scissor";
        }
        return cpuHand;
    }
}
