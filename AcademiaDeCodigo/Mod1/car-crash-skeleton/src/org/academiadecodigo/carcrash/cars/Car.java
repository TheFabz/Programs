package org.academiadecodigo.carcrash.cars;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

abstract  public class Car {

    public boolean crash;
    public boolean crashWithAmbulanceKiller;
    private boolean hasReachedEnd;
    private boolean hasReachedBottom;
    private int fieldWidth = Field.getWidth() -1;
    private int fieldHeight = Field.getHeight() -1;

    public Car(){
        crash = false;
        crashWithAmbulanceKiller = false;
        pos = new Position();

    }

    /** The position of the car on the grid */
    private Position pos;


    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return crash;
    }

    public void setCrashed() {
        crash = true;
    }

    public void leaveScreen(){
        crashWithAmbulanceKiller = true;
    }

    public void moveCol(){

        int carCol = this.getPos().getCol();

        if(!crash && !crashWithAmbulanceKiller) {

            if (!hasReachedEnd && carCol < fieldWidth) {
                pos.incrementCol();
            }
            else if (carCol == fieldWidth) {
                hasReachedEnd = true;
                pos.decrementCol();
            }
            else if (hasReachedEnd && carCol == 0) {
                hasReachedEnd = false;
                pos.incrementCol();
            }
            else{
                pos.decrementCol();
            }
        }

        if(crashWithAmbulanceKiller){
            pos.incrementColSpeed();
        }

        if(crash){

        }

    }

    public void moveRow(){

        int carRow = this.getPos().getRow();

        if(!crash) {
            if (!hasReachedBottom && carRow < fieldHeight) {
                pos.incrementRow();
            } else if (carRow == fieldHeight) {
                hasReachedBottom = true;
                pos.decrementRow();
            } else if (hasReachedBottom && carRow == 0) {
                hasReachedBottom = false;
                pos.incrementRow();
            } else {
                pos.decrementRow();
            }
        }
        if(crash){

        }
    }

    public boolean checkIfCrashed(Car otherCar){

        return otherCar.getPos().getRow() == this.getPos().getRow() && otherCar.getPos().getCol() == this.getPos().getCol();

        }



    @Override
    public String toString(){
        return "Car";
    }

}
