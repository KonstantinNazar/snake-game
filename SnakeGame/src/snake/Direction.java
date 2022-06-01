package snake;

public class Direction
{
    boolean right;
    boolean left;
    boolean up;
    boolean down;

    Direction()
    {
        rightDirection();
    }

    public void rightDirection()
    {
        if (!left)
        {
            right = true;
            left = false;
            up = false;
            down = false;
        }
    }

    public void leftDirection()
    {
        if (!right)
        {
            right = false;
            left = true;
            up = false;
            down = false;
        }
    }

    public void upDirection()
    {
        if (!down)
        {
            right = false;
            left = false;
            up = true;
            down = false;
        }
    }

    public void downDirection()
    {
        if (!up)
        {
            right = false;
            left = false;
            up = false;
            down = true;
        }
    }

    public Direction getDirection(Direction snakeDirection)
    {
        Direction direction = new Direction();
        direction.right = snakeDirection.right;
        direction.left = snakeDirection.left;
        direction.up = snakeDirection.up;
        direction.down = snakeDirection.down;
        return direction;
    }

    public void turnLeft(Direction currentDirection)
    {
        if(!currentDirection.right)
            this.leftDirection();
    }

    public void turnRight(Direction currentDirection)
    {
        if(!currentDirection.left)
            this.rightDirection();
    }

    public void turnUp(Direction currentDirection)
    {
        if(!currentDirection.down)
            this.upDirection();
    }

    public void turnDown(Direction currentDirection)
    {
        if(!currentDirection.up)
            this.downDirection();
    }
}
