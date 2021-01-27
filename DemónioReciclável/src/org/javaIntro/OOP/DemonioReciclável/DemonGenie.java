package org.javaIntro.OOP.DemonioReciclável;

public class DemonGenie extends Genie{

    public int recycleCount;

    public DemonGenie(int requestedWishes,int numWishes){
        super(requestedWishes,numWishes);
    }

    public void recycle(){
        System.out.println("The demos has been asked to recycle everything");
        recycleCount++;
    }

    public int getRecycleCount(){
        return recycleCount;
    }


    @Override
    public void grantWishes() {
        if (recycleCount == 0) {
            System.out.println("Demons don't care for rules and will grant all your available wishes!");
            for (var i = 0; i < Genie.getMaxNumberOfWishes(); i++) {
                System.out.println("Wish #" + (i + 1) + " is granted. Your wish is my command!");
            }
        }
        else if( recycleCount > 0){
            System.out.println("I have been recycled.. no more wishes for you.");
        }
    }
        //Demon specifics
    }


