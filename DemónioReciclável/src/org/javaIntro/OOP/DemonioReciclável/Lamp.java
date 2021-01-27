package org.javaIntro.OOP.DemonioReciclável;

public class Lamp {

    private int defineGenieNumber;
    private int rubCount = 0;
    private int rechargeCount = 0;

    //set number of genie when instanced;
    public Lamp (int genieNum){
        this.defineGenieNumber = genieNum;
    }

    //releases genie;
    public Genie rub(int wishesRequest,int wishesMax) {
        rubCount++;
            //generate Friendly Genie
            if (rubCount % 2 == 0) {
                FriendlyGenie friendlyGenie = new FriendlyGenie(wishesRequest, wishesMax);
                return friendlyGenie;
            }

            //generate Demon
            else if (defineGenieNumber / rubCount == 1) {
                DemonGenie demonGenie = new DemonGenie(wishesRequest, wishesMax);
                return demonGenie;
            }

            //generate Grumpy Genie
            else {
                GrumpyGenie grumpyGenie = new GrumpyGenie(wishesRequest, wishesMax);
                return grumpyGenie;
            }
        }

    public void recharge(){
        rechargeCount++;
        rubCount = 0;
        DemonGenie demonGenie = new DemonGenie(1,1);
        demonGenie.recycle();
        demonGenie.grantWishes();

    }

    public int getRechargeCount(){
        return rechargeCount;
    }


}
