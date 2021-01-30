package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.Ambulance;
import org.academiadecodigo.carcrash.cars.AmbulanceKiller;
import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarFactory;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

import javax.swing.event.AncestorEvent;

public class Game {


    public static final int MANUFACTURED_CARS = 10;
    public static final int MANUFACTURED_AMBULANCES = 10;
    public static final int MANUFACTURED_AMBULANCES_KILLERS = 10;
    /**
     * Container of Cars
     */
    private Car[] cars;
    private Ambulance[] ambulances;
    private AmbulanceKiller[] ambulancesKiller;


    /**
     * Animation delay
     */
    private int delay;

    public Game(int cols, int rows, int delay) {
        Field.init(cols, rows);
        this.delay = delay;
    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {
        cars = new Car[MANUFACTURED_CARS];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
        }


        ambulances = new Ambulance[MANUFACTURED_AMBULANCES];
        for (int i = 0; i < ambulances.length; i++) {
            ambulances[i] = CarFactory.getNewAmbulance();
        }

        ambulancesKiller = new AmbulanceKiller[MANUFACTURED_AMBULANCES_KILLERS];
        for (int i = 0; i < ambulancesKiller.length; i++) {
            ambulancesKiller[i] = CarFactory.getNewAmbulanceKiller();
        }

        Field.draw(cars, ambulances, ambulancesKiller);
    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {
            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();

            // Update screen
            Field.draw(cars, ambulances, ambulancesKiller);
        }

    }

    private void moveAllCars() {

        for (int i = 0; i < cars.length; i++) {

            if ((int) ((Math.random() * 2)) == 1) {
                cars[i].moveRow();
            } else {
                cars[i].moveCol();
            }

            for (int j = i + 1; j < cars.length; j++) {
                boolean crash = cars[i].checkIfCrashed(cars[j]);
                if (crash) {
                    cars[i].setCrashed();
                    cars[j].setCrashed();
                }
            }
        }

        for (int i = 0; i < ambulances.length; i++) {

            if ((int) ((Math.random() * 2)) == 1) {
                ambulances[i].moveRow();
            } else {
                ambulances[i].moveCol();
            }

            for (int j = 0; j < cars.length; j++) {
                for (int k = (j + 1); k < cars.length; k++) {
                    boolean crash = cars[j].checkIfCrashed(cars[k]);
                    boolean uncrash = ambulances[i].checkIfCrashed((cars[j]));
                    if (crash && uncrash) {
                        ambulances[i].fix(cars[j], cars[k]);
                    }
                }
            }
        }
        for (int i = 0; i < ambulancesKiller.length; i++) {

            if ((int) ((Math.random() * 2)) == 1) {
                ambulancesKiller[i].moveRow();
            } else {
                ambulancesKiller[i].moveCol();
            }
            for (int j = 0; j < ambulances.length; j++) {
                for (int k = (j + 1); k < ambulancesKiller.length; k++) {
                    boolean crash = ambulances[j].checkIfCrashed(ambulancesKiller[k]);
                    if (crash) {
                        int odds = (int) ((Math.random() * 2));

                        if(odds == 1) {
                            ambulances[j].leaveScreen();
                        }
                        else if (odds == 0){
                            ambulances[j].setCrashed();
                        }
                    }
                }
            }
        }
    }
}