package org.javaIntro.OOP.DemonioReciclável;

public class Genie {

    public static int maxNumberOfWishes;
    public static int wishesRequestAmount;

    public Genie(int requestedWishes,int numWishes){
        this.wishesRequestAmount = requestedWishes;
        this.maxNumberOfWishes = numWishes;
    }

    public static int getMaxNumberOfWishes(){
        return maxNumberOfWishes;
    }

    public static int getWishesRequestAmount(){
        return wishesRequestAmount;
    }

    //grants wishes;
    public void grantWishes(){

        for( var i = 0; i < wishesRequestAmount; i++){
            System.out.println("Wish #" + (i+1) + " is granted. Your wish is my command!");
        }
    }

}
