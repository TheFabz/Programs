package JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies;

import JavaIntro.AdvancedOOP.SniperGame.Shootable;

public class EnemyFighter extends EnemyAbstract implements Shootable{

    //prints msg
    public void printMessage(){
        System.out.println("AIM FOCUSED, you've found a soldier ! ");
    }

}
