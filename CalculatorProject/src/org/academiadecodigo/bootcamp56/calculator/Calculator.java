package org.academiadecodigo.bootcamp56.calculator;

import java.sql.SQLOutput;

public class Calculator {

    public String color;
    public String brand;
    public int result;

    public int add(int number1, int number2){

        result = number1 + number2;

        return result;
    }

    public Calculator(String brand, String color){
        this.color = color;
        this.brand = brand;
    }

    public int add(int num1, int num2, int num3, int num4){

        result = num1 + num2 + num3 + num4;

        return result;
    }
}
