package org.academiadecodigo.bootcamp56;

public class Random {

    public int gameRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
