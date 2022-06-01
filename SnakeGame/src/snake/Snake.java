package snake;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Snake extends ObjectOnField
{
    ArrayList<SnakeCell> allSnakeCells;
    ArrayList<Cell> startLocation;
    Direction direction;
    
    public Snake()
    {
        initializeSnake();
        startLocation = initializeStartLocation(new ArrayList<>());
    }

    private void initializeSnake()
    {
        direction = new Direction();
        allCells = new ArrayList<Cell>();
        allSnakeCells = new ArrayList<SnakeCell>();
        addNewSnippet(new Cell(4,4), 0);
        addNewSnippet(new Cell(3,4),1);
        addNewSnippet(new Cell(2,4),2);

        ImageIcon imageHeadIcon = new ImageIcon(getClass().getResource("/img/head.png"));
        allCells.get(0).image = imageHeadIcon.getImage();
        allSnakeCells.get(0).image = imageHeadIcon.getImage();
    }

    private ArrayList<Cell> initializeStartLocation(ArrayList<Cell> startLocation)
    {
        startLocation.add(new Cell(2,4));
        startLocation.add(new Cell(3,4));
        startLocation.add(new Cell(4,4));
        startLocation.add(new Cell(5,4));
        startLocation.add(new Cell(6,4));
        startLocation.add(new Cell(7,4));
        return startLocation;
    }

    public void addNewSnippet(Cell snippet, int position)
    {
        this.allSnakeCells.add(position, new SnakeCell(snippet.x,snippet.y));
        this.allCells.add(position, allSnakeCells.get(allSnakeCells.size() - 1));
    }

    public Cell getHead()
    {
        return allCells.get(0);
    }

    public boolean snakeNotCrashIntoItself()
    {
        for (int i = allCells.size() - 1; i > 1; i--)
            if (allCells.get(i).equals(getHead()))
                    return true;
        return false;
    }

    public void moveSnake()
    {
        for (int i = getSnakeLength() - 1; i > 0; i--)
        {
            Cell s = new Cell(allCells.get(i).x, allCells.get(i).y);
            Cell d = new Cell(allCells.get(i - 1).x, allCells.get(i - 1).y);
            s.updateCellCoords(d.x,d.y);
            allCells.get(i).updateCellCoords(allCells.get(i - 1).x, allCells.get(i - 1).y);
            allSnakeCells.get(i).updateCellCoords(allSnakeCells.get(i - 1).x, allSnakeCells.get(i - 1).y);
        }
        moveHeadCell();
    }

    private void moveHeadCell()
    {
        if (direction.right)
            allSnakeCells.get(0).updateCellCoords(allSnakeCells.get(0).x + 1, allSnakeCells.get(0).y);
        if (direction.left)
            allSnakeCells.get(0).updateCellCoords(allSnakeCells.get(0).x - 1, allSnakeCells.get(0).y);
        if (direction.up)
            allSnakeCells.get(0).updateCellCoords(allSnakeCells.get(0).x, allSnakeCells.get(0).y - 1);
        if (direction.down)
            allSnakeCells.get(0).updateCellCoords(allSnakeCells.get(0).x, allSnakeCells.get(0).y + 1);
    }

    public void repaintSnake()
    {
        Image crash = allSnakeCells.get(0).getCrashImage();
        for (Cell cell : allCells)
            cell.image = crash;
    }

    public int getSnakeLength()
    {
        return allSnakeCells.size();
    }
}
