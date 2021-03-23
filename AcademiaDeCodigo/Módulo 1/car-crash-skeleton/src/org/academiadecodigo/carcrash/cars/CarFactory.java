package org.academiadecodigo.carcrash.cars;

public class CarFactory {

    public static  Car getNewCar() {

        Car[] cars = {new FordFiesta(), new JipeDiogo()};
        return (cars[ (int) ((Math.random() * 2))]);
        }

    public static  Ambulance getNewAmbulance() {
        return new Ambulance();
    }

    public static  AmbulanceKiller getNewAmbulanceKiller() {
        return new AmbulanceKiller();
    }

}

