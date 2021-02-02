package JavaIntro.AdvancedOOP.SniperGame;

import JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies.ArmouredEnemyFighter;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies.EnemyAbstract;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies.EnemyFighter;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.GameObjectAbstract;

public class Game {

    GameObjectAbstract[] gameObjects;
    int gameObjectsAmount;
    int shotsFired;
    int enemyCount;
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

            if (gameObjects[i] instanceof isShootable) {
                enemyCount++;
                while ( !((isShootable) gameObjects[i]).isDestroyed() )  {
                    shotsFired++;
                    System.out.println("\nEnemy #" + (enemyCount));
                    gameObjects[i].printMessage();
                    ((isShootable) gameObjects[i]).healthAfterHit(sniper.shoot());
                    System.out.println("Enemy health is: " + ((isShootable) gameObjects[i]).getHealth());
                }
            }
        System.out.println("\nThe total number of shots was: " + shotsFired);
        }

}





