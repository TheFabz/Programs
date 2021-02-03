package JavaIntro.AdvancedOOP.SniperGame;

import JavaIntro.AdvancedOOP.SniperGame.GameObject.Barrel;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies.ArmouredEnemyFighter;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies.EnemyFighter;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.GameObjectAbstract;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.Tree;

public class ObjectFactory {

    //randomly selects 1 of 4 obj possibilities
    public GameObjectAbstract GameObjectFactory(){

        GameObjectAbstract[] objects = {new Tree(), new EnemyFighter(), new ArmouredEnemyFighter(), new Barrel()};

        return objects[(int) ((Math.random() * 4))];
    }

}
