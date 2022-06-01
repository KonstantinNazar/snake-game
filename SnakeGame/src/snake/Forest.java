package snake;

import java.util.ArrayList;

public class Forest extends ObjectOnField
{
    public ArrayList<Cell> environment;

    public Forest()
    {
        environment = new ArrayList<>();
    }

    public void formEnvironment(Cell tree)
    {
        for (int i = tree.x - 1; i <= tree.x + 1; i++ )
            for (int j = tree.y - 1; j <= tree.y + 1; j++)
                if (i > 0 && i < Settings.CELLS_X)
                    if (j > 1 && j < Settings.CELLS_Y - 1)
                        environment.add(new Cell(i, j));
    }
}
