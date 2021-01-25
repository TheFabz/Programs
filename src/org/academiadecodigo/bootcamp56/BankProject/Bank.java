package org.academiadecodigo.bootcamp56.BankProject;

public class Bank {

    public float balance = 0;

   public float giveBalance(){
       return balance;
   }

    public void receiveDeposit(float sum){
       balance += sum;
    }

    public void performWithdrawal(float sum){
       if(balance - sum >= 0) {
        balance -= sum;
       }
       else{
           System.out.println("You have insufficient funds.");
       }
    }


}
