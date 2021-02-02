package JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies;

import JavaIntro.AdvancedOOP.SniperGame.GameObject.GameObjectAbstract;

public abstract class EnemyAbstract extends GameObjectAbstract {

    private int health;
    private boolean isDead;

    public EnemyAbstract(){
        isDead = false;
        health = 100;
    }

    public int getHealth() {
        return health;
    }

    public int setHealth(int health){
    this.health = health;
    return health;
    }

    public boolean checkIfDead(){

        if(health > 0){
            isDead = false;
        }

        else{
            isDead = true;
        }
        return isSoldierDead();

    }

    public boolean isSoldierDead(){
        return isDead;
    }

    public void healthAfterHit(int damageTaken){

        health = health - damageTaken;

    }


}
