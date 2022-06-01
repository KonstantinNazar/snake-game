package snake;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameField
{
    ObjectOnField menu = new ObjectOnField();
    ObjectOnField glade = new ObjectOnField();
    ObjectOnField border = new ObjectOnField();
    ObjectOnField grass = new ObjectOnField();
    Corner corner = new Corner();
    Forest forest = new Forest();
    Cell food;
    Snake snake;

    public GameField()
    {
        snake = new Snake();
        this.initializeObjectsOnField();
    }

    private void initializeObjectsOnField()
    {
        menu.allCells = initializeMenu(new ArrayList<>());
        glade.allCells = initializeGlade(new ArrayList<>());
        border.allCells = initializeBorders(new ArrayList<>());
        grass.allCells = initializeGrass(new ArrayList<>());
        forest.allCells = initializeForest(new ArrayList<>());
        food = initializeFood(new Cell(Cell.randomX(), Cell.randomY()));
    }

    private Cell initializeFood(Cell cell)
    {
        while (objectAlreadyOnCell(cell, this.forest.allCells)
                || objectAlreadyOnCell(cell, this.border.allCells)
                || objectAlreadyOnCell(cell, this.menu.allCells)
                || objectAlreadyOnCell(cell, this.snake.startLocation))
            cell.updateCellCoords(Cell.randomX(), Cell.randomY());
        cell.image = getFoodImage();
        return cell;
    }

    public void findNewPlaceForFood()
    {
        Cell newFood = new Cell(Cell.randomX(), Cell.randomY());
        while (objectAlreadyOnCell(newFood, this.forest.allCells)
                || objectAlreadyOnCell(newFood, this.border.allCells)
                || objectAlreadyOnCell(newFood, this.menu.allCells)
                || food.equals(newFood))
            newFood.updateCellCoords(Cell.randomX(), Cell.randomY());
        food.x = newFood.x;
        food.y = newFood.y;
    }

    private Image getFoodImage()
    {
        Image banana;
        ImageIcon bananaCellIcon = new ImageIcon(getClass().getResource("/img/banana.png"));
        banana = bananaCellIcon.getImage();
        return banana;
    }

    private ArrayList<Cell> initializeForest(ArrayList<Cell> forest)
    {
        for(int i = 0; i < Settings.NUMBEROFTREES; i++)
        {
            Cell cell = new Cell(Cell.randomX(), Cell.randomY());
            if (!(objectAlreadyOnCell(cell, forest))
                && !(objectAlreadyOnCell(cell, this.forest.environment))
                && !(objectAlreadyOnCell(cell, this.snake.startLocation))
                && !(objectAlreadyOnCell(cell, this.corner.environment))
                && objectAlreadyOnCell(cell, this.glade.allCells))
            {
                forest.add(cell);
                this.forest.formEnvironment(cell);
                cell.image = getTreeImage();
            }
            else
                i--;
        }
        return forest;
    }

    private Image getTreeImage()
    {
        Image tree;
        ImageIcon treeCellIcon = new ImageIcon(getClass().getResource("/img/tree.png"));
        tree = treeCellIcon.getImage();
        return tree;
    }

    private ArrayList<Cell> initializeGrass(ArrayList<Cell> grass)
    {
        for(int i = 0; i < Settings.NUMBEROFGRASS; i++)
        {
            Cell cell = new Cell(Cell.randomX(), Cell.randomY());
            if (!objectAlreadyOnCell(cell, grass) && objectAlreadyOnCell(cell, this.glade.allCells))
            {
                grass.add(cell);
                cell.image = getGrassImage();
            }
            else
                i--;
        }
        return grass;
    }

    private Image getGrassImage() 
    {
        Image grass;
        ImageIcon grassCellIcon = new ImageIcon(getClass().getResource("/img/grass.png"));
        grass = grassCellIcon.getImage();
        return grass;
    }

    public boolean objectAlreadyOnCell(Cell currentCell, ArrayList<Cell> array)
    {
        if (array.isEmpty())
            return false;
        else
        {
            for (Cell cell : array)
                if (currentCell.equals(cell))
                    return true;
        }
        return false;
    }

    private ArrayList<Cell> initializeBorders(ArrayList<Cell> border)
    {
        for (int i = 0; i <= Settings.CELLS_X; i++)
            for (int j = 1; j <= Settings.CELLS_Y - 1; j++)
                if (i == 0 || i == Settings.CELLS_X || j == 1 || j == Settings.CELLS_Y - 1)
                {
                    Cell cell = new Cell(i, j);
                    cell.image = getBorderImage();
                    border.add(cell);
                }
        return border;
    }

    private Image getBorderImage()
    {
        Image border;
        ImageIcon borderCellIcon = new ImageIcon(getClass().getResource("/img/border.png"));
        border = borderCellIcon.getImage();
        return border;
    }

    private ArrayList<Cell> initializeGlade(ArrayList<Cell> glade)
    {
        for (int i = 1; i < Settings.CELLS_X; i++)
            for (int j = 2; j < Settings.CELLS_Y - 1; j++)
            {
                Cell cell = new Cell(i, j);
                cell.image = getGladeImage();
                glade.add(cell);
            }
        return glade;
    }

    private Image getGladeImage()
    {
        Image glade;
        ImageIcon gladeCellIcon = new ImageIcon(getClass().getResource("/img/field.png"));
        glade = gladeCellIcon.getImage();
        return glade;
    }

    private ArrayList<Cell> initializeMenu (ArrayList<Cell> menu)
    {
        for (int i = 0; i <= Settings.CELLS_X; i++)
        {
            Cell cell = new Cell(i, 0);
            cell.image = getMenuImage();
            menu.add(cell);
        }
        for (int i = 0; i <= Settings.CELLS_X; i++)
        {
            Cell cell = new Cell(i, Settings.CELLS_Y);
            cell.image = getMenuImage();
            menu.add(cell);
        }
        return menu;
    }

    private Image getMenuImage()
    {
        Image menu;
        ImageIcon menuCellIcon = new ImageIcon(getClass().getResource("/img/black.png"));
        menu = menuCellIcon.getImage();
        return menu;
    }
}
