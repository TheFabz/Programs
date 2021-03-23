package org.javaIntro.OOP.DemonioReciclável;

public class Main {

    public static void main(String[] args) {


        int lamp1WishesRequest = 3;
        int lamp1WishesMax = 10;
        int lamp1GenieAmount = 3;
        Genie[] lamp1ArrayOfGenies = new Genie[lamp1GenieAmount];
        Lamp lamp1 = new Lamp(lamp1GenieAmount);


            for (int i = 0; i < lamp1GenieAmount; i++) {
                lamp1ArrayOfGenies[i] = lamp1.rub(lamp1WishesRequest , lamp1WishesMax);
            }

//            for (int i = 0; i < lamp1GenieAmount; i++) {
//                lamp1ArrayOfGenies[i].grantWishes();
//            }

            lamp1.recharge();

//----------------------------------------------------------------------------------------------------------------------

        int lamp2WishesRequest = 3;
        int lamp2WishesMax = 10;
        int lamp2GenieAmount = 3;
        Genie[] lamp2ArrayOfGenies = new Genie[lamp2GenieAmount];
        Lamp lamp2 = new Lamp(lamp2GenieAmount);


        for (int i = 0; i < lamp2GenieAmount; i++) {
            lamp2ArrayOfGenies[i] = lamp2.rub(lamp2WishesRequest , lamp2WishesMax);
        }

//        for (int i = 0; i < lamp2GenieAmount; i++) {
//           lamp2ArrayOfGenies[i].grantWishes();
//        }

        lamp2.recharge();

//----------------------------------------------------------------------------------------------------------------------

        System.out.println(lamp1.getRechargeCount());
        System.out.println(lamp2.getRechargeCount());




    }
}

