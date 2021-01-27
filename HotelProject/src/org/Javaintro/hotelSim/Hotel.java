package org.Javaintro.hotelSim;

public class Hotel {

    public String hotelName;
    private Room room1 = new Room("Room #1");
    private Room room2 = new Room("Room #2");
    private Room room3 = new Room("Room #3");
    private Room room4 = new Room("Room #4");
    public int availableRoomCount;
    private boolean isRoom1Available = room1.getRoomState();
    private boolean isRoom2Available = room2.getRoomState();
    private boolean isRoom3Available = room3.getRoomState();
    private boolean isRoom4Available = room4.getRoomState();
    private boolean[] arrayOfRooms = {isRoom1Available, isRoom2Available, isRoom3Available, isRoom4Available};
    private boolean[] availableRooms = new boolean[4];
    private boolean[] unAvailableRooms = new boolean[4];

    //randomly provides true or false;
    private boolean getRandomState(){
        int random = (int) ((Math.random() * 2));

        if(random == 0){
            return false;
        }
        else{
            return true;
        }
    }

    //gives rooms random state, available or unavailable;
    private void giveRoomRandomState(){
        for(int i = 0; i < arrayOfRooms.length; i++){
            arrayOfRooms[i] = getRandomState();
        }
    }

    //takes hotel name as parameter and randomizes hotel instance availability.
    public Hotel(String name){
        this.hotelName = name;
        giveRoomRandomState();
    }

    //sends available rooms to array.availableRooms and unavailable rooms to array.unAvailable
    private void sortRoomByStatus(){
        for (int i = 0; i < arrayOfRooms.length; i++) {

            if (arrayOfRooms[i] == true) {
                availableRooms[i] = arrayOfRooms[i];
            } else if (arrayOfRooms[i] == false) {
                unAvailableRooms[i] = arrayOfRooms[i];
            }
        }
    }

    //Gives customer list of all rooms and their status
    public void getRoomStatus(){
        System.out.println("Rooms status:\n");

        for (int j = 0; j < availableRooms.length; j++) {
            if (availableRooms[j]) {
                availableRoomCount++;
                System.out.println((j + 1) + ") " + "Room #" + (j+1) + " is available.");
            }
            else if(!unAvailableRooms[j]) {
                System.out.println((j + 1) + ") " + "Room #" + (j+1) + " is NOT available.");
            }
        }
    }

    public void confirmAvailability() {
        sortRoomByStatus();
        getRoomStatus();
    }

    //Turns first available room unavailable
    public void checkIn() {
        for (int x = 0; x < availableRooms.length; x++) {
            if (availableRooms[x]) {
                System.out.println("Room #" + (x+1) + " is available! We are checking you in! Thanks for choosing " + hotelName + ".");
                availableRooms[x] = unAvailableRooms[x] ;
                break;
            }
            else if(!availableRooms[x]) {
                System.out.println("\nRoom #" + (x+1) + " is not available....");
            }
        }
    }

    //Reverts user chosen room back to available
    public void checkout(){
        for (int y = 0; y < unAvailableRooms.length; y++) {
            if (!unAvailableRooms[y]) {
                System.out.println("\nWe are checking you out of Room. Thanks for choosing " + hotelName+".");
                unAvailableRooms[y] = availableRooms[y];
                break;
            }
            else if(unAvailableRooms[y]) {
                System.out.println("\nTest");
            }
        }
    }


}
