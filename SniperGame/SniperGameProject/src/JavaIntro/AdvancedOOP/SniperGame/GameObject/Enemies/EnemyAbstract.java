package JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies;

import JavaIntro.AdvancedOOP.SniperGame.GameObject.GameObjectAbstract;
import JavaIntro.AdvancedOOP.SniperGame.isShootable;

public abstract class EnemyAbstract extends GameObjectAbstract implements isShootable {

    private int health;

    public EnemyAbstract(){
        health = 100;
    }

    public boolean isDestroyed(){
        if(health > 0){
            return false;
        } else{
            return true;
        }
    }

    public int getHealth() {
        return health;
    }

    public void healthAfterHit(int damageTaken){
        health -= damageTaken;
    }


}
