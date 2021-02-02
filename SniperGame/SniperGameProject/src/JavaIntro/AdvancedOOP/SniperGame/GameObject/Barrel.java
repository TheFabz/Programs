package JavaIntro.AdvancedOOP.SniperGame.GameObject;

import JavaIntro.AdvancedOOP.SniperGame.isShootable;

public class Barrel extends GameObjectAbstract implements isShootable {

    private int health;

    public Barrel(){
        super();

        BarrelType barrel = BarrelType.getRandomBarrelType();

        switch(barrel){
            case WOOD:
                this.health=70;
                break;
            case METAL:
                this.health=150;
                break;
            case PLASTIC:
                this.health = 25;
                break;
            default:
                this.health = 100;
        }

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
        } else{
            return true;
        }
    }

    @Override
    public int getHealth() {
        return health;
    }


}

