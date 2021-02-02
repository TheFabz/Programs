package JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies;

public class ArmouredEnemyFighter extends EnemyAbstract {

    private int armour = 50;

    @Override
    public void healthAfterHit(int damageTaken){
        System.out.println("Armour health is " + armour);
            while (armour > 0){
                armour -= damageTaken;
            }
            super.healthAfterHit(damageTaken);
    }

    public void printMessage(){
        System.out.println("AIM FOCUSED, you've found an armoured soldier ! ");
    }

}
