package org.Javaintro.hotelSim;

public class Room {

    private boolean isRoomAvailable = true;
    private String name;

    public Room(String name){
        this.name = name;
    }

    public boolean getRoomState(){
        return isRoomAvailable;
    }


}
