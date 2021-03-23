package org.Javaintro.hotelSim;
import java.util.Scanner;

public class Customer {

    private String name;
    private String choice;
    private boolean optionIsChosen = false;
    private boolean isAvailabilityChecked = false;
    private boolean isReservationMade;
    private boolean reservationAvailable;
    private Scanner customerNameInput = new Scanner(System.in);
    private Scanner customerOption = new Scanner(System.in);
    private Hotel rubensHotels = new Hotel("Ruben's Hotels");

    //sets user's name
    public Customer() {
        System.out.println("Please enter your name to begin.");
        name = customerNameInput.nextLine();
        customerActions();
    }

    //Checks user in to first available room.
    private void makeReservation() {
        rubensHotels.checkIn();
        customerActions();

    }

    public void checkOut(){
        rubensHotels.checkout();
        customerActions();
    }

    //Gives user list of all runs and their status
    private void checkReservation() {
        rubensHotels.confirmAvailability();
    }

    private void isReservationAvailable(){
        if(rubensHotels.availableRoomCount > 0){
            reservationAvailable = true;
        }
        else{
            reservationAvailable = false;
        }
    }

    public void customerActions() {
        System.out.println("\n" + name + "! Please select one of the following: \n\na) Check availability\nb) Make reservation\nc) Checkout\nQ) Quit");

        while (!optionIsChosen) {

            choice = customerOption.nextLine();

            if (choice.equals("a")) {

                if (!isReservationMade) {
                    System.out.println("We are checking availability, please hold.\n");
                    isAvailabilityChecked = true;
                    checkReservation();
                    customerActions();
                }
                else{
                    System.out.println("You already have a reservation.");
                    rubensHotels.getRoomStatus();
                    customerActions();
                }
            }
            else if (choice.equals("b")) {

                if(isAvailabilityChecked && !isReservationMade) {
                    System.out.println("We are making a reservation, please hold.");
                    isReservationAvailable();
                    if(reservationAvailable) {
                        isReservationMade = true;
                        makeReservation();
                    }
                    else if(!reservationAvailable){
                        System.out.println("No reservations available. Try again later.");
                        customerActions();
                    }
                }

                else if (!isAvailabilityChecked){
                    System.out.println("Please check availability first.");
                    customerActions();
                }
                else if (isAvailabilityChecked && isReservationMade){
                    System.out.println("You already have a reservation.");
                    customerActions();
                }
            }
            else if (choice.equals("c")){

                if(!isReservationMade) {
                    System.out.println("You must first make a reservation");
                    customerActions();
                }
                else {
                    isAvailabilityChecked = false;
                    isReservationMade = false;
                    checkOut();
                }
            }
            else if(choice.equals("Q")){
                System.out.println("Quitting..\nGoodbye!");
                optionIsChosen = true;
            }
            else{
                System.out.println("Please select a valid option.");
                customerActions();
            }
        }
    }


}



