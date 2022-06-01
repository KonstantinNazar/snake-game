package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Panel extends JPanel implements ActionListener
{
    GameField field;
    private boolean inGame;
    Direction stepDirection;
    private Timer step;

    public Panel()
    {
        step = new Timer(Settings.gameSpeed, this);
        field = new GameField();
        stepDirection = new Direction();
        inGame = true;
        step.start();
        setFocusable(true);
        addKeyListener(new FieldKeyListener());
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        printObjects(g, field);
    }

    private void printObjects(Graphics g, GameField print)
    {
        printCells(g, print.menu.allCells);
        printCells(g, print.border.allCells);
        printCells(g, print.glade.allCells);
        printCells(g, print.grass.allCells);
        printCells(g, print.forest.allCells);
        printCell(g, print.food);
        printCells(g, print.snake.allCells);
    }

    private void printCells(Graphics g, ArrayList<Cell> allCells)
    {
        for(Cell cell : allCells)
            printCell(g, cell);
    }

    private void printCell(Graphics g, Cell cell)
    {
        g.drawImage(cell.image, cell.x_inPixel(), cell.y_inPixel(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (inGame)
        {
            stepDirection = stepDirection.getDirection(field.snake.direction);
            checkFoodGrab();
            checkCollision();
            updateSnake();
        }
        repaint();
    }

    private void checkFoodGrab()
    {
        if (field.snake.getHead().equals(field.food))
        {
            field.snake.addNewSnippet(new Cell(0,0), field.snake.getSnakeLength());
            field.findNewPlaceForFood();
        }
    }

    private void checkCollision()
    {
        if (field.objectAlreadyOnCell(field.snake.getHead(), field.border.allCells)
            || field.objectAlreadyOnCell(field.snake.getHead(), field.forest.allCells)
            || field.snake.snakeNotCrashIntoItself())
                inGame = false;
    }

    private void updateSnake()
    {
        if (inGame)
            field.snake.moveSnake();
        else
            field.snake.repaintSnake();
    }

    class FieldKeyListener extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            switch (key)
            {
                case KeyEvent.VK_LEFT:
                    field.snake.direction.turnLeft(stepDirection);
                    break;
                case KeyEvent.VK_RIGHT:
                    field.snake.direction.turnRight(stepDirection);
                    break;
                case KeyEvent.VK_UP:
                    field.snake.direction.turnUp(stepDirection);
                    break;
                case KeyEvent.VK_DOWN:
                    field.snake.direction.turnDown(stepDirection);
                    break;
                case KeyEvent.VK_SPACE:
                    //if (!inGame)
                    //{
                        field = new GameField();
                        inGame = true;
                    //}
            }
        }
    }
}
