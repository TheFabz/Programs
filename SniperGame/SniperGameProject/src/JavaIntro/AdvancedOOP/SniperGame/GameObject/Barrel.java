package JavaIntro.AdvancedOOP.SniperGame.GameObject;

import JavaIntro.AdvancedOOP.SniperGame.isShootable;

public class Barrel extends GameObjectAbstract implements isShootable {

    private int health;
    private boolean isDestroyed;


    public Barrel(){
        super();
        BarrelType barrel = BarrelType.getRandomBarrelType();
        switch(barrel){
            case WOOD:
                health=70;
                break;
            case METAL:
                health=150;
                break;
            case PLASTIC:
                health = 25;
            default:
                health = 100;
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

