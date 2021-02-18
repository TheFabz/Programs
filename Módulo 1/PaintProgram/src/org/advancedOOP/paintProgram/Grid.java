package org.advancedOOP.paintProgram;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid extends Rectangle {

    private int lineSpaceY = 50;
    private int lineSpaceX = 50;
    private final Line[] linesY = new Line[this.getWidth() / lineSpaceY];
    private final Line[] linesX = new Line[this.getHeight() / lineSpaceX];

    public Grid()  {
        super(10, 10, 1500, 900);
        this.setColor(Color.BLACK);
        this.draw();
        drawLines();
    }

    public void drawLines() {
        for (int i = 0; i < linesY.length; i++) {
            linesY[i] = new Line(lineSpaceY + this.getX(), this.getY(), lineSpaceY + this.getX(), this.getHeight() + this.getY());
            linesY[i].setColor(Color.BLACK);
            linesY[i].draw();
            lineSpaceY += 50;
        }
        for (int i = 0; i < linesX.length; i++) {
            linesX[i] = new Line(this.getX(), lineSpaceX + this.getY(), this.getWidth() + this.getX(), lineSpaceX + this.getY());
            linesX[i].setColor(Color.BLACK);
            linesX[i].draw();
            lineSpaceX += 50;
        }
    }

}




