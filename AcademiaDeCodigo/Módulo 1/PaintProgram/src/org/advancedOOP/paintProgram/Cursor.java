package org.advancedOOP.paintProgram;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor extends Cell implements KeyboardHandler {

    private final int x;
    private final int y;

    public Cursor(int paddingX, int paddingY, int x, int y){
        super(paddingX, paddingY, x, y);
        this.x = x;
        this.y = y;
        this.setColor(Color.BLUE);
        this.fill();
        keyboardControls();
    }
    public void keyboardControls(){
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent downArrow = new KeyboardEvent();
        downArrow.setKey(KeyboardEvent.KEY_DOWN);
        downArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downArrow);

        KeyboardEvent upArrow = new KeyboardEvent();
        upArrow.setKey(KeyboardEvent.KEY_UP);
        upArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upArrow);

        KeyboardEvent rightArrow = new KeyboardEvent();
        rightArrow.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightArrow);

        KeyboardEvent leftArrow = new KeyboardEvent();
        leftArrow.setKey(KeyboardEvent.KEY_LEFT);
        leftArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftArrow);
    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            this.translate(0, y);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            this.translate(0, -y);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            this.translate(x, 0);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            this.translate(-x, 0);
        }
        if (this.getY() > 890) {
            this.translate(0, -y);
        }
        if (this.getY() < 10) {
            this.translate(0, y);
        }
        if (this.getX() > 1490) {
            this.translate(-x, 0);
        }
        if (this.getX() < 10) {
            this.translate(x, 0);
        }
        }
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

}
