package JavaIntro.AdvancedOOP.SniperGame;

import JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies.ArmouredEnemyFighter;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies.EnemyAbstract;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.Enemies.EnemyFighter;
import JavaIntro.AdvancedOOP.SniperGame.GameObject.GameObjectAbstract;

public class Game {

    private GameObjectAbstract[] gameObjects;
    private int gameObjectsAmount;
    private int shotsFired;
    private int enemyCount;
    private Sniper sniper = new Sniper();

    public Game(int objectCount) {
        this.gameObjectsAmount = objectCount;
    }

    private void sendObjectsToGame() {
        gameObjects = new GameObjectAbstract[gameObjectsAmount];

        for (int i = 0; i < gameObjectsAmount; i++) {
            gameObjects[i] = new ObjectFactory().GameObjectFactory();
        }
    }

    public void start() {
        sendObjectsToGame();

        for (int i = 0; i < gameObjectsAmount; i++) {

            if (gameObjects[i] instanceof Shootable) {
                enemyCount++;
                while (!((Shootable) gameObjects[i]).isDestroyed()) {
                    shotsFired++;
                    System.out.println("\nEnemy #" + (enemyCount));
                    gameObjects[i].printMessage();
                    ((Shootable) gameObjects[i]).healthAfterHit(sniper.shoot());
                    System.out.println("Enemy health is: " + ((Shootable) gameObjects[i]).getHealth());
                }
            }
        }
        System.out.println("\nThe total number of shots was: " + shotsFired);
    }

}





