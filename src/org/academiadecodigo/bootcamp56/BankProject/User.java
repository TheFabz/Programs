package org.academiadecodigo.bootcamp56.BankProject;
import java.util.Scanner;

public class User {

    public String name;
    Scanner userNameInput;
    String userChoice;
    Scanner userOption = new Scanner(System.in);
    Scanner amount = new Scanner(System.in);
    Bank BES = new Bank();

    public User(){
        userNameInput = new Scanner(System.in);
    }

    public void defineNameAndStart(){
        System.out.println("Please enter your name to start.");
        this.name = userNameInput.nextLine();
        userActions();
    }

    private void checkBalance(){
        System.out.println("Your balance is: " + BES.giveBalance()  + "€.");
    }

    private void makeDeposit(){
        System.out.println("How much would you like to deposit?");
        float sum = amount.nextFloat();
        BES.receiveDeposit(sum);
    }

    private void makeWithdrawal(){
        System.out.println("How much would you like to withdrawal?");
        float sum = amount.nextFloat();
        BES.performWithdrawal(sum);
    }

    public void userActions() {

        while (true) {

            System.out.println("\nHello " + name + "! What would you like to do?\na) Check Balance\nb) Make a deposit\nc) Make a withdrawal\nQ) Quit");
            userChoice = userOption.nextLine();

            if(userChoice.equals("a")){
                    checkBalance();
                }
            else if(userChoice.equals("b")){
                    makeDeposit();
                }
            else if(userChoice.equals("c")) {
                    makeWithdrawal();
                }
            else if (userChoice.equals("Q") || userChoice.equals("q")){
                    System.out.println("See you next time!");
                    break;
                }
            else {
                    System.out.println("Invalid option, try again.");
                }

            }
        }
    }

