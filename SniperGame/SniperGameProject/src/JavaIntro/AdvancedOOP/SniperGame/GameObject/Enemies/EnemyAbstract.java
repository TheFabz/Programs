package JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies;

import JavaIntro.AdvancedOOP.SniperGame.GameObject.GameObjectAbstract;
import JavaIntro.AdvancedOOP.SniperGame.Shootable;

public abstract class EnemyAbstract extends GameObjectAbstract implements Shootable {

    private int health;

    public EnemyAbstract(){
        health = 100;
    }

    //checks on enemy health
    public boolean isDestroyed(){
        if(health > 0){

            return false;
        } else{

            return true;
        }
    }

    //returns current health and returns 0 if health is a negative number
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

    //subtracts health points
    public void healthAfterHit(int damageTaken){
        health -= damageTaken;
    }

}
