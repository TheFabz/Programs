package org.academiadecodigo.forcau.forcaugraphicclient;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Graphic {

    KeyboardController keyboard;
    private ClientListener clientListener;
    private ClientWriter clientWriter;
    Console console;
    TextBox userInputBox;
    private int wrongGuessCounter;
    WordField wordField;

    public Graphic(int numOfCharacters) {

        buildMainCanvas();

        buildGallows();

        this.keyboard = new KeyboardController(this);

        userInputBox = new TextBox(550, 600, 350, 40, "");

        TextBox userSpaceSenderBox = new TextBox(550, 650, 350, 40, "Send: SPACEBAR / Erase: LEFT ARROW");
        userSpaceSenderBox.drawChar();

        console = new Console();

        wordField = new WordField(numOfCharacters);
        wordField.buildBottomWord();

        wrongGuessCounter = 0;

    }

    public void setClientWriter(ClientWriter clientWriter) {
        if (clientWriter != null) {
            this.clientWriter = clientWriter;
            clientWriter.setUserInputBox(userInputBox);
        }
        clientWriter.setGraphicsHandler(this);
    }

    public void setClientReader(ClientListener clientListener) {
        if (clientWriter != null) {
            this.clientListener = clientListener;
        }
        clientListener.setGraphicsHandler(this);
    }

    public void sendClientMessage() {
        clientWriter.sendMessage();
    }

    public void appendCharToString(String message) {
        clientWriter.buildMessageString(message);
    }

    public void eraseMessageChar() {
        clientWriter.eraseCharFromString();
    }

    public void newMessageToConsole(String message) {
        console.buildTextBox(message);
    }

    public void hangingPartsSchedule() {

        switch (wrongGuessCounter) {
            case 0:
                buildHead();
                break;
            case 1:
                buildLeftBody();
                break;
            case 2:
                buildRightBody();
                break;
            case 3:
                buildLeftArm();
                break;
            case 4:
                buildRightArm();
                break;
            case 5:
                buildLeftLeg();
                break;
            case 6:
                buildPicinha();
                break;
            case 7:
                buildRightLeg();
                break;
            default:
                break;
        }

        wrongGuessCounter++;
    }

    private void buildMainCanvas() {

        Picture mainCanvas = new Picture(10, 10, "resources/landscape.png");
        mainCanvas.draw();

    }

    private void buildGallows() {

        Picture gallows = new Picture(10, 10, "resources/gallows.png");
        gallows.draw();
    }

    private void buildHead() {

        int random = (int) (Math.random() * 4);
        String caroca;

        switch (random) {
            case 0:
                caroca = "resources/paulo.png";
                break;
            case 1:
                caroca = "resources/ricardo.png";
                break;
            case 2:
                caroca = "resources/sara.png";
                break;
            default:
                caroca = "resources/vando.png";
                break;
        }

        Picture head = new Picture(-65, -30, caroca);
        head.grow(-140, -140);
        head.draw();
    }

    private void buildLeftBody() {

        Text leftBody = new Text(170, 320, "{");
        leftBody.grow(20, 80);
        leftBody.draw();
    }

    private void buildRightBody() {

        Text rightBody = new Text(220, 320, "}");
        rightBody.grow(20, 80);
        rightBody.draw();
    }

    private void buildLeftArm() {

        Text leftArm = new Text(140, 330, "/");
        leftArm.grow(15, 80);
        leftArm.draw();
    }

    private void buildRightArm() {

        Text RightArm = new Text(250, 330, "\\");
        RightArm.grow(15, 80);
        RightArm.draw();
    }

    private void buildLeftLeg() {

        Text leftLeg = new Text(170, 450, "(");
        leftLeg.grow(15, 80);
        leftLeg.draw();
    }

    private void buildPicinha() {

        Text mainMember = new Text(195, 405, "'|'");
        mainMember.grow(10, 10);
        mainMember.setColor(Color.PINK);
        mainMember.draw();
    }

    private void buildRightLeg() {

        Text RightLeg = new Text(215, 450, ")");
        RightLeg.grow(15, 80);
        RightLeg.draw();
    }

}