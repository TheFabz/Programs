package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private SimpleGfxGrid grid;
    private Rectangle rectangle;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        this.grid = grid;
        rectangle = new Rectangle((grid.columnToX(getCol())) ,(grid.rowToY(getRow())),grid.getCellSize(),grid.getCellSize() ) ;
        show();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        this.grid = grid;
        rectangle = new Rectangle((grid.columnToX(col)) ,(grid.rowToY(row)),grid.getCellSize(),grid.getCellSize() ) ;
        show();
        //throw new UnsupportedOperationException();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
        //throw new UnsupportedOperationException();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int y = grid.rowToY(getRow());
        int x = grid.columnToX(getCol());

       // throw new UnsupportedOperationException();
        super.moveInDirection(direction,distance);

        int otherY = grid.rowToY(getRow());
        int otherX = grid.columnToX(getCol());

        rectangle.translate((otherX - x),(otherY - y));

    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        //throw new UnsupportedOperationException();
        super.setColor(color);
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
    }

}
