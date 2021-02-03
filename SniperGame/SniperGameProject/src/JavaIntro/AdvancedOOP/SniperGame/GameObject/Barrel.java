package JavaIntro.AdvancedOOP.SniperGame.GameObject;

import JavaIntro.AdvancedOOP.SniperGame.Shootable;

public class Barrel extends GameObjectAbstract implements Shootable {

    private int health;

    //Gets a random barrel type (plastic, wood, metal) each of these has different health point amounts.
    public Barrel(){
        super();
        this.health = BarrelType.values()[((int) ((Math.random()*3)))].getBarrelHealth();
    }

    //prints msg
    @Override
    public void printMessage() {
        System.out.println("Why are you aiming at a barrel?");
    }

    //subtracts health points
    @Override
    public void healthAfterHit(int damageTaken) {
        health -= damageTaken;
    }

    //checks on barrel health
    @Override
    public boolean isDestroyed(){
        if(health > 0){
            return false;
        }
        else{
            return true;
        }
    }

    //returns current health and returns 0 if health is a negative number
    @Override
    public int getHealth() {
        if(health > 0) {
            return health;
        }
        else if(health <= 0){
            health =0;
            return health;
        }
        else{
            return health;
        }
    }


}

