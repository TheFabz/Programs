package org.IntroToJava.OOP.HotelChunga;

public class Hotel {

    public String hotelName;
    private boolean isRoomAvailable = true;

    public Hotel(String name){
        this.hotelName = name;
    }

    public void confirmAvailability(){
        if(isRoomAvailable){
            System.out.println("We currently have a free room. Please proceed by making a reservation.");
        }
        else if(!isRoomAvailable){
            System.out.println("There are no available rooms at this time.");
        }
    }

    public void checkIn(){
        System.out.println("\nWe are checking you in! Thanks for choosing " + hotelName);
        isRoomAvailable = false;
    }

    public void checkout(){
        System.out.println("\nWe are checking you out! Thanks for choosing " + hotelName);
        isRoomAvailable = true;
    }

}
