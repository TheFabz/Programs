package JavaIntro.AdvancedOOP.SniperGame.GameObject;

import JavaIntro.AdvancedOOP.SniperGame.Shootable;

public class Barrel extends GameObjectAbstract implements Shootable {

    private int health;
    private BarrelType barrelType;

    public Barrel(){
        super();
        this.health = barrelType.values()[((int) ((Math.random()*3)))].getBarrelHealth();
    }

    @Override
    public void printMessage() {
        System.out.println("Why are you aiming at a barrel?");
    }

    @Override
        public void healthAfterHit(int damageTaken) {
        health = health - damageTaken;
    }

    @Override
    public boolean isDestroyed(){
        if(health > 0){
            return false;
        }
        else{
            return true;
        }
    }

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

