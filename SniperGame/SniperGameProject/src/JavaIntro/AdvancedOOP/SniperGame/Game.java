package JavaIntro.AdvancedOOP.SniperGame;

import JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies.ArmouredEnemyFighter;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies.EnemyAbstract;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies.EnemyFighter;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.GameObjectAbstract;

public class Game {

    GameObjectAbstract[] gameObjects;
    int gameObjectsAmount;
    int shotsFired;
    Sniper sniper = new Sniper();

    public Game(int objectCount) {
        this.gameObjectsAmount = objectCount;
    }

    public void sendObjectsToGame() {
        gameObjects = new GameObjectAbstract[gameObjectsAmount];

        for (int i = 0; i < gameObjectsAmount; i++) {
            gameObjects[i] = new ObjectFactory().GameObjectFactory();
        }
    }


    public void start() {
        sendObjectsToGame();

        for (int i = 0; i < gameObjectsAmount; i++)

            if (gameObjects[i] instanceof EnemyFighter || gameObjects[i] instanceof ArmouredEnemyFighter) {
                while (((EnemyAbstract) gameObjects[i]).checkIfDead() == false) {
                    shotsFired++;
                    System.out.println("\nEnemy #" + (i+1));
                    gameObjects[i].printMessage();
                    ((EnemyAbstract) gameObjects[i]).healthAfterHit(sniper.shoot());
                    System.out.println("Enemy health is: ");
                    System.out.println(((EnemyAbstract) gameObjects[i]).getHealth());
                }
                System.out.println("The total number of shots was: " + shotsFired);
            }
        }


}





