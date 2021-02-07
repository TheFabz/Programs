package AdvancedOOP.AcademiaDeCodigo.PongGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.EventListener;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Ball {

    private boolean hasReachedEnd;
    private boolean hasReachedTop;
    private boolean isGameOver;
    private final Ellipse ball;
    private int player1Score;
    private int player2Score;
    private String p1ScoreMessage = "Score Player1: " + player1Score;
    private String p2ScoreMessage = "Score Player2: " + player2Score;

    private final Text score1 = new Text(15,10, p1ScoreMessage);
    private final Text score2 = new Text(890,10,p2ScoreMessage);

    public Ball() throws InterruptedException {
        ball = new Ellipse(500,345,55,55);
        ball.setColor(Color.BLACK);
        ball.fill();
        ball.draw();
        move();
        score1.draw();
        score2.draw();
    }

    public void incrementX(){
        ball.translate(1, 0);
    }
    public void decrementX(){
        ball.translate(-1, 0);
    }
    public void incrementY(){
        ball.translate(0, 1);
    }
    public void decrementY(){
        ball.translate(0, -1);
    }

    public void move() throws InterruptedException {

        int gameTotalScore = 0;

        while(gameTotalScore < 10) {

            gameTotalScore = player1Score + player2Score;

            TimeUnit.MILLISECONDS.sleep(1);

            if (!hasReachedEnd && ball.getX() < 950) {
                incrementX();
            } else if (ball.getX() == 950) {
                hasReachedEnd = true;
                decrementX();
            } else if (hasReachedEnd && ball.getX() == 10) {
                hasReachedEnd = false;
                incrementX();
            } else {
                decrementX();
            }

            if (!hasReachedTop && ball.getY() < 750) {
                incrementY();
            } else if (ball.getY() == 750) {
                player1Score++;
                hasReachedTop = true;
                decrementY();
            } else if (hasReachedTop && ball.getY() == 10) {
                player2Score++;
                hasReachedTop = false;
                incrementY();
            } else {
                decrementY();
            }
        }

    }




}
