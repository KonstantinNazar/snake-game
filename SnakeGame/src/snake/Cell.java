package snake;

import java.awt.*;
import java.util.Random;

public class Cell
{
    public int x;
    public int y;
    Image image;

    Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Cell)
        {
            Cell cell = (Cell)obj;
            return this.x == cell.x && this.y == cell.y;
        }
        return super.equals(obj);
    }

    public int x_inPixel()
    {
        return this.x * Settings.CELL_PIXELS;
    }
    public int y_inPixel()
    {
        return this.y * Settings.CELL_PIXELS;
    }

    public static int randomX()
    {
        return new Random().nextInt(Settings.CELLS_X);
    }

    public static int randomY()
    {
        return new Random().nextInt(Settings.CELLS_Y);
    }

    public void updateCellCoords(int newX, int newY)
    {
        this.x = newX;
        this.y = newY;
    }

}
