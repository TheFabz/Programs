package org.javaIntro.OOP.DemonioReciclável;

public class GrumpyGenie extends Genie {

    public GrumpyGenie(int requestedWishes,int numWishes) {
        super(requestedWishes,numWishes);
    }

    @Override
    public void grantWishes() {
        System.out.println("You only get one wish because you are human scum!");
    }

}
