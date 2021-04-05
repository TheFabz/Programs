package org.advancedOOP.paintProgram;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyBoardManager implements KeyboardHandler {


    public KeyBoardManager(){ keyboardControls(); }

    public void keyboardControls() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent spaceBar = new KeyboardEvent();
        spaceBar.setKey(KeyboardEvent.KEY_SPACE);
        spaceBar.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceBar);

        KeyboardEvent key1 = new KeyboardEvent();
        key1.setKey(KeyboardEvent.KEY_1);
        key1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key1);

        KeyboardEvent key2 = new KeyboardEvent();
        key2.setKey(KeyboardEvent.KEY_2);
        key2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key2);

        KeyboardEvent key3 = new KeyboardEvent();
        key3.setKey(KeyboardEvent.KEY_3);
        key3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key3);

        KeyboardEvent key4 = new KeyboardEvent();
        key4.setKey(KeyboardEvent.KEY_4);
        key4.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key4);

        KeyboardEvent key5 = new KeyboardEvent();
        key5.setKey(KeyboardEvent.KEY_5);
        key5.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key5);

        KeyboardEvent key6 = new KeyboardEvent();
        key6.setKey(KeyboardEvent.KEY_6);
        key6.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key6);

        KeyboardEvent key7 = new KeyboardEvent();
        key7.setKey(KeyboardEvent.KEY_7);
        key7.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key7);

        KeyboardEvent key8 = new KeyboardEvent();
        key8.setKey(KeyboardEvent.KEY_8);
        key8.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key8);

        KeyboardEvent key9 = new KeyboardEvent();
        key9.setKey(KeyboardEvent.KEY_9);
        key9.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key9);

        KeyboardEvent key0 = new KeyboardEvent();
        key0.setKey(KeyboardEvent.KEY_0);
        key0.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key0);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(clear);

        KeyboardEvent close = new KeyboardEvent();
        close.setKey(KeyboardEvent.KEY_Q);
        close.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(close);

        KeyboardEvent test = new KeyboardEvent();
        test.setKey(KeyboardEvent.KEY_T);
        test.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(test);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) { }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

}
