package AdvancedOOP.AcademiaDeCodigo.PongGame.PlayerAbstract;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Player2 extends PlayerAbstract{

    public Player2(){
        this.player = new Rectangle(960,345,40,140);
        player.setColor(Color.BLACK);
        player.draw();
        player.fill();

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent downArrow = new KeyboardEvent();
        downArrow.setKey(KeyboardEvent.KEY_X);
        downArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downArrow);

        KeyboardEvent upArrow = new KeyboardEvent();
        upArrow.setKey(KeyboardEvent.KEY_Z);
        upArrow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upArrow);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_X){
            player.translate(0,15);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_Z){
            player.translate(0,-15);
        }
        if(player.getY() == 675){
            player.translate(0,-15);
        }
        if(player.getY() == 15){
            player.translate(0,15);
        }

    }

}


