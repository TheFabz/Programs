package org.Javaintro.hotelSim;
import java.util.Scanner;

public class Customer {

    private String name;
    private String choice;
    private boolean optionIsChosen = false;
    private boolean isAvailabilityChecked = false;
    private boolean isReservationMade = false;
    private Scanner customerNameInput = new Scanner(System.in);
    private Scanner customerOption = new Scanner(System.in);
    private Hotel rubensHotels = new Hotel("Ruben's Hotels");


    public Customer() {
        System.out.println("Please enter your name to begin.");
        name = customerNameInput.nextLine();
        customerActions();
    }

    public void makeReservation() {
        rubensHotels.checkIn();
        customerActions();

    }

    public void checkReservation() {
        rubensHotels.confirmAvailability();
    }

    public void checkOut(){
    rubensHotels.checkout();
    customerActions();
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
                    isReservationMade = true;
                    makeReservation();
                }
                else if (!isAvailabilityChecked){
                    System.out.println("Please check availability first.");
                    customerActions();
                }
                else {
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



