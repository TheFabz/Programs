package org.academiadecodigo.bootcamp56.calculator;

public class Sandbox {

    public static void main(String[] args){

        //instancia 1
        Calculator casio = new Calculator("casio","fag red");
        //instancia 2
        Calculator texasInstr = new Calculator("texas","blue balls blue");

        casio.brand = "Casio";
        texasInstr.brand = "Texas Instruments";

        //casio.color = "Hot Pink";
        //texasInstr.color = "Fag red";

        System.out.println("The calculator is a " + casio.brand + " and it's color is " + casio.color+".");
        System.out.println("The calculator is a " + texasInstr.brand + " and it's color is " + texasInstr.color+".");



        System.out.println(casio.result);
    }
}
