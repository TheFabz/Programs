package org.academiadecodigo.bootcamp56;

public class Player {

    public int playerRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
