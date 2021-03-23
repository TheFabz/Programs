package AdvancedOOP.AcademiaDeCodigo.PongGame;

import AdvancedOOP.AcademiaDeCodigo.PongGame.PlayerAbstract.Player1;
import AdvancedOOP.AcademiaDeCodigo.PongGame.PlayerAbstract.Player2;
import AdvancedOOP.AcademiaDeCodigo.PongGame.PlayerAbstract.PlayerAbstract;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Game {

    private int scoreP1;
    private int scoreP2;
    public Player1 player1 = new Player1();
    public Player2 player2 = new Player2();
    public Ball ball;
    public Ball ball2;


    public void start() throws InterruptedException {
        Rectangle canvas = new Rectangle(10,10,1000,800);
        canvas.draw();

        ball = new Ball(30);

        player1 = new Player1();
        player2 = new Player2();

        ball2 = new Ball(60);


    }

    public void collissionDetection(){

    }

}
