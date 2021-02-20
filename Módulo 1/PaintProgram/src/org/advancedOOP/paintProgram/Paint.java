package org.advancedOOP.paintProgram;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Paint extends KeyBoardManager {

    private final Grid grid = new Grid();
    private Color currentColor = Color.BLACK;
    private int cellsSpaceY = 0;
    private int cellsSpaceX = 0;
    private final int cursorSize = 50;
    private final Cell[][] cells = new Cell[grid.getWidth() / cursorSize][grid.getHeight() / cursorSize];
    private final Cursor cursor = new Cursor(grid.getX(),grid.getY(),cursorSize,cursorSize);

    public Paint() {
        drawCells();
    }

    public void drawCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int s = 0; s < cells[i].length; s++) {
                cells[i][s] = new Cell(grid.getX() + cellsSpaceX, grid.getY() + cellsSpaceY, cursorSize, cursorSize);
                cellsSpaceY += 50;
            }
            cellsSpaceY = 0;
            cellsSpaceX += 50;
        }
    }

    public void paint() {
        for (Cell[] cell : cells) {
            for (int b = 0; b < cells[b].length; b++) {
                if (cell[b].getX() == cursor.getX() && cell[b].getY() == cursor.getY()) {
                    if (!(cell[b].getIsColored())) {
                        cell[b].setColor(currentColor);
                        cell[b].fill();
                        cell[b].setColored(true);
                    } else if ((cell[b].getIsColored())) {
                        cell[b].delete();
                        cell[b].setColored(false);
                    }
                    cursor.setColor(currentColor);
                }
            }
        }
    }

    public void setClear() throws IOException {
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                value.delete();
                value.setColored(false);
            }
        }
    }

    public void changeColor(Color color) {
        if (Color.RED.equals(color)) {
            currentColor = Color.RED;
        } else if (Color.GREEN.equals(color)) {
            currentColor = Color.GREEN;
        } else if (Color.BLUE.equals(color)) {
            currentColor = Color.BLUE;
        } else if (Color.YELLOW.equals(color)) {
            currentColor = Color.YELLOW;
        } else if (Color.PINK.equals(color)) {
            currentColor = Color.PINK;
        } else if (Color.MAGENTA.equals(color)) {
            currentColor = Color.MAGENTA;
        } else if (Color.CYAN.equals(color)) {
            currentColor = Color.CYAN;
        } else if (Color.ORANGE.equals(color)) {
            currentColor = Color.ORANGE;
        } else if (Color.GRAY.equals(color)) {
            currentColor = Color.GRAY;
        } else{
            currentColor = Color.BLACK;
        }
        }

    public void getFilledValues() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].getIsColored()) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    public void load() throws IOException {
        FileManager fileManager = new FileManager();
        fileManager.startInput();
        String l;
        while ((l = fileManager.inputStream.readLine()) != null) {
            String[] lineWords = l.split(" ");
            cells[Integer.parseInt(lineWords[0])][Integer.parseInt(lineWords[1])].setColor(stringToColor(lineWords[2]));
            cells[Integer.parseInt(lineWords[0])][Integer.parseInt(lineWords[1])].fill();
            cells[Integer.parseInt(lineWords[0])][Integer.parseInt(lineWords[1])].setColored(true);
        }
    }

    public void save () throws IOException {
        FileManager fileManager = new FileManager();
        fileManager.startOutput();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].getIsColored()) {
                    //add color to save document ***********
                    String data = i + " " + j + " " + colorToString(cells[i][j].getColor()) +"\n";
                    byte[] saveData;
                    saveData = data.getBytes(StandardCharsets.UTF_8);
                    fileManager.outputStream.write(saveData);
                    fileManager.outputStream.flush();
                }
            }
        }
    }

    public String colorToString(Color color){
        if (Color.BLACK.equals(color)) {
            return "BLACK";
        } else if (Color.RED.equals(color)) {
            return "RED";
        } else if (Color.GREEN.equals(color)) {
            return "GREEN";
        } else if (Color.BLUE.equals(color)) {
            return "BLUE";
        } else if (Color.YELLOW.equals(color)) {
            return "YELLOW";
        } else if (Color.PINK.equals(color)) {
            return "PINK";
        } else if (Color.CYAN.equals(color)) {
            return "CYAN";
        } else if (Color.GRAY.equals(color)) {
            return "GRAY";
        } else if (Color.MAGENTA.equals(color)) {
            return "MAGENTA";
        } else if (Color.ORANGE.equals(color)) {
            return "ORANGE";
        } else{
            return "Black";
        }
    }

    public Color stringToColor(String str){
        return switch (str) {
            case "RED" -> Color.RED;
            case "GREEN" -> Color.GREEN;
            case "BLUE" -> Color.BLUE;
            case "YELLOW" -> Color.YELLOW;
            case "PINK" -> Color.PINK;
            case "CYAN" -> Color.CYAN;
            case "GRAY" -> Color.GRAY;
            case "MAGENTA" -> Color.MAGENTA;
            case "ORANGE" -> Color.ORANGE;
            default -> Color.BLACK;
        };
    }

    public void close() throws IOException {
        System.exit(0);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            paint();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_C) {
            try {
                setClear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_1) {
            changeColor(Color.BLACK);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_2) {
            changeColor(Color.RED);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_3) {
            changeColor(Color.GREEN);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_4) {
            changeColor(Color.BLUE);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_5) {
            changeColor(Color.YELLOW);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_6) {
            changeColor(Color.PINK);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_7) {
            changeColor(Color.MAGENTA);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_8) {
            changeColor(Color.CYAN);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_9) {
            changeColor(Color.ORANGE);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_0) {
            changeColor(Color.GRAY);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            try {
                save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {
            try {
                load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_Q) {
            try {
                close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_T) {
            getFilledValues();
        }
    }

}
