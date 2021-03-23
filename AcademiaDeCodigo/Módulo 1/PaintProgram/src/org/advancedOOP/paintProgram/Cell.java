package org.advancedOOP.paintProgram;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell extends Rectangle {

    private boolean isColored;

    public Cell(int paddingX, int paddingY, int x, int y) {
        super(paddingX, paddingY, x, y);
        setColor(Color.BLUE);
    }

    public void setColored(boolean setter){
        this.isColored = setter;
    }

    public boolean getIsColored(){
        return isColored;
    }


}
