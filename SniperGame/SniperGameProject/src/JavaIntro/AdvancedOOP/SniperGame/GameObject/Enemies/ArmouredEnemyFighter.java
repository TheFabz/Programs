package JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies;

public class ArmouredEnemyFighter extends EnemyAbstract {

    private int armour;

    public ArmouredEnemyFighter(){
        super();
        armour = 50;
        setHealth(100 + armour);
    }

    public void printMessage(){
        System.out.println("AIM FOCUSED, you've found an armoured soldier ! ");
    }

}
