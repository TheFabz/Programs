package org.academiadecodigo.bootcamp56.BankProject;
import java.util.Scanner;

public class User {

    private String name;
    private static String pw;
    private static String enteredPW;
    private String userChoice;
    private Scanner userNameInput;
    private Scanner passwordInput;
    private Scanner userOption = new Scanner(System.in);
    private Scanner amount = new Scanner(System.in);
    private Bank BES = new Bank();

    public User(){
        userNameInput = new Scanner(System.in);
        passwordInput = new Scanner(System.in);
    }

    public void defineNamePWAndStart(){
        System.out.println("Please enter your name to start.");
        this.name = userNameInput.nextLine();
        System.out.println("Set your Pin:");
        this.pw = passwordInput.nextLine();
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

    public static String getPw(){
        return pw;
    }

    public static String getEnteredPw(){
        return enteredPW;
    }

    private void userActions() {

        while (true) {

            System.out.println("\nHello " + name + "! What would you like to do?\na) Check Balance\nb) Make a deposit\nc) Make a withdrawal\nQ) Quit");
            userChoice = userOption.nextLine();

            if(userChoice.equals("a")){
                while(!Bank.isPasswordCorrect){

                    System.out.println("Please enter your password to perform this action.");
                    enteredPW = passwordInput.nextLine();
                    BES.confirmPassword();
                }
                checkBalance();
                Bank.isPasswordCorrect = false;
            }
            else if(userChoice.equals("b")) {
                while (!Bank.isPasswordCorrect) {

                    System.out.println("Please enter your password to perform this action.");
                    enteredPW = passwordInput.nextLine();
                    BES.confirmPassword();
                }
                makeDeposit();
                Bank.isPasswordCorrect = false;
            }

            else if(userChoice.equals("c")) {

                while(!Bank.isPasswordCorrect){

                    System.out.println("Please enter your password to perform this action.");
                    enteredPW = passwordInput.nextLine();
                    BES.confirmPassword();
                }
                makeWithdrawal();
                Bank.isPasswordCorrect = false;
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

