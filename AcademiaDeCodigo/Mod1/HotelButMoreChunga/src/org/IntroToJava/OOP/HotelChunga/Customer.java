package org.IntroToJava.OOP.HotelChunga;

public class Customer {

    private Hotel rubensHotels = new Hotel("Ruben's Hotels");
    private String name;
    private String actionName;

    public Customer(String name, String action){
        this.name = name;
        this.actionName = action;
        userActions();
    }

    private void checkIn(){
        rubensHotels.checkIn();
    }

    private void checkOut(){
    rubensHotels.checkout();
    }

    private void userActions() {
        if (actionName.equals("Check-in")) {
        checkIn();
        }

        else if(actionName.equals("Check-out")){
            checkOut();
        }
    }

}
