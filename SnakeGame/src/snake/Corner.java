package snake;

import java.util.ArrayList;

public class Corner extends ObjectOnField
{
    public ArrayList<Cell> environment;

    public Corner()
    {
        environment = new ArrayList<>();
        formEnvironment(new Cell(1, 2));
        formEnvironment(new Cell(28, 2));
        formEnvironment(new Cell(2,16));
        formEnvironment(new Cell(28, 16));
    }

    public void formEnvironment(Cell corner)
    {
        for (int i = corner.x - 1; i <= corner.x + 1; i++ )
            for (int j = corner.y - 1; j <= corner.y + 1; j++)
                if (i > 0 && i < Settings.CELLS_X)
                    if (j > 1 && j < Settings.CELLS_Y - 1)
                        environment.add(new Cell(i, j));
    }
}
