package snake;

public class Settings
{
    public static final int CELL_PIXELS = 30;
    public static final int SIZEX = 900;
    public static final int SIZEY = 598;    // ширина верхней плашки 28 px => 570 + 28 = 598
    public static final int NUMBEROFTREES = 19;
    public static final int NUMBEROFGRASS = 60;
    public static final int CELLS_X = (SIZEX / CELL_PIXELS) - 1;
    public static final int CELLS_Y = (SIZEY / CELL_PIXELS) - 1;
    public static int gameSpeed = 350;

    public static boolean cellOnStartSnakePosition(Cell cell)
    {
        if (cell.equals(new Cell(3,3)) || cell.equals(new Cell(4,3))
            ||  cell.equals(new Cell(5,3)) || cell.equals(new Cell(6,3))
                || cell.equals(new Cell(7,3)) ||  cell.equals(new Cell(8,3)))
            return true;
        else
            return false;


    }
}
