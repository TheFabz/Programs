package org.academiadecodigo.carcrash.field;

public class Position {

    private int col = (int) ((Math.random() * Field.getWidth()));
    private int row = (int) ((Math.random() * Field.getHeight()));


    public void incrementRow(){
        row++;
    }

    public void decrementRow(){
        row--;
    }

    public void incrementCol(){
        col++;
    }

    public void decrementCol(){
        col--;
    }

    public int getCol() { return col; }

    public int getRow() {
        return row;
    }

    public void incrementColSpeed(){
        col += col/2;
    }




}
