package AdvancedOOP.AcademiaDeCodigo.PongGame.PlayerAbstract;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerAbstract implements KeyboardHandler {

    public Rectangle player;

    public PlayerAbstract(){

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            player.translate(0,15);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            player.translate(0,-15);
        }
        if(player.getY() == 675){
            player.translate(0,-15);
        }
        if(player.getY() == 15){
            player.translate(0,15);
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
