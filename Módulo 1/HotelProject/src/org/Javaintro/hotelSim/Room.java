package org.Javaintro.hotelSim;

public class Room {

    private boolean isRoomAvailable = true;
    private String name;

    public Room(String name){
        this.name = name;
    }

    //returns room state
    public boolean getRoomState(){
        return isRoomAvailable;
    }


}
