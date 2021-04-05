package org.javaIntro.OOP.DemonioReciclável;

public class FriendlyGenie extends Genie {

    public FriendlyGenie(int requestedWishes, int numWishes){
        super(requestedWishes,numWishes);
    }

    @Override
    public void grantWishes() {
        System.out.println("I am a friendly genie and will grant your requested wishes.");
        for( var i = 0; i < Genie.getWishesRequestAmount(); i++){
            System.out.println("Wish #" + (i+1) + " is granted. Your wish is my command!");
        }
    }

}
