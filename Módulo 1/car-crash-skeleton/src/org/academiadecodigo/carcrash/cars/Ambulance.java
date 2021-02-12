package org.academiadecodigo.carcrash.cars;

public class Ambulance extends Car{

    public void fix(Car car1, Car car2){
        car1.crash = false;
        car2.crash = false;
    }

    @Override
    public String toString() {
        return "Ambulance";

    }

}

