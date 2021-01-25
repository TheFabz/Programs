package org.academiadecodigo.bootcamp56.BankProject;

public class Bank {

    private float balance = 0;
    private String bankPW;
    private String attemptedPassword;
    public static boolean isPasswordCorrect = false;

    public Bank() {
        String bankPW = "";
        String attemptedPassword = "";

    }

    public float giveBalance() {
        return balance;
    }

    public void receiveDeposit(float sum) {
        balance += sum;
    }

    public void performWithdrawal(float sum) {
        if (balance - sum >= 0) {
            balance -= sum;
        } else {
            System.out.println("You have insufficient funds.");
        }
    }

    public void confirmPassword() {
            this.bankPW = User.getPw();
            this.attemptedPassword = User.getEnteredPw();

            if (bankPW.equals(attemptedPassword)) {
                System.out.println("Password is correct.");
                isPasswordCorrect = true;
            } else {
                System.out.println("You have entered the wrong password.");
            }
    }
}